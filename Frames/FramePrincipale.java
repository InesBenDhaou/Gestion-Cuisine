//package Frames;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class FramePrincipale extends JFrame {
    
    private ImageIcon food ;
    private JLabel backgroundImage ;

    JButton home;
    JLabel homeLabel;

    JButton Back;
    JLabel BackLabel;

    JLabel titre ;
    JLabel bv ;
    
    buttonRounded RANGEMENT  ;
    buttonRounded TYPE_INGREDIENT ;
    buttonRounded INGREDIENT ;
    buttonRounded RECETTE ;
    buttonRounded COMPOSITION;
    buttonRounded PRODUIT;
    protected static Color HOVER_COLOR  = new Color (248, 160, 160) ;
    public FramePrincipale ()
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

        bv = new JLabel("bienvenue!");
        bv.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        bv.setForeground(Color.black);
        bv.setBounds(120, 130, 400,100);

        // traitement button

        RANGEMENT = new buttonRounded("RANGEMENT");
        RANGEMENT.setBounds(98,230,200,50);
        RANGEMENT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameMiseAJour f = new FrameMiseAJour("RANGEMENT") ;
            }
        });
        TYPE_INGREDIENT = new buttonRounded("TYPE INGREDIENT");
        TYPE_INGREDIENT.setBounds(98,290,200,50);
        TYPE_INGREDIENT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameMiseAJour f = new FrameMiseAJour("TYPE INGREDIENT") ;
            }
        });
        INGREDIENT = new buttonRounded("INGREDIENT");
        INGREDIENT.setBounds(98,350,200,50);
        INGREDIENT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameMiseAJour f = new FrameMiseAJour("INGREDIENT") ;
            }
        });
        RECETTE= new buttonRounded("RECETTE");
        RECETTE.setBounds(98,410,200,50);
        RECETTE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameMiseAJour f = new FrameMiseAJour("RECETTE") ;
            }
        });
        COMPOSITION= new buttonRounded("COMPOSITION");
        COMPOSITION.setBounds(98,470,200,50);
        COMPOSITION.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameMiseAJour f = new FrameMiseAJour("COMPOSITION") ;
            }
        });
        
        PRODUIT = new buttonRounded("PRODUIT");
        PRODUIT.setBounds(98,530,200,50);
        PRODUIT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameMiseAJour f = new FrameMiseAJour("PRODUIT") ;
            }
        });
       
       

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
        backgroundImage.add(RECETTE);
        backgroundImage.add(TYPE_INGREDIENT);
        backgroundImage.add(INGREDIENT);
        backgroundImage.add(RANGEMENT);
        backgroundImage.add(COMPOSITION);
        backgroundImage.add(PRODUIT);
        backgroundImage.add(titre);
        backgroundImage.add(bv);
        this.add(backgroundImage);
        
        //frame
        this.setSize(410,680);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocation(570, 90);

        

    }

}
