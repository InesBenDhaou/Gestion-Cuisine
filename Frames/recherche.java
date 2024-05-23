import javax.swing.JFrame;
import java.sql.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Models.*;
import Models.Datatable.*;
import DAO.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.function.Function;


public class recherche extends JFrame {
    
    private ImageIcon food ;
    private JLabel backgroundImage ;

    JButton home;
    JLabel homeLabel;

    JButton Back;
    JLabel BackLabel;

    JLabel titre ;
    JLabel id ;
    
    JButton rechercher  ;
    JTextField IDENTIFIANT;
    JTable Lister ;
    
    protected static Color HOVER_COLOR  = new Color (248, 160, 160) ;
    public recherche (String NomTable)
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
                       FrameMiseAJour f = new FrameMiseAJour("") ;
                 }
         });
        titre = new JLabel("GESTION DE CUISINE");
        titre.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        titre.setForeground(Color.black);
        titre.setBounds(18, 70, 400,100);

        id = new JLabel("IDENTIFIANT : ");
        id.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        id.setForeground(Color.black);
        id.setBounds(50, 150, 300,100);

        // zone de texte de Nom joueur
        IDENTIFIANT = new JTextField();
        IDENTIFIANT.setPreferredSize(new Dimension(200, 10));
        IDENTIFIANT.setBounds(50, 225, 300,30);
        IDENTIFIANT.setBackground(Color.white);
        IDENTIFIANT.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        IDENTIFIANT.setForeground(Color.GRAY);
        IDENTIFIANT.setText("Entrer l'identifiant ");
        IDENTIFIANT.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (IDENTIFIANT.getForeground() == Color.GRAY) {
                    IDENTIFIANT.setText("");
                    IDENTIFIANT.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (IDENTIFIANT.getText().isEmpty()) {
                    IDENTIFIANT.setText("Enter votre Nom");
                    IDENTIFIANT.setForeground(Color.black);
                }
            }
        });
        IDENTIFIANT.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                IDENTIFIANT.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                IDENTIFIANT.setBackground(Color.white);
                    
                }
            
        });

        // traitement button
        ImageIcon buttonRechercheIcon = new ImageIcon ("Images/search.png");
        rechercher = new JButton (null,buttonRechercheIcon);
        rechercher.setBackground(Color.BLACK);
        rechercher.setBorderPainted(false);
        rechercher.setContentAreaFilled(false);
        rechercher.setBounds(360,220,buttonRechercheIcon.getIconWidth(),buttonRechercheIcon.getIconHeight());
        rechercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  
             }
        });



        //recuperer l'id
        //String myId = IDENTIFIANT.getText();
        IDENTIFIANT.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e ){
                if (IDENTIFIANT.getText().length() > 0) {
                    TableModel m = Utils.getModel(NomTable, IDENTIFIANT.getText());
                    Lister.setModel(m);
                    Lister.invalidate();
                }
            }
            
        });





        // create a new JTable with the DefaultTableModel
        Lister = new JTable(Utils.getModel(NomTable, ""));
        Lister.setOpaque(false);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Lister.getDefaultRenderer(Object.class);
        renderer.setOpaque(false);

        Lister.setPreferredScrollableViewportSize(new Dimension(150, 100));
        Lister.setFillsViewportHeight(false);

        // add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(Lister);
        scrollPane.setOpaque( false );
        scrollPane.getViewport().setOpaque( false );
        scrollPane.setBounds(50, 280, 300, 50);


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
        this.add(home);
        this.add(homeLabel);
        this.add(Back);
        this.add(BackLabel);
        this.add(rechercher);
        this.add(IDENTIFIANT);
        this.add(id);

        this.add(titre);

        
        this.add(scrollPane);
            
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(570, 90);

        

    }

    

}

    
