/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;

import java.util.*;
import miniprojet.Humains.ClientNeutre;

/**
 * Classe correspondant a l'application des differentes regles du president
 * @author ISEN
 */
public class President {
    ArrayList<ClientNeutre> joueurs;
    int table;

    /**
     * Constructeur de la classe president qui prends en charge la gestion d'une partie
     * @param joueurs liste des 4 joueurs
     * @param table indice de la table
     */
    public President(ArrayList<ClientNeutre> joueurs, int table) {
        this.joueurs = joueurs;
        this.table = table;
    }
       
    public void jeu(){
        Paquet newpaquet = new Paquet();
        //System.out.println("Paquet de Carte");
        //System.out.println(newpaquet.getCartes());
        
        newpaquet.bat();
        //System.out.println("Melange du paquet en cours:");
        //System.out.println(newpaquet.getCartes());
        
        newpaquet.coupe((int) (Math.random() * 51));    //Coupage du paquet
        //System.out.println("Coupe du paquet");
        //System.out.println(newpaquet.getCartes());
        
        newpaquet.distribue(joueurs, 1);
        
//        System.out.println("Main Premier Joueur:");
//        System.out.println(joueurs.get(0).getMain());
//        
//        System.out.println("Main Deuxieme Joueur:");
//        System.out.println(joueurs.get(1).getMain());
//        
//        System.out.println("Main Troisieme Joueur:");
//        System.out.println(joueurs.get(2).getMain());
//        
//        System.out.println("Main Quatrieme Joueur:");
//        System.out.println(joueurs.get(3).getMain());      
        
        int currentPlayer= (int) (Math.random()*4);    //Choix du joueur jouant en premier le pli
        List<ArrayList> newMove;
        List<ArrayList> previousMove = new ArrayList();
        boolean finPartie = false;
        while(!finPartie)
        {                
            ArrayList<Integer> pli = new ArrayList(); //Nouveau pli
            pli.add(1);
            pli.add(1);
            pli.add(1);
            pli.add(1);
            MainJoueur currentPlayerCards= new MainJoueur(currentPlayer,joueurs);
            System.out.printf("\nLe joueur numéro %d commence un nouveau pli -> ",currentPlayer);
            newMove = currentPlayerCards.PremierCoup( currentPlayerCards.RecupValeurMain(), joueurs);//Decision et affichage du coup joué du joueur en cours
            System.out.println(newMove);
            pli.add(newMove.size());
            
            for (ArrayList coup1 : newMove) {                              //MAJ de la main du joueur precedent
                joueurs.get(currentPlayer).getMain().remove(coup1);
            }
            if(currentPlayer==3){                                       //Changement de joueur
                currentPlayer=0;
            }
            else{
                currentPlayer+=1;
            }
            previousMove.removeAll(previousMove);
            previousMove.addAll(newMove);   //MAJ du dernier coup joué
            while(true){
                if(joueurs.get(0).getMain().isEmpty()){
                    System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",0);
                    finPartie=true;
                    break;
                }
                if(joueurs.get(1).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",1);
                        finPartie=true;
                        break;
                }
                if(joueurs.get(2).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",2);
                        finPartie=true;
                        break;
                }
                if(joueurs.get(3).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",3);
                        finPartie=true;
                        break;
                }
                if(pli.get(pli.size()-1) == 0 && pli.get(pli.size()-2) == 0 && pli.get(pli.size()-3) == 0 && pli.get(pli.size()-4) == 0 ){ //Tout les joueurs sont bloqués
                    if (currentPlayer==0){
                        currentPlayer=3;
                    }
                    else{
                        currentPlayer=currentPlayer-1;
                    }
                    break;  //On relance un nouveau pli
                } 
               currentPlayerCards = new MainJoueur(currentPlayer,joueurs);          //On recupere la main du joueur en cours
               newMove = currentPlayerCards.CoupSuivant(previousMove, currentPlayerCards.RecupValeurMain(), joueurs);//Decision et affichage du coup joué du joueur en cours
               if(!newMove.isEmpty()){     //si le joueur peut jouer
                   System.out.printf("Tour du joueur numero %d -> ",currentPlayer);
                   System.out.println(newMove);
                   previousMove.removeAll(previousMove);    //On met à jour le coup precedent
                   previousMove.addAll(newMove);
                }
                pli.add(newMove.size());
                for (ArrayList coup1 : newMove) {                              //MAJ de la main du joueur
                    joueurs.get(currentPlayer).getMain().remove(coup1);
                }
                if(currentPlayer==3){                                       //Changement de joueur
                    currentPlayer=0;
                }
                else{
                    currentPlayer+=1;
                }
                
                
            }
        }
    }
}
