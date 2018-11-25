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
 * l'objet fournisseur hérité de l'objet Humain
 */
public class Fournisseur extends Humain {
    
    /**
     * Constructeur
     * @param prenom
     * @param nom
     * @param porte_monnaie
     * @param popularite
     * @param cri 
     */
    public Fournisseur(String prenom, String nom, double porte_monnaie, int popularite, String cri) {
        super(prenom, nom, porte_monnaie, popularite, cri);
    }
    /**
     * Constructeur aléatoire
     */
    public Fournisseur() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());

    }

    @Override
    public String toString() {
        return "Fournisseur{ Prenom: " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + '}';
    }
    /**
     * Permet de livrer une boisson donnée dans la quantité voulue
     * @param boisson
     * @param quantite 
     */
    public void livrer(Boisson boisson, int quantite) {
        Bar.getInstance().getBarman().recevoirLivraison(boisson,quantite);
        Bar.getInstance().getPatronne().payer(this, (quantite*boisson.getPrixVente()));
        
    }

}
