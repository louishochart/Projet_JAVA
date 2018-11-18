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
import javax.swing.JTextField;

import java.awt.Color; 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;

/**
 *
 * @author Louis
 */
public class HumanCreation extends JFrame {
    
    private JButton clients = new JButton("Client");
    private JButton clientes = new JButton("Cliente");
    private JButton serveurs = new JButton("Serveur");
    private JButton serveuses = new JButton("Serveuse");
    private JButton retour = new JButton("Retour");
   
    
    
    public HumanCreation() {
        
        clients.addActionListener(new ClientsListener());
        clientes.addActionListener(new ClientesListener());
        serveurs.addActionListener(new ServeursListener());
        serveuses.addActionListener(new ServeusesListener());
        retour.addActionListener(new RetourListener());
        
        this.setTitle("Bar actuel");
        this.setSize(610, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        Box vbox1 = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox(); 
        hbox1.add(clients);
        hbox1.add(clientes);
        hbox1.add(serveurs);
        hbox1.add(serveuses);
        vbox1.add(hbox1);
        this.getContentPane().add(vbox1, BorderLayout.NORTH);
        
        Box vbox2 = Box.createVerticalBox();
        Box hbox2 = Box.createHorizontalBox();
        hbox2.add(retour);
        vbox2.add(hbox2);
        this.getContentPane().add(vbox2, BorderLayout.SOUTH);
        
        
        this.getContentPane().setBackground(Color.ORANGE);
        this.setVisible(true);
    }
    
    class ClientsListener implements ActionListener{
        
        private JPanel pan = new JPanel();
        private JButton valider = new JButton("Valider");
        private JButton retour = new JButton("Retour");
        private JLabel label = new JLabel("Nombre d'ajouts générés aléatoirement");
        private JTextField jtf = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();          
            jtf.setPreferredSize(new Dimension(150, 30));
            hbox1.add(label); hbox1.add(jtf); hbox1.add(valider);     vbox1.add(hbox1); vbox1.add(retour);
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true);           
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                if(jtf.getText().matches("\\d+")){      
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        System.out.println("ok");
                    }
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                HumanCreation fen = new HumanCreation();
            }
        } 
    }
    class ClientesListener implements ActionListener{
        
        private JPanel pan = new JPanel();
        private JButton valider = new JButton("Valider");
        private JButton retour = new JButton("Retour");
        private JLabel label = new JLabel("Nombre d'ajouts générés aléatoirement");
        private JTextField jtf = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();          
            jtf.setPreferredSize(new Dimension(150, 30));
            hbox1.add(label); hbox1.add(jtf); hbox1.add(valider);     vbox1.add(hbox1); vbox1.add(retour);
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true);           
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                if(jtf.getText().matches("\\d+")){      
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        System.out.println("ok");
                    }
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                HumanCreation fen = new HumanCreation();
            }
        } 
    }
    class ServeursListener implements ActionListener{
        
        private JPanel pan = new JPanel();
        private JButton valider = new JButton("Valider");
        private JButton retour = new JButton("Retour");
        private JLabel label = new JLabel("Nombre d'ajouts générés aléatoirement");
        private JTextField jtf = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();          
            jtf.setPreferredSize(new Dimension(150, 30));
            hbox1.add(label); hbox1.add(jtf); hbox1.add(valider);     vbox1.add(hbox1); vbox1.add(retour);
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true);           
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                if(jtf.getText().matches("\\d+")){      
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        System.out.println("ok");
                    }
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                HumanCreation fen = new HumanCreation();
            }
        } 
    }
    class ServeusesListener implements ActionListener{
        
        private JPanel pan = new JPanel();
        private JButton valider = new JButton("Valider");
        private JButton retour = new JButton("Retour");
        private JLabel label = new JLabel("Nombre d'ajouts générés aléatoirement");
        private JTextField jtf = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();          
            jtf.setPreferredSize(new Dimension(150, 30));
            hbox1.add(label); hbox1.add(jtf); hbox1.add(valider);     vbox1.add(hbox1); vbox1.add(retour);
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true);           
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                if(jtf.getText().matches("\\d+")){      
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        System.out.println("ok");
                    }
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                HumanCreation fen = new HumanCreation();
            }
        } 
    }
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            NouveauBar fen = new NouveauBar();
        }
    }   
    
    
    
}
