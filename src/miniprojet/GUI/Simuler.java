/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import miniprojet.Tournoi.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import miniprojet.Bar.Bar;
import miniprojet.Fonctions.Save;
import miniprojet.president.*;

/**
 *
 * Permet à l'utilisateur de voir les clients présents dans le bar aujourd'hui
 * de faire une partie de président(simulée ou non)
 * de créer un nouveau tournoi -> TournoiInterface
 * de simuler une heure ( répétable jusque minuit) et d'accéder aux infos sur les évènements de cette heure -> RapportHeure
 */
public class Simuler extends JFrame {

    private final JButton tables = new JButton("Clients présents dans le bar");
    private final JButton simuler = new JButton("Simuler l'heure suivante");
    private final JButton nvSim = new JButton("Simuler la soirée suivante");
    private final JButton tournoi = new JButton("Programmer un nouveau tournoi");
    private final JButton president = new JButton("Jouer une partie de Président");
    private final JButton retour = new JButton("Retour");

    public Simuler() {

        tables.addActionListener(new TablesListener());
        simuler.addActionListener(new SimulerListener());
        nvSim.addActionListener(new NvSimListener());
        retour.addActionListener(new RetourListener());
        president.addActionListener(new PresidentListener());
        tournoi.addActionListener(new TournoiListener());

        this.setTitle("Simulation");
        this.setSize(1500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

        Box vbox1 = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox();
        hbox1.add(tables);
        vbox1.add(hbox1);
        vbox1.add(new JLabel(" "));
        Box hbox2 = Box.createHorizontalBox();
        hbox2.add(new JLabel("Il y a " + Bar.getInstance().getSimulation().getClients().size() + " clients "));
        Box hbox3 = Box.createHorizontalBox();
        hbox3.add(new JLabel("et  " + Bar.getInstance().getSimulation().getServeurs().size() + " serveurs dans le bar."));
        vbox1.add(hbox2);
        vbox1.add(hbox3);

        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));

        Box hbox4 = Box.createHorizontalBox();
        hbox4.add(new JLabel("Il est actuellement " + (Bar.getInstance().getSimulation().getNbHeures() + 17) + " heures."));
        vbox1.add(hbox4);

