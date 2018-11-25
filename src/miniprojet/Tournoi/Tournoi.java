
package miniprojet.Tournoi;

import java.util.ArrayList;
import miniprojet.Bar.*;
import miniprojet.Humains.*;
import miniprojet.president.President;

/**
 * L'objet Tournoi, permettant de simuler un tournoi
 */
public class Tournoi {
    private ArrayList<Table> tables = new ArrayList();
    private ArrayList<ClientNeutre> clients = new ArrayList();
    private int recompense;
    private boolean cree=false;
    private int nbTours = 0;
    private int tour = 0 ;
    private ArrayList<ArrayList<President>> tournoi = new ArrayList();
    private ArrayList<ClientNeutre> vainqueurs = new ArrayList();
    private boolean joueur=false;
    
    
    public Tournoi() {
        
    }
    
    /**
     * Annonce du tournoi, affectation des joueurs et préparation des matchs
     */
    public void creation(){
        Bar.getInstance().getPatronne().parler("Il y a un tournoi en vue, le prix d'entrée est de 2 €, inscrivez vous sur l'affiche");
        this.affecterTournoi();
        this.preparerMatchs();
    }    
    /**
     * Choisit un nombre de clients parmis ceux présents dans la simulation de la soirée
     * Les place sur les tables réservées au tournoi
     * Vérifie que le nombre de joueur est une puissance de 4 
     */
    private void affecterTournoi(){
               
        for(int i = 0 ; i < Bar.getInstance().getSimulation().getClients().size();i++){
            double random = Math.random();
            random = (Math.round(random * 100.0) / 100.0);
            if (random > 0.25) {
                Bar.getInstance().getSimulation().getClients().get(i).parlerDestinataire(Bar.getInstance().getPatronne(), "Je m'inscris ! ");
                Bar.getInstance().getSimulation().getClients().get(i).payer(Bar.getInstance().getPatronne(), 2);
                this.recompense += 2;
                this.getClients().add(Bar.getInstance().getSimulation().getClients().get(i));
            }
        }
        int nbTables = this.getClients().size()/4;
        if(nbTables<16){
            if(nbTables < 4){
                nbTables = 1 ;
                this.nbTours=1;
            }
            else{
                nbTables=4;
                this.nbTours=2;
            }
        }
        else{
            nbTables=16;
            this.nbTours=3;
        }
        int nbJoueurs = nbTables*4; 
        while(this.getClients().size()>nbJoueurs){
            Bar.getInstance().getPatronne().parlerDestinataire(this.getClients().get(this.getClients().size()-1), "Désolée, il n'y a plus de place dans le tournoi. Reessayez demain ! ");
            Bar.getInstance().getPatronne().payer(this.getClients().get(this.getClients().size()-1), 2);
            this.recompense -= 2;
            this.getClients().remove(this.getClients().size()-1);
        }
        for (int i = 0; i < nbTables; i++) {
            this.getTables().add(new Table());
        }
        for (int i = 0; i < this.getTables().size(); i++) {
            for (int j = 0; j < 4; j++) {
                this.getTables().get(i).addClient(this.getClients().get((i*4)+j));
            }
        }

        this.setCree(true);        
    }
    /**
     * Ajoute les matchs à venir dans la liste des matchs du tournoi
     */
    private void preparerMatchs(){
        if(this.getNbTours()==3){
            ArrayList<President> tour1 = new ArrayList();
            for(int i=0;i<16;i++){
                tour1.add(new President(this.getTables().get(i)));
            }
            tournoi.add(tour1);
            
            ArrayList<President> tour2 = new ArrayList();
            for(int i=0;i<4;i++){
                tour2.add(new President(this.getTables().get(i)));
            }
            tournoi.add(tour2);
            
            ArrayList<President> tour3 = new ArrayList();
            tour3.add(new President(this.getTables().get(0)));
            tournoi.add(tour3);
        }
        else if(this.getNbTours()==2){
            ArrayList<President> tour1 = new ArrayList();
            for(int i=0;i<4;i++){
                tour1.add(new President(this.getTables().get(i)));
            }
            tournoi.add(tour1);
            
            ArrayList<President> tour2 = new ArrayList();
            tour2.add(new President(this.getTables().get(0)));
            tournoi.add(tour2);
        }
        else if(this.getNbTours()==1){
            ArrayList<President> tour1 = new ArrayList();
            tour1.add(new President(this.getTables().get(0)));
            tournoi.add(tour1);
        }
    }
    /**
     * Permet de jouer un tour du tournoi 
     * Si l'utilisateur a choisi de participer, il joue le premier match de chaque tour
     */
    public void jouerTour(){
        if(this.isJoueur()) {
            this.tournoi.get(this.getTour()).get(0).JeuVsPlayer();
            for (int i = 1; i < this.tournoi.get(this.getTour()).size(); i++) {
                this.tournoi.get(this.getTour()).get(i).jeu();
                vainqueurs.add(this.tournoi.get(this.getTour()).get(i).getVainqueur());
            }
        }
        else{
            for(int i = 0 ; i < this.tournoi.get(this.getTour()).size();i++){
                this.tournoi.get(this.getTour()).get(i).jeu();
                vainqueurs.add(this.tournoi.get(this.getTour()).get(i).getVainqueur());
            }
        }
    }
    /**
     * Permet de passer au tour suivant
     */
    public void tourSuivant(){
        int nbTables = vainqueurs.size()/4;
        for(int i = 0 ; i < nbTables ; i ++ ) {
            this.getTables().set(i, new Table());
            for(int j = 0 ; j < 4 ; j++){
                this.getTables().get(i).addClient(vainqueurs.get(j+i));
            }
        }      
        while(nbTables<this.getTables().size()){
            this.getTables().remove(this.getTables().size()-1);
        }
        this.setVainqueurs(new ArrayList());
        this.incrementTour();
    }
    
    public void incrementTour(){
        this.tour++;
    }
    
    /**
     * Le vainqueur reçoit sa récompense
     */
    public void finaliser(){
        Bar.getInstance().getPatronne().payer(Bar.getInstance().getSimulation().getTournoi().getTournoi().get(Bar.getInstance().getSimulation().getTournoi().getTour()).get(0).getVainqueur(), recompense/2);
    }
    
    
    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public ArrayList<ClientNeutre> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ClientNeutre> clients) {
        this.clients = clients;
    }

    public int getRecompense() {
        return recompense;
    }

    public boolean isCree() {
        return cree;
    }

    public void setCree(boolean cree) {
        this.cree = cree;
    }
    
    public void changerTable(ClientNeutre client,Table nvTable){
        Table temp = client.getTable();
        client.setTable(nvTable);
        temp.getClients().remove(client);
        nvTable.addClient(client);
    }

    public int getNbTours() {
        return nbTours;
    }

    public void setNbTours(int nbTours) {
        this.nbTours = nbTours;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public ArrayList<ArrayList<President>> getTournoi() {
        return tournoi;
    }

    public ArrayList<ClientNeutre> getVainqueurs() {
        return vainqueurs;
    }

    public void setVainqueurs(ArrayList<ClientNeutre> vainqueurs) {
        this.vainqueurs = vainqueurs;
    }

    public void setJoueur(boolean joueur) {
        this.joueur = joueur;
    }

    public boolean isJoueur() {
        return joueur;
    }
    


    
    
    
    
    
}
