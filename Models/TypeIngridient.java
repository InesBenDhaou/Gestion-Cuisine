package Models;
public class TypeIngridient {
    
    private String NomType ;
    private String refType ;

    public TypeIngridient(String nomType, String refType) {
        NomType = nomType;
        this.refType = refType;
    }
    
    public String getNomType() {
        return NomType;
    }
    public String getRefType() {
        return refType;
    }
    public void setNomType(String nomType) {
        NomType = nomType;
    }
    public void setRefType(String refType) {
        this.refType = refType;
    }

    


    
}
