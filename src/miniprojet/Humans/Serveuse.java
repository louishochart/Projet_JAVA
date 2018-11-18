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
public class Serveuse extends Human{
    
    private final Boissons boisson = Boissons.EAU;
    private int coeff_charme;
    
    public Serveuse(String prenom, String surnom, float porte_monnaie, int popularite, String cri, int taille_biceps) {
        super(prenom, surnom, porte_monnaie, popularite, cri);
        this.coeff_charme = taille_biceps;
        Save();
    }
    
    public Serveuse() throws IOException{
        super(new Random().getRandomPrenom_f(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        this.coeff_charme=(int)(Math.random()*10);
        Save();
    }
    
    public void Save(){
        try{
            char separator= ';';
            File file=new File(".\\db\\serveuses.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()
            +separator+this.getPopularite()+separator+this.getCri()+separator+this.boisson+separator+this.coeff_charme);  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }
    
    @Override
    public String toString() {
        return "Serveuse{ Prenom: "+this.getPrenom()+", Surnom : "+this.getSurnom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri() + '}';
    }

    public Boissons getBoisson() {
        return boisson;
    }

    public int getCoeff_charme() {
        return coeff_charme;
    }

    public void setCoeff_charme(int coeff_charme) {
        this.coeff_charme = coeff_charme;
    }
    
    
}
