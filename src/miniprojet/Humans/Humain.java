/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humans;

import java.util.Objects;
import miniprojet.Humans.*;
import miniprojet.Bar.*;
import miniprojet.*;
import miniprojet.Functions.*;

/**
 *
 * @author Louis
 */
public class Humain {
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
    
    public void boire(Boisson boisson){
        System.out.println(this.getPrenom()+" "+this.getNom()+" : Je ne peux pas boire !");
    }
    public void payer(float prix){
        this.porte_monnaie-=prix;
        Bar.getInstance().getBarman().setPorte_monnaie(Bar.getInstance().getBarman().getPorte_monnaie()+prix);
        Bar.getInstance().getBarman().recevoir_paiement(prix);
    }
    
    public void offrir_verre(Humain destinataire, Boisson boisson){
        if(!(this.getClass().getSimpleName().equals("Humain"))&&!(this.getClass().getSimpleName().equals("Fournisseur"))){
            if(this.getPorte_monnaie()>boisson.getPrix_vente()){
                if(!(destinataire.getClass().getSimpleName().equals("Humain"))&&!(destinataire.getClass().getSimpleName().equals("Fournisseur"))){
                    if((destinataire.getClass().getSimpleName().equals("Serveur")||destinataire.getClass().getSimpleName().equals("Serveuse"))&&(boisson.getDegree()!=0)){
                        System.out.println(destinataire.getPrenom()+" "+destinataire.getNom()+" ne peut pas boire d'alcool, il est serveur !");
                    }
                    else{
                        destinataire.parler("Merci "+this.getPrenom()+" !");
                        this.payer(boisson.getPrix_vente());
                        destinataire.boire(boisson);
                    }
                }
                else{
                    System.out.println(destinataire.getPrenom()+" "+destinataire.getNom()+" n'a pas le droit de boire !");
                }
            }
            else{
                this.parler("Je n'ai pas assez d'argent !");
            }
        }
        else{
            this.parler("Je n'ai pas le droit d'offrir de verre");
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
