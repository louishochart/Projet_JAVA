    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color; 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



 
/**
 *
 * @author Louis
 */

public class Interface1 extends JFrame {
   
    private JButton bouton1 = new JButton("Gerer Bar actuel");
    private JButton bouton2 = new JButton("Nouveau Bar");
    private JButton quitter = new JButton("Fermer");
    
    public Interface1(){
        
        this.setTitle("Gestion du Bar");
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        bouton1.addActionListener(new Bouton1Listener());
        bouton2.addActionListener(new Bouton2Listener());
        quitter.addActionListener(new QuitterListener());
        
        Box box1 = Box.createHorizontalBox(); 
        box1.add(bouton1);
        box1.add(bouton2);
        Box box2 = Box.createHorizontalBox(); 
        box2.add(quitter);
        Box box = Box.createVerticalBox();
        box.add(box1);
        box.add(box2);
        this.getContentPane().add(box);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setVisible(true);
    }

    class Bouton1Listener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuel baractuel = new BarActuel();    
        }
    }
    //Classe écoutant notre second bouton
    class Bouton2Listener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent ae) {
            dispose();
            NouveauBar nvbar = new NouveauBar();
        }
    }
    class QuitterListener implements ActionListener{
    //Redéfinition de la méthode actionPerformed()
        public void actionPerformed(ActionEvent ae) {
            dispose();
        }
    }
}
