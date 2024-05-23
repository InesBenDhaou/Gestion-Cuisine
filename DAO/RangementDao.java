package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Rangement;

public class RangementDao extends DAO <Rangement>{

    public RangementDao(Connection cnx) {
        super(cnx);
    }

    
    public ArrayList <Rangement> findall() {
        ArrayList<Rangement> result = new ArrayList<>();
        
        try {
            String query = "select * from Rangement";
            Statement stmt = this.cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String refRangement = rs.getString("refRangement");
                String NomRangement  = rs.getString("NomRangement");
                
                Rangement rangement = new Rangement( NomRangement , refRangement);
                result.add(rangement);
            }
            return result;
        } 
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return result;
        
    }

    
    public Rangement find(String id) {
        try {
            String query = "select * from Rangement where RefRangement = '" + id + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()) {
                String RefRangement = rs.getString("RefRangement");
                String NomRangement = rs.getString("NomRangement");
                Rangement rangement = new Rangement(NomRangement, RefRangement);
                return rangement;
            }
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return null; 
    }

    

    public boolean update(Rangement obj) {
        try {
            String query = "update Rangement set NomRangement = '" + obj.getNomRangement() + "'" +
                            " where RefRangement = '" + obj.getRefRangement() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public boolean delete(Rangement obj) {
        try {
            String query = "DELETE FROM Rangement WHERE RefRangement = '" + obj.getRefRangement() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }



    public boolean create (Rangement obj) {
        try {
            String query = "insert into Rangement (RefRangement, NomRangement) " +
                            "values (?, ?)";
            PreparedStatement stmt = this.cnx.prepareStatement(query);
            stmt.setString(1, obj.getRefRangement());
            stmt.setString(2, obj.getNomRangement());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
}
