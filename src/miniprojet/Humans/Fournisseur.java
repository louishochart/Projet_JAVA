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
public class Fournisseur extends Human {

    public Fournisseur(String prenom, String surnom, float porte_monnaie, int popularite, String cri) {
        super(prenom, surnom, porte_monnaie, popularite, cri);
        Save();
    }
    public Fournisseur() throws IOException{
        super(new Random().getRandomPrenom_m(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        Save();
    }
    
    public void Save(){
        try{
            char separator= ';';
            File file=new File(".\\db\\fournisseur.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()+separator
                            +this.getPopularite()+separator+this.getCri());  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }
    

    @Override
    public String toString() {
        return "Fournisseur{ Prenom: "+this.getPrenom()+", Surnom : "+this.getSurnom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri() + '}';
    }
    
    
    
    public void recevoir_commande(){
        
    }
    
    public void livrer(){
        
    }
    
    public void recevoir_paiement(){
        
    }
}
