import javax.swing.JFrame;

import DAO.CompositionDao;
import DAO.IngredientDao;
import DAO.RecetteDao;
import Models.Composition;
import Models.DBMSC;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class FrameCompo extends Frame {
    
    private ImageIcon food ;
    private JLabel backgroundImage ;

    JLabel titre ;
    JLabel table ;

    JButton home;
    JLabel homeLabel;

    JButton Back;
    JLabel BackLabel;

    JLabel Ref ;
    JLabel Qte ;
    JLabel RefRec;
    JLabel RefIng;

    JTextField inputRef;
    JTextField inputQte;
    JTextField inputRefRec;
    JTextField inputRefIng;
    
    buttonRounded Annuler ;
    buttonRounded inserer ;
    buttonRounded Modifier ;
    buttonRounded Supprimer ;

    String Refvalue ;
    Double Qtevalue ;
    String RefRecettevalue ;
    String RefIngvalue ;

    public FrameCompo (String Action)
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
                       FrameMiseAJour f = new FrameMiseAJour("COMPOSITION") ;
                 }
         });

        titre = new JLabel("GESTION DE CUISINE");
        titre.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        titre.setForeground(Color.black);
        titre.setBounds(18, 70, 400,100);

        table = new JLabel("-Table Composition-");
        table.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        table.setForeground(Color.black);
        table.setBounds(50, 130, 400,100);

        

        // traitement input
        Ref = new JLabel("RefComposition : ");
        Ref.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Ref.setForeground(Color.black);
        Ref.setBounds(30, 200, 300,100);

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

        Qte = new JLabel("Quantite :");
        Qte.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Qte.setForeground(Color.black);
        Qte.setBounds(30, 250, 400,100);
        
        inputQte = new JTextField();
        inputQte.setPreferredSize(new Dimension(200, 10));
        inputQte.setBounds(180, 290, 200,30);
        inputQte.setBackground(Color.white);
        inputQte.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputQte.setForeground(Color.GRAY);
        inputQte.setText("Entrer la Quantite ");
        inputQte.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputQte.getForeground() == Color.GRAY) {
                    inputQte.setText("");
                    inputQte.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputQte.getText().isEmpty()) {
                    inputQte.setText("Enter la Quantite");
                    inputQte.setForeground(Color.black);
                }
            }
        });
        inputQte.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputQte.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputQte.setBackground(Color.white);
                    
                }
            
        });

        RefRec = new JLabel("RefRecette :");
        RefRec.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        RefRec.setForeground(Color.black);
        RefRec.setBounds(30, 300, 400,100);
        
        inputRefRec = new JTextField();
        inputRefRec.setPreferredSize(new Dimension(200, 10));
        inputRefRec.setBounds(180, 340, 200,30);
        inputRefRec.setBackground(Color.white);
        inputRefRec.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputRefRec.setForeground(Color.GRAY);
        inputRefRec.setText("Entrer la RefRecette ");
        inputRefRec.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputRefRec.getForeground() == Color.GRAY) {
                    inputRefRec.setText("");
                    inputRefRec.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputRefRec.getText().isEmpty()) {
                    inputRefRec.setText("Entrer la RefRecette");
                    inputRefRec.setForeground(Color.black);
                }
            }
        });
        inputRefRec.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputRefRec.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputRefRec.setBackground(Color.white);
                    
                }
            
        });

        RefIng = new JLabel("RefIngredient :");
        RefIng.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        RefIng.setForeground(Color.black);
        RefIng.setBounds(30, 350, 400,100);
        
        inputRefIng = new JTextField();
        inputRefIng.setPreferredSize(new Dimension(200, 10));
        inputRefIng.setBounds(180, 390, 200,30);
        inputRefIng.setBackground(Color.white);
        inputRefIng.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputRefIng.setForeground(Color.GRAY);
        inputRefIng.setText("Entrer la RefIngredient ");
        inputRefIng.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputRefIng.getForeground() == Color.GRAY) {
                    inputRefIng.setText("");
                    inputRefIng.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputRefIng.getText().isEmpty()) {
                    inputRefIng.setText("Entrer la RefIngredient");
                    inputRefIng.setForeground(Color.black);
                }
            }
        });
        inputRefIng.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputRefIng.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputRefIng.setBackground(Color.white);
                    
                }
            
        });

        Annuler = new buttonRounded("Annuler");
        Annuler.setBounds(200,450,145,30);
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

                       inputQte.setText("Entrer la quantite ");
                       inputQte.setForeground(Color.GRAY);
                       inputQte.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputQte.getForeground() == Color.GRAY) {
                                    inputQte.setText("");
                                    inputQte.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputQte.getText().isEmpty()) {
                                    inputQte.setText("Enter la quantite");
                                    inputQte.setForeground(Color.black);
                                }
                            }
                        });  

                        inputRefRec.setText("Entrer la RefRecette ");
                        inputRefRec.setForeground(Color.GRAY);
                        inputRefRec.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputRefRec.getForeground() == Color.GRAY) {
                                    inputRefRec.setText("");
                                    inputRefRec.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputRefRec.getText().isEmpty()) {
                                    inputRefRec.setText("Entrer la RefRecette");
                                    inputRefRec.setForeground(Color.black);
                                }
                            }
                        });     
   
                        inputRefIng.setText("Entrer la RefIngredient ");
                        inputRefIng.setForeground(Color.GRAY);
                        inputRefIng.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputRefIng.getForeground() == Color.GRAY) {
                                    inputRefIng.setText("");
                                    inputRefIng.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputRefIng.getText().isEmpty()) {
                                    inputRefIng.setText("la RefIngredient");
                                    inputRefIng.setForeground(Color.black);
                                }
                            }
                        });     
   

                        }
                    
                });

               
            if (Action.equals("insertion")){
                    inserer = new buttonRounded("Inserer");
                    inserer.setBounds(50,450,145,30);
                    backgroundImage.add(inserer);
                    inserer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            Qtevalue = Double.parseDouble(inputQte.getText());
                            RefRecettevalue = inputRefRec.getText();
                            RefIngvalue = inputRefIng.getText();
                            CompositionDao tid = new CompositionDao (con);   
                            RecetteDao r = new RecetteDao(con);
                            IngredientDao i = new IngredientDao(con);

                            Composition ti = new Composition(Refvalue, Qtevalue,r.find(RefRecettevalue),i.find(RefIngvalue));
                            tid.create(ti);
                           
                   }});
                   }
            else if (Action.equals("Modification")){
                    Modifier = new buttonRounded("Modifier");
                    Modifier.setBounds(50,450,145,30);
                    backgroundImage.add(Modifier);
                    Modifier.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            Qtevalue = Double.parseDouble(inputQte.getText());
                            RefRecettevalue = inputRefRec.getText();
                            RefIngvalue = inputRefIng.getText();
                            CompositionDao tid = new CompositionDao (con);   
                            RecetteDao r = new RecetteDao(con);
                            IngredientDao i = new IngredientDao(con);

                            Composition ti = new Composition(Refvalue, Qtevalue,r.find(RefRecettevalue),i.find(RefIngvalue));
                            tid.update(ti);
                           
                   }});
                   
                   }
                   
            else {
                    Supprimer = new buttonRounded("Supprimer");
                    Supprimer.setBounds(50,450,145,30);
                    backgroundImage.add(Supprimer);
                    Supprimer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            CompositionDao tid = new CompositionDao (con);   
                            Composition ti = tid.find(Refvalue);
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
                    //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // do nothing and let the user continue using the frame
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
        {
            backgroundImage.add(Qte);
            backgroundImage.add(RefRec);
            backgroundImage.add(RefIng);
            backgroundImage.add(inputRefIng);
            backgroundImage.add(inputRefRec);
            backgroundImage.add(inputQte);

        }
        this.add(backgroundImage);
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
       // this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(570, 90);

        

    }

}

    

