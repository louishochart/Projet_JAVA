/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import miniprojet.Humains.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Louis
 */
public class Table { 
    List<ClientNeutre> clients = new ArrayList<ClientNeutre>();
    private Serveur serveur;

    public Table() {
    }
    
    
    

    public List<ClientNeutre> getClients() {
        return clients;
    }
    
    public Serveur getServeur() {
        return serveur;
    }
    

    public void setClients(List<ClientNeutre> clients) {
        this.clients = clients;
    }
    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }
    
    
    public void addClient(ClientNeutre c){
        if (this.isFree()){
            this.clients.add(c);
        }
    }
    
    public int getNbClients(){
        return(this.getClients().size());
    }  
    public boolean isFree(){
        if(this.getNbClients()<4){
            return true;
        }
        else{
            return false;
        }
    }
}
