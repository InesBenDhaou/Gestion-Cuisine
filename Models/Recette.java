package Models;
public class Recette {

    private String refRecette ;
    private String nomRecette ;
    private String DescriptifRecette ;
    private double caloriesRecette ;
    private String difficulte ;
    private double tempsPreparation ;
    private double tempsCuisson ;
    private int nbPersonne ;

    public Recette (String refRecette , String nomRecette ,String DescriptifRecette , double caloriesRecette ,String difficulte ,double tempsPreparation , double tempsCuisson ,int nbPersonne )
    {
        this.refRecette = refRecette ;
        this.nomRecette = nomRecette ;
        this.DescriptifRecette = DescriptifRecette ;
        this.caloriesRecette = caloriesRecette ;
        this.difficulte = difficulte ;
        this.tempsPreparation = tempsPreparation ;
        this.tempsCuisson = tempsCuisson;
        this.nbPersonne = nbPersonne ;

    }

    public String getRefRecette() {
        return refRecette;
    }

    public String getNomRecette() {
        return nomRecette;
    }

    public String getDescriptifRecette() {
        return DescriptifRecette;
    }

    public double getCaloriesRecette() {
        return caloriesRecette;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public double getTempsPreparation() {
        return tempsPreparation;
    }

    public double getTempsCuisson() {
        return tempsCuisson;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public void setRefRecette(String refRecette) {
        this.refRecette = refRecette;
    }

    public void setNomRecette(String nomRecette) {
        this.nomRecette = nomRecette;
    }

    public void setDescriptifRecette(String descriptifRecette) {
        DescriptifRecette = descriptifRecette;
    }

    public void setCaloriesRecette(double caloriesRecette) {
        this.caloriesRecette = caloriesRecette;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    public void setTempsPreparation(double tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public void setTempsCuisson(double tempsCuisson) {
        this.tempsCuisson = tempsCuisson;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    @Override
    public String toString() {
        return "recette " + nomRecette + " | " + DescriptifRecette;
    }
    
}
