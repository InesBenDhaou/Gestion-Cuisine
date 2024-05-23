package Models;
public class Composition {
    private String RefComposition ;
    private Double QteComposition ;
    private Recette recette ;
    private Ingridient ingridient ;

    public Composition(String refComposition, Double qteComposition, Recette recette, Ingridient ingridient) {
        RefComposition = refComposition;
        QteComposition = qteComposition;
        this.recette = recette;
        this.ingridient = ingridient;
    }
   
    public String getRefComposition() {
        return RefComposition;
    }
    public Double getQteComposition() {
        return QteComposition;
    }
    public Recette getRecette() {
        return recette;
    }
    public Ingridient getIngridient() {
        return ingridient;
    }
    public void setRefComposition(String refComposition) {
        RefComposition = refComposition;
    }
    public void setQteComposition(Double qteComposition) {
        QteComposition = qteComposition;
    }
    public void setRecette(Recette recette) {
        this.recette = recette;
    }
    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
    }
    
    
}
