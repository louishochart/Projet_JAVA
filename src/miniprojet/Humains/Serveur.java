/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Bar.*;
import miniprojet.Fonctions.Random;

/**
 *
 * @author Louis
 */
public class Serveur extends ServeurNeutre {

    private int tailleBiceps;
    private Table table;

    public Serveur(String prenom, String nom, double porte_monnaie, int popularite, String cri, int tailleBiceps) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.tailleBiceps = tailleBiceps;
    }

    public Serveur() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());
        this.tailleBiceps = (int) (Math.random() * 10);

    }

    @Override
    public String toString() {
        return "Serveur{ Prenom: " + this.getPrenom() + ", Surnom : " + this.getNom() + ", Porte Monnaie : " + this.getPorte_monnaie()
                + ", Popularité : " + this.getPopularite() + ", Cri : " + this.getCri() + " , taille_biceps : " + tailleBiceps + '}';
    }

    public int getTailleBiceps() {
        return tailleBiceps;
    }

    public void setTailleBiceps(int tailleBiceps) {
        this.tailleBiceps = tailleBiceps;
    }

}
