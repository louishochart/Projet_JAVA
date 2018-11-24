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
    int value;
    
    /**Constructeur d'une carte*/
    public Carte(CouleurCarte couleur, FigureCarte figure, int value) {
        this.carte_unique.add(figure);
        this.carte_unique.add(couleur);
        this.value=value;
    }

    public ArrayList getCarteUnique() {
        return this.carte_unique;
    } 
    
    public int getValueCarte() {
        return value;
    }
    
}
