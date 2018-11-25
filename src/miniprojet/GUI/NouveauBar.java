/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import miniprojet.Fonctions.Files;
import miniprojet.Humains.Fournisseur;
import miniprojet.Humains.Patronne;
import miniprojet.Humains.Barman;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import miniprojet.Bar.*;

/**
 *
 * @author Louis
 */
public class NouveauBar extends JFrame {

    private JButton bouton2 = new JButton("Créer nouveaux Personnage");
    private JLabel label = new JLabel("Bar créé!");
    private JButton retour = new JButton("Retour");

    public NouveauBar() {

        this.setTitle("Nouveau Bar Confirmation");
        this.setSize(1000, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        bouton2.addActionListener(new Bouton2Listener());
        retour.addActionListener(new RetourListener());

        new Files().emptyFiles();

        Bar.getInstance();
        Bar.getInstance().setStock(new Stock(50));
        Bar.getInstance().getCaisse().setCaisse(50f);
        Bar.getInstance().setPatronne(new Patronne());
        Bar.getInstance().setFournisseur(new Fournisseur());
        Bar.getInstance().setBarman(new Barman());
        Bar.getInstance().setClients(new ArrayList());
        Bar.getInstance().setServeurs(new ArrayList());
        Bar.getInstance().setTables(new ArrayList());

        JLabel name = new JLabel(Bar.getInstance().getName());
        JLabel patronne = new JLabel(Bar.getInstance().getPatronne().toString());
        JLabel barman = new JLabel(Bar.getInstance().getBarman().toString());
        JLabel fournisseur = new JLabel(Bar.getInstance().getFournisseur().toString());
        Box vbox1 = Box.createVerticalBox();
        vbox1.add(label);
        vbox1.add(new JLabel("  "));
        vbox1.add(name);
        vbox1.add(new JLabel("  "));
        vbox1.add(patronne);
        vbox1.add(barman);
        vbox1.add(fournisseur);
        vbox1.add(new JLabel("  "));
        vbox1.add(bouton2);
        vbox1.add(retour);

        this.getContentPane().add(vbox1);
        this.getContentPane().setBackground(Color.ORANGE);

        this.setVisible(true);;
    }

    class Bouton2Listener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            NvPerso fen = new NvPerso();
        }
    }

    class RetourListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            NouveauBarConfirmation fen = new NouveauBarConfirmation();
        }
    }

}
