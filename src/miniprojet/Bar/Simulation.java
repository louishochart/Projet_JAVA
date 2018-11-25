/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniprojet.Bar.*;
import miniprojet.Humains.*;
import miniprojet.Fonctions.*;

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
            System.out.println("la patronne est dans le bar");
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
        for (int i = 0; i < Bar.getInstance().getSimulation().getClients().size(); i++) {
            double random = Math.random();
            random = (Math.round(random * 100.0) / 100.0);
            if(Bar.getInstance().getSimulation().getClients().get(i).getClass().getSimpleName().equals("Client") || Bar.getInstance().getSimulation().getClients().get(i).getClass().getSimpleName().equals("Cliente")){
                if (Bar.getInstance().getSimulation().getClients().get(i).getTable().getServeur() instanceof Serveur) {
                    Serveur serveur = (Serveur) Bar.getInstance().getSimulation().getClients().get(i).getTable().getServeur();
                    if (random > 0.4) {
                        random = Math.random();
                        random = (Math.round(random * 100.0) / 100.0);
                        if (random > 0.5 * (1-(serveur.getTailleBiceps() / 10))) {
                            random = Math.random();
                            random = (Math.round(random * 100.0) / 100.0);
                            if (random < 0.5) {
                                Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                            } else {
                                Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                            }
                        } else {
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
                        if (random > 0.5 * (serveuse.getCoeffCharme()/ 10)) {
                            random = Math.random();
                            random = (Math.round(random * 100.0) / 100.0);
                            if (random < 0.5) {
                                Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
                            } else {
                                Bar.getInstance().getSimulation().getClients().get(i).commander(Bar.getInstance().getSimulation().getClients().get(i).getBoissonFav2());
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
                        else {
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
            this.incrementNbHeures();
        }
    }
    

    public void incrementNbHeures() {
        this.nbHeures++;
    }

    public void reinitialiser() {
        Bar.getInstance().setSimulation(new Simulation());
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

    public void setClients(List<ClientNeutre> clients) {
        this.clients = clients;
    }

    public void setServeurs(List<ServeurNeutre> serveurs) {
        this.serveurs = serveurs;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

}
