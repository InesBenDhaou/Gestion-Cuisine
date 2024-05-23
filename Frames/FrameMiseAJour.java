//package Frames;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class FrameMiseAJour extends JFrame {
    
    private ImageIcon food ;
    private JLabel backgroundImage ;

    JLabel titre ;
    JLabel bv ;

    JButton home;
    JLabel homeLabel;

    JButton Back;
    JLabel BackLabel;

    
    buttonRounded Recherche  ;
    buttonRounded insertion ;
    buttonRounded Modification ;
    buttonRounded Suppression ;
    buttonRounded Lister;

    public FrameMiseAJour (String NomTable)
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

         Recherche = new buttonRounded("RECHERCHE");
         Recherche.setBounds(98,230,200,50);
         Recherche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                recherche r = new recherche(NomTable) ;
          }
         });
         insertion = new buttonRounded("INSERTION");
         insertion.setBounds(98,290,200,50);
         insertion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (NomTable.equals("RANGEMENT"))
                {FrameRangement r = new FrameRangement("insertion") ;}
                if (NomTable.equals("TYPE INGREDIENT"))
                {FrameTypeIng r = new FrameTypeIng("insertion") ;}
                if (NomTable.equals("INGREDIENT"))
                {FrameIng r = new FrameIng("insertion");}
                if (NomTable.equals("RECETTE"))
                {FrameRecette r = new FrameRecette("insertion");}
                if (NomTable.equals("COMPOSITION"))
                {FrameCompo r = new FrameCompo("insertion");}
                if (NomTable.equals("PRODUIT"))
                {FrameProduit r = new FrameProduit("insertion");}
          }
         });

         Modification = new buttonRounded("MODIFICATION");
         Modification.setBounds(98,350,200,50);
         Modification.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (NomTable.equals("RANGEMENT"))
                {FrameRangement r = new FrameRangement("Modification") ;}
                else if (NomTable.equals("TYPE INGREDIENT"))
                {FrameTypeIng r = new FrameTypeIng("Modification") ;}
                else if (NomTable.equals("INGREDIENT"))
                {FrameIng r = new FrameIng("Modification");}
                else if (NomTable.equals("RECETTE"))
                {FrameRecette r = new FrameRecette("Modification");}
                else if (NomTable.equals("COMPOSITION"))
                {FrameCompo r = new FrameCompo("Modification");}
                else 
                {FrameProduit r = new FrameProduit("Modification");}
          }
         });
         Suppression = new buttonRounded("SUPPRESSION");
         Suppression.setBounds(98,410,200,50);
         Suppression.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                if (NomTable.equals("RANGEMENT"))
                {FrameRangement r = new FrameRangement("Suppression") ;}
                else if (NomTable.equals("TYPE INGREDIENT"))
                {FrameTypeIng r = new FrameTypeIng("Suppression") ;}
                else if (NomTable.equals("INGREDIENT"))
                {FrameIng r = new FrameIng("Suppression");}
                else if (NomTable.equals("RECETTE"))
                {FrameRecette r = new FrameRecette("Suppression");}
                else if (NomTable.equals("COMPOSITION"))
                {FrameCompo r = new FrameCompo("Suppression");}
                else
                {FrameProduit r = new FrameProduit("Suppression");}
          }
         });
         Lister = new buttonRounded("LISTER");
         Lister.setBounds(98,470,200,50);
         Lister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameLister f = new FrameLister(NomTable);
                
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
        backgroundImage.add(Suppression);
        backgroundImage.add(Modification);
        backgroundImage.add(insertion);
        backgroundImage.add(Recherche);
        backgroundImage.add(Lister);
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
