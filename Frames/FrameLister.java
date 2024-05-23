import javax.swing.JFrame;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.*;
import Models.*;
import Models.Datatable.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

public class FrameLister extends JFrame {
    
    private ImageIcon food ;
    private JLabel backgroundImage ;

    JLabel titre ;
    JLabel table ;

    JButton home;
    JLabel homeLabel;

    JButton Back;
    JLabel BackLabel;

    JLabel Ref ;
    JLabel Desc;
    JLabel Date;
    JLabel Qte;
    JLabel Prix;
    JLabel RefRang;
    JLabel RefIng;

    JTextField inputRef;
    JTextField inputDesc;
    JTextField inputDate;
    JTextField inputQte;
    JTextField inputPrix;
    JTextField inputRefRang;
    JTextField inputRefIng;

    JTable Lister ;
    
    buttonRounded Annuler ;
    buttonRounded inserer ;
    buttonRounded Modifier ;
    buttonRounded Supprimer ;

    public FrameLister (String NomTable)
    {    
        
        super("FoodManagement");
        
        //background image

        food = new ImageIcon(this.getClass().getResource("/Images/fond.jpg"));
        backgroundImage = new JLabel(food);

        setLayout(new BorderLayout());
        setContentPane(backgroundImage);
        setLayout(null);

        // les bouttons

        ImageIcon buttonHomeIcon = new ImageIcon ("Images/home.png");
        home = new JButton (null,buttonHomeIcon);
        home.setBackground(Color.BLACK);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setBounds(30,30,buttonHomeIcon.getIconWidth(),buttonHomeIcon.getIconHeight());
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   dispose();
                   FramePrincipale f = new FramePrincipale() ;
             }
        });
        homeLabel = new JLabel("HOME");
        homeLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        homeLabel.setForeground(Color.WHITE);
        homeLabel.setBounds(30, 30, 100,100);

        ImageIcon buttonBackIcon = new ImageIcon ("Images/back.png");
        Back = new JButton (null,buttonBackIcon);
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.setBounds(340,30,buttonBackIcon.getIconWidth(),buttonBackIcon.getIconHeight());
        BackLabel = new JLabel("BACK");
        BackLabel.setFont(new Font(Font.SERIF, Font.BOLD, 10));
        BackLabel.setForeground(Color.WHITE);
        BackLabel.setBounds(340, 27, 100,100);
        Back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                       dispose();
                       FramePrincipale f = new FramePrincipale() ;
                 }
         });

        titre = new JLabel("GESTION DE CUISINE");
        titre.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        titre.setForeground(Color.black);
        titre.setBounds(18, 70, 400,100);

        table = new JLabel("-"+NomTable+"-");
        table.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        table.setForeground(Color.black);
        table.setBounds(30, 110, 400,100);

        
        if (NomTable.equals("TYPE INGREDIENT")){
            Connection cnx = DBMSC.getConnection();
            TypeIngredientDao tpe = new TypeIngredientDao(cnx);
            ArrayList<TypeIngridient> rowData = tpe.findall();
            TableModel model = new TypeIngredientDatatable(rowData);
            // create a new JTable with the DefaultTableModel
            Lister = new JTable(model);
            Lister.setOpaque(false);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
            renderer.setOpaque(false);
        }
        else if (NomTable.equals("RANGEMENT")){
            Connection cnx = DBMSC.getConnection();
            RangementDao rg = new RangementDao(cnx);
            ArrayList<Rangement> rowData = rg.findall();
            TableModel model = new RangementDataTable(rowData);
            // create a new JTable with the DefaultTableModel
            Lister = new JTable(model);
            Lister.setOpaque(false);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
            renderer.setOpaque(false);
        }
        else if (NomTable.equals("INGREDIENT")){
            Connection cnx = DBMSC.getConnection();
            IngredientDao rg = new IngredientDao(cnx);
            ArrayList<Ingridient> rowData = rg.findall();
            TableModel model = new IngredientDatatable(rowData);
            // create a new JTable with the DefaultTableModel
            Lister = new JTable(model);
            Lister.setOpaque(false);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
            renderer.setOpaque(false);
        }
        else if (NomTable.equals("RECETTE")){
            Connection cnx = DBMSC.getConnection();
            RecetteDao rg = new RecetteDao(cnx);
            ArrayList<Recette> rowData = rg.findall();
            TableModel model = new RecetteDatatable(rowData);
            // create a new JTable with the DefaultTableModel
            Lister = new JTable(model);
            Lister.setOpaque(false);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
            renderer.setOpaque(false);
        }
        else if (NomTable.equals("COMPOSITION")){
            Connection cnx = DBMSC.getConnection();
            CompositionDao rg = new CompositionDao(cnx);
            ArrayList<Composition> rowData = rg.findall();
            TableModel model = new CompositionDatatable(rowData);
            // create a new JTable with the DefaultTableModel
            Lister = new JTable(model);
            Lister.setOpaque(false);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
            renderer.setOpaque(false);
        }
        else {
            Connection cnx = DBMSC.getConnection();
            ProduitDao p = new ProduitDao(cnx);
            ArrayList<Produit> rowData = p.findall();
            TableModel model = new ProduitDatatable(rowData);
            // create a new JTable with the DefaultTableModel
            Lister = new JTable(model);
            Lister.setOpaque(false);
            DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
            renderer.setOpaque(false);
        }

        // customize the table
        Lister.setPreferredScrollableViewportSize(new Dimension(150, 100));
        Lister.setFillsViewportHeight(false);

        // add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(Lister);
        scrollPane.setOpaque( false );
        scrollPane.getViewport().setOpaque( false );
        scrollPane.setBounds(40, 200, 300, 500);


        JPanel p = new JPanel(new BorderLayout());
        p.add (scrollPane,BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the Game?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0); // exit the application
                }
                else {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // do nothing and let the user continue using the frame
                }
            }
        });
            
        //ajout des elements dans le frame
        this.add(home);
        this.add(homeLabel);
        this.add(Back);
        this.add(BackLabel);

        this.add(titre);

        this.add(table);
        this.add(scrollPane);
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(570, 90);
    }

}

