package Models.Datatable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Models.TypeIngridient;

public class TypeIngredientDatatable extends AbstractTableModel {
    
        private ArrayList<TypeIngridient> typeIngredients ;
        private String[] columns ; 
      
        public TypeIngredientDatatable(ArrayList<TypeIngridient> typeIngredients){
          super();
          this.typeIngredients = typeIngredients;
          columns = new String[]{"RefType", "NomType"};
        }
      
        // Number of column of your table
        public int getColumnCount() {
          return columns.length ;
        }
      
        // Number of row of your table
        @Override
        public int getRowCount() {
            return typeIngredients.size();
        }
      
        // The object to render in a cell
        public Object getValueAt(int row, int col) {
          TypeIngridient club = typeIngredients.get(row);
          switch(col) {
            case 0: return club.getRefType();
            case 1: return club.getNomType();
            default: return null;
          }
        }
      
        // Optional, the name of your column
        public String getColumnName(int col) {
          return columns[col] ;
        }
      
      }
