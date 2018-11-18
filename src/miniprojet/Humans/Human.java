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
public class Human {
    String prenom;
    String surnom;
    double porte_monnaie;
    int popularite;
    String cri;

    public Human(String prenom, String surnom, double porte_monnaie, int popularite, String cri) {
        this.prenom = prenom;
        this.surnom = surnom;
        this.porte_monnaie = porte_monnaie;
        this.popularite = popularite;
        this.cri = cri;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
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

    public String getSurnom() {
        return surnom;
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
     
    public void parler(){
        
    }
    public void boire(){
    
    }
    public void payer(){
        
    }
    public void offrir_verre(){
        
    }
    public void se_presenter(){
        
    }
}
