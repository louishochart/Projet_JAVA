/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import miniprojet.Tournoi.Tournoi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniprojet.Bar.*;
import miniprojet.Humains.*;
import miniprojet.Fonctions.*;
import miniprojet.president.President;


/**
 *
 * @author Louis
 */
public class Simulation {

    private List<ClientNeutre> clients = new ArrayList();
    private List<ServeurNeutre> serveurs = new ArrayList();
    private List<Table> tables = new ArrayList();
    private ClientNeutre joueur;
    private int nbHeures = 0;
    private List<ClientNeutre> tournees = new ArrayList();
    private List<ClientNeutre> exclus = new ArrayList();
    private int verresOfferts = 0 ;
    private int verresBus = 0 ;
    private List<ClientNeutre> tourneesh = new ArrayList();
    private List<ClientNeutre> exclush = new ArrayList();
    private int verresOffertsh = 0 ;
    private int verresBush = 0 ;
    private President partie;
    private Tournoi tournoi = new Tournoi();

    public Simulation() {
        
    }

    public void affecterClients() {
        int nbClientsAleatoire = (int) (Bar.getInstance().getClientsDispos().size() * (0.5)) + (int) (Math.random() * ((Bar.getInstance().getClientsDispos().size() - Bar.getInstance().getClientsDispos().size() * (0.5) + 1)));
        for (int i = 0; i < nbClientsAleatoire; i++) {
            int numeroTable = (int) (Math.random() * (Bar.getInstance().getFreeTables().size()));
            Bar.getInstance().getClientsDispos().get(i).setTable(Bar.getInstance().getFreeTables().get(numeroTable));
            Bar.getInstance().getFreeTables().get(numeroTable).addClient(Bar.getInstance().getClientsDispos().get(i));
            Bar.getInstance().getSimulation().getClients().add(Bar.getInstance().getClientsDispos().get(i));
        }
        double random = Math.random();
        random = (Math.round(random * 100.0) / 100.0);
        if(random<0.25){
            int numeroTable = (int) (Math.random() * (Bar.getInstance().getFreeTables().size()));
            Bar.getInstance().getPatronne().setTable(Bar.getInstance().getFreeTables().get(numeroTable));
            Bar.getInstance().getFreeTables().get(numeroTable).addClient(Bar.getInstance().getPatronne());
            Bar.getInstance().getSimulation().getClients().add(Bar.getInstance().getPatronne());
        }
        for (int i = 0; i < Bar.getInstance().getTables().size(); i++) {
            if (Bar.getInstance().getTables().get(i).getClients().size() > 0) {
                this.getTables().add(Bar.getInstance().getTables().get(i));
                
            }
        }
    }

    public void affecterServeurs() {
        int nbServeurs = (int) (Bar.getInstance().getServeurs().size() * (0.6)) + (int) (Math.random() * ((Bar.getInstance().getServeurs().size() + 1 - Bar.getInstance().getServeurs().size() * (0.6))));
        for (int i = 0; i < nbServeurs; i++) {
            this.getServeurs().add(Bar.getInstance().getServeurs().get(i));
        }
        int indice = 0;
        for (int i = 0; i < this.getTables().size(); i++) {
            this.getTables().get(i).setServeur(this.getServeurs().get(indice));
            this.getServeurs().get(indice).getTables().add(this.getTables().get(i));
            indice++;
            if (indice == nbServeurs) {
                indice = 0;
            }
        }
    }

