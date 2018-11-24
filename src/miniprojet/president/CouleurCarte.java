/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;

/**
 *
 * @author ISEN
 */
public enum CouleurCarte {
    
    COEUR("COEUR"),
    TREFLE("TREFLE"),
    PIQUE("PIQUE"),
    CARREAU("CARREAU");
    
    String couleur;

    private CouleurCarte(String couleur) {
        this.couleur = couleur;
    }
    
    public String getCouleur() {
        return couleur;
    }
    
    
    
    
}
