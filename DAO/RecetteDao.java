package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Recette;

public class RecetteDao extends DAO<Recette> {

    
    public RecetteDao(Connection cnx) {
        super(cnx);
    }

    
    public boolean create(Recette obj) {
        try {
            String query = "insert into Recette (RefRecette, NomRecette, DescriptifRecette, CaloriesRecette, Difficulte, TempsPreparation,TempsCuisson,NbPersonnes) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.cnx.prepareStatement(query);
            stmt.setString(1, obj.getRefRecette());
            stmt.setString(2, obj.getNomRecette());
            stmt.setString(3, obj.getDescriptifRecette());
            stmt.setDouble(4, obj.getCaloriesRecette());
            stmt.setString(5, obj.getDifficulte());
            stmt.setDouble(6, obj.getTempsPreparation());
            stmt.setDouble(7, obj.getTempsCuisson());
            stmt.setInt(8, obj.getNbPersonne());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public boolean delete(Recette obj) {
        try {
            String query = "DELETE FROM Recette WHERE RefRecette = '" + obj.getRefRecette() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    
    public Recette find(String id) {
        try {
            String query = "select * from Recette where RefRecette = '" + id + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()) {
                String RefRecette = rs.getString("RefRecette");
                String NomRecette = rs.getString("NomRecette");
                String DescriptifRecette = rs.getString("DescriptifRecette");
                Integer CaloriesRecette = rs.getInt("CaloriesRecette");
                String Difficulte = rs.getString("Difficulte");
                Integer TempsPreparation = rs.getInt("TempsPreparation");
                Integer TempsCuisson = rs.getInt("TempsCuisson");
                Integer NbPersonnes = rs.getInt("NbPersonnes");
                Recette recette = new Recette(RefRecette, NomRecette, DescriptifRecette, CaloriesRecette, Difficulte, TempsPreparation, TempsCuisson, NbPersonnes);
                return recette;
            }
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return null; 
    }

   
    public ArrayList<Recette> findall() {
        ArrayList<Recette> result = new ArrayList<>();
        try {
            String query = "select * from Recette";
            Statement stmt = this.cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RefRecette = rs.getString("RefRecette");
                String NomRecette = rs.getString("NomRecette");
                String DescriptifRecette = rs.getString("DescriptifRecette");
                Integer CaloriesRecette = rs.getInt("CaloriesRecette");
                String Difficulte = rs.getString("Difficulte");
                Integer TempsPreparation = rs.getInt("TempsPreparation");
                Integer TempsCuisson = rs.getInt("TempsCuisson");
                Integer NbPersonnes = rs.getInt("NbPersonnes");
                Recette recette = new Recette(RefRecette, NomRecette, DescriptifRecette, CaloriesRecette, Difficulte, TempsPreparation, TempsCuisson, NbPersonnes);
                result.add(recette);
            }
            return result;
        } 
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return result;
    }

    
    public boolean update(Recette obj) {
        
        try {
            String query = "update Recette set NomRecette = '" + obj.getNomRecette() + "'," +
                            "DescriptifRecette = '" + obj.getDescriptifRecette() + "'," +
                            "CaloriesRecette = " + obj.getCaloriesRecette() + "," +
                            "Difficulte = '" + obj.getDifficulte() + "'," +
                            "TempsPreparation = " + obj.getTempsPreparation() + "," +
                            "TempsCuisson = " + obj.getTempsCuisson() + "," +
                            "NbPersonnes = " + obj.getNbPersonne() + " " +
                            " where RefRecette = '" + obj.getRefRecette() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
