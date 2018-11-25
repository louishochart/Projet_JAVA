/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Bar.*;
import miniprojet.Fonctions.Random;

/**
 * l'objet Barman du Bar, hérité de l'objet Humain
 */
public class Barman extends Humain {

    private Boisson boisson_fav_1;
    private Boisson boisson_fav_2;
    /**
     * Constructeur de l'objet Barman
     * @param prenom
     * @param nom
     * @param porte_monnaie
     * @param popularite
     * @param cri
     * @param boisson_fav_1
     * @param boisson_fav_2 
     */
    public Barman(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2) {

        super(prenom, nom, porte_monnaie, popularite, cri);
        this.setBoisson_fav_1(boisson_fav_1);
        this.setBoisson_fav_2(boisson_fav_2);
    }
    /**
     * Constructeur aléatoire de l'objet Barman
     */
    public Barman() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());
        this.boisson_fav_1 = new Random().getRandomSoft();
        Boisson b = new Random().getRandomSoft();
        while (boisson_fav_1.getName().equals(b.getName())) {
            b = new Random().getRandomSoft();
        }
        this.boisson_fav_2 = b;
    }
    
    /**
     * Le Barman Verifie les stocks de boisson en fin de soirée
     * et demande une livraison si c'est nécessaire
     */
    public void verifierStocks(){
        for (Boisson boisson : Bar.getInstance().getStock().getBoissons()) {
            if (Bar.getInstance().getStock().getStock(boisson)<5){
                this.demanderLivraison(boisson,50);
            }
        }
    }
    /**
     * Demande la livraison d'une boisson pour une quantité donnée
     * @param boisson
     * @param quantite 
     */
    public void demanderLivraison(Boisson boisson, int quantite ){
        if(Bar.getInstance().getPatronne().getPorte_monnaie()>(boisson.getPrixAchat()*quantite)){
            Bar.getInstance().getFournisseur().livrer(boisson,quantite);
            Bar.getInstance().getPatronne().parlerDestinataire(this,"Je renouvelle le stock de"+boisson.getName());
        }
        else{
            Bar.getInstance().getPatronne().parlerDestinataire(this,"Je ne peux pas renouveller le stock de "+boisson.getName());
        }
    }
    /**
     * ajoute les stocks reçus dans le Stock du bar
     * @param boisson
     * @param quantite 
     */
    public void recevoirLivraison(Boisson boisson, int quantite){
        Bar.getInstance().getStock().addStock(boisson, quantite);
    }
    /**
     * Quand le serveur est payé, il met l'argent dans la caisse
     * @param expediteur
     * @param paiement 
     */
    public void recevoirPaiement(Humain expediteur, float paiement) {
        this.parlerDestinataire(expediteur,"Merci");
        Bar.getInstance().getCaisse().addCaisse(paiement);
    }
    /**
     * Le serveur finit ses phrases par "coco"
     * @param destinataire
     * @param phrase 
     */
    public void parlerDestinataire(Humain destinataire, String phrase) {
        System.out.println(this.getPrenom() + " " + this.getNom() + " à " + destinataire.getPrenom() + " " + destinataire.getNom() + " : " + phrase + " coco !");
    }
    @Override
    public String toString() {
        return "Barman{ Prenom: " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + " , boisson_fav_1 : " + boisson_fav_1 + " , boisson_fav_2 : " + boisson_fav_2 + '}';
    }

    public Boisson getBoisson_fav_1() {
        return boisson_fav_1;
    }

    public Boisson getBoisson_fav_2() {
        return boisson_fav_2;
    }

    public void setBoisson_fav_1(Boisson boisson_fav_1) {
        if (boisson_fav_1.getDegree() != 0) {
            System.out.println("Le Barman déteste l'aloool");
        } else {
            this.boisson_fav_1 = boisson_fav_1;
        }
    }

    public void setBoisson_fav_2(Boisson boisson_fav_2) {
        if (boisson_fav_2.getDegree() != 0) {
            System.out.println("Le Barman déteste l'aloool");
        } else {
            this.boisson_fav_2 = boisson_fav_2;
        }
    }

}
