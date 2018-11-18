/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humans;

import miniprojet.Humans.*;
import miniprojet.Bar.*;
import miniprojet.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import miniprojet.Functions.Random;

/**
 *
 * @author Louis
 */
public class Cliente extends Human {
    
    private Boissons boisson_fav_1;
    private Boissons boisson_fav_2;
    private float niveau_alcool;
    int nb_bijoux;

    public Cliente(String prenom, String surnom, double porte_monnaie, int popularite, String cri, Boissons boisson_fav_1, Boissons boisson_fav_2, float niveau_alcool, int nb_bijoux) {
        super(prenom, surnom, porte_monnaie, popularite, cri);
        
        this.boisson_fav_1 = boisson_fav_1;
        while(boisson_fav_1.getName().equals(boisson_fav_2.getName())){
            boisson_fav_2 = new Random().getRandomBoisson();
        }
        this.boisson_fav_2 = boisson_fav_2;
        this.niveau_alcool = niveau_alcool;
        this.nb_bijoux=nb_bijoux;
        Save();
    }
    
    public Cliente() throws IOException{
        super(new Random().getRandomPrenom_f(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        this.boisson_fav_1=new Random().getRandomBoisson();
        Boissons b = new Random().getRandomBoisson();
        
        while(boisson_fav_1.getName().equals(b.getName())){
            b = new Random().getRandomBoisson();
        }
        
        this.boisson_fav_2=b;
        this.niveau_alcool=0;
        this.nb_bijoux=(int)Math.random()*10;
        Save();
    }
    
    public void Save(){     
        try{
            char separator= ';';
            File file=new File(".\\db\\clients.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()+separator
                            +this.getPopularite()+separator+this.getCri()+separator+this.getBoisson_fav_1()+separator
                        +this.boisson_fav_2+separator+this.niveau_alcool+separator+this.nb_bijoux);  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}  
    }
    public Boissons getBoisson_fav_1() {
        return boisson_fav_1;
    }

    public Boissons getBoisson_fav_2() {
        return boisson_fav_2;
    }

    public float getNiveau_alcool() {
        return niveau_alcool;
    }

    public void setBoisson_fav_1(Boissons boisson_fav_1) {
        this.boisson_fav_1 = boisson_fav_1;
    }

    public void setBoisson_fav_2(Boissons boisson_fav_2) {
        this.boisson_fav_2 = boisson_fav_2;
    }

    public void setNiveau_alcool(float niveau_alcool) {
        this.niveau_alcool = niveau_alcool;
    }

    @Override
    public String toString() {
        return "Cliente{ Prenom: "+this.getPrenom()+", Surnom : "+this.getSurnom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri()+", boisson_fav_1="+ boisson_fav_1 + ", boisson_fav_2=" + boisson_fav_2 + ", niveau_alcool=" + niveau_alcool + '}';
    } 
    
    public void verre_gratuit(){
        
    }
    public void se_presenter_court(){
        
    }
}
