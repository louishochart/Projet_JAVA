/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Functions;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniprojet.Bar.*;
import miniprojet.*;
/**
 *
 * @author Louis
 */
public class Random {

    public Random() {
    }
    
    public String getRandomPrenom_m() {
        BufferedReader br=null;
        try {
            File file=new File(".\\création\\prenoms_m.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            int nblignes=0;
            List<String> prenom_m = new ArrayList<String>();
            while((st = br.readLine()) != null){
                nblignes++;
                prenom_m.add(st);
            }   double random = Math.random()*(nblignes);
            return(prenom_m.get((int)random));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } catch (IOException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public String getRandomPrenom_f(){
        BufferedReader br=null;
        try {
            File file=new File(".\\création\\prenoms_f.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            int nblignes=0;
            List<String> prenom_f = new ArrayList<String>();
            while((st = br.readLine()) != null){
                nblignes++;
                prenom_f.add(st);
            }   double random = Math.random()*(nblignes);
            return(prenom_f.get((int)random));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } catch (IOException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String getRandomNom(){
        BufferedReader br=null;
        try {
            File file=new File(".\\création\\noms.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            int nblignes=0;
            List<String> noms = new ArrayList<String>();
            while((st = br.readLine()) != null){
                nblignes++;
                noms.add(st);
            }   double random = Math.random()*(nblignes);
            return(noms.get((int)random));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } catch (IOException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public String getRandomCri(){
        BufferedReader br=null;
        try {
            File file=new File(".\\création\\cris.txt"); // définir l'arborescence
            br = new BufferedReader(new FileReader(file));
            String st;
            int nblignes=0;
            List<String> cri = new ArrayList<String>();
            while((st = br.readLine()) != null){
                nblignes++;
                cri.add(st);
            }   double random = Math.random()*(nblignes);
            return(cri.get((int)random));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } catch (IOException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            return("Erreur");
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public double getRandomPorteMonnaie(){
        double random = Math.random()*100;
        random = (Math.round(random * 100.0) / 100.0);
        return random;
    }
    public int getRandomPopularite(){
        double random = Math.random()*100*Math.random()*100/100;
        return((int)random);
    }
    public Boisson getRandomBoisson(){
        Boisson[] boissons = Boisson.values();
        int count = boissons.length;
        double random = Math.random()*(count);
        return(boissons[(int)random]);
    }
    public Boisson getRandomSoft(){
        Boisson[] boissons = Boisson.values();
        List<Boisson> softs = new ArrayList<Boisson>();
        for(int i = 0 ; i < boissons.length;i++){
            if (boissons[i].getDegree()==0){
                softs.add(boissons[i]);
            }
        }
        double random = Math.random()*(softs.size());
        return(softs.get((int)random));
    }
    public Color getRandomCouleur(){
        double random = Math.random()*(Color.values().length);
        return(Color.values()[(int)random]);
    }
}
