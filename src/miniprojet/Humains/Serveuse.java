/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;


import miniprojet.Fonctions.Random;

/**
 * l'objet Serveuse, hérité de l'objet ServeurNeutre
 */
public class Serveuse extends ServeurNeutre {

    private int coeffCharme;
    /**
     * Constructeur
     * @param prenom
     * @param nom
     * @param porte_monnaie
     * @param popularite
     * @param cri
     * @param coeffCharme 
     */
    public Serveuse(String prenom, String nom, double porte_monnaie, int popularite, String cri, int coeffCharme) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.coeffCharme = coeffCharme;
    }
    /**
     * Constructeur Aléatoire
     */
    public Serveuse() {
        super(new Random().getRandomPrenom_f(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());
        this.coeffCharme = (int) (Math.random() * 10);

    }

    @Override
    public String toString() {
        return "Serveuse{ Prenom: " + this.getPrenom() + ", Surnom : " + this.getNom() + ", Porte Monnaie : " + this.getPorte_monnaie()
                + ", Popularité : " + this.getPopularite() + ", Cri : " + this.getCri() + " , coeff_charme : " + coeffCharme + '}';
    }

    public int getCoeffCharme() {
        return coeffCharme;
    }

    public void setCoeffCharme(int coeffCharme) {
        this.coeffCharme = coeffCharme;
    }

}
