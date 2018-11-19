/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humans;

import miniprojet.Humans.*;
import miniprojet.Bar.*;
import miniprojet.*;

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
    
    public void parler(){
        System.out.println(this.getPrenom()+" :");
    }
    
    public void boire(Boisson boisson){
        System.out.println(this.getPrenom()+" "+this.getNom()+" : Je ne peux pas boire !");
    }
    public void payer(float prix){
        this.porte_monnaie-=prix;
    }
    public void offrir_verre(Humain destinataire, Boisson boisson){
        if(destinataire.getClass().getName()=="Humain" || destinataire.getClass().getName()=="Fournisseur")
        destinataire.boire(boisson);
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
}
