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

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import miniprojet.Bar.Bar;
import miniprojet.Bar.Table;
import miniprojet.Fonctions.*;
import miniprojet.president.President;

/**
 *  Récupère les infos des fichiers .txt
 * S'il en manque, on demande à l'utilsateur d'en ajouter
 * Sinon, on peut accéder aux personnages actuels -> PersosActuels, ou simuler une nouvelle soirée -> Simuler
 */
public class BarActuelVerif extends JFrame {

    private final JButton nvperso = new JButton("Créer nouveau personnage");
    private final JButton persosactuels = new JButton("Voir personnages existants");
    private final JButton simulation = new JButton("Entrer dans la simulation");
    private final JButton retour = new JButton("Retour");

    public BarActuelVerif() {

        new RecupererDatabase();

        this.setTitle("Bar actuel");
        this.setSize(500, 500);
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

        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));
        

        Box hbox3 = Box.createHorizontalBox();
        Box hbox4 = Box.createHorizontalBox();

        if (Bar.getInstance().getTables().size() < 1) {
            JLabel label = new JLabel("Il faut aujouter des tables");
            hbox3.add(label);
        } 
        else if (Bar.getInstance().getPatronne() == null || Bar.getInstance().getFournisseur() == null || Bar.getInstance().getBarman() == null) {
            JLabel label = new JLabel("Vous devez créer un nouveau bar");
            hbox3.add(label);
        } 
        else if (Bar.getInstance().getClients().size() < 1) {
            JLabel label = new JLabel("Il faut aujouter des client(e)s");
            hbox3.add(label);
        } 
        else if (Bar.getInstance().getServeurs().size() < 1) {
            JLabel label = new JLabel("Il faut aujouter des serveu(r)s(es)");
            hbox3.add(label);
        } 
        else {
            hbox3.add(persosactuels);
            hbox4.add(simulation);
        }
        vbox1.add(hbox3);
        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));       
        vbox1.add(hbox4);
        
        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));
        Box hbox = Box.createHorizontalBox();
        hbox.add(retour);
        vbox1.add(hbox);
        
        
        this.getContentPane().add(vbox1);

        this.getContentPane().setBackground(Color.ORANGE);

        this.setVisible(true);

    }

    class NvPersoListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            NvPerso2 fen = new NvPerso2();
        }
    }

    class PersosActuelsListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            PersosActuels fen = new PersosActuels();
        }
    }

    class SimulationListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            Bar.getInstance().getSimulation().reinitialiser();
            Bar.getInstance().getSimulation().affecterClients();
            Bar.getInstance().getSimulation().affecterServeurs();

            Simuler fen = new Simuler();
        }
    }

    class RetourListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            PageAccueil fen = new PageAccueil();
        }
    }

}
