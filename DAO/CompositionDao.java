package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Composition;

public class CompositionDao extends DAO <Composition>{

    public CompositionDao(Connection cnx) {
        super(cnx);
        
    }

    public ArrayList<Composition> findall() {
        ArrayList<Composition> result = new ArrayList<>();
        
        try {
            String query = "select * from Composition";
            Statement stmt = this.cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RefComposition = rs.getString("RefComposition");
                Double QuantiteComposition = rs.getDouble("QuantiteComposition");
                String RefRecette = rs.getString("RefRecette");
                String RefIngredient = rs.getString("RefIngredient");
                IngredientDao i = new IngredientDao(cnx);
                RecetteDao r = new RecetteDao(cnx);
                Composition composition = new Composition(RefComposition, QuantiteComposition, r.find(RefRecette), i.find(RefIngredient));
                result.add(composition);
            }
            return result;
        } 
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return result;
        
    }

    public Composition find(String id) {
        try {
            String query = "select * from Composition where RefComposition = '" + id + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()) {
                String RefComposition = rs.getString("RefComposition");
                Double QuantiteComposition = rs.getDouble("QuantiteComposition");
                String RefRecette = rs.getString("RefRecette");
                String RefIngredient = rs.getString("RefIngredient");
                IngredientDao i = new IngredientDao(cnx);
                RecetteDao r = new RecetteDao(cnx);
                
                Composition composition = new Composition(RefComposition, QuantiteComposition, r.find(RefRecette), i.find(RefIngredient));
                return composition;
            }
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return null; 
    }

    public boolean create(Composition obj) {
        try {
            String query = "insert into Composition (RefComposition, QuantiteComposition, RefRecette, RefIngredient) " +
                            "values (?, ?, ?, ?)";
            PreparedStatement stmt = this.cnx.prepareStatement(query);
            stmt.setString(1, obj.getRefComposition());
            stmt.setDouble(2, obj.getQteComposition());
            stmt.setString(3, obj.getRecette().getRefRecette());
            stmt.setString(4, obj.getIngridient().getRefIngredient());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    public boolean update(Composition obj) {
        try {
            String query = "update Composition set  QuantiteComposition = " + obj.getQteComposition() + 
                          " where RefComposition = '" + obj.getRefComposition() + "'";
                            
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public boolean delete(Composition obj) {
        try {
            String query = "DELETE FROM Composition WHERE RefComposition = '" + obj.getRefComposition() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
}
