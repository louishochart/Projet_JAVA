/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import miniprojet.Humans.*;
import miniprojet.Bar.*;
import miniprojet.*;
import miniprojet.Functions.Random;

/**
 *
 * @author Louis
 */
public class Barman extends Human{
    
    private Boissons boisson_fav_1;
    private Boissons boisson_fav_2;
    
    public Barman(String prenom, String surnom, float porte_monnaie, int popularite, String cri, Boissons boisson_fav_1, Boissons boisson_fav_2) {
        
        super(prenom, surnom, porte_monnaie, popularite, cri);
        this.setBoisson_fav_1(boisson_fav_1);
        this.setBoisson_fav_2(boisson_fav_2);
    }
    
    public Barman() throws IOException{
        super(new Random().getRandomPrenom_m(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        this.boisson_fav_1=new Random().getRandomBoisson();
        Boissons b = new Random().getRandomBoisson();
        
        while(boisson_fav_1.getName().equals(b.getName())){
            b = new Random().getRandomBoisson();
        }
        this.boisson_fav_2=b;
        Save();
    }
    
    public void Save(){
        try{
            char separator= ';';
            File file=new File(".\\db\\barman.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()+separator
                            +this.getPopularite()+separator+this.getCri()+separator+this.boisson_fav_1+separator
                        +this.boisson_fav_2);  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }

    @Override
    public String toString() {
        return "Barman{ Prenom: "+this.getPrenom()+", Surnom : "+this.getSurnom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri()+", boisson_fav_1="+ boisson_fav_1 + ", boisson_fav_2=" + boisson_fav_2 + '}';
    }
    
    
    
    public Boissons getBoisson_fav_1() {
        return boisson_fav_1;
    }

    public Boissons getBoisson_fav_2() {
        return boisson_fav_2;
    }

    public void setBoisson_fav_1(Boissons boisson_fav_1) {
        if (boisson_fav_1.getDegree()!=0){
            System.out.println("Le Barman déteste l'aloool");
        }
        else{
            this.boisson_fav_1 = boisson_fav_1;
        }
    }

    public void setBoisson_fav_2(Boissons boisson_fav_2) {
        if (boisson_fav_2.getDegree()!=0){
            System.out.println("Le Barman déteste l'aloool");
        }
        else{
            this.boisson_fav_2 = boisson_fav_2;
        }
    }

    
    
    public void boire(){
        
    }
    public void gestion_caisse(){
    }

}
