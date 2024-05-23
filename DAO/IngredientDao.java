package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Ingridient;

public class IngredientDao extends DAO <Ingridient>{
    
    public IngredientDao(Connection cnx) {
        super(cnx);
    }

    public boolean create(Ingridient obj) {
        try {
            String query = "insert into Ingredient (RefIngredient, NomIngredient, RefType) " +
                            "values (?, ?, ?)";
            PreparedStatement stmt = this.cnx.prepareStatement(query);
            stmt.setString(1, obj.getRefIngredient());
            stmt.setString(2, obj.getNomIngredient());
            stmt.setString(3, obj.getType().getRefType());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public boolean delete(Ingridient obj) {
        try {
            String query = "DELETE FROM Ingredient WHERE RefIngredient = '" + obj.getRefIngredient() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public Ingridient find(String id) {
        try {
            String query = "select * from Ingredient where RefIngredient = '" + id + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()) {
                String RefIngredient = rs.getString("RefIngredient");
                String NomIngredient= rs.getString("NomIngredient");
                String RefType = rs.getString("RefType");
                TypeIngredientDao t = new TypeIngredientDao(cnx);
                Ingridient ingridient = new Ingridient(RefIngredient, NomIngredient, t.find(RefType));
                return ingridient;
            }
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return null; 
    }

   
    public ArrayList<Ingridient> findall() {
        ArrayList<Ingridient> result = new ArrayList<>();
        try {
            String query = "select * from Ingredient";
            Statement stmt = this.cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RefIngridient = rs.getString("RefIngredient");
                String NomIngridient = rs.getString("NomIngredient");
                String RefType = rs.getString("RefType");
                TypeIngredientDao t = new TypeIngredientDao(cnx);
                Ingridient ingridient = new Ingridient(RefIngridient, NomIngridient, t.find(RefType));
                result.add(ingridient);
            }
            return result;
        } 
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return result;
    }

    
    public boolean update(Ingridient obj) {
        
        try {
            
            String query = "update Ingredient set NomIngredient = '" + obj.getNomIngredient() + "'"+
                            " where RefIngredient = '" + obj.getRefIngredient() + "'";
                            
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
}
