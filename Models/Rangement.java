package Models;
public class Rangement {
    private String NomRangement ;
    private String refRangement ;

    public Rangement (String Nr , String Rf)
    {
        NomRangement = Nr;
        refRangement = Rf ;
    }

    public String getNomRangement (){return NomRangement ; }
    public String getRefRangement (){return refRangement ;}


}