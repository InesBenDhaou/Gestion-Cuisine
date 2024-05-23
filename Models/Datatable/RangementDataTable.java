package Models.Datatable;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Models.Rangement;

public class RangementDataTable extends AbstractTableModel {
    
        private ArrayList<Rangement> rangements ;
        private String[] columns ; 
      
        public RangementDataTable(ArrayList<Rangement> rangements){
          super();
          this.rangements = rangements;
          columns = new String[]{"REFRANGEMENT", "NOMRANGEMENT"};
        }
      
        // Number of column of your table
        public int getColumnCount() {
          return columns.length ;
        }
      
        // Number of row of your table
        @Override
        public int getRowCount() {
            return rangements.size();
        }
      
        // The object to render in a cell
        public Object getValueAt(int row, int col) {
            Rangement club = rangements.get(row);
          switch(col) {
            case 0: return club.getRefRangement();
            case 1: return club.getNomRangement();
            default: return null;
          }
        }
      
        // Optional, the name of your column
        public String getColumnName(int col) {
          return columns[col] ;
        }
      
      }

