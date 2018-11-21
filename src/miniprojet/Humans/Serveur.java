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
public class Serveur extends Humain{
    
    private final Boisson boisson = Boisson.EAU;
    private int taille_biceps;

    public Serveur(String prenom, String nom, double porte_monnaie, int popularite, String cri, int taille_biceps) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.taille_biceps = taille_biceps;
    }
    
    public Serveur(){
        super(new Random().getRandomPrenom_m(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        this.taille_biceps=(int)(Math.random()*10);
        save();
    }
    
    public void save(){
        try{
            char separator= ';';
            File file=new File(".\\db\\serveurs.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
                System.out.println("c nv");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(this.getPrenom()+separator+this.getNom()+separator+this.getPorte_monnaie()
            +separator+this.getPopularite()+separator+this.getCri()+separator+this.boisson+separator+this.taille_biceps);  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }
    
    @Override
    public String toString() {
        return "Serveur{ Prenom: "+this.getPrenom()+", Surnom : "+this.getNom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri() + " , taille_biceps : "+taille_biceps + '}';
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public int getTaille_biceps() {
        return taille_biceps;
    }

    public void setTaille_biceps(int taille_biceps) {
        this.taille_biceps = taille_biceps;
    }
   
}
