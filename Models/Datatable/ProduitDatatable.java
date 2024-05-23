package Models.Datatable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Models.Produit;

public class ProduitDatatable extends AbstractTableModel {
    
        private ArrayList<Produit> produits ;
        private String[] columns ; 
      
        public ProduitDatatable(ArrayList<Produit> produits){
          super();
          this.produits = produits;
          columns = new String[]{"RefProduit", "DescriptifProduit","DatePeremption", "QteProduit","PrixProduit", "RefRangement","RefIngredient"};
        }
      
        // Number of column of your table
        public int getColumnCount() {
          return columns.length ;
        }
      
        // Number of row of your table
        @Override
        public int getRowCount() {
            return produits.size();
        }
      
        // The object to render in a cell
        public Object getValueAt(int row, int col) {
            Produit club = produits.get(row);
          switch(col) {
            case 0: return club.getRefProduit();
            case 1: return club.getDescriptifProduit();
            case 2: return club.getDatePeremption();
            case 3: return club.getQteProduit();
            case 4: return club.getPrixProduit();
            case 5: return club.getRangement().getRefRangement();
            case 6: return club.getIngridient().getRefIngredient();
            default: return null;
          }
        }
      
        // Optional, the name of your column
        public String getColumnName(int col) {
          return columns[col] ;
        }
      
      }


