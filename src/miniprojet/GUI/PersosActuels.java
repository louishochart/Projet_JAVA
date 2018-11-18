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
import miniprojet.Functions.*;

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
    private JButton retour = new JButton("Retour");
    
    public PersosActuels(){
        new Initialize();
        this.setTitle("Personnages Actuels");
        this.setSize(600, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        patronne.addActionListener(new PatronneListener());
        barman.addActionListener(new BarmanListener());
        fournisseur.addActionListener(new FournisseurListener());
        clients.addActionListener(new ClientsListener());
        clientes.addActionListener(new ClientesListener());
        serveurs.addActionListener(new ServeursListener());
        serveuses.addActionListener(new ServeusesListener());
        
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
        vbox1.add(hbox1);
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
            JLabel label = new JLabel(Bar.getInstance().getPatronne().getPrenom()+" "+Bar.getInstance().getPatronne().getSurnom());   
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
            JLabel label = new JLabel(Bar.getInstance().getBarman().getPrenom()+" "+Bar.getInstance().getBarman().getSurnom());   
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
            JLabel label = new JLabel(Bar.getInstance().getFournisseur().getPrenom()+" "+Bar.getInstance().getFournisseur().getSurnom());   
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
                JLabel label = new JLabel(Bar.getInstance().getClients().get(i).getPrenom()+" "+Bar.getInstance().getClients().get(i).getSurnom());
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
    class ClientesListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getClientes().size() ; i++){                
                JLabel label = new JLabel(Bar.getInstance().getClientes().get(i).getPrenom()+" "+Bar.getInstance().getClientes().get(i).getSurnom());
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
    class ServeursListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getServeurs().size() ; i++){                
                JLabel label = new JLabel(Bar.getInstance().getServeurs().get(i).getPrenom()+" "+Bar.getInstance().getServeurs().get(i).getSurnom());
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
    class ServeusesListener implements ActionListener{
        
        JPanel pan = new JPanel();
        JButton retour = new JButton("Retour");        
        public void actionPerformed(ActionEvent ae) {               
            retour.addActionListener(new RetourListener());           
            Box vbox1 = Box.createVerticalBox();          
            for(int i = 0 ; i < Bar.getInstance().getServeuses().size() ; i++){                
                JLabel label = new JLabel(Bar.getInstance().getServeuses().get(i).getPrenom()+" "+Bar.getInstance().getServeuses().get(i).getSurnom());
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
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuel fen = new BarActuel();
        }
    }
}
