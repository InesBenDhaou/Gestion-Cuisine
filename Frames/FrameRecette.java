import javax.swing.JFrame;

import DAO.RecetteDao;
import Models.DBMSC;
import Models.Recette;

import java.awt.Color;
import javax.swing.*;
import java.sql.Connection;
import java.awt.*;
import java.awt.event.*;

public class FrameRecette extends JFrame {
    
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
    JLabel Desc;
    JLabel calorie;
    JLabel diff;
    JLabel TemP;
    JLabel TemC;
    JLabel Nbper;

    JTextField inputRef;
    JTextField inputNom;
    JTextField inputDesc;
    JTextField inputcalorie;
    JTextField inputdiff;
    JTextField inputTemP;
    JTextField inputTemC;
    JTextField inputNbper;
    
    buttonRounded Annuler ;
    buttonRounded inserer ;
    buttonRounded Modifier ;
    buttonRounded Supprimer ;
    String Refvalue ;
    String Nomvalue ;
    String Descvalue ;
    Double Calvalue ;
    String Diffvalue ;
    Double Tpvalue ;
    Double Tcvalue ;
    int NbValue ;

    public FrameRecette (String Action)
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
                       FrameMiseAJour f = new FrameMiseAJour("RECETTE") ;
                 }
         });

        titre = new JLabel("GESTION DE CUISINE");
        titre.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        titre.setForeground(Color.black);
        titre.setBounds(18, 70, 400,100);

        table = new JLabel("-Table Recette-");
        table.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        table.setForeground(Color.black);
        table.setBounds(90, 110, 400,100);

        

        // traitement input
        Ref = new JLabel("RefRecette : ");
        Ref.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Ref.setForeground(Color.black);
        Ref.setBounds(30, 170, 300,100);

        inputRef = new JTextField();
        inputRef.setPreferredSize(new Dimension(200, 10));
        inputRef.setBounds(180, 210, 200,30);
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

        Nom = new JLabel("NomRecette :");
        Nom.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Nom.setForeground(Color.black);
        Nom.setBounds(30, 220, 400,100);
        
        inputNom = new JTextField();
        inputNom.setPreferredSize(new Dimension(200, 10));
        inputNom.setBounds(180, 260, 200,30);
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
                    inputNom.setText("Enter le Nom");
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

        Desc = new JLabel("Decription :");
        Desc.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Desc.setForeground(Color.black);
        Desc.setBounds(30, 270, 400,100);
        
        inputDesc = new JTextField();
        inputDesc.setPreferredSize(new Dimension(200, 10));
        inputDesc.setBounds(180, 310, 200,30);
        inputDesc.setBackground(Color.white);
        inputDesc.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputDesc.setForeground(Color.GRAY);
        inputDesc.setText("Entrer la Decription ");
        inputDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputDesc.getForeground() == Color.GRAY) {
                    inputDesc.setText("");
                    inputDesc.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputDesc.getText().isEmpty()) {
                    inputDesc.setText("Entrer la Decription");
                    inputDesc.setForeground(Color.black);
                }
            }
        });
        inputDesc.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputDesc.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputDesc.setBackground(Color.white);
                    
                }
            
        });

        calorie = new JLabel("Calories :");
        calorie.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        calorie.setForeground(Color.black);
        calorie.setBounds(30, 320, 400,100);
        
        inputcalorie = new JTextField();
        inputcalorie.setPreferredSize(new Dimension(200, 10));
        inputcalorie.setBounds(180, 360, 200,30);
        inputcalorie.setBackground(Color.white);
        inputcalorie.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputcalorie.setForeground(Color.GRAY);
        inputcalorie.setText("Entrer Nb Calories ");
        inputcalorie.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputcalorie.getForeground() == Color.GRAY) {
                    inputcalorie.setText("");
                    inputcalorie.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputcalorie.getText().isEmpty()) {
                    inputcalorie.setText("Entrer Nb Calories");
                    inputcalorie.setForeground(Color.black);
                }
            }
        });
        inputcalorie.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputcalorie.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputcalorie.setBackground(Color.white);
                    
                }
            
        });

        diff = new JLabel("Difficulte :");
        diff.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        diff.setForeground(Color.black);
        diff.setBounds(30, 370, 400,100);
        
        inputdiff = new JTextField();
        inputdiff.setPreferredSize(new Dimension(200, 10));
        inputdiff.setBounds(180, 410, 200,30);
        inputdiff.setBackground(Color.white);
        inputdiff.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputdiff.setForeground(Color.GRAY);
        inputdiff.setText("Entrer la Difficulte ");
        inputdiff.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputdiff.getForeground() == Color.GRAY) {
                    inputdiff.setText("");
                    inputdiff.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputdiff.getText().isEmpty()) {
                    inputdiff.setText("Entrer la Difficulte");
                    inputdiff.setForeground(Color.black);
                }
            }
        });

        inputdiff.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputdiff.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputdiff.setBackground(Color.white);
                    
                }
            
        });
        
        TemP= new JLabel("TempsPrepara :");
        TemP.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        TemP.setForeground(Color.black);
        TemP.setBounds(30, 420, 400,100);
        
        inputTemP = new JTextField();
        inputTemP.setPreferredSize(new Dimension(200, 10));
        inputTemP.setBounds(180, 460, 200,30);
        inputTemP.setBackground(Color.white);
        inputTemP.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputTemP.setForeground(Color.GRAY);
        inputTemP.setText("Entrer le Temps ");
        inputTemP.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputTemP.getForeground() == Color.GRAY) {
                    inputTemP.setText("");
                    inputTemP.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputTemP.getText().isEmpty()) {
                    inputTemP.setText("Entrer le Temps");
                    inputTemP.setForeground(Color.black);
                }
            }
        });
        inputTemP.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputTemP.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputTemP.setBackground(Color.white);
                    
                }
            
        });

        TemC = new JLabel("TempsCuisson :");
        TemC.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        TemC.setForeground(Color.black);
        TemC.setBounds(30, 470, 400,100);
        
        inputTemC = new JTextField();
        inputTemC.setPreferredSize(new Dimension(200, 10));
        inputTemC.setBounds(180, 510, 200,30);
        inputTemC.setBackground(Color.white);
        inputTemC.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputTemC.setForeground(Color.GRAY);
        inputTemC.setText("Entrer le Temps ");
        inputTemC.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputTemC.getForeground() == Color.GRAY) {
                    inputTemC.setText("");
                    inputTemC.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputTemC.getText().isEmpty()) {
                    inputTemC.setText("Entrer le Temps");
                    inputTemC.setForeground(Color.black);
                }
            }
        });
        inputTemC.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputTemC.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputTemC.setBackground(Color.white);
                    
                }
            
        });

        Nbper = new JLabel("NbPersonnes :");
        Nbper.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Nbper.setForeground(Color.black);
        Nbper.setBounds(30, 520, 400,100);
        
        inputNbper = new JTextField();
        inputNbper.setPreferredSize(new Dimension(200, 10));
        inputNbper.setBounds(180, 560, 200,30);
        inputNbper.setBackground(Color.white);
        inputNbper.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputNbper.setForeground(Color.GRAY);
        inputNbper.setText("Entrer NbPersonnes ");
        inputNbper.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputNbper.getForeground() == Color.GRAY) {
                    inputNbper.setText("");
                    inputNbper.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputNbper.getText().isEmpty()) {
                    inputNbper.setText("Entrer NbPersonnes");
                    inputNbper.setForeground(Color.black);
                }
            }
        });
        inputNbper.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputNbper.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputNbper.setBackground(Color.white);
                    
                }
            
        });

        Annuler = new buttonRounded("Annuler");
        Annuler.setBounds(200,600,145,30);
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

                        inputDesc.setText("Entrer Description ");
                        inputDesc.setForeground(Color.GRAY);
                        inputDesc.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputDesc.getForeground() == Color.GRAY) {
                                    inputDesc.setText("");
                                    inputDesc.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputDesc.getText().isEmpty()) {
                                    inputDesc.setText("Entrer Description");
                                    inputDesc.setForeground(Color.black);
                                }
                            }
                        });     

                        inputcalorie.setText("Entrer Nb Calorie ");
                        inputcalorie.setForeground(Color.GRAY);
                        inputcalorie.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputcalorie.getForeground() == Color.GRAY) {
                                    inputcalorie.setText("");
                                    inputcalorie.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputcalorie.getText().isEmpty()) {
                                    inputcalorie.setText("Entrer Nb Calorie");
                                    inputcalorie.setForeground(Color.black);
                                }
                            }
                        });     

                        inputdiff.setText("Entrer la Difficulte ");
                        inputdiff.setForeground(Color.GRAY);
                        inputdiff.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputdiff.getForeground() == Color.GRAY) {
                                    inputdiff.setText("");
                                    inputdiff.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputdiff.getText().isEmpty()) {
                                    inputdiff.setText("Entrer la Difficulte ");
                                    inputdiff.setForeground(Color.black);
                                }
                            }
                        });     

                        inputTemP.setText("Entrer le temps");
                        inputTemP.setForeground(Color.GRAY);
                        inputTemP.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputdiff.getForeground() == Color.GRAY) {
                                    inputdiff.setText("");
                                    inputdiff.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputdiff.getText().isEmpty()) {
                                    inputdiff.setText("Entrer le temps ");
                                    inputdiff.setForeground(Color.black);
                                }
                            }
                        });     
                        inputTemC.setText("Entrer le temps ");
                        inputTemC.setForeground(Color.GRAY);
                        inputTemC.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputTemC.getForeground() == Color.GRAY) {
                                    inputTemC.setText("");
                                    inputTemC.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputTemC.getText().isEmpty()) {
                                    inputTemC.setText("Entrer le temps ");
                                    inputTemC.setForeground(Color.black);
                                }
                            }
                        });   

                        inputNbper.setText("Entrer NbPersonnes ");
                        inputNbper.setForeground(Color.GRAY);
                        inputNbper.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputNbper.getForeground() == Color.GRAY) {
                                    inputNbper.setText("");
                                    inputNbper.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputNbper.getText().isEmpty()) {
                                    inputNbper.setText("Entrer NbPersonnes ");
                                    inputNbper.setForeground(Color.black);
                                }
                            }
                        });     
   

                        }
                    
                });

                
            if (Action.equals("insertion")){
                    inserer = new buttonRounded("Inserer");
                    inserer.setBounds(50,600,145,30);
                    backgroundImage.add(inserer);
                    inserer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            Nomvalue = inputNom.getText();
                            Descvalue = inputDesc.getText();
                            Calvalue = Double.parseDouble(inputcalorie.getText());
                            Diffvalue = inputdiff.getText();
                            Tpvalue = Double.parseDouble(inputTemP.getText());
                            Tcvalue = Double.parseDouble(inputTemC.getText());
                            NbValue = Integer.parseInt(inputNbper.getText());
                            
                            Recette r = new Recette (Refvalue, Nomvalue,Descvalue,Calvalue,Diffvalue,Tpvalue,Tcvalue,NbValue);
                            RecetteDao rd = new RecetteDao (con);   
                            rd.create(r);
                           
                   }});
                   }
            else if (Action.equals("Modification")){
                    Modifier = new buttonRounded("Modifier");
                    Modifier.setBounds(50,600,145,30);
                    backgroundImage.add(Modifier);
                    Modifier.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            Nomvalue = inputNom.getText();
                            Descvalue = inputDesc.getText();
                            Calvalue = Double.parseDouble(inputcalorie.getText());
                            Diffvalue = inputdiff.getText();
                            Tpvalue = Double.parseDouble(inputTemP.getText());
                            Tcvalue = Double.parseDouble(inputTemC.getText());
                            NbValue = Integer.parseInt(inputNbper.getText());
                            
                            Recette r = new Recette (Refvalue, Nomvalue,Descvalue,Calvalue,Diffvalue,Tpvalue,Tcvalue,NbValue);
                            RecetteDao rd = new RecetteDao (con);   
                            rd.update(r);
                           
                   }});
                        
                    
                   }
                   
            else {
                    Supprimer = new buttonRounded("Supprimer");
                    Supprimer.setBounds(50,600,145,30);
                    backgroundImage.add(Supprimer);
                    Supprimer.addActionListener(new ActionListener() {
                       
                        
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            RecetteDao rd = new RecetteDao (con);   
                            Recette r = rd.find(Refvalue);
                            rd.delete(r);
                           
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
        {        
                 backgroundImage.add(inputNom);
                 backgroundImage.add(inputDesc);
                 backgroundImage.add(inputdiff);
                 backgroundImage.add(inputNbper);
                 backgroundImage.add(inputcalorie);
                 backgroundImage.add(inputTemC);
                 backgroundImage.add(inputTemP);
                 backgroundImage.add(Nom);
                 backgroundImage.add(Desc);
                 backgroundImage.add(calorie); 
                 backgroundImage.add(diff);  
                 backgroundImage.add(TemC);
                 backgroundImage.add(TemP);
                 backgroundImage.add(Nbper);
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
