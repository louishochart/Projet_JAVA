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
        for (int i = 0; i < Bar.getInstance().getTables().size(); i++) {
            if (Bar.getInstance().getTables().get(i).getClients().size() > 0) {
                this.getTables().add(Bar.getInstance().getTables().get(i));
            }
        }
    }

    public void affecterServeurs() {
        int nbServeurs = (int) (Bar.getInstance().getServeurs().size() * (0.6)) + (int) (Math.random() * ((Bar.getInstance().getServeurs().size()+1 - Bar.getInstance().getServeurs().size() * (0.6))));
        for(int i = 0 ; i < nbServeurs ; i++){
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
        
        if(Bar.getInstance().getClients().get(0).getTable().getServeur() instanceof Serveur){
            Serveur s = (Serveur) Bar.getInstance().getClients().get(0).getTable().getServeur();
        }
        this.incrementNbHeures();
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
