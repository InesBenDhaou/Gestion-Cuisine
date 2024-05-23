package Models;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.table.TableModel;

import DAO.CompositionDao;
import DAO.DAO;
import DAO.IngredientDao;
import DAO.ProduitDao;
import DAO.RangementDao;
import DAO.RecetteDao;
import DAO.TypeIngredientDao;
import Models.Datatable.CompositionDatatable;
import Models.Datatable.IngredientDatatable;
import Models.Datatable.ProduitDatatable;
import Models.Datatable.RangementDataTable;
import Models.Datatable.RecetteDatatable;
import Models.Datatable.TypeIngredientDatatable;

public class Utils {
    
    public static TableModel getModel(String NomTable, String filtreId) {
        Connection cnx = DBMSC.getConnection();
        ArrayList elements;
        DAO dao;
        TableModel model;

        if (NomTable.equals("TYPE INGREDIENT")){
            dao = new TypeIngredientDao(cnx);
            elements = new ArrayList();
            if (filtreId.length() > 0)
                elements.add(dao.find(filtreId));
                
            model = new TypeIngredientDatatable(elements);
        }
        else if (NomTable.equals("RANGEMENT")){
            dao = new RangementDao(cnx);
            elements = new ArrayList();
            if (filtreId.length() > 0)
                elements.add(dao.find(filtreId));
            model = new RangementDataTable(elements);
        }
        else if (NomTable.equals("INGREDIENT")){
            dao = new IngredientDao(cnx);
            elements = new ArrayList();
            if (filtreId.length() > 0)
                elements.add(dao.find(filtreId));
            model = new IngredientDatatable(elements);
        }
        else if (NomTable.equals("RECETTE")){
            dao = new RecetteDao(cnx);
            elements = new ArrayList();
            if (filtreId.length() > 0)
                elements.add(dao.find(filtreId));
            model = new RecetteDatatable(elements);
        }
        else if (NomTable.equals("COMPOSITION")){
            dao = new CompositionDao(cnx);
            elements = new ArrayList();
            if (filtreId.length() > 0)
                elements.add(dao.find(filtreId));
            model = new CompositionDatatable(elements);
        }
        else {
            dao = new ProduitDao(cnx);
            elements = new ArrayList();
            if (filtreId.length() > 0)
                elements.add(dao.find(filtreId));
            model = new ProduitDatatable(elements);
        }

        return model;
    }
}