        if (!(Bar.getInstance().getSimulation().getTournoi().isCree()) && (Bar.getInstance().getSimulation().getNbHeures() == 0)) {
            vbox1.add(new JLabel(" "));
            vbox1.add(new JLabel(" "));

            Box hbox7 = Box.createHorizontalBox();
            hbox7.add(tournoi);
            vbox1.add(hbox7);
        }

        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));

        Box hbox5 = Box.createHorizontalBox();
        if (Bar.getInstance().getSimulation().getNbHeures() < 7) {
            hbox5.add(simuler);
        } else {
            hbox5.add(nvSim);
        }

        vbox1.add(hbox5);

        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));
        Box hbox6 = Box.createHorizontalBox();
        hbox6.add(president);
        vbox1.add(hbox6);

        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));

        Box hbox = Box.createHorizontalBox();
        hbox.add(retour);
        vbox1.add(hbox);
        this.getContentPane().add(vbox1);

        this.getContentPane().setBackground(java.awt.Color.ORANGE);
        this.setVisible(true);
    }

    class TablesListener implements ActionListener {

        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");

        public void actionPerformed(ActionEvent ae) {
            retour.addActionListener(new RetourListener());

            Box vbox1 = Box.createVerticalBox();
            Box hbox0 = Box.createHorizontalBox();
            vbox1.add(hbox0);

            Box hbox1 = Box.createHorizontalBox();
            for (int i = 0; i < Bar.getInstance().getSimulation().getTables().size(); i++) {
                JButton table = new JButton("Table n° " + i);
                table.addActionListener(new TableListener());
                hbox1.add(table);
            }
            vbox1.add(hbox1);

            Box hbox4 = Box.createHorizontalBox();
            hbox4.add(retour);
            vbox1.add(new JLabel(" "));
            vbox1.add(hbox4);

            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(java.awt.Color.ORANGE);
            setVisible(true);
        }

        class TableListener implements ActionListener {

            JPanel pan = new JPanel();
            JButton retour = new JButton("Retour");

            public void actionPerformed(ActionEvent ae) {
                retour.addActionListener(new RetourListener());
                int numero = Integer.parseInt(String.valueOf(ae.getSource().toString().charAt(ae.getSource().toString().lastIndexOf("Table") + 9)));
                Box vbox1 = Box.createVerticalBox();
                Box hbox0 = Box.createHorizontalBox();
                hbox0.add(new JLabel("Il y a " + Bar.getInstance().getSimulation().getTables().get(numero).getClients().size() + " clients assis à cette table."));
                vbox1.add(hbox0);
                vbox1.add(new JLabel(" "));

                for (int i = 0; i < Bar.getInstance().getSimulation().getTables().get(numero).getClients().size(); i++) {
                    Box hbox1 = Box.createHorizontalBox();
                    JLabel label = new JLabel(Bar.getInstance().getSimulation().getTables().get(numero).getClients().get(i).toString());
                    hbox1.add(label);
                    vbox1.add(hbox1);
                }
                vbox1.add(new JLabel(" "));
                Box hbox2 = Box.createHorizontalBox();
                hbox2.add(new JLabel(Bar.getInstance().getSimulation().getTables().get(numero).getServeur().toString()));
                vbox1.add(hbox2);
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
                    Simuler fen = new Simuler();
                }
            }
        }

        class RetourListener implements ActionListener {

            public void actionPerformed(ActionEvent ae) {
                dispose();
                Simuler fen = new Simuler();
            }
        }
    }

    class PresidentListener implements ActionListener {

        JPanel pan = new JPanel();
        JButton player = new JButton("Jouer une partie");
        JButton random = new JButton("Simuler une partie");
        JButton retour = new JButton("Retour");

        public void actionPerformed(ActionEvent ae) {
            retour.addActionListener(new RetourListener());
            random.addActionListener(new RandomListener());
            player.addActionListener(new PlayerListener());
            Box vbox = Box.createVerticalBox();

            Box hbox1 = Box.createHorizontalBox();
            hbox1.add(player);
            hbox1.add(random);
            vbox.add(hbox1);
            vbox.add(new JLabel(" "));
            vbox.add(new JLabel(" "));
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox.add(hbox2);

            pan.add(vbox);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);

            setVisible(true);
        }

        class RandomListener implements ActionListener {

            JPanel pan = new JPanel();

            public void actionPerformed(ActionEvent ae) {
                Box vbox = Box.createVerticalBox();
                if (!Bar.getInstance().getSimulation().getFullTables().isEmpty()) {
                    System.out.println(Bar.getInstance().getSimulation().getFullTables().size());
                    double randomint = Math.random() * Bar.getInstance().getSimulation().getFullTables().size();
                    int indiceTable = (int) randomint;
                    System.out.println(Bar.getInstance().getSimulation().getFullTables().get(indiceTable).getClients().size());
                    Bar.getInstance().getSimulation().setPartie(new President(Bar.getInstance().getSimulation().getFullTables().get(indiceTable)));
                    Bar.getInstance().getSimulation().getPartie().jeu();

                    Box hbox1 = Box.createHorizontalBox();
                    int indice = Bar.getInstance().getSimulation().getPartie().getIndiceTable();
                    hbox1.add(new JLabel("Table n°" + indice));
                    vbox.add(hbox1);

                    for (int i = 0; i < Bar.getInstance().getTables().get(indice).getClients().size(); i++) {
                        vbox.add(new JLabel(" "));
                        vbox.add(new JLabel(" "));
                        vbox.add(new JLabel(Bar.getInstance().getTables().get(indice).getClients().get(i).toString()));
                    }
                    vbox.add(new JLabel(" "));
                    vbox.add(new JLabel(" "));
                    Box hbox3 = Box.createHorizontalBox();
                    hbox3.add(new JLabel("Vainqueur de la partie : " + Bar.getInstance().getSimulation().getPartie().getVainqueur().getPrenom() + " " + Bar.getInstance().getSimulation().getPartie().getVainqueur().getNom()));
                    vbox.add(hbox3);

                    vbox.add(new JLabel(" "));
                    vbox.add(new JLabel(" "));
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(retour);
                    vbox.add(hbox);
                } else {
                    Box hbox1 = Box.createHorizontalBox();
                    hbox1.add(new JLabel("Aucune table n'est pleine, recommencez la simulation ou ajoutez des clientss "));
                    vbox.add(hbox1);

                    vbox.add(new JLabel(" "));
                    vbox.add(new JLabel(" "));
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(retour);
                    vbox.add(hbox);
                }

                pan.add(vbox);
                setContentPane(pan);
                pan.setBackground(Color.ORANGE);

                setVisible(true);
            }
        }
        class PlayerListener implements ActionListener {

            JPanel pan = new JPanel();

            public void actionPerformed(ActionEvent ae) {
                Box vbox = Box.createVerticalBox();
                if (!Bar.getInstance().getSimulation().getFullTables().isEmpty()) {
                    System.out.println(Bar.getInstance().getSimulation().getFullTables().size());
                    double randomint = Math.random() * Bar.getInstance().getSimulation().getFullTables().size();
                    int indiceTable = (int) randomint;
                    System.out.println(Bar.getInstance().getSimulation().getFullTables().get(indiceTable).getClients().size());
                    Bar.getInstance().getSimulation().setPartie(new President(Bar.getInstance().getSimulation().getFullTables().get(indiceTable)));
                    Bar.getInstance().getSimulation().getPartie().JeuVsPlayer();

                    Box hbox1 = Box.createHorizontalBox();
                    int indice = Bar.getInstance().getSimulation().getPartie().getIndiceTable();
                    hbox1.add(new JLabel("Table n°" + indice));
                    vbox.add(hbox1);

                    for (int i = 0; i < Bar.getInstance().getTables().get(indice).getClients().size(); i++) {
                        vbox.add(new JLabel(" "));
                        vbox.add(new JLabel(" "));
                        vbox.add(new JLabel(Bar.getInstance().getTables().get(indice).getClients().get(i).toString()));
                    }
                    vbox.add(new JLabel(" "));
                    vbox.add(new JLabel(" "));
                    Box hbox3 = Box.createHorizontalBox();
                    hbox3.add(new JLabel("Vainqueur de la partie : " + Bar.getInstance().getSimulation().getPartie().getVainqueur().getPrenom() + " " + Bar.getInstance().getSimulation().getPartie().getVainqueur().getNom()));
                    vbox.add(hbox3);

                    vbox.add(new JLabel(" "));
                    vbox.add(new JLabel(" "));
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(retour);
                    vbox.add(hbox);
                } else {
                    Box hbox1 = Box.createHorizontalBox();
                    hbox1.add(new JLabel("Aucune table n'est pleine, recommencez la simulation ou ajoutez des clientss "));
                    vbox.add(hbox1);

                    vbox.add(new JLabel(" "));
                    vbox.add(new JLabel(" "));
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(retour);
                    vbox.add(hbox);
                }

                pan.add(vbox);
                setContentPane(pan);
                pan.setBackground(Color.ORANGE);

                setVisible(true);
            }
        }
        class RetourListener implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new Simuler();
            }
        }
    }
    class TournoiListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            Bar.getInstance().getSimulation().getTournoi().creation();
            TournoiInterface fen = new TournoiInterface();
        }
    }

    class SimulerListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            Bar.getInstance().getSimulation().simulerHeure();
            dispose();
            new RapportHeure();
        }
    }

    class NvSimListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            new RapportHeure();
            Bar.getInstance().getSimulation().reinitialiser();
            Bar.getInstance().getSimulation().affecterClients();
            Bar.getInstance().getSimulation().affecterServeurs();
            Bar.getInstance().getBarman().verifierStocks();
            new Save();
        }
    }

    class RetourListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuelVerif fen = new BarActuelVerif();
        }
    }
}
