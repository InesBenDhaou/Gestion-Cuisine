import javax.swing.JFrame;

import DAO.TypeIngredientDao;
import Models.DBMSC;
import Models.TypeIngridient;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
public class FrameTypeIng extends JFrame {
    
    private ImageIcon food ;
    private JLabel backgroundImage ;

    JLabel titre ;
    JLabel table ;

    JButton home;
    JLabel homeLabel;

    JButton Back;
    JLabel BackLabel;

    JLabel Ref ;
    JLabel Nom ;

    JTextField inputRef;
    JTextField inputNom;

    String RefTypevalue ;
    String NomTypevalue;

    buttonRounded Annuler ;
    buttonRounded inserer ;
    buttonRounded Modifier ;
    buttonRounded Supprimer ;

    public FrameTypeIng (String Action)
    {    
        
        super("FoodManagement");
        
        //background image

        food = new ImageIcon(this.getClass().getResource("/Images/fond.jpg"));
        backgroundImage = new JLabel(food);
        backgroundImage.setSize(1000,1000);

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
                       FrameMiseAJour f = new FrameMiseAJour("TYPE INGREDIENT") ;
                 }
         });

        titre = new JLabel("GESTION DE CUISINE");
        titre.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        titre.setForeground(Color.black);
        titre.setBounds(18, 70, 400,100);

        table = new JLabel("-Table TypeIngredient-");
        table.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        table.setForeground(Color.black);
        table.setBounds(50, 130, 400,100);

        

        // traitement input
        Ref = new JLabel("RefType : ");
        Ref.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Ref.setForeground(Color.black);
        Ref.setBounds(50, 200, 300,100);

        inputRef = new JTextField();
        inputRef.setPreferredSize(new Dimension(200, 10));
        inputRef.setBounds(180, 240, 200,30);
        inputRef.setBackground(Color.white);
        inputRef.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputRef.setForeground(Color.GRAY);
        inputRef.setText("Entrer la Reference ");
        inputRef.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputRef.getForeground() == Color.GRAY) {
                    inputRef.setText("");
                    inputRef.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputRef.getText().isEmpty()) {
                    inputRef.setText("Entrer la Reference ");
                    inputRef.setForeground(Color.black);
                }
            }
        });
        inputRef.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputRef.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputRef.setBackground(Color.white);
                    
                }
            
        });

        Nom = new JLabel("NomType :");
        Nom.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Nom.setForeground(Color.black);
        Nom.setBounds(50, 250, 400,100);
        
        inputNom = new JTextField();
        inputNom.setPreferredSize(new Dimension(200, 10));
        inputNom.setBounds(180, 290, 200,30);
        inputNom.setBackground(Color.white);
        inputNom.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputNom.setForeground(Color.GRAY);
        inputNom.setText("Entrer le Nom ");
        inputNom.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputNom.getForeground() == Color.GRAY) {
                    inputNom.setText("");
                    inputNom.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputNom.getText().isEmpty()) {
                    inputNom.setText("Enter votre Nom");
                    inputNom.setForeground(Color.black);
                }
            }
        });
        inputNom.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputNom.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputNom.setBackground(Color.white);
                    
                }
            
        });

        Annuler = new buttonRounded("Annuler");
        Annuler.setBounds(200,350,145,30);
        Annuler.addActionListener(new ActionListener() {
                    public void actionPerformed (ActionEvent e)
                    {
                       //tfaragh les input 
                        
                       inputRef.setText("Entrer la Referance");
                       inputRef.setForeground(Color.GRAY);
                       inputRef.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputRef.getForeground() == Color.GRAY) {
                                    inputRef.setText("");
                                    inputRef.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputRef.getText().isEmpty()) {
                                    inputRef.setText("Enter la Reference");
                                    inputRef.setForeground(Color.black);
                                }
                            }
                        });     

                       inputNom.setText("Entrer le Nom ");
                       inputNom.setForeground(Color.GRAY);
                       inputNom.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputNom.getForeground() == Color.GRAY) {
                                    inputNom.setText("");
                                    inputNom.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputNom.getText().isEmpty()) {
                                    inputNom.setText("Enter le Nom");
                                    inputNom.setForeground(Color.black);
                                }
                            }
                        });     

                        }
                    
                });

                 
            if (Action.equals("insertion")){
                    inserer = new buttonRounded("Inserer");
                    inserer.setBounds(50,350,145,30);
                    backgroundImage.add(inserer);
                    inserer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            RefTypevalue = inputRef.getText();
                            NomTypevalue = inputNom.getText();
                            TypeIngridient ti = new TypeIngridient(NomTypevalue, RefTypevalue);
                            TypeIngredientDao tid = new TypeIngredientDao (con);   
                            tid.create(ti);
                           
                   }});
                   }
            else if (Action.equals("Modification")){
                    Modifier = new buttonRounded("Modifier");
                    Modifier.setBounds(50,350,145,30);
                    backgroundImage.add(Modifier);
                    Modifier.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            RefTypevalue = inputRef.getText();
                            NomTypevalue = inputNom.getText();
                            TypeIngridient ti = new TypeIngridient(NomTypevalue, RefTypevalue);
                            TypeIngredientDao tid = new TypeIngredientDao (con);   
                            tid.update(ti);
                        
                 }});
                   }
                   
            else {
                    Supprimer = new buttonRounded("Supprimer");
                    Supprimer.setBounds(50,350,145,30);
                    backgroundImage.add(Supprimer);
                    Supprimer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) { 
                            Connection con = DBMSC.getConnection();
                            RefTypevalue = inputRef.getText();
                            NomTypevalue = inputNom.getText();
                            TypeIngridient ti = new TypeIngridient(NomTypevalue, RefTypevalue);
                            TypeIngredientDao tid = new TypeIngredientDao (con); 
                             tid.delete(ti);
                        
                    }});
                   }

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
        backgroundImage.add(homeLabel);
        backgroundImage.add(home);
        backgroundImage.add(Back);
        backgroundImage.add(BackLabel);
        backgroundImage.add(Ref);
        backgroundImage.add(inputRef);
        backgroundImage.add(Annuler);
        backgroundImage.add(titre);
        backgroundImage.add(table);
        if (Action.equals("Modification") || Action.equals("insertion") )
        {backgroundImage.add(Nom);
        backgroundImage.add(inputNom);
        }
        this.add(backgroundImage);
       
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(570, 90);

        

    }

}

