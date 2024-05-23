import javax.swing.JFrame;

import DAO.IngredientDao;
import DAO.ProduitDao;
import DAO.RangementDao;
import Models.DBMSC;
import Models.Produit;
import Models.Rangement;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.time.LocalDate;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FrameProduit extends JFrame {
    
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
    
    buttonRounded Annuler ;
    buttonRounded inserer ;
    buttonRounded Modifier ;
    buttonRounded Supprimer ;

    String Refvalue ;
    String Descvalue ;
    String Datevalue ;
    Double Qtevalue ;
    Double Prixvalue ;
    String RefRangvalue ;
    String RefIngvalue ;


    public FrameProduit (String Action)
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
                   FrameMiseAJour f = new FrameMiseAJour("PRODUIT") ;
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
                       FrameMiseAJour f = new FrameMiseAJour("PRODUIT") ;
                 }
         });

        titre = new JLabel("GESTION DE CUISINE");
        titre.setFont(new Font(Font.SERIF, Font.BOLD, 35));
        titre.setForeground(Color.black);
        titre.setBounds(18, 70, 400,100);

        table = new JLabel("-Table Produit-");
        table.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        table.setForeground(Color.black);
        table.setBounds(90, 110, 400,100);

        

        // traitement input
        Ref = new JLabel("RefProduit : ");
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

        Desc = new JLabel("Description :");
        Desc.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Desc.setForeground(Color.black);
        Desc.setBounds(30, 220, 400,100);
        
        inputDesc = new JTextField();
        inputDesc.setPreferredSize(new Dimension(200, 10));
        inputDesc.setBounds(180, 260, 200,30);
        inputDesc.setBackground(Color.white);
        inputDesc.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputDesc.setForeground(Color.GRAY);
        inputDesc.setText("Entrer la Description ");
        inputDesc.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputDesc.getForeground() == Color.GRAY) {
                    inputDesc.setText("");
                    inputDesc.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputDesc.getText().isEmpty()) {
                    inputDesc.setText("Enter la Description");
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

        Qte = new JLabel("Quantite:");
        Qte.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Qte.setForeground(Color.black);
        Qte.setBounds(30, 270, 400,100);
        
        inputQte = new JTextField();
        inputQte.setPreferredSize(new Dimension(200, 10));
        inputQte.setBounds(180, 310, 200,30);
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
                    inputQte.setText("Entrer la Quantite");
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

        Date = new JLabel("DatePeremption :");
        Date.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Date.setForeground(Color.black);
        Date.setBounds(30, 320, 400,100);
        
        inputDate = new JTextField();
        inputDate.setPreferredSize(new Dimension(200, 10));
        inputDate.setBounds(180, 360, 200,30);
        inputDate.setBackground(Color.white);
        inputDate.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputDate.setForeground(Color.GRAY);
        inputDate.setText("Entrer Date ");
        inputDate.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputDate.getForeground() == Color.GRAY) {
                    inputDate.setText("");
                    inputDate.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputDate.getText().isEmpty()) {
                    inputDate.setText("Entrer Date");
                    inputDate.setForeground(Color.black);
                }
            }
        });
        inputDate.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputDate.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputDate.setBackground(Color.white);
                    
                }
            
        });

        Prix = new JLabel("Prix :");
        Prix.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        Prix.setForeground(Color.black);
        Prix.setBounds(30, 370, 400,100);
        
        inputPrix = new JTextField();
        inputPrix.setPreferredSize(new Dimension(200, 10));
        inputPrix.setBounds(180, 410, 200,30);
        inputPrix.setBackground(Color.white);
        inputPrix.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputPrix.setForeground(Color.GRAY);
        inputPrix.setText("Entrer le Prix ");
        inputPrix.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputPrix.getForeground() == Color.GRAY) {
                    inputPrix.setText("");
                    inputPrix.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputPrix.getText().isEmpty()) {
                    inputPrix.setText("Entrer le Prix");
                    inputPrix.setForeground(Color.black);
                }
            }
        });

        inputPrix.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputPrix.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputPrix.setBackground(Color.white);
                    
                }
            
        });
        
        RefRang= new JLabel("RefRangement :");
        RefRang.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        RefRang.setForeground(Color.black);
        RefRang.setBounds(30, 420, 400,100);
        
        inputRefRang = new JTextField();
        inputRefRang.setPreferredSize(new Dimension(200, 10));
        inputRefRang.setBounds(180, 460, 200,30);
        inputRefRang.setBackground(Color.white);
        inputRefRang.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputRefRang.setForeground(Color.GRAY);
        inputRefRang.setText("Entrer la Reference ");
        inputRefRang.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputRefRang.getForeground() == Color.GRAY) {
                    inputRefRang.setText("");
                    inputRefRang.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputRefRang.getText().isEmpty()) {
                    inputRefRang.setText("Entrer la Reference");
                    inputRefRang.setForeground(Color.black);
                }
            }
        });
        inputRefRang.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                inputRefRang.setBackground(new Color (248, 160, 160));
                }
                
            
            public void mouseExited(MouseEvent e) {
                
                inputRefRang.setBackground(Color.white);
                    
                }
            
        });

        RefIng = new JLabel("RefIngredient :");
        RefIng.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        RefIng.setForeground(Color.black);
        RefIng.setBounds(30, 470, 400,100);
        
        inputRefIng= new JTextField();
        inputRefIng.setPreferredSize(new Dimension(200, 10));
        inputRefIng.setBounds(180, 510, 200,30);
        inputRefIng.setBackground(Color.white);
        inputRefIng.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        inputRefIng.setForeground(Color.GRAY);
        inputRefIng.setText("Entrer la Reference ");
        inputRefIng.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (inputRefIng.getForeground() == Color.GRAY) {
                    inputRefIng.setText("");
                    inputRefIng.setForeground(Color.black);
                }
            }
            
            public void focusLost(FocusEvent e) {
                if (inputRefIng.getText().isEmpty()) {
                    inputRefIng.setText("Entrer la Reference");
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
        Annuler.setBounds(200,560,145,30);
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

                       inputDesc.setText("Entrer Description  ");
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
                                    inputDesc.setText("Entrer Description ");
                                    inputDesc.setForeground(Color.black);
                                }
                            }
                        });  


                        inputRefIng.setText("Entrer la Reference ");
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
                                    inputRefIng.setText("Entrer la Reference");
                                    inputRefIng.setForeground(Color.black);
                                }
                            }
                        });     

                        inputDate.setText("Entrer la Date");
                        inputDate.setForeground(Color.GRAY);
                        inputDate.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputDate.getForeground() == Color.GRAY) {
                                    inputDate.setText("");
                                    inputDate.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputDate.getText().isEmpty()) {
                                    inputDate.setText("Entrer Date ");
                                    inputDate.setForeground(Color.black);
                                }
                            }
                        });     

                        inputQte.setText("Entrer la Quantite ");
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
                                    inputQte.setText("Entrer la Quantite ");
                                    inputQte.setForeground(Color.black);
                                }
                            }
                        });     
                        inputPrix.setText("Entrer le Prix ");
                        inputPrix.setForeground(Color.GRAY);
                        inputPrix.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputPrix.getForeground() == Color.GRAY) {
                                    inputPrix.setText("");
                                    inputPrix.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputPrix.getText().isEmpty()) {
                                    inputPrix.setText("Entrer le Prix ");
                                    inputPrix.setForeground(Color.black);
                                }
                            }
                        });   

                        inputRefRang.setText("Entrer la Referance ");
                        inputRefRang.setForeground(Color.GRAY);
                        inputRefRang.addFocusListener(new FocusListener() {
                            public void focusGained(FocusEvent e) {
                                if (inputRefRang.getForeground() == Color.GRAY) {
                                    inputRefRang.setText("");
                                    inputRefRang.setForeground(Color.BLACK);
                                }
                            }
                            
                            public void focusLost(FocusEvent e) {
                                if (inputRefRang.getText().isEmpty()) {
                                    inputRefRang.setText("Entrer la Referance ");
                                    inputRefRang.setForeground(Color.black);
                                }
                            }
                        });     
   

                        }
                    
                });

                
            if (Action.equals("insertion")){
                    inserer = new buttonRounded("Inserer");
                    inserer.setBounds(50,560,145,30);
                    backgroundImage.add(inserer);
                    inserer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            Descvalue = inputDesc.getText();
                            Datevalue =  inputDate.getText();
                            Qtevalue = Double.parseDouble(inputQte.getText());
                            Prixvalue = Double.parseDouble(inputPrix.getText());
                            RefRangvalue = inputRefRang.getText();
                            RefIngvalue = inputRefIng.getText();
                            ProduitDao tid = new ProduitDao (con);   
                            RangementDao rg = new RangementDao(con);
                            IngredientDao i = new IngredientDao(con);
                            Produit ti = new Produit(Refvalue, Descvalue,Datevalue,Qtevalue,Prixvalue,rg.find(RefRangvalue),i.find(RefIngvalue));
                            tid.create(ti);
                           
                   }});
                   }
            else if (Action.equals("Modification")){
                    Modifier = new buttonRounded("Modifier");
                    Modifier.setBounds(50,560,145,30);
                    backgroundImage.add(Modifier);
                    Modifier.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            Descvalue = inputDesc.getText();
                            Datevalue =  inputDate.getText();
                            Qtevalue = Double.parseDouble(inputQte.getText());
                            Prixvalue = Double.parseDouble(inputPrix.getText());
                            RefRangvalue = inputRefRang.getText();
                            RefIngvalue = inputRefIng.getText();
                            ProduitDao tid = new ProduitDao (con);   
                            RangementDao rg = new RangementDao(con);
                            IngredientDao i = new IngredientDao(con);
                            Produit ti = new Produit(Refvalue, Descvalue,Datevalue,Qtevalue,Prixvalue,rg.find(RefRangvalue),i.find(RefIngvalue));
                            tid.update(ti);
                           
                        
                    }});
                   }
                   
            else {
                    Supprimer = new buttonRounded("Supprimer");
                    Supprimer.setBounds(50,560,145,30);
                    backgroundImage.add(Supprimer);
                    Supprimer.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {  
                            Connection con = DBMSC.getConnection();
                            Refvalue = inputRef.getText();
                            ProduitDao tid = new ProduitDao (con);  
                            Produit p = tid.find(Refvalue);
                            tid.delete(p);
                           
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
            backgroundImage.add(Qte);
            backgroundImage.add(Desc);
            backgroundImage.add(RefIng); 
            backgroundImage.add(RefRang);  
            backgroundImage.add(Prix);
            backgroundImage.add(Date);
            backgroundImage.add(inputQte);
            backgroundImage.add(inputDesc);
            backgroundImage.add(inputRefIng);
            backgroundImage.add(inputRefRang);
            backgroundImage.add(inputPrix);
            backgroundImage.add(inputDate);
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