    public void simulerHeure() {
        this.initialiserHeure();
        for (int i = 0; i < Bar.getInstance().getSimulation().getClients().size(); i++) {
            double random = Math.random();
            random = (Math.round(random * 100.0) / 100.0);
            if(Bar.getInstance().getSimulation().getClients().get(i).getClass().getSimpleName().equals("Client") || Bar.getInstance().getSimulation().getClients().get(i).getClass().getSimpleName().equals("Cliente")){
                if (Bar.getInstance().getSimulation().getClients().get(i).getTable().getServeur() instanceof Serveur) {
                    Serveur serveur = (Serveur) Bar.getInstance().getSimulation().getClients().get(i).getTable().getServeur();
                    if (random > 0.4) {
                        random = Math.random();
                        random = (Math.round(random * 100.0) / 100.0);
                        if (random > 0.5 * (serveur.getTailleBiceps() / 10)) {
                            random = Math.random();
                            random = (Math.round(random * 100.0) / 100.0);
                            if (random <0.3*Bar.getInstance().getSimulation().getClients().get(i).getPopularite()/100) {
                                random = Math.random();
                                random = (Math.round(random * 100.0) / 100.0);
                                if (random < 0.5) {
                                    Bar.getInstance().getBarman().offrirVerre(Bar.getInstance().getSimulation().getClients().get(i), Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                                } else {
                                    Bar.getInstance().getBarman().offrirVerre(Bar.getInstance().getSimulation().getClients().get(i), Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav1());
                                }
                            }
                            else{
                                random = Math.random();
                                random = (Math.round(random * 100.0) / 100.0);
                                if (random < 0.5) {
                                    Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                                } 
                                else {
                                    Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                                }
                            }
                            
                        } 
                        else {
                            random = Math.random();
                            random = (Math.round(random * 100.0) / 100.0);
                            if (random < 0.25) {
                                Bar.getInstance().getSimulation().getClients().get(i).offrirTournee(new Random().getRandomBoisson());
                            } else {
                                random = Math.random() * Bar.getInstance().getSimulation().getClients().size();
                                int indiceClient = (int) random;
                                random = Math.random();
                                random = (Math.round(random * 100.0) / 100.0);
                                if (random < 0.5) {
                                    Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(Bar.getInstance().getSimulation().getClients().get(indiceClient), Bar.getInstance().getSimulation().getClients().get(indiceClient).getBoissonFav2());
                                } else {
                                    Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(Bar.getInstance().getSimulation().getClients().get(indiceClient), Bar.getInstance().getSimulation().getClients().get(indiceClient).getBoissonFav1());
                                }

                            }
                        }
                    }
                } 
                else if (Bar.getInstance().getClients().get(i).getTable().getServeur() instanceof Serveuse) {
                    Serveuse serveuse = (Serveuse) Bar.getInstance().getClients().get(i).getTable().getServeur();
                    if (random > 0.4) {
                        random = Math.random();
                        random = (Math.round(random * 100.0) / 100.0);
                        if (random > 0.5 * (1-(serveuse.getCoeffCharme()/ 10))) {
                            random = Math.random();
                            random = (Math.round(random * 100.0) / 100.0);
                            if (random <0.3*Bar.getInstance().getSimulation().getClients().get(i).getPopularite()/100) {
                                random = Math.random();
                                random = (Math.round(random * 100.0) / 100.0);
                                if (random < 0.5) {
                                    Bar.getInstance().getBarman().offrirVerre(Bar.getInstance().getSimulation().getClients().get(i), Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                                } else {
                                    Bar.getInstance().getBarman().offrirVerre(Bar.getInstance().getSimulation().getClients().get(i), Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav1());
                                }
                            }
                            else{
                                random = Math.random();
                                random = (Math.round(random * 100.0) / 100.0);
                                if (random < 0.5) {
                                    Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                                } 
                                else {
                                    Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                                }
                            }
                            
                        } 
                        else {
                            random = Math.random();
                            random = (Math.round(random * 100.0) / 100.0);
                            if (random < 0.25) {
                                Bar.getInstance().getSimulation().getClients().get(i).offrirTournee(new Random().getRandomBoisson());
                            } else {
                                random = Math.random();
                                random = (Math.round(random * 100.0) / 100.0);
                                if(random>0.5*(1-serveuse.getCoeffCharme())){
                                    random = Math.random() * Bar.getInstance().getSimulation().getClients().size();
                                    int indiceClient = (int) random;
                                    random = Math.random();
                                    random = (Math.round(random * 100.0) / 100.0);
                                    if (random < 0.5) {
                                        Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(Bar.getInstance().getSimulation().getClients().get(indiceClient), Bar.getInstance().getSimulation().getClients().get(indiceClient).getBoissonFav2());
                                    } else {
                                        Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(Bar.getInstance().getSimulation().getClients().get(indiceClient), Bar.getInstance().getSimulation().getClients().get(indiceClient).getBoissonFav1());
                                    }
                                }
                                else{
                                    Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(serveuse,serveuse.getBoisson());
                                }

                            }
                        }
                    }
                }
            }
            else if (Bar.getInstance().getSimulation().getClients().get(i).getClass().getSimpleName().equals("Patronne")){
                random = Math.random();
                random = (Math.round(random * 100.0) / 100.0);
                if (random > 0.7) {
                    random = Math.random();
                    random = (Math.round(random * 100.0) / 100.0);
                    if(random<0.5){
                        random = Math.random();
                        random = (Math.round(random * 100.0) / 100.0);
                        if (random < 0.5) {
                            Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                        } 
                        else 
                        {
                            Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                        }
                    }
                    else {
                        random = Math.random() * Bar.getInstance().getSimulation().getClients().size();
                        int indiceClient = (int) random;
                        random = Math.random();
                        random = (Math.round(random * 100.0) / 100.0);
                        if (random < 0.5) {
                            Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(Bar.getInstance().getSimulation().getClients().get(indiceClient), Bar.getInstance().getSimulation().getClients().get(indiceClient).getBoissonFav2());
                        } 
                        else {
                            Bar.getInstance().getSimulation().getClients().get(i).offrirVerre(Bar.getInstance().getSimulation().getClients().get(indiceClient), Bar.getInstance().getSimulation().getClients().get(indiceClient).getBoissonFav1());
                        }
                    }
                } 
            }            
        }
        Bar.getInstance().getPatronne().verifierCaisse();
        this.incrementNbHeures();
    }
    
    
    public void echangerPlace(ClientNeutre c1, ClientNeutre c2){
        Table temp = c1.getTable();
        
        for(int i = 0 ; i < Bar.getInstance().getSimulation().getTables().size();i++){
            for(int j = 0 ; j < Bar.getInstance().getSimulation().getTables().get(i).getClients().size();j++){
                if(c1.equals(Bar.getInstance().getSimulation().getTables().get(i).getClients().get(j))){
                    Bar.getInstance().getSimulation().getTables().get(i).getClients().set(j, c2);
                }
                else if(c2.equals(Bar.getInstance().getSimulation().getTables().get(i).getClients().get(j))){
                    Bar.getInstance().getSimulation().getTables().get(i).getClients().set(j, c1);
                }
            }
        }
        
        c1.setTable(c2.getTable());
        c2.setTable(temp);
        
        
    }
    
    public void initialiserHeure(){
        this.tourneesh = new ArrayList();
        this.exclush = new ArrayList();
        this.verresOffertsh = 0 ;
        this.verresBush = 0 ;
    }
    
    public void incrementNbHeures() {
        this.nbHeures++;
    }
    public void incrementVerresOfferts() {
        this.verresOfferts++;
        this.verresOffertsh++;
    }

    public void incrementVerresBus() {
        this.verresBus ++;
        this.verresBush ++;
    }

    public void reinitialiser() {
        Bar.getInstance().setSimulation(new Simulation());
        for(int i = 0 ; i < Bar.getInstance().getTables().size() ; i++ ){
            for(int j = 0 ; j < Bar.getInstance().getTables().get(i).getClients().size() ; j++){
                Bar.getInstance().getTables().get(i).getClients().remove(Bar.getInstance().getTables().get(i).getClients().get(j));
            }
        }
        for(int i = 0 ; i < Bar.getInstance().getClients().size();i++){
            Bar.getInstance().getClients().get(i).setExclu(false);
        }
        this.setTournoi(new Tournoi());
    }
    
    public ArrayList<Table> getFullTables() {
        ArrayList<Table> fullTables = new ArrayList<Table>();
        for (int i = 0; i < this.getTables().size(); i++) {
            if (this.getTables().get(i).isFull()) {
                fullTables.add(this.getTables().get(i));
            }
        }
        return (fullTables);
    }

    public List<ClientNeutre> getClients() {
        return clients;
    }

    public List<ServeurNeutre> getServeurs() {
        return serveurs;
    }

    public List<Table> getTables() {
        return tables;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public ClientNeutre getJoueur() {
        return joueur;
    }

    public List<ClientNeutre> getTournees() {
        return tournees;
    }

    public List<ClientNeutre> getExclus() {
        return exclus;
    }

    public List<ClientNeutre> getTourneesh() {
        return tourneesh;
    }

    public List<ClientNeutre> getExclush() {
        return exclush;
    }

    public int getVerresOfferts() {
        return verresOfferts;
    }

    public int getVerresBus() {
        return verresBus;
    }

    public int getVerresOffertsh() {
        return verresOffertsh;
    }

    public int getVerresBush() {
        return verresBush;
    }
    

    public void setClients(List<ClientNeutre> clients) {
        this.clients = clients;
    }

    public void setServeurs(List<ServeurNeutre> serveurs) {
        this.serveurs = serveurs;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public void setJoueur(ClientNeutre joueur) {
        this.joueur = joueur;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    public void setTournees(List<ClientNeutre> tournees) {
        this.tournees = tournees;
    }

    public void setExclus(List<ClientNeutre> exclus) {
        this.exclus = exclus;
    }

    public void setVerresOfferts(int verresOfferts) {
        this.verresOfferts = verresOfferts;
    }

    public void setVerresBus(int verresBus) {
        this.verresBus = verresBus;
    }

    public President getPartie() {
        return partie;
    }

    public void setPartie(President partie) {
        this.partie = partie;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }
    
    
    
}
