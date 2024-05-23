package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Models.Produit;

public class ProduitDao extends DAO<Produit>{

    public ProduitDao(Connection cnx) {
        super(cnx);
    }


    public ArrayList<Produit> findall() {
        ArrayList<Produit> result = new ArrayList<>();
        try {
            String query = "select * from Produit";
            Statement stmt = this.cnx.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String RefProduit = rs.getString("RefProduit");
                String DESCRIPTIFPRODUIT = rs.getString("DESCRIPTIFPRODUIT");
                String DATEPEREMPTION = rs.getString("DATEPEREMPTION");
                Double QUANTITEPRODUIT = rs.getDouble("QUANTITEPRODUIT");
                Double PRIXPRODUIT = rs.getDouble("PRIXPRODUIT");
                String REFRANGEMENT = rs.getString("REFRANGEMENT");
                String REFINGREDIENT = rs.getString("REFINGREDIENT");
                RangementDao r = new RangementDao(cnx);
                IngredientDao i = new IngredientDao(cnx);
               
                Produit produit = new Produit(RefProduit, DESCRIPTIFPRODUIT, DATEPEREMPTION, QUANTITEPRODUIT, PRIXPRODUIT, r.find(REFRANGEMENT), i.find(REFINGREDIENT));
                result.add(produit);
            }
            return result;
        } 
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return result;
    }

    public Produit find(String id) {
        try {
            String query = "select * from Produit where RefProduit = '" + id + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()) {
                String RefProduit = rs.getString("RefProduit");
                String DESCRIPTIFPRODUIT = rs.getString("DESCRIPTIFPRODUIT");
                String DATEPEREMPTION = rs.getString("DATEPEREMPTION");
                Double QUANTITEPRODUIT = rs.getDouble("QUANTITEPRODUIT");
                Double PRIXPRODUIT = rs.getDouble("PRIXPRODUIT");
                String REFRANGEMENT = rs.getString("REFRANGEMENT");
                String REFINGREDIENT = rs.getString("REFINGREDIENT");
                RangementDao r = new RangementDao(cnx);
                IngredientDao i = new IngredientDao(cnx);
                Produit produit = new Produit(RefProduit, DESCRIPTIFPRODUIT, DATEPEREMPTION, QUANTITEPRODUIT, PRIXPRODUIT, r.find(REFRANGEMENT), i.find(REFINGREDIENT));
                return produit;
            }
        }
        catch(SQLException e)
        {
          e.getStackTrace();
        }
        return null; 
    }

    
    public boolean create(Produit obj) {
        try {
            String query = "insert into Produit (RefProduit, DESCRIPTIFPRODUIT, DATEPEREMPTION, QUANTITEPRODUIT, PRIXPRODUIT,REFRANGEMENT,REFINGREDIENT ) " +
                            "values (?, ? ,?, ? ,?, ? ,?)";
            PreparedStatement stmt = this.cnx.prepareStatement(query);
            stmt.setString(1, obj.getRefProduit());
            stmt.setString(2, obj.getDescriptifProduit());
            stmt.setString(3, obj.getDatePeremption());
            stmt.setDouble(4, obj.getQteProduit());
            stmt.setDouble(5, obj.getPrixProduit());
            stmt.setString(6, obj.getRangement().getRefRangement());
            stmt.setString(7, obj.getIngridient().getRefIngredient());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
  
    @Override
    public boolean update(Produit obj) {
        try {
            String query = "update Produit set DESCRIPTIFPRODUIT = '" + obj.getDescriptifProduit() + "'," +
                            " DATEPEREMPTION = '" + obj.getDatePeremption() + "'," +
                            " QUANTITEPRODUIT = " + obj.getQteProduit() + " , " +
                            " PRIXPRODUIT = " + obj.getPrixProduit()  + " " +
                            " where RefProduit = '" + obj.getRefProduit() + "'";

            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    public boolean delete(Produit obj) {
        try {
            String query = "DELETE FROM Produit WHERE RefProduit = '" + obj.getRefProduit() + "'";
            Statement stmt = this.cnx.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
        
    }
    
}
