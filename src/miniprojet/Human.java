/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;




/**
 *
 * @author Louis
 */
public class Human {
    private String prenom;
    private String surnom;
    private float porte_monnaie;
    private float popularite;
    private String cri;

    public Human(String prenom, String surnom, float porte_monnaie, float popularite, String cri) {
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

    public void setPorte_monnaie(float porte_monnaie) {
        this.porte_monnaie = porte_monnaie;
    }

    public void setPopularite(float popularite) {
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

    public float getPorte_monnaie() {
        return porte_monnaie;
    }

    public float getPopularite() {
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
