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
public class Barman extends Humain {

    private Boisson boisson_fav_1;
    private Boisson boisson_fav_2;

    public Barman(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2) {

        super(prenom, nom, porte_monnaie, popularite, cri);
        this.setBoisson_fav_1(boisson_fav_1);
        this.setBoisson_fav_2(boisson_fav_2);
    }

    public Barman() {
        super(new Random().getRandomPrenom_m(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri());
        this.boisson_fav_1 = new Random().getRandomSoft();
        Boisson b = new Random().getRandomSoft();
        while (boisson_fav_1.getName().equals(b.getName())) {
            b = new Random().getRandomSoft();
        }
        this.boisson_fav_2 = b;
    }
    
    public void commander() {
        if (Bar.getInstance().getStock().getStock(this.getBoisson_fav_1()) > 0) {
            this.boire(this.getBoisson_fav_1());

        } else if (Bar.getInstance().getStock().getStock(this.getBoisson_fav_2()) > 0) {
            this.boire(getBoisson_fav_2());
        }
    }
    public void boire(Boisson boisson) {       
        Bar.getInstance().getStock().removeFromStock(boisson, 1);
        this.parler("Je bois un verre de " + boisson.getName());  
        Bar.getInstance().getSimulation().incrementVerresBus();
    } 
    
    public void recevoirVerre(Humain expediteur, Boisson boisson) {
        this.boire(boisson);
        this.parlerDestinataire(expediteur, "Merci beaucoup !");  
        Bar.getInstance().getSimulation().incrementVerresOfferts();
    }
    
    public void verifierStocks(){
        for (Boisson boisson : Bar.getInstance().getStock().getBoissons()) {
            if (Bar.getInstance().getStock().getStock(boisson)<5){
                this.demanderLivraison(boisson,50);
            }
        }
    }
    public void demanderLivraison(Boisson boisson, int quantite ){
        if(Bar.getInstance().getPatronne().getPorte_monnaie()>(boisson.getPrixAchat()*quantite)){
            Bar.getInstance().getFournisseur().livrer(boisson,quantite);
            Bar.getInstance().getPatronne().parlerDestinataire(this,"Je renouvelle le stock de"+boisson.getName());
        }
        else{
            Bar.getInstance().getPatronne().parlerDestinataire(this,"Je ne peux pas renouveller le stock de "+boisson.getName());
        }
    }
    public void recevoirLivraison(Boisson boisson, int quantite){
        Bar.getInstance().getStock().addStock(boisson, quantite);
    }

    public void recevoirPaiement(Humain expediteur, float paiement) {
        this.parlerDestinataire(expediteur,"Merci");
        Bar.getInstance().getCaisse().addCaisse(paiement);
    }
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
