package Models;
public class Ingridient {

    private String refIngredient ;
    private String nomIngredient ;
    private TypeIngridient type ;

    public Ingridient(String refIngredient, String nomIngredient, TypeIngridient type) {
        this.refIngredient = refIngredient;
        this.nomIngredient = nomIngredient;
        this.type = type;
    }

    public String getRefIngredient() {
        return refIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public TypeIngridient getType() {
        return type;
    }

    public void setRefIngredient(String refIngredient) {
        this.refIngredient = refIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public void setType(TypeIngridient type) {
        this.type = type;
    }

    public void afficher()
    {
        System.out.println(getRefIngredient() + " "+getNomIngredient()+" "+getType().getRefType());
    }
    

    
}
