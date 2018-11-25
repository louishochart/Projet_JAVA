/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Fonctions.Random;
import miniprojet.Bar.*;

/**
 *
 * @author Louis
 */
public class Client extends ClientNeutre {

    private Color couleur_tshirt;

    public Client(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool, Color couleur_tshirt) {
        super(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool);
        this.couleur_tshirt = couleur_tshirt;
    }

    public Client() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(),
                new Random().getRandomCri(), new Random().getRandomBoisson(), new Random().getRandomBoisson(), 0f);

        while (this.getBoissonFav1().getName().equals(this.getBoissonFav2().getName())) {
            this.setBoissonFav2(new Random().getRandomBoisson());
        }

        this.couleur_tshirt = new Random().getRandomCouleur();
    }

    public void parlerDestinataire(Humain destinataire, String phrase) {
        if (destinataire.getClass().getSimpleName().equals("Serveuse") && this.getNiveauAlcool() > 1) {
            System.out.println(this.getPrenom() + " " + this.getNom() + " à " + destinataire.getPrenom() + " " + destinataire.getNom() + " : " + phrase + " poupée !");
        } else {
            System.out.println(this.getPrenom() + " " + this.getNom() + " à " + destinataire.getPrenom() + " " + destinataire.getNom() + " : " + phrase);
        }
    }

    public Color getCouleur_tshirt() {
        return couleur_tshirt;
    }

    public void setCouleur_tshirt(Color couleur_tshirt) {
        this.couleur_tshirt = couleur_tshirt;
    }

    @Override
    public String toString() {
        return "Client{ Prenom : " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + " , boisson_fav_1 : " + this.getBoissonFav1() + " , boisson_fav_2 : "
                + this.getBoissonFav2() + " , niveau_alcool : " + this.getNiveauAlcool() + " , couleur_tshirt : " + couleur_tshirt + " , exclu? = " + this.isExclu() + '}';
    }

    public void verre_gratuit() {

    }

    public void se_presenter_court() {

    }
}
