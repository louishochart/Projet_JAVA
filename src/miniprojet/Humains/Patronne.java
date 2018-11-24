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
public class Patronne extends Cliente {

    public Patronne(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool, int nb_bijoux) {
        super(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, nb_bijoux);

    }

    public Patronne() {
        super(new Random().getRandomPrenom_f(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri(), new Random().getRandomBoisson(), new Random().getRandomBoisson(), 0f, (int) Math.random() * 10);
    }

    public void exclure(ClientNeutre client) {
        Bar.getInstance().getBarman().parlerDestinataire(client,"Dehors ! Je ne veux plus te voir dans ce bar ce soir ! ");
        client.setExclu(true);
    }
    
    public void verifierCaisse(){
        if(Bar.getInstance().getCaisse().getCaisse()>100){
            this.recupererArgent(Bar.getInstance().getCaisse().getCaisse()-100);
        }
    }
    private void recupererArgent(float cash) {
        Bar.getInstance().getCaisse().removeCaisse(cash);
        this.porte_monnaie+=cash;
    }
    


    @Override
    public String toString() {
        return "Patronne{ Prenom: " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + " , boisson_fav_1 : " + this.getBoisson_fav_1() + " , boisson_fav_2 : "
                + this.getBoisson_fav_2() + " , niveau_alcool : " + this.getNiveau_alcool() + " , nombre_bijoux : " + this.getNb_bijoux() + '}';
    }

    void exclure() {

    }

    void ne_plus_servir() {

    }

    
}
