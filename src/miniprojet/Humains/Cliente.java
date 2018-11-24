/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Bar.*;
import miniprojet.Fonctions.*;

/**
 *
 * @author Louis
 */
public class Cliente extends ClientNeutre {

    int nb_bijoux;

    public Cliente(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool, int nb_bijoux) {
        super(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool);
        this.nb_bijoux = nb_bijoux;
    }

    public Cliente() {
        super(new Random().getRandomPrenom_f(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(),
                new Random().getRandomCri(), new Random().getRandomBoisson(), new Random().getRandomBoisson(), 0f);

        while (this.getBoisson_fav_1().getName().equals(this.getBoisson_fav_2().getName())) {
            this.setBoisson_fav_2(new Random().getRandomBoisson());
        }
        this.nb_bijoux = (int) Math.random() * 10;

    }

    public void parlerDestinataire(Humain destinataire, String phrase) {
        if (destinataire.getClass().getSimpleName().equals("Serveur") && this.getNiveau_alcool() > 1) {
            System.out.println(this.getPrenom() + " " + this.getNom() + " à " + destinataire.getPrenom() + " " + destinataire.getNom() + " : " + phrase + " beau gosse !");
        } else {
            System.out.println(this.getPrenom() + " " + this.getNom() + " à " + destinataire.getPrenom() + " " + destinataire.getNom() + " : " + phrase);
        }
    }

    public int getNb_bijoux() {
        return nb_bijoux;
    }

    public void setNb_bijoux(int nb_bijoux) {
        this.nb_bijoux = nb_bijoux;
    }

    @Override
    public String toString() {
        return "Cliente{ Prenom: " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + " , boisson_fav_1 : " + this.getBoisson_fav_1() + " , boisson_fav_2 : "
                + this.getBoisson_fav_2() + " , niveau_alcool : " + this.getNiveau_alcool() + " ,nombre_bijoux : " + this.getNb_bijoux() + " , exclu? = " + this.isExclu() + " }";
    }

    public void verre_gratuit() {

    }

    public void se_presenter_court() {

    }
}
