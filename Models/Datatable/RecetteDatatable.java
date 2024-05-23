package Models.Datatable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Models.Recette;

public class RecetteDatatable extends AbstractTableModel {
    
        private ArrayList<Recette> Recettes ;
        private String[] columns ; 
      
        public RecetteDatatable(ArrayList<Recette> Recettes){
          super();
          this.Recettes = Recettes;
          columns = new String[]{"REFRECETTE", "NOMRECETTE","DESCRIPTIFRECETTE", "CALORIESRECETTE","DIFFICULTE", "TEMPSPREPARATION","TEMPSCUISSON", "NBPERSONNES"};
        }
      
        // Number of column of your table
        public int getColumnCount() {
          return columns.length ;
        }
      
        // Number of row of your table
        @Override
        public int getRowCount() {
            return Recettes.size();
        }
      
        // The object to render in a cell
        public Object getValueAt(int row, int col) {
            Recette club = Recettes.get(row);
          switch(col) {
            case 0: return club.getRefRecette();
            case 1: return club.getNomRecette();
            case 2: return club.getDescriptifRecette();
            case 3: return club.getCaloriesRecette();
            case 4: return club.getDifficulte();
            case 5: return club.getTempsPreparation();
            case 6: return club.getTempsCuisson();
            case 7: return club.getNbPersonne();
            default: return null;
          }
        }
      
        // Optional, the name of your column
        public String getColumnName(int col) {
          return columns[col] ;
        }
      
      }

