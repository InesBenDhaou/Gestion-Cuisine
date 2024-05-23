package DAO;
import Models.TypeIngridient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TypeIngredientDao extends DAO<TypeIngridient>{

    public TypeIngredientDao(Connection cnx) {
        super(cnx);
    }

    
    public ArrayList<TypeIngridient> findall() {
        ArrayList<TypeIngridient> result = new ArrayList<>();
        
        try {
            String query = "select * from TypeIngredient";
            Statement stmt = this.cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String refType = rs.getString("refType");
                String NomType  = rs.getString("NomType");
                
                TypeIngridient typeIngredient = new TypeIngridient(NomType, refType);
                result.add(typeIngredient);
            }
            return result;
        } 
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return result;
    }

    
    public TypeIngridient find(String id) {
        try {
            String query = "select * from TypeIngredient where RefType = '" + id + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()) {
                String RefType = rs.getString("RefType");
                String NomType = rs.getString("NomType");
                TypeIngridient typeIngridient = new TypeIngridient(NomType , RefType);
                return typeIngridient;
            }
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return null; 
    }
    

    
    public boolean create(TypeIngridient obj) {
        try {
            String query = "insert into TypeIngredient (RefType, NomType) " +
                            "values (?, ?)";
            PreparedStatement stmt = this.cnx.prepareStatement(query);
            stmt.setString(1, obj.getRefType());
            stmt.setString(2, obj.getNomType());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public boolean update(TypeIngridient obj) {
        try {
           
            String query = "update TypeIngredient set NomType = '" + obj.getNomType()+ "'" +
                            " where RefType = '" + obj.getRefType() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    

    
    public boolean delete(TypeIngridient obj) {
        try {
            String query = "DELETE FROM TypeIngredient WHERE RefType = '" + obj.getRefType() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    
}
