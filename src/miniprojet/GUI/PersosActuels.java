/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import miniprojet.Fonctions.Initialize;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color; 
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import miniprojet.Bar.*;

/**
 *
 * @author Louis
 */
public class PersosActuels extends JFrame{
    private JButton patronne = new JButton("Patronne");
    private JButton barman = new JButton("Barman");
    private JButton fournisseur = new JButton("Fournisseur");
    private JButton clients = new JButton("Clients");
    private JButton clientes = new JButton("Clientes");
    private JButton serveurs = new JButton("Serveurs");
    private JButton serveuses = new JButton("Serveuses");
    private JButton stock = new JButton("Stock");
    private JButton caisse = new JButton("Caisse");
    private JButton tables = new JButton("Tables");
    private JButton retour = new JButton("Retour");
    
    public PersosActuels(){
        new Initialize();
        this.setTitle("Personnages Actuels");
        this.setSize(1300, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        patronne.addActionListener(new PatronneListener());
        barman.addActionListener(new BarmanListener());
        fournisseur.addActionListener(new FournisseurListener());
        clients.addActionListener(new ClientsListener());
        clientes.addActionListener(new ClientesListener());
        serveurs.addActionListener(new ServeursListener());
        serveuses.addActionListener(new ServeusesListener());
        stock.addActionListener(new StockListener());
        caisse.addActionListener(new CaisseListener());
        tables.addActionListener(new TablesListener());
        retour.addActionListener(new RetourListener());
        
        Box vbox1 = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox(); 
        hbox1.add(patronne);
        hbox1.add(barman);
        hbox1.add(fournisseur);
        hbox1.add(clients);
        hbox1.add(clientes);
        hbox1.add(serveurs);
        hbox1.add(serveuses);  
  
        Box hbox2 = Box.createHorizontalBox(); 
        hbox2.add(stock);
        hbox2.add(caisse);
        hbox2.add(tables);
        
        vbox1.add(hbox1);
        vbox1.add(hbox2);
        
        this.getContentPane().add(vbox1, BorderLayout.NORTH);
        Box vbox3 = Box.createVerticalBox();
        Box hbox3 = Box.createHorizontalBox();
        hbox3.add(retour);
        vbox3.add(hbox3);
        this.getContentPane().add(vbox3, BorderLayout.SOUTH);
        
        this.getContentPane().setBackground(Color.ORANGE);
        this.setVisible(true);
    }
    
    class PatronneListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");
        
        public void actionPerformed(ActionEvent ae) {
            
            retour.addActionListener(new RetourListener());
            JLabel label = new JLabel(Bar.getInstance().getPatronne().toString());   
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();
            hbox1.add(label);
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox1);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);
            
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class BarmanListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");
        
        public void actionPerformed(ActionEvent ae) {
            
            retour.addActionListener(new RetourListener());
            JLabel label = new JLabel(Bar.getInstance().getBarman().toString());   
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();
            hbox1.add(label);
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox1);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);
            
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class FournisseurListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");
        
        public void actionPerformed(ActionEvent ae) {
            
            retour.addActionListener(new RetourListener());
            JLabel label = new JLabel(Bar.getInstance().getFournisseur().toString());   
            Box vbox1 = Box.createVerticalBox();
            Box hbox1 = Box.createHorizontalBox();
            hbox1.add(label);
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox1);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);
            
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class ClientsListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getClients().size() ; i++){    
                if(Bar.getInstance().getClients().get(i).getClass().getSimpleName().equals("Client")){
                    JLabel label = new JLabel(Bar.getInstance().getClients().get(i).toString());
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(label);
                    vbox1.add(hbox);
                }
            }         
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class ClientesListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getClients().size() ; i++){                
                if(Bar.getInstance().getClients().get(i).getClass().getSimpleName().equals("Cliente")){
                    JLabel label = new JLabel(Bar.getInstance().getClients().get(i).toString());
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(label);
                    vbox1.add(hbox);
                }
            }         
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class ServeursListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getServeurs().size() ; i++){                
                if(Bar.getInstance().getServeurs().get(i).getClass().getSimpleName().equals("Serveur")){
                    JLabel label = new JLabel(Bar.getInstance().getServeurs().get(i).toString());
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(label);
                    vbox1.add(hbox);
                }
            }         
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class ServeusesListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getServeurs().size() ; i++){                
                if(Bar.getInstance().getServeurs().get(i).getClass().getSimpleName().equals("Serveuse")){
                    JLabel label = new JLabel(Bar.getInstance().getServeurs().get(i).toString());
                    Box hbox = Box.createHorizontalBox();
                    hbox.add(label);
                    vbox1.add(hbox);
                }
            }         
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class StockListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getStock().getBoissons().size() ; i++){                
                JLabel label = new JLabel(Bar.getInstance().getStock().getBoissons().get(i).getName()+" : "+Bar.getInstance().getStock().getQuantites().get(i));
                Box hbox = Box.createHorizontalBox();
                hbox.add(label);
                vbox1.add(hbox);
            }         
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class CaisseListener implements ActionListener{
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();                     
            JLabel label = new JLabel(Float.toString(Bar.getInstance().getCaisse().getCaisse()));
            Box hbox = Box.createHorizontalBox();
            hbox.add(label);
            vbox1.add(hbox);     
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox2);
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    class TablesListener implements ActionListener{
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            
            Box vbox1 = Box.createVerticalBox();    
            Box hbox1 = Box.createHorizontalBox();
            for(int i = 0 ; i < Bar.getInstance().getTables().size() ; i++){
                JButton table = new JButton("Table n°"+i);
                hbox1.add(table);
            }
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(retour);
            vbox1.add(hbox1);
            
            pan.add(vbox1);
            setContentPane(pan);
            pan.setBackground(Color.ORANGE);           
            setVisible(true); 
        }
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                PersosActuels fen = new PersosActuels();
            }
        } 
    }
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuelVerif fen = new BarActuelVerif();
        }
    }
}
