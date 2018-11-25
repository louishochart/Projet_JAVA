/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

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
public class Resultat extends JFrame {

    JPanel pan = new JPanel();
    JButton retour = new JButton("Retour");
    JButton valider = new JButton("Valider");

    public Resultat() {

        this.setTitle("Resultat");
        this.setSize(1500, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        valider.addActionListener(new ValiderListener());
        Box vbox = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox();
        for (int i = 0; i < Bar.getInstance().getSimulation().getTournoi().getTables().size(); i++) {
            JButton bouton = new JButton("Résultat de la Table n°" + i);
            bouton.addActionListener(new TableListener());
            hbox1.add(bouton);
        }
        vbox.add(hbox1);
        vbox.add(new JLabel("  "));
        vbox.add(new JLabel("  "));
        Box hbox = Box.createHorizontalBox();
        hbox.add(valider);
        vbox.add(hbox);
        pan.add(vbox);
        setContentPane(pan);
        pan.setBackground(java.awt.Color.ORANGE);
        setVisible(true);
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
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(new JLabel("Le vainqueur est : " + Bar.getInstance().getSimulation().getTournoi().getTournoi().get(Bar.getInstance().getSimulation().getTournoi().getTour()).get(numero).getVainqueur()));
            vbox1.add(hbox2);
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
                Resultat fen = new Resultat();

            }
        }
    }

    class ValiderListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            Bar.getInstance().getSimulation().getTournoi().tourSuivant();
            TournoiInterface fen = new TournoiInterface();
        }
    }

}
