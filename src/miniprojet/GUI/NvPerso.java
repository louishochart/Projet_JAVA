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
import java.util.ArrayList;
import java.util.List;

import miniprojet.Bar.*;
import miniprojet.Humans.*;

/**
 *
 * @author Louis
 */
public class NvPerso extends JFrame {
    
    private JButton clients = new JButton("Client");
    private JButton clientes = new JButton("Cliente");
    private JButton serveurs = new JButton("Serveur");
    private JButton serveuses = new JButton("Serveuse");
    private JButton valider = new JButton("Valider");
    private JButton retour = new JButton("Retour");
   
    
    
    public NvPerso() {
        
        clients.addActionListener(new ClientsListener());
        clientes.addActionListener(new ClientesListener());
        serveurs.addActionListener(new ServeursListener());
        serveuses.addActionListener(new ServeusesListener());
        valider.addActionListener(new ValiderListener());
        retour.addActionListener(new RetourListener());
        
        this.setTitle("NvPerso");
        this.setSize(610, 150);
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
        
        Box vbox3 = Box.createVerticalBox();
        Box hbox3 = Box.createHorizontalBox();
        vbox3.add(new JLabel(" "));
        hbox3.add(valider);
        vbox3.add(hbox3);
        this.getContentPane().add(vbox3, BorderLayout.CENTER);
        
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
                    List<Client> clients = new ArrayList<Client>();
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        clients.add(new Client());
                    }
                    Bar.getInstance().setClients(clients);
                    dispose();
                    NvPerso fen = new NvPerso();
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso fen = new NvPerso();
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
                    List<Cliente> clientes = new ArrayList<Cliente>();
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        clientes.add(new Cliente());
                    }
                    Bar.getInstance().setClientes(clientes);
                    dispose();
                    NvPerso fen = new NvPerso();
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso fen = new NvPerso();
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
                    List<Serveur> serveurs = new ArrayList<Serveur>();
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        serveurs.add(new Serveur());
                    }
                    Bar.getInstance().setServeurs(serveurs);
                    dispose();
                    NvPerso fen = new NvPerso();
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso fen = new NvPerso();
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
                    List<Serveuse> serveuses = new ArrayList<Serveuse>();
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        serveuses.add(new Serveuse());
                    }
                    Bar.getInstance().setServeuses(serveuses);
                    dispose();
                    NvPerso fen = new NvPerso();
                }
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso fen = new NvPerso();
            }
        } 
    }
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            NouveauBarConfirmation fen = new NouveauBarConfirmation();
        }
    }   
    
    class ValiderListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuelVerif fen = new BarActuelVerif();
        }
    }  
    
    
    
}
