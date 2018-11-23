/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import miniprojet.Humains.*;
import miniprojet.Fonctions.*;

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

/**
 *
 * @author Louis
 */
public class NvPerso2 extends JFrame {
    
    private JButton clients = new JButton("Client");
    private JButton serveurs = new JButton("Serveur");
    private JButton tables = new JButton("Tables");
    private JButton valider = new JButton("Valider");
    private JButton retour = new JButton("Retour");
   
    
    
    public NvPerso2() {
        
        clients.addActionListener(new ClientsListener());
        serveurs.addActionListener(new ServeursListener());
        tables.addActionListener(new TablesListener());
        valider.addActionListener(new ValiderListener());
        retour.addActionListener(new RetourListener());
        
        this.setTitle("NvPerso");
        this.setSize(800, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        
        Box vbox1 = Box.createVerticalBox();
        Box hbox1 = Box.createHorizontalBox(); 
        hbox1.add(clients);
        hbox1.add(serveurs);
        hbox1.add(tables);
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
        private JLabel label  = new JLabel("Nombre de clients générés aléatoirement        ");
        private JLabel label2 = new JLabel("Nombre de clientes générées aléatoirement   ");
        private JTextField jtf = new JTextField();
        private JTextField jtf2 = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            jtf.setPreferredSize(new Dimension(150, 30));
            jtf2.setPreferredSize(new Dimension(150, 30));
            
            Box vbox1 = Box.createVerticalBox();
            
            Box hbox = Box.createHorizontalBox();
            hbox.add(new JLabel("Il y a actuellement "+Bar.getInstance().getClients().size()+" clients. Le nombre maximum de clients est actuellement de "
                    +Bar.getInstance().getTables().size()*4+". Ajoutez des tables pour en avoir plus"));
            
            Box hbox1 = Box.createHorizontalBox();                    
            hbox1.add(label); hbox1.add(jtf);
            
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(label2); hbox2.add(jtf2);
            
            Box hbox3 = Box.createHorizontalBox();
            hbox3.add(retour);
            hbox3.add(valider);
            
            vbox1.add(hbox); vbox1.add(hbox1); vbox1.add(hbox2); vbox1.add(hbox3);
            
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true); 
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                List<ClientNeutre> total = new ArrayList<ClientNeutre>();
                if(jtf.getText().matches("\\d+")){                
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        total.add(new Client());
                    }
                }
                if(jtf2.getText().matches("\\d+")){      
                    for(int i = 0 ; i < parseInt(jtf2.getText()) ; i++){
                        total.add(new Cliente());
                    }
                }
                if(total.size()>0&&!((Bar.getInstance().getClients().size()+total.size())>Bar.getInstance().getTables().size()*4)){
                    Bar.getInstance().setClients(total);
                    dispose();
                    NvPerso2 fen = new NvPerso2();
                }                
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso2 fen = new NvPerso2();
            }
        } 
    }
    
    
    class ServeursListener implements ActionListener{
        
        private JPanel pan = new JPanel();
        private JButton valider = new JButton("Valider");
        private JButton retour = new JButton("Retour");
        private JLabel label  = new JLabel("Nombre de serveurs générés aléatoirement        ");
        private JLabel label2 = new JLabel("Nombre de serveuses générées aléatoirement   ");
        private JTextField jtf = new JTextField();
        private JTextField jtf2 = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            jtf.setPreferredSize(new Dimension(150, 30));
            jtf2.setPreferredSize(new Dimension(150, 30));
            
            Box vbox1 = Box.createVerticalBox();
            
            Box hbox = Box.createHorizontalBox();
            hbox.add(new JLabel("Il y a actuellement "+Bar.getInstance().getServeurs().size()+" serveurs. Le nombre maximum de serveurs est actuellement de "
                    +Bar.getInstance().getTables().size()+". Ajoutez des tables pour en avoir plus"));
            
            Box hbox1 = Box.createHorizontalBox();                    
            hbox1.add(label); hbox1.add(jtf);
            
            Box hbox2 = Box.createHorizontalBox();
            hbox2.add(label2); hbox2.add(jtf2);
            
            Box hbox3 = Box.createHorizontalBox();
            hbox3.add(retour);
            hbox3.add(valider);
            
            vbox1.add(hbox); vbox1.add(hbox1); vbox1.add(hbox2); vbox1.add(hbox3);
            
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true); 
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                List<ServeurNeutre> total = new ArrayList<ServeurNeutre>();
                if(jtf.getText().matches("\\d+")){                
                    for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                        total.add(new Serveur());
                    }
                }
                if(jtf2.getText().matches("\\d+")){      
                    for(int i = 0 ; i < parseInt(jtf2.getText()) ; i++){
                        total.add(new Serveuse());
                    }
                }
                if(total.size()>0&&!((Bar.getInstance().getServeurs().size()+total.size())>Bar.getInstance().getTables().size())){
                    Bar.getInstance().setServeurs(total);
                    dispose();
                    NvPerso2 fen = new NvPerso2();
                }                
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso2 fen = new NvPerso2();
            }
        }
    }
    
    class TablesListener implements ActionListener{
        
        private JPanel pan = new JPanel();
        private JButton valider = new JButton("Valider");
        private JButton retour = new JButton("Retour");
        private JLabel label  = new JLabel("Nombre de tables créées        ");
        private JLabel label2 = new JLabel("Il y a actuellement "+Bar.getInstance().getTables().size()
                +" tables. Le maximum est de 10 tables. Vous pouvez donc ajouter "+(int)(10-Bar.getInstance().getTables().size())+" tables.");
        private JLabel label3 = new JLabel("Le nombre maximal de 10 tables est déjà atteint. Vous ne pouvez pas ajouter de tables.");
        private JTextField jtf = new JTextField();
        
        public void actionPerformed(ActionEvent ae) {
            
            valider.addActionListener(new ValiderListener());
            retour.addActionListener(new RetourListener());
            jtf.setPreferredSize(new Dimension(150, 30));
            
            Box vbox1 = Box.createVerticalBox();
            
            if (Bar.getInstance().getTables().size() < 10) {
                Box hbox = Box.createHorizontalBox();
                hbox.add(label2);
                Box hbox1 = Box.createHorizontalBox();
                hbox1.add(label);
                hbox1.add(jtf);
                vbox1.add(hbox);
                vbox1.add(hbox1);
                Box space = Box.createHorizontalBox();
                space.add(new JLabel(" "));
                vbox1.add(space);
                Box hbox2 = Box.createHorizontalBox();
                hbox2.add(retour);
                hbox2.add(valider);
                vbox1.add(hbox2);
            }
            else{
                Box hbox = Box.createHorizontalBox();
                hbox.add(label3);
                vbox1.add(hbox);
                Box space = Box.createHorizontalBox();
                space.add(new JLabel(" "));
                vbox1.add(space);
                Box hbox2 = Box.createHorizontalBox();
                hbox2.add(retour);
                vbox1.add(hbox2);
            }
            
            
            pan.add(vbox1);        
            pan.setBackground(Color.ORANGE);
            setContentPane(pan);
            setVisible(true); 
        }
        class ValiderListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                List<ServeurNeutre> total = new ArrayList<ServeurNeutre>();
                if(jtf.getText().matches("\\d+")){ 
                    if(parseInt(jtf.getText())<11){
                        for(int i = 0 ; i < parseInt(jtf.getText()) ; i++){
                            Bar.getInstance().addTable(new Table());
                        }
                        dispose();
                        NvPerso2 fen = new NvPerso2();
                    }
                    
                }
                else{
                    System.out.println("Veuillez entrer un entier");
                }              
            }
        }   
        class RetourListener implements ActionListener{
            public void actionPerformed(ActionEvent ae) {
                dispose();
                NvPerso2 fen = new NvPerso2();
            }
        }
    }
    
    class RetourListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            dispose();
            BarActuelVerif fen = new BarActuelVerif();
        }
    }   
    
    class ValiderListener implements ActionListener{
        public void actionPerformed(ActionEvent ae) {
            new Save();
            dispose();
            BarActuelVerif fen = new BarActuelVerif();
        }
    }  
    
    
    
}
