/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniprojet.Bar.*;
import miniprojet.Humans.*;
import miniprojet.*;
/**
 *
 * @author Louis
 */
public class Initialize {
        
    public Initialize(){
        Bar.getInstance().setPatronne(patronne());
        Bar.getInstance().setBarman(barman());
        Bar.getInstance().setFournisseur(fournisseur());
        Bar.getInstance().setClients(clients());
        Bar.getInstance().setClientes(clientes());
        Bar.getInstance().setServeurs(serveurs());
        Bar.getInstance().setServeuses(serveuses());
    }
    public Patronne patronne(){
        BufferedReader br=null;
        try {
            File file=new File(".\\db\\patronne.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boissons[] boissons = Boissons.values();
                Boissons boisson_fav_1 = null;
                Boissons boisson_fav_2 = null;
                for(int i = 0 ; i < boissons.length ; i ++){
                    if(boissons[i].getName().equals(valeurs[5])){
                        boisson_fav_1=boissons[i];
                    }
                    if(boissons[i].getName().equals(valeurs[6])){
                        boisson_fav_2=boissons[i];
                    }
                }
                float niveau_alcool = parseFloat(valeurs[7]);
                Color couleur_tshirt = null;
                int nb_bijoux = parseInt(valeurs[8]);
                return(new Patronne(prenom,surnom,porte_monnaie,popularite,cri,boisson_fav_1,boisson_fav_2,niveau_alcool,nb_bijoux));
            }   
            return(new Patronne());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(new Patronne());
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(new Patronne());
        } finally {
            
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Barman barman(){
        BufferedReader br=null;
        try {
            File file=new File(".\\db\\barman.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boissons[] boissons = Boissons.values();
                Boissons boisson_fav_1 = null;
                Boissons boisson_fav_2 = null;
                for(int i = 0 ; i < boissons.length ; i ++){
                    if(boissons[i].getName().equals(valeurs[5])){
                        boisson_fav_1=boissons[i];
                    }
                    if(boissons[i].getName().equals(valeurs[6])){
                        boisson_fav_2=boissons[i];
                    }
                }
                return(new Barman(prenom,surnom,porte_monnaie,popularite,cri,boisson_fav_1,boisson_fav_2));
            }   
            return(new Barman());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(new Barman());
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(new Barman());
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Fournisseur fournisseur(){
        BufferedReader br=null;
        try {
            File file=new File(".\\db\\fournisseur.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                return(new Fournisseur(prenom,surnom,porte_monnaie,popularite,cri));
            }   
            return(new Fournisseur());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(new Fournisseur());
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(new Fournisseur());
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Client> clients(){
        BufferedReader br = null;
        List<Client>liste = new ArrayList<Client>();
        try {
            
            File file=new File(".\\db\\clients.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boissons[] boissons = Boissons.values();
                Boissons boisson_fav_1 = null;
                Boissons boisson_fav_2 = null;
                for(int i = 0 ; i < boissons.length ; i ++){
                    if(boissons[i].getName().equals(valeurs[5])){
                        boisson_fav_1=boissons[i];
                    }
                    if(boissons[i].getName().equals(valeurs[6])){
                        boisson_fav_2=boissons[i];
                    }
                }
                float niveau_alcool = parseFloat(valeurs[7]);
                Color couleur_tshirt = null;
                Color[] couleurs = Color.values();
                for(int i = 0 ; i < couleurs.length ; i ++){
                    if(couleurs[i].getName().equals(valeurs[8])){
                        couleur_tshirt=couleurs[i];
                    }
                }
                liste.add(new Client(prenom,surnom,porte_monnaie,popularite,cri,boisson_fav_1,boisson_fav_2,niveau_alcool,couleur_tshirt));
            }   
            return(liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }
    public List<Cliente> clientes(){
        BufferedReader br = null;
        List<Cliente>liste = new ArrayList<Cliente>();
        try {
            
            File file=new File(".\\db\\clientes.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boissons[] boissons = Boissons.values();
                Boissons boisson_fav_1 = null;
                Boissons boisson_fav_2 = null;
                for(int i = 0 ; i < boissons.length ; i ++){
                    if(boissons[i].getName().equals(valeurs[5])){
                        boisson_fav_1=boissons[i];
                    }
                    if(boissons[i].getName().equals(valeurs[6])){
                        boisson_fav_2=boissons[i];
                    }
                }
                float niveau_alcool = parseFloat(valeurs[7]);
                Color couleur_tshirt = null;
                int nb_bijoux = parseInt(valeurs[8]);
                liste.add(new Cliente(prenom,surnom,porte_monnaie,popularite,cri,boisson_fav_1,boisson_fav_2,niveau_alcool,nb_bijoux));
            }   
            return(liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Serveur> serveurs(){
        BufferedReader br = null;
        List<Serveur>liste = new ArrayList<Serveur>();
        try {          
            File file=new File(".\\db\\serveurs.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                int taille_biceps = parseInt(valeurs[6]);           
                liste.add(new Serveur(prenom,surnom,porte_monnaie,popularite,cri,taille_biceps));
            }   
            return(liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public List<Serveuse> serveuses(){
        BufferedReader br = null;
        List<Serveuse>liste = new ArrayList<Serveuse>();
        try {
            File file=new File(".\\db\\serveuses.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            while((st = br.readLine()) != null){
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String surnom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                int coeff_charme = parseInt(valeurs[6]);           
                liste.add(new Serveuse(prenom,surnom,porte_monnaie,popularite,cri,coeff_charme));
            }   
            return(liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } catch (IOException ex) {
            Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            return(liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Initialize.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
