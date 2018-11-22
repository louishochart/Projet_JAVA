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
    
    /**Constructeur d'une carte*/
    public Carte(Couleur_carte couleur, Figure_carte figure) {
        this.carte_unique.add(figure);
        this.carte_unique.add(couleur);
    }

    public ArrayList getCarte_unique() {
        return this.carte_unique;
    } 
}
