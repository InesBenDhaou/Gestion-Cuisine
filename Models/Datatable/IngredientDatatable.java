
package Models.Datatable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Models.Ingridient;

public class IngredientDatatable extends AbstractTableModel {
    
        private ArrayList<Ingridient> ingridients ;
        private String[] columns ; 
      
        public IngredientDatatable(ArrayList<Ingridient> ingridients){
          super();
          this.ingridients = ingridients;
          columns = new String[]{"RefIngredient", "NomIngredient","RefType"};
        }
      
        // Number of column of your table
        public int getColumnCount() {
          return columns.length ;
        }
      
        // Number of row of your table
        @Override
        public int getRowCount() {
            return ingridients.size();
        }
      
        // The object to render in a cell
        public Object getValueAt(int row, int col) {
            Ingridient club = ingridients.get(row);
          switch(col) {
            case 0: return club.getRefIngredient();
            case 1: return club.getNomIngredient();
            case 2: return club.getType().getRefType();
            default: return null;
          }
        }
      
        // Optional, the name of your column
        public String getColumnName(int col) {
          return columns[col] ;
        }
      
      }



