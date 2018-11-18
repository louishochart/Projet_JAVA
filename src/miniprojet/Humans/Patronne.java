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
public class Patronne extends Cliente {

    public Patronne(String prenom, String surnom, double porte_monnaie, int popularite, String cri, Boissons boisson_fav_1, Boissons boisson_fav_2, float niveau_alcool, int nb_bijoux) {
        super(prenom, surnom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, nb_bijoux);
        
    }
    
    public Patronne() {
        super(new Random().getRandomPrenom_f(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri(),new Random().getRandomBoisson(),new Random().getRandomBoisson(),0f,(int)Math.random()*10);
        Save();
    }
    
    public void Save(){
        try{
            char separator= ';';
            File file=new File(".\\db\\patronne.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()+separator
            +this.getPopularite()+separator+this.getCri()+separator+this.getBoisson_fav_1()+separator
            +this.getBoisson_fav_2()+separator+this.getNiveau_alcool()+separator+this.nb_bijoux);  
            // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }

    @Override
    public String toString() {
        return "Patronne{ Prenom: "+this.getPrenom()+", Surnom : "+this.getSurnom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri()+", boisson_fav_1="+ this.getBoisson_fav_1() + ", boisson_fav_2=" + this.getBoisson_fav_2() + ", niveau_alcool=" + this.getNiveau_alcool() + '}';
    }
    
    
    
    void exclure(){
        
    }
    
    void ne_plus_servir(){
        
    }
    
    void recupere_argent(){
        
    }
    
    void payer_fournisseur(){
        
    }
}
