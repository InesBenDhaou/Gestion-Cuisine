package Models;
import java.sql.Date;

public class Produit {
    private String RefProduit ;
    private String descriptifProduit ;
    private String DatePeremption ;
    private Double QteProduit;
    private Double PrixProduit ;
    private Rangement rangement ;
    private Ingridient ingridient ;

    public Produit(String refProduit, String descriptifProduit, String datePeremption, Double qteProduit,Double prixProduit, Rangement rangement, Ingridient ingridient) {
        RefProduit = refProduit;
        this.descriptifProduit = descriptifProduit;
        DatePeremption = datePeremption;
        QteProduit = qteProduit;
        PrixProduit = prixProduit;
        this.rangement = rangement;
        this.ingridient = ingridient;
    }

    
    public String getRefProduit() {
        return RefProduit;
    }
    public String getDescriptifProduit() {
        return descriptifProduit;
    }
    public String getDatePeremption() {
        return DatePeremption;
    }
    public Double getQteProduit() {
        return QteProduit;
    }
    public Double getPrixProduit() {
        return PrixProduit;
    }
    public Rangement getRangement() {
        return rangement;
    }
    public Ingridient getIngridient() {
        return ingridient;
    }
    public void setRefProduit(String refProduit) {
        RefProduit = refProduit;
    }
    public void setDescriptifProduit(String descriptifProduit) {
        this.descriptifProduit = descriptifProduit;
    }
    public void setDatePeremption(String datePeremption) {
        DatePeremption = datePeremption;
    }
    public void setQteProduit(Double qteProduit) {
        QteProduit = qteProduit;
    }
    public void setPrixProduit(Double prixProduit) {
        PrixProduit = prixProduit;
    }
    public void setRangement(Rangement rangement) {
        this.rangement = rangement;
    }
    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
    }
    
}
