/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import miniprojet.Bar.Bar;

/**
 *
 * @author Louis
 */
public class TournoiInterface extends JFrame {

    private JButton quitter = new JButton("Fermer");
    private JButton tour = new JButton("Tour Suivant");
    private JButton fin = new JButton("Fin du tournoi");

    public TournoiInterface() {
        this.setTitle("Page d'Accueil");
        this.setSize(1500, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

        tour.addActionListener(new tourListener());
        fin.addActionListener(new finListener());
        quitter.addActionListener(new QuitterListener());

        Box vbox = Box.createVerticalBox();

        Box hbox1 = Box.createHorizontalBox();
        hbox1.add(new JLabel("Tournoi de président"));
        vbox.add(hbox1);
        vbox.add(new JLabel("  "));
        vbox.add(new JLabel("  "));
        Box hbox2 = Box.createHorizontalBox();
        hbox2.add(new JLabel("Il reste " + Bar.getInstance().getSimulation().getTournoi().getTables().size()*4 + " joueurs répartis sur " + Bar.getInstance().getSimulation().getTournoi().getTables().size() + " tables."));
        vbox.add(hbox2);
        vbox.add(new JLabel("  "));
        vbox.add(new JLabel("  "));

        Box hbox3 = Box.createHorizontalBox();
        for (int i = 0; i < Bar.getInstance().getSimulation().getTournoi().getTables().size(); i++) {
            JButton bouton = new JButton("Table n°" + i);
            bouton.addActionListener(new TableListener());
            hbox3.add(bouton);
        }
        vbox.add(hbox3);
        vbox.add(new JLabel("  "));
        vbox.add(new JLabel("  "));

        Box hbox4 = Box.createHorizontalBox();
        if (Bar.getInstance().getSimulation().getTournoi().getTour() < Bar.getInstance().getSimulation().getTournoi().getNbTours()) {
            hbox4.add(tour);
        } else {
            hbox4.add(fin);
        }
        vbox.add(hbox4);

        vbox.add(new JLabel("  "));
        vbox.add(new JLabel("  "));

        this.getContentPane().add(vbox);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setVisible(true);
    }

    class TableListener implements ActionListener {

        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");

        public void actionPerformed(ActionEvent ae) {
            retour.addActionListener(new RetourListener());

            int numero = Integer.parseInt(String.valueOf(ae.getSource().toString().charAt(ae.getSource().toString().lastIndexOf("Table") + 8)));
            System.out.println(numero);
            System.out.println(Bar.getInstance().getSimulation().getTournoi().getTables().get(numero).getClients().size());
            Box vbox1 = Box.createVerticalBox();
            Box hbox0 = Box.createHorizontalBox();
            hbox0.add(new JLabel("Il y a " + Bar.getInstance().getSimulation().getTournoi().getTables().get(numero).getClients().size() + " clients assis à cette table."));
            vbox1.add(hbox0);
            vbox1.add(new JLabel(" "));

            for (int i = 0; i < Bar.getInstance().getSimulation().getTournoi().getTables().get(numero).getClients().size(); i++) {
                Box hbox1 = Box.createHorizontalBox();
                JLabel label = new JLabel(Bar.getInstance().getSimulation().getTournoi().getTables().get(numero).getClients().get(i).toString());
                hbox1.add(label);
                vbox1.add(hbox1);
            }
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));
            Box hbox3 = Box.createHorizontalBox();
            hbox3.add(retour);

            vbox1.add(hbox3);

            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(java.awt.Color.ORANGE);
            setVisible(true);
        }

        class RetourListener implements ActionListener {

            public void actionPerformed(ActionEvent ae) {

                dispose();
                TournoiInterface fen = new TournoiInterface();

            }
        }
    }

    class tourListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Bar.getInstance().getSimulation().getTournoi().jouerTour();
            dispose();
            Resultat fen = new Resultat();
        }
    }

    class finListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()

        public void actionPerformed(ActionEvent ae) {
            dispose();
        }
    }

    class QuitterListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()

        public void actionPerformed(ActionEvent ae) {
            dispose();
        }
    }
}
