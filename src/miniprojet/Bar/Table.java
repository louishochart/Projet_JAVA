/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import miniprojet.Humains.*;
import java.util.ArrayList;


/**
 * La classe Table permet de de stocker des Clients
 */
public class Table {

    ArrayList<ClientNeutre> clients = new ArrayList();
    private ServeurNeutre serveur;

    public Table() {
    }

    public ArrayList<ClientNeutre> getClients() {
        return clients;
    }

    public ServeurNeutre getServeur() {
        return serveur;
    }

    public void setClients(ArrayList<ClientNeutre> clients) {
        this.clients = clients;
    }

    public void setServeur(ServeurNeutre serveur) {
        this.serveur = serveur;
    }

    public void addClient(ClientNeutre c) {
        if (this.isFree()) {
            this.clients.add(c);
        }
    }

    public boolean isFree() {
        if (this.getClients().size() < 4) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isFull(){
        if (this.getClients().size() == 4) {
            return true;
        } else {
            return false;
        }
    }
}
