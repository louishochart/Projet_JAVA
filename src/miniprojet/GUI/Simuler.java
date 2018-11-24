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
public class Simuler extends JFrame {

    private JButton tables = new JButton("Clients présents dans le bar");
    private JButton simuler = new JButton("Simuler l'heure suivante");
    private JButton retour = new JButton("Retour");

    public Simuler() {

        tables.addActionListener(new TablesListener());
        simuler.addActionListener(new SimulerListener());
        retour.addActionListener(new RetourListener());

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
        hbox2.add(new JLabel("Aujourd'hui, il y a " + Bar.getInstance().getSimulation().getClients().size() + " clients "));
        Box hbox3 = Box.createHorizontalBox();
        hbox3.add(new JLabel("et  " + Bar.getInstance().getSimulation().getServeurs().size() + " serveurs dans le bar."));
        vbox1.add(hbox2);
        vbox1.add(hbox3);

        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));
        
        Box hbox4 = Box.createHorizontalBox();
        hbox4.add(new JLabel("Il est actuellement "+(Bar.getInstance().getSimulation().getNbHeures()+17)+" heures."));
        vbox1.add(hbox4);
        
        vbox1.add(new JLabel(" "));
        vbox1.add(new JLabel(" "));
        
        Box hbox5 = Box.createHorizontalBox();
        hbox5.add(simuler);
        vbox1.add(hbox5);
        
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
    class SimulerListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            new RapportHeure();
        }
    }
    class RetourListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuelVerif fen = new BarActuelVerif();
        }
    }
}
