/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Fonctions.Random;
import miniprojet.Humains.*;
import miniprojet.Bar.*;

/**
 *
 * @author Louis
 */
public class Fournisseur extends Humain {

    public Fournisseur(String prenom, String nom, double porte_monnaie, int popularite, String cri) {
        super(prenom, nom, porte_monnaie, popularite, cri);
    }

    public Fournisseur() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());

    }

    @Override
    public String toString() {
        return "Fournisseur{ Prenom: " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + '}';
    }

    public void livrer(Boisson boisson, int quantite) {
        Bar.getInstance().getBarman().recevoirLivraison(boisson,quantite);
        Bar.getInstance().getPatronne().payer(this, (quantite*boisson.getPrixVente()));
        
    }

}
