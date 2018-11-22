/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import miniprojet.Bar.*;
import miniprojet.*;
import miniprojet.Fonctions.Random;

/**
 *
 * @author Louis
 */
public class Serveuse extends ServeurNeutre{
    
    private int coeff_charme;

    public Serveuse(String prenom, String nom, double porte_monnaie, int popularite, String cri, int taille_biceps) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.coeff_charme = coeff_charme;
    }
    
    
    
    public Serveuse(){
        super(new Random().getRandomPrenom_f(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        this.coeff_charme=(int)(Math.random()*10);
    
    }
    
    @Override
    public String toString() {
        return "Serveuse{ Prenom: "+this.getPrenom()+", Surnom : "+this.getNom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri() + " , coeff_charme : "+ coeff_charme +'}';
    }


    public int getCoeff_charme() {
        return coeff_charme;
    }

    public void setCoeff_charme(int coeff_charme) {
        this.coeff_charme = coeff_charme;
    }
    
    
}
