import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import DAO.RecetteDao;
import DAO.TypeIngredientDao;
import Models.DBMSC;
//import Frames.FramePrincipale;
import Models.Recette;
import Models.TypeIngridient;
import java.sql.*;

public class Main {
    
    public static void main (String args[] )
    {
        try{
            DBMSC.createConnection();
            //Connection con = DBMSC.getConnection();
            //RecetteDao recetteDao = new RecetteDao(con);
            //TypeIngredientDao typeIngredientDao = new TypeIngredientDao(con);
            /*ArrayList<Recette> result = recetteDao.findall();
            /*for (Recette recette : result) {
                System.out.println(recette.toString());
            }
             // get one
            /*Recette recette = recetteDao.find("r0001");
            System.out.println(recette.toString());
            recette.setNomRecette("kutkut");
            recetteDao.update(recette);*/

            /*Recette recette = new Recette("abc", "test", "test", 10, "moyen", 40, 40, 4);
            recetteDao.create(recette);*/
            /*ArrayList<TypeIngridient> result = TypeIngredientDao.findall();
            for (TypeIngridient typeIngredient : result) {
                System.out.println(typeIngredient.toString());
            }*/
            FramePrincipale f = new FramePrincipale();
        }
        catch(SQLException e) {

        }
        catch(ClassNotFoundException e) {

        }
    }
               
    
}
