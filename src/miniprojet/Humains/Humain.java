/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Fonctions.Random;
import java.util.Objects;
import miniprojet.Bar.*;
import miniprojet.*;

/**
 *
 * @author Louis
 */
public abstract class Humain {
    String prenom;
    String nom;
    double porte_monnaie;
    int popularite;
    String cri;

    public Humain(String prenom, String nom, double porte_monnaie, int popularite, String cri) {
        this.prenom = prenom;
        this.nom = nom;
        this.porte_monnaie = porte_monnaie;
        this.popularite = popularite;
        this.cri = cri;   
    }
    public Humain(){
        this.prenom = new Random().getRandomPrenom_m();
        this.nom = new Random().getRandomNom();
        this.porte_monnaie = new Random().getRandomPorteMonnaie();
        this.popularite = new Random().getRandomPopularite();
        this.cri = new Random().getRandomCri();
    }
    
    
    public void parler(String phrase){
        System.out.println(this.getPrenom()+" "+this.getNom()+" : "+phrase);
    }
    public void parlerdestinataire(Humain destinataire, String phrase){     
        System.out.println(this.getPrenom()+" "+this.getNom()+" à "+destinataire.getPrenom()+" "+destinataire.getNom()+" : "+phrase);
    }
    
    public void boire(Boisson boisson){
        System.out.println(this.getPrenom()+" "+this.getNom()+" : Je ne peux pas boire !");
    }
    public void payer(float prix){
        this.porte_monnaie-=prix;
        Bar.getInstance().getBarman().setPorte_monnaie(Bar.getInstance().getBarman().getPorte_monnaie()+prix);
        Bar.getInstance().getBarman().recevoir_paiement(prix);
    }
    
    public void offrir_verre(Humain destinataire, Boisson boisson){
        if(this.canPay(boisson)){
            this.parlerdestinataire(destinataire,"Je t'offre un verre de "+boisson.getName());
            destinataire.recevoir_verre(this, boisson);
        }
        else{
            this.parler("Je n'ai pas assez d'argent pour offrir de verre !");
        }
    }
    
    public void recevoir_verre(Humain expediteur, Boisson boisson){
        System.out.println("Merci "+expediteur.getPrenom()+", mais je n'ai pas soif !");
    }
    
    public boolean canPay(Boisson boisson){
        if (this.getPorte_monnaie()<boisson.getPrixVente()){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void se_presenter(){
        System.out.println("Je m'appelle "+this.getPrenom()+" "+this.getNom());
    }

    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPorte_monnaie(double porte_monnaie) {
        this.porte_monnaie = porte_monnaie;
    }
    public void setPopularite(int popularite) {
        this.popularite = popularite;
    }
    public void setCri(String cri) {
        this.cri = cri;
    }

    public String getPrenom() {
        return prenom;
    }
    public String getNom() {
        return nom;
    }
    public double getPorte_monnaie() {
        return porte_monnaie;
    }
    public int getPopularite() {
        return popularite;
    }
    public String getCri() {
        return cri;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Humain other = (Humain) obj;
        if (Double.doubleToLongBits(this.porte_monnaie) != Double.doubleToLongBits(other.porte_monnaie)) {
            return false;
        }
        if (this.popularite != other.popularite) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.cri, other.cri)) {
            return false;
        }
        return true;
    }
    
    
}
