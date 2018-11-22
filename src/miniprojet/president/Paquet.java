/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;

import java.util.*;


/**
 * Classe correspondant à un jeu de carte
 * @author ISEN
 */

public class Paquet {
    /** Paquet de carte*/
    List<ArrayList> cartes = new ArrayList<ArrayList>();

    
    /**Constructeur du paquet*/
    public Paquet()
   {
      for(int i = 0; i < Couleur_carte.values().length; i++)
      {
            for(int j = 0; j < Figure_carte.values().length; j++)
            {
                Carte carte = new Carte(Couleur_carte.values()[i],Figure_carte.values()[j]);
                this.cartes.add(carte.getCarte_unique());
            }
      }
    }

    public List<ArrayList> getCartes() {
        return cartes;
    }
    
    /**Melange le paquet de carte*/
    public void bat()
    {
        int nb = 0;
        for (int i = 52; i > 0; i--) 
        {
                nb = (int) (Math.random() * i); //on prends une carte au hasard et on la met à la fin
                this.cartes.add(this.cartes.get(nb));
                this.cartes.remove(nb);
        }
    }
    
    /**Coupe le paquet de carte*/
    public void coupe(int n)
    {
        this.cartes.addAll(this.cartes.subList(52-n, 52));
        this.cartes.addAll(this.cartes.subList(0, 52-n));
        for (int i = 0; i < 52; i++)
        {
            this.cartes.remove(0);
        }
        
    }
    /**Distribue les cartes du paquet aux 4 joueurs de la table*/
    public void distribue()
    {
        
    }
    
}
