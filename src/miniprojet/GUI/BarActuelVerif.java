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

import miniprojet.Functions.*;


/**
 *
 * @author Louis
 */
public class BarActuelVerif extends JFrame {
    
    private JButton nvperso = new JButton("Créer nouveau personnage");
    private JButton persosactuels = new JButton("Voir personnages existants");
    private JButton retour = new JButton("Retour");
    
    public BarActuelVerif() {
        
        this.setTitle("Bar actuel Verification");
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        nvperso.addActionListener(new NvPersoListener());
        retour.addActionListener(new RetourListener());
        persosactuels.addActionListener(new PersosActuelsListener());
        
        Box vbox1 = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox(); 
        hbox1.add(nvperso);
        vbox1.add(hbox1);
        this.getContentPane().add(vbox1, BorderLayout.NORTH);
        
        Box vbox2 = Box.createVerticalBox();
        Box hbox2 = Box.createHorizontalBox();
        hbox2.add(retour);
        vbox2.add(hbox2);
        this.getContentPane().add(vbox2, BorderLayout.PAGE_END);
        
        Box vbox3 = Box.createVerticalBox();
        Box hbox3 = Box.createHorizontalBox();
        if(new Files().checkIfEmpty("patronne")||new Files().checkIfEmpty("barman")||new Files().checkIfEmpty("fournisseur")){
            JLabel label = new JLabel("Vous devez créer un nouveau bar");
            hbox3.add(label);
        }
        else if(new Files().checkIfEmpty("clients")&&new Files().checkIfEmpty("clientes")){
            JLabel label = new JLabel("Il faut aujouter des client(e)s");
            hbox3.add(label);
        }
        else if(new Files().checkIfEmpty("serveurs")&&new Files().checkIfEmpty("serveuses")){
            JLabel label = new JLabel("Il faut aujouter des serveu(r)s(es)");
            hbox3.add(label);
        }
        else{
            hbox3.add(persosactuels);
        }
        vbox3.add(hbox3);
        this.getContentPane().add(vbox3, BorderLayout.CENTER);
        
        this.getContentPane().setBackground(Color.ORANGE);
        
        this.setVisible(true);

    }
    
    class NvPersoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            HumanCreation2 fen = new HumanCreation2();
       }
    }
    
    class PersosActuelsListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            PersosActuels fen = new PersosActuels();
       }
    }
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            PageAccueil fen = new PageAccueil();
        }
    }
    
    
    
    
    
}
