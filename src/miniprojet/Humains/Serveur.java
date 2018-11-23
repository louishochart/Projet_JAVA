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
public class Serveur extends ServeurNeutre {

    private int taille_biceps;
    private Table table;

    public Serveur(String prenom, String nom, double porte_monnaie, int popularite, String cri, int taille_biceps) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.taille_biceps = taille_biceps;
    }

    public Serveur() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());
        this.taille_biceps = (int) (Math.random() * 10);

    }

    @Override
    public String toString() {
        return "Serveur{ Prenom: " + this.getPrenom() + ", Surnom : " + this.getNom() + ", Porte Monnaie : " + this.getPorte_monnaie()
                + ", Popularité : " + this.getPopularite() + ", Cri : " + this.getCri() + " , taille_biceps : " + taille_biceps + '}';
    }

    public int getTaille_biceps() {
        return taille_biceps;
    }

    public void setTaille_biceps(int taille_biceps) {
        this.taille_biceps = taille_biceps;
    }

}
