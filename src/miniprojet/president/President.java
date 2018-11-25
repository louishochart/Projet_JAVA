/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;

import java.util.*;
import miniprojet.Bar.Bar;
import miniprojet.Bar.Table;
import miniprojet.Humains.ClientNeutre;

/**
 * Classe correspondant a l'application des differentes regles du president
 * @author ISEN
 */
public class President {
    private ArrayList<ClientNeutre> joueurs;
    private Table table;
    private ClientNeutre vainqueur;
    private int indiceTable;

    /**
     * Constructeur de la classe president qui prends en charge la gestion d'une partie
     * @param table indice de la table
     */
    public President(Table table) {
        this.table = table;
        for(int i = 0 ; i < Bar.getInstance().getSimulation().getTables().size() ; i++){
            if(this.table.equals(Bar.getInstance().getSimulation().getTables().get(i))){
                this.setIndiceTable(i);
            }
        }
        
    }
       
    public void jeu(){
        Paquet newpaquet = new Paquet();
        
        this.joueurs = table.getClients();
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
                    this.setVainqueur(joueurs.get(0));
                    finPartie=true;
                    break;
                }
                if(joueurs.get(1).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",1);
                        this.setVainqueur(joueurs.get(1));
                        finPartie=true;
                        break;
                }
                if(joueurs.get(2).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",2);
                        this.setVainqueur(joueurs.get(2));
                        finPartie=true;
                        break;
                }
                if(joueurs.get(3).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",3);
                        this.setVainqueur(joueurs.get(3));
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

    public ArrayList<ClientNeutre> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(ArrayList<ClientNeutre> joueurs) {
        this.joueurs = joueurs;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public ClientNeutre getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(ClientNeutre vainqueur) {
        this.vainqueur = vainqueur;
    }

    public int getIndiceTable() {
        return indiceTable;
    }

    public void setIndiceTable(int indiceTable) {
        this.indiceTable = indiceTable;
    }
    
    /**
     * Simule une partie contre utilisateur (joueur numero 3)
     */
    public void JeuVsPlayer(){
        this.joueurs = table.getClients();
        Paquet newpaquet = new Paquet();
        newpaquet.bat();
        newpaquet.coupe((int) (Math.random() * 51));    //Coupage du paquet       
        newpaquet.distribue(joueurs, 1);
        System.out.println("Votre main:");
        System.out.println(joueurs.get(3).getMain());

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
            if(currentPlayer==3){   //Utilisateur qui commence le pli
                System.out.println("Vous commencez...");
                System.out.println("Votre main : \n");
                System.out.println(joueurs.get(3).getMain());
                Scanner sc = new Scanner(System.in);//APPEL FONCTION LOUIS :: retourne un chiffre correspondant au nombre de carte voulant etre joué
                System.out.println("Combien de cartes ?");
                int nbCartesWanted = sc.nextInt();
                List<ArrayList> choixpossibles = currentPlayerCards.ListesChoixJoueurPremierCoup(currentPlayerCards.RecupValeurMain(), joueurs, nbCartesWanted);
                System.out.println(choixpossibles);
                System.out.println("Choix ? Donnez l'indice de votre choix à partir de 0");
                boolean check = false;
                int str=0;
                while (!check) {
                    try {
                        str = sc.nextInt();
                        check=true;
                    } 
                    catch (InputMismatchException e) {
                        System.out.println("Ecrire un entier");
                    }
                }
                int choix = sc.nextInt();
                newMove=currentPlayerCards.DecisionJoueur(nbCartesWanted, choix, choixpossibles);
                System.out.println("Vous avez joué : ");
                System.out.println(newMove);
            }
            else{
                System.out.printf("\nLe joueur numéro %d commence un nouveau pli -> ",currentPlayer);
                newMove = currentPlayerCards.PremierCoup( currentPlayerCards.RecupValeurMain(), joueurs);//Decision et affichage du coup joué du joueur en cours
                System.out.println(newMove);
            }
 
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
                    this.setVainqueur(joueurs.get(0));
                    finPartie=true;
                    break;
                }
                if(joueurs.get(1).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",1);
                        this.setVainqueur(joueurs.get(1));
                        finPartie=true;
                        break;
                }
                if(joueurs.get(2).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",2);
                        this.setVainqueur(joueurs.get(2));
                        finPartie=true;
                        break;
                }
                if(joueurs.get(3).getMain().isEmpty()){
                        System.out.printf("\nVAINQUEUR DE LA PARTIE : Joueur numero %d\n",3);
                        this.setVainqueur(joueurs.get(3));
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
                
                if(currentPlayer==3){           //Tour de l'utilisateur ???
                    List<ArrayList> choixPossibles = currentPlayerCards.CoupUtilisateurPossible(previousMove, currentPlayerCards.RecupValeurMain(),joueurs);
                    int nbCartes = previousMove.size();
                    if(choixPossibles.get(0).isEmpty()){
                        System.out.println("Vous ne pouvez pas jouer...");
                    }
                    else{
                        System.out.println("Vos possibilités :");
                        System.out.println(choixPossibles);
                        Scanner sc = new Scanner(System.in);//APPEL FONCTION LOUIS :: (nbCartes,choixPossibles)
                        System.out.println("Votre décision ? : Donnez l'indice de votre choix à partir de 0");
                        boolean check = false;
                        int str=0;
                        while(!check){
                            try{
                                str = sc.nextInt();
                                check=true;
                            }
                            catch(InputMismatchException e){
                                System.out.println("Ecrire un entier");
                            }                        
                        }
                        
                        newMove = currentPlayerCards.DecisionJoueur(nbCartes, str, choixPossibles);   //Decision prise
                        
                        if(!newMove.get(0).isEmpty()){     //si le joueur décide de jouer
                            System.out.println("Vous avez joué : ");
                            System.out.println(newMove);
                            previousMove.removeAll(previousMove);    //On met à jour le coup precedent
                            previousMove.addAll(newMove);
                        }
                    }  
                }
                else{
                    newMove = currentPlayerCards.CoupSuivant(previousMove, currentPlayerCards.RecupValeurMain(), joueurs);//Decision et affichage du coup joué du joueur en cours
                    if(!newMove.isEmpty()){     //si le joueur peut jouer
                        System.out.printf("Tour du joueur numero %d -> ",currentPlayer);
                        System.out.println(newMove);
                        previousMove.removeAll(previousMove);    //On met à jour le coup precedent
                        previousMove.addAll(newMove);
                    }
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
