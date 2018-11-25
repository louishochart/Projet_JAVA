/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import miniprojet.Bar.Bar;
import miniprojet.Humains.*;

/**
 * Permet d'accéder aux informations sur les évènements survenus pendant une heure précise
 */
public class RapportHeure extends JFrame {
    private JButton quitter = new JButton("Fermer");
    public RapportHeure() {
        if (Bar.getInstance().getSimulation().getNbHeures() < 7) {
            this.setTitle("Rapport Heure");
            this.setSize(1500, 600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

            quitter.addActionListener(new QuitterListener());

            Box vbox1 = Box.createVerticalBox();

            Box hbox1 = Box.createHorizontalBox();
            hbox1.add(new JLabel("Rapport de l'heure entre " + (17 + Bar.getInstance().getSimulation().getNbHeures() - 1) + "h et " + (17 + Bar.getInstance().getSimulation().getNbHeures())));
            vbox1.add(hbox1);
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(new JLabel("Nombre de verres bus : " + Bar.getInstance().getSimulation().getVerresBush()));
            vbox1.add(hbox2);
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox3 = Box.createHorizontalBox();
            hbox3.add(new JLabel("Nombre de verres offerts : " + Bar.getInstance().getSimulation().getVerresOffertsh()));
            vbox1.add(hbox3);
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox4 = Box.createHorizontalBox();
            hbox4.add(new JLabel("Nombre de clients exclus : " + Bar.getInstance().getSimulation().getExclush().size()));
            vbox1.add(hbox4);
            for (int i = 0; i < Bar.getInstance().getSimulation().getExclush().size(); i++) {
                vbox1.add(new JLabel(Bar.getInstance().getSimulation().getExclush().get(i).toString()));
            }
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox5 = Box.createHorizontalBox();
            hbox5.add(new JLabel("Nombre de tournées générales offertes : " + Bar.getInstance().getSimulation().getTourneesh().size()));
            vbox1.add(hbox5);
            for (int i = 0; i < Bar.getInstance().getSimulation().getTourneesh().size(); i++) {
                vbox1.add(new JLabel(Bar.getInstance().getSimulation().getTournees().get(i).toString()));
            }
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox = Box.createHorizontalBox();
            hbox.add(quitter);
            vbox1.add(hbox);

            this.getContentPane().add(vbox1);
            this.getContentPane().setBackground(java.awt.Color.ORANGE);
            this.toFront();
            this.setVisible(true);
        } else {
            
            this.setTitle("Rapport Heure");
            this.setSize(1500, 600);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

            quitter.addActionListener(new QuitterListener());

            Box vbox1 = Box.createVerticalBox();

            Box hbox1 = Box.createHorizontalBox();
            hbox1.add(new JLabel("Rapport de la soirée : "));
            vbox1.add(hbox1);
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(new JLabel("Nombre de verres bus : " + Bar.getInstance().getSimulation().getVerresBus()));
            vbox1.add(hbox2);
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox3 = Box.createHorizontalBox();
            hbox3.add(new JLabel("Nombre de verres offerts : " + Bar.getInstance().getSimulation().getVerresOfferts()));
            vbox1.add(hbox3);
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox4 = Box.createHorizontalBox();
            hbox4.add(new JLabel("Nombre de clients exclus : " + Bar.getInstance().getSimulation().getExclus().size()));
            vbox1.add(hbox4);
            for (int i = 0; i < Bar.getInstance().getSimulation().getExclus().size(); i++) {
                vbox1.add(new JLabel(Bar.getInstance().getSimulation().getExclus().get(i).toString()));
            }
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox5 = Box.createHorizontalBox();
            hbox5.add(new JLabel("Nombre de tournées générales offertes : " + Bar.getInstance().getSimulation().getTournees().size()));
            vbox1.add(hbox5);
            for (int i = 0; i < Bar.getInstance().getSimulation().getTournees().size(); i++) {
                vbox1.add(new JLabel(Bar.getInstance().getSimulation().getTournees().get(i).toString()));
            }
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox = Box.createHorizontalBox();
            hbox.add(quitter);
            vbox1.add(hbox);

            this.getContentPane().add(vbox1);
            this.getContentPane().setBackground(java.awt.Color.ORANGE);
            this.setVisible(true);
        }

    }

    class QuitterListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()

        public void actionPerformed(ActionEvent ae) {
            dispose();
            Simuler fen =  new Simuler();
        }
    }

}
