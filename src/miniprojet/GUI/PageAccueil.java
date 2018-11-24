/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Louis
 */
public class PageAccueil extends JFrame {

    private JButton baractuel = new JButton("Gerer Bar actuel");
    private JButton nvbar = new JButton("Nouveau Bar");
    private JButton quitter = new JButton("Fermer");

    public PageAccueil() {

        this.setTitle("Page d'Accueil");
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);

        baractuel.addActionListener(new BarActuelListener());
        nvbar.addActionListener(new NvBarListener());
        quitter.addActionListener(new QuitterListener());

        Box box1 = Box.createHorizontalBox();
        box1.add(baractuel);
        box1.add(nvbar);
        Box box2 = Box.createHorizontalBox();
        box2.add(quitter);
        Box box = Box.createVerticalBox();
        box.add(box1);
        box.add(box2);
        this.getContentPane().add(box);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setVisible(true);
    }

    class BarActuelListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuelVerif baractuel = new BarActuelVerif();
        }
    }

    //Classe écoutant notre second bouton
    class NvBarListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()

        public void actionPerformed(ActionEvent ae) {
            dispose();
            NouveauBarConfirmation nvbar = new NouveauBarConfirmation();
        }
    }

    class QuitterListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()

        public void actionPerformed(ActionEvent ae) {
            dispose();
        }
    }
}
