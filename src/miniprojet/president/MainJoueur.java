/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;
import java.util.*;
import miniprojet.Humains.*;

/**
 *  Classe contenant une main d'un joueur et les methodes associé au décisions du joueurs possible avec sa main
 * @author ISEN
 */
public class MainJoueur {
    List<ArrayList> main = new ArrayList<>();

    /**
     * Constructeur de la main en cours
     * @param indiceJoueur Indice indiquant quel joueur doit jouer
     * @param joueurs   ArrayList des joueurs
     */
    public MainJoueur(int indiceJoueur, ArrayList<ClientNeutre> joueurs) {
        main = new ArrayList();
        main.addAll(joueurs.get(indiceJoueur).getMain());
    }

    /**
     * Traduction des figures des cartes en reel valeur de 0 à 12
     * @return Un ArrayList contenant des valeurs entre 0 et 12 correspondant à la main du joueur en cours
     */
    public ArrayList RecupValeurMain()
    {
        ArrayList<Integer> listeValeurMain = new ArrayList<>();
        int value;
        Object figure;
        for (ArrayList main1 : this.main) {
            figure=main1.get(0);
            if(figure.equals(FigureCarte.AS)){
                value=11;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.ROI)){
                value=10;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.DAME)){
                value=9;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.VALET)){
                value=8;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.DIX)){
                value=7;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.NEUF)){
                value=6;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.HUIT)){
                value=5;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.SEPT)){
                value=4;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.SIX)){
                value=3;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.CINQ)){
                value=2;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.QUATRE)){
                value=1;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.TROIS)){
                value=0;
                listeValeurMain.add(value);
            }
            if(figure.equals(FigureCarte.DEUX)){
                value=12;
                listeValeurMain.add(value);
            }
        }
  return listeValeurMain;
    }
    
    /**
     * Methode correspondant au premier coup d'une partie
     * @param listeValeurMainJoueur Contient un ArrayList contenant les valeurs en int correspondant aux figures des cartes du joueur
     * @param mainJoueur ArrayListe contenant la main du joueur à cloner
     * @return La décision de jeu du joueur en fonction des regles du jeu
     */
    public List<ArrayList> PremierCoup(ArrayList<Integer> listeValeurMainJoueur,ArrayList mainJoueur){
        List<ArrayList> choixJoueur = new ArrayList();
        int value=13;                                               //Init variable
        for(int i=0;i<listeValeurMainJoueur.size();i++){ 
            if(listeValeurMainJoueur.get(i)<=value){
                value = listeValeurMainJoueur.get(i);               //Recuperation de la valeur de carte la petite parmi la main du joueur
            }
        }
        for(int j=0;j<listeValeurMainJoueur.size();j++){
            if(listeValeurMainJoueur.get(j)==value){
                choixJoueur.add(this.main.get(j));                 //Recuperation de la ou les plus petites carte(s) du joueur
            }   
        }
        return choixJoueur;
    }
    
    /**
     * Methode permettant de prendre la decision d'un coup à jouer en fonction du pli en cours
     * @param valueCardLastChoice Valeur des cartes du dernier choix effecuté sur le pli, correspond à un ArrayList contenant la ou les cartes joués au coup précedent
     * @param listeValeurMainJoueur Contient un ArrayList contenant les valeurs en int correspondant aux figures des cartes du joueur
     * @param mainJoueur ArrayListe contenant la main du joueur à cloner
     * @return La décision de jeu du joueur en fonction des regles du jeu et du coup joué precedemment
     */
    public List<ArrayList> CoupSuivant(List<ArrayList> valueCardLastChoice,ArrayList<Integer> listeValeurMainJoueur,ArrayList mainJoueur){
        List<ArrayList> choixJoueur = new ArrayList();
        int valuePrevious=13;
        Object figure;
        figure=valueCardLastChoice.get(0).get(0);       //recuperation de la valeur reelle de la carte du coup precedent
        if(figure.equals(FigureCarte.AS)){
            valuePrevious=11;
        }
        if(figure.equals(FigureCarte.ROI)){
            valuePrevious=10;
        }
        if(figure.equals(FigureCarte.DAME)){
            valuePrevious=9;
        }
        if(figure.equals(FigureCarte.VALET)){
            valuePrevious=8;
        }
        if(figure.equals(FigureCarte.DIX)){
            valuePrevious=7;
        }
        if(figure.equals(FigureCarte.NEUF)){
            valuePrevious=6;
        }
        if(figure.equals(FigureCarte.HUIT)){
            valuePrevious=5;
        }
        if(figure.equals(FigureCarte.SEPT)){
            valuePrevious=4;
        }
        if(figure.equals(FigureCarte.SIX)){
            valuePrevious=3;
        }
        if(figure.equals(FigureCarte.CINQ)){
            valuePrevious=2;
        }
        if(figure.equals(FigureCarte.QUATRE)){
            valuePrevious=1;
        }
        if(figure.equals(FigureCarte.TROIS)){
            valuePrevious=0;
        }
        if(figure.equals(FigureCarte.DEUX)){
            valuePrevious=12;
        }
        int nbCards = valueCardLastChoice.size();
        int value=13;                                               //Init variable
        if(nbCards==2){                 //Le joueur doit jouer deux cartes ou ne pas jouer
            int indice1=13;
            int indice2=13;
            for(int i=0;i<listeValeurMainJoueur.size();i++){
                if(listeValeurMainJoueur.get(i)<=value && listeValeurMainJoueur.get(i)>=valuePrevious){
                    for(int j=i+1;j<listeValeurMainJoueur.size();j++){
                        if(listeValeurMainJoueur.get(i) == listeValeurMainJoueur.get(j)){  //Si il a une deuxieme carte de meme valeur
                            value = listeValeurMainJoueur.get(i);
                            indice2=j;
                            indice1=i;
                        }
                    }
                }
            }
            if(indice1!=13 && indice2!=13){
                choixJoueur.add(this.main.get(indice1));
                choixJoueur.add(this.main.get(indice2));
            }
            return choixJoueur;
        }
        else{                 //Le joueur doit jouer une carte ou ne pas jouer
            int indiceCarte=13;
            for(int i=0;i<listeValeurMainJoueur.size();i++){ 
                if(listeValeurMainJoueur.get(i)<=value && listeValeurMainJoueur.get(i)>=valuePrevious ){
                    value = listeValeurMainJoueur.get(i);              //Recuperation de la valeur de carte la petite parmi la main du joueur
                    indiceCarte=i;
                }
            }
            if(indiceCarte!=13){                                              //Si il peut jouer une carte
                choixJoueur.add(this.main.get(indiceCarte));
            }
            return choixJoueur;
        }
    }
    
    /**
     * Methode permettant de selectionner les différentes options du joueur en fonction du jeu en cours
     * @param valueCardLastChoice Valeur des cartes du dernier choix effecuté sur le pli, correspond à un ArrayList contenant la ou les cartes joués au coup précedent
     * @param listeValeurMainJoueur Contient un ArrayList contenant les valeurs en int correspondant aux figures des cartes du joueur
     * @param mainJoueur ArrayListe contenant la main du joueur
     * @return Une liste contenant les different choix possible
     */
    public List<ArrayList> CoupUtilisateurPossible(List<ArrayList> valueCardLastChoice,ArrayList<Integer> listeValeurMainJoueur,ArrayList mainJoueur){
        List<ArrayList> choixPossibles = new ArrayList<>();
        int valuePrevious=13;
        Object figure;
        figure=valueCardLastChoice.get(0).get(0);       //recuperation de la valeur reelle de la carte du coup precedent
        if(figure.equals(FigureCarte.AS)){
            valuePrevious=11;
        }
        if(figure.equals(FigureCarte.ROI)){
            valuePrevious=10;
        }
        if(figure.equals(FigureCarte.DAME)){
            valuePrevious=9;
        }
        if(figure.equals(FigureCarte.VALET)){
            valuePrevious=8;
        }
        if(figure.equals(FigureCarte.DIX)){
            valuePrevious=7;
        }
        if(figure.equals(FigureCarte.NEUF)){
            valuePrevious=6;
        }
        if(figure.equals(FigureCarte.HUIT)){
            valuePrevious=5;
        }
        if(figure.equals(FigureCarte.SEPT)){
            valuePrevious=4;
        }
        if(figure.equals(FigureCarte.SIX)){
            valuePrevious=3;
        }
        if(figure.equals(FigureCarte.CINQ)){
            valuePrevious=2;
        }
        if(figure.equals(FigureCarte.QUATRE)){
            valuePrevious=1;
        }
        if(figure.equals(FigureCarte.TROIS)){
            valuePrevious=0;
        }
        if(figure.equals(FigureCarte.DEUX)){
            valuePrevious=12;
        }
        int nbCards = valueCardLastChoice.size();
        if(nbCards==2){     //Le joueur peut soit jouer deux cartes, soit ne pas jouer
            for(int i=0;i<listeValeurMainJoueur.size();i++){
                if(listeValeurMainJoueur.get(i)>=valuePrevious){
                    for(int j =i+1; j<listeValeurMainJoueur.size();j++){
                        if(listeValeurMainJoueur.get(i)==listeValeurMainJoueur.get(j)){     //On recupere tout les doubles possibles
                            choixPossibles.add(this.main.get(i));
                            choixPossibles.add(this.main.get(j));
                        }
                    }  
                }
            }
            ArrayList choixVide = new ArrayList();      //Choix de ne pas jouer le coup
            choixPossibles.add(choixVide);
        }
        else{               //Le joueur peut jouer une carte ou ne pas jouer
            for(int i=0;i<listeValeurMainJoueur.size();i++){
                if(listeValeurMainJoueur.get(i)>=valuePrevious){
                    choixPossibles.add(this.main.get(i));
                }
            }
            ArrayList choixVide = new ArrayList();      //Choix de ne pas jouer le coup
            choixPossibles.add(choixVide);
        }
        return choixPossibles;
    }
    
    /**
     * Methode permettant de recuperer le choix de l'utilisateur et de retourner les cartes correspondantes
     * @param nbCarte Nombre de carte joués au coup précedent
     * @param choix Indice correspondant au choix de l'utilisateur parmi les coups possibles
     * @param choixPossibles Liste des diférentes options de coup
     * @return La liste des cartes jouées par l'utilisateur
     */
    public List<ArrayList> DecisionJoueur(int nbCarte, int choix, List<ArrayList> choixPossibles){
        List<ArrayList> decisionJoueur = new ArrayList<>();
        switch (nbCarte) {
            case 1:
                decisionJoueur.add(choixPossibles.get(choix));
                break;
            case 2:
                decisionJoueur.add(choixPossibles.get(choix));
                decisionJoueur.add(choixPossibles.get(choix+1));
                break;
            case 3:
                decisionJoueur.add(choixPossibles.get(choix));
                decisionJoueur.add(choixPossibles.get(choix+1));
                decisionJoueur.add(choixPossibles.get(choix+2));
                break;
            default:
                decisionJoueur.add(choixPossibles.get(choix));
                decisionJoueur.add(choixPossibles.get(choix+1));
                decisionJoueur.add(choixPossibles.get(choix+2));
                decisionJoueur.add(choixPossibles.get(choix+3));
                break;
        }
        if(choixPossibles.size()==choix){       //si le joueur ne veut pas jouer
            decisionJoueur.removeAll(decisionJoueur);
        }
        return decisionJoueur;
    }
    
    /**
     * 
     * @param listeValeurMainJoueur
     * @param mainJoueur
     * @param nbCartes
     * @return 
     */
    public List<ArrayList> ListesChoixJoueurPremierCoup(ArrayList<Integer> listeValeurMainJoueur,ArrayList mainJoueur,int nbCartes){
        List<ArrayList> choixPossibles = new ArrayList<>();
        switch (nbCartes) {
            case 4:
                for(int i=0;i<listeValeurMainJoueur.size();i++){
                    for(int j=i+1;j<listeValeurMainJoueur.size();j++){
                        if(listeValeurMainJoueur.get(i) ==listeValeurMainJoueur.get(j)){
                            for(int k = j+1;k<listeValeurMainJoueur.size();k++){
                                if(listeValeurMainJoueur.get(i) ==listeValeurMainJoueur.get(k)){
                                    for(int w = k+1;w<listeValeurMainJoueur.size();w++){
                                        if(listeValeurMainJoueur.get(i) ==listeValeurMainJoueur.get(w)){    //on recupere les quadruplets
                                            choixPossibles.add(this.main.get(i));
                                            choixPossibles.add(this.main.get(j));
                                            choixPossibles.add(this.main.get(k));
                                            choixPossibles.add(this.main.get(w));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }   break;
            case 3:
                for(int i=0;i<listeValeurMainJoueur.size();i++){
                    for(int j=i+1;j<listeValeurMainJoueur.size();j++){
                        if(listeValeurMainJoueur.get(i) ==listeValeurMainJoueur.get(j)){
                            for(int k = j+1;k<listeValeurMainJoueur.size();k++){
                                if(listeValeurMainJoueur.get(i) ==listeValeurMainJoueur.get(k)){    //on recupere les triplets
                                    choixPossibles.add(this.main.get(i));
                                    choixPossibles.add(this.main.get(j));
                                    choixPossibles.add(this.main.get(k));
                                }
                            }
                        }
                    }
                }   break;
            case 2:
                for(int i=0;i<listeValeurMainJoueur.size();i++){
                    for(int j=i+1;j<listeValeurMainJoueur.size();j++){
                        if(listeValeurMainJoueur.get(i) ==listeValeurMainJoueur.get(j)){    //on recupere les doublets
                            choixPossibles.add(this.main.get(i));
                            choixPossibles.add(this.main.get(j));
                        }
                    }
                }   break;
            default:
                choixPossibles.addAll(mainJoueur);                                          //On recupere la main en entier
                break;
        }
        return choixPossibles;
    }

}
