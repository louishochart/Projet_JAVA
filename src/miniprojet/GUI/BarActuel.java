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
public class BarActuel extends JFrame {
    
    private JButton bouton1 = new JButton("Créer nouveau personnage");
    private JButton bouton2 = new JButton("Voir personnages existants");
    private JButton retour = new JButton("Retour");
    
    public BarActuel() {
        
        this.setTitle("Bar actuel");
        this.setSize(500, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        bouton1.addActionListener(new Bouton1Listener());
        retour.addActionListener(new RetourListener());
        
        Box box1 = Box.createHorizontalBox(); 
        box1.add(bouton1);
        box1.add(bouton2);
        Box box2 = Box.createHorizontalBox(); 
        box2.add(retour);
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
            HumanCreation fen = new HumanCreation();
       }
    }
    
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            Interface1 fen = new Interface1();
        }
    }
    
    
    
    
    
}
