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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import miniprojet.Bar.*;


/**
 *
 * @author Louis
 */
public class NouveauBarConfirmation extends JFrame {
    
    private JButton nvBar = new JButton("Créer nouveau Bar");
    private JButton retour = new JButton("Retour");
    
    
    public NouveauBarConfirmation() {
        
        nvBar.addActionListener(new nvBarListener());
        retour.addActionListener(new RetourListener());
        
        this.setTitle("Nouveau Bar Confirmation");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        Box vbox1 = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox(); 
        hbox1.add(nvBar);
        vbox1.add(hbox1);
        
        Box vbox2 = Box.createVerticalBox();
        Box hbox2 = Box.createHorizontalBox(); 
        hbox2.add(retour);
        vbox2.add(hbox2);
        
        this.getContentPane().add(vbox1,BorderLayout.NORTH);
        this.getContentPane().add(vbox2,BorderLayout.SOUTH);
        this.getContentPane().setBackground(Color.ORANGE);
        
        this.setVisible(true);

    }
    class nvBarListener implements ActionListener{
        
        public void actionPerformed(ActionEvent ae) {
            dispose();
            NouveauBar fen = new NouveauBar();
       }
    }
    
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            PageAccueil fen = new PageAccueil();
        }
    }
    
    
    
    
    
}
