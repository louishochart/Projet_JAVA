/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;
import java.util.ArrayList;


/**
 * Classe correspondant à une carte de jeu
 * @author ISEN
 */
public class Carte {   
    ArrayList carte_unique = new ArrayList();
    
    /**
     * Constructeur d'une carte
     * @param couleur Pique, Carreau, Trefle, Coeur
     * @param figure figure des cartes allant de 2 à l'As 
     */
    public Carte(CouleurCarte couleur, FigureCarte figure) {
        this.carte_unique.add(figure);
        this.carte_unique.add(couleur);
    }

    /**
     * Getter d'une carte
     * @return une carte
     */
    public ArrayList getCarteUnique() {
        return this.carte_unique;
    } 
}
