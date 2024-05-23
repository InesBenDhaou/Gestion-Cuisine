
package Models.Datatable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Models.Composition;

public class CompositionDatatable extends AbstractTableModel {
    
        private ArrayList<Composition> compositions ;
        private String[] columns ; 
      
        public CompositionDatatable(ArrayList<Composition> compositions){
          super();
          this.compositions = compositions;
          columns = new String[]{"RefCompo", "Qte","RefRecette", "RefIngredient"};
        }
      
        // Number of column of your table
        public int getColumnCount() {
          return columns.length ;
        }
      
        // Number of row of your table
        @Override
        public int getRowCount() {
            return compositions.size();
        }
      
        // The object to render in a cell
        public Object getValueAt(int row, int col) {
            Composition club = compositions.get(row);
          switch(col) {
            case 0: return club.getRefComposition();
            case 1: return club.getQteComposition();
            case 2: return club.getRecette().getRefRecette();
            case 3: return club.getIngridient().getRefIngredient();
            default: return null;
          }
        }
      
        // Optional, the name of your column
        public String getColumnName(int col) {
          return columns[col] ;
        }
      
      }

