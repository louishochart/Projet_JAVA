/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import miniprojet.Fonctions.Files;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color; 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import miniprojet.Bar.Bar;
import miniprojet.Fonctions.*;
import miniprojet.Bar.Simulation;



/**
 *
 * @author Louis
 */
public class BarActuelVerif extends JFrame {
    
    private JButton nvperso = new JButton("Créer nouveau personnage");
    private JButton persosactuels = new JButton("Voir personnages existants");
    private JButton simulation = new JButton("Entrer dans la simulation");
    private JButton retour = new JButton("Retour");
    
    public BarActuelVerif() {
        
        new RecupererDatabase();
        
        this.setTitle("Bar actuel");
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        nvperso.addActionListener(new NvPersoListener());
        retour.addActionListener(new RetourListener());
        persosactuels.addActionListener(new PersosActuelsListener());
        simulation.addActionListener(new SimulationListener());
        
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
        Box hbox4 = Box.createHorizontalBox();
        hbox4.add(new JLabel(" "));
        Box hbox5 = Box.createHorizontalBox();
        
        if(Bar.getInstance().getTables().size()<1){
            JLabel label = new JLabel("Il faut aujouter des tables");
            hbox3.add(label);
        }
        else if(Bar.getInstance().getPatronne()==null||Bar.getInstance().getFournisseur()==null||Bar.getInstance().getBarman()==null){
            JLabel label = new JLabel("Vous devez créer un nouveau bar");
            hbox3.add(label);
        }
        else if(Bar.getInstance().getClients().size()<1){
            JLabel label = new JLabel("Il faut aujouter des client(e)s");
            hbox3.add(label);
        }
        else if(Bar.getInstance().getServeurs().size()<1){
            JLabel label = new JLabel("Il faut aujouter des serveu(r)s(es)");
            hbox3.add(label);
        }
        
        
        else{
            hbox3.add(persosactuels);
            hbox5.add(simulation);
        }
        vbox3.add(hbox3);
        vbox3.add(hbox4);
        vbox3.add(hbox5);
        this.getContentPane().add(vbox3, BorderLayout.CENTER);
        
        this.getContentPane().setBackground(Color.ORANGE);
        
        this.setVisible(true);

    }
    
    class NvPersoListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            NvPerso2 fen = new NvPerso2();
       }
    }
    
    class PersosActuelsListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            PersosActuels fen = new PersosActuels();
       }
    }
    
    class SimulationListener implements ActionListener{
        public void actionPerformed(ActionEvent ae){
            dispose();
            Bar.getInstance().getSimulation().reinitialiser();
            Bar.getInstance().getSimulation().affecterClients();
            Bar.getInstance().getSimulation().affecterServeurs();
            
            Simuler fen = new Simuler();
        }
    }
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            PageAccueil fen = new PageAccueil();
        }
    }
    
    
    
    
    
}
