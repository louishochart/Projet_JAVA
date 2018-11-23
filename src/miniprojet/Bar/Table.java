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
    private ServeurNeutre serveur;

    public Table() {
    }
    
    
    

    public List<ClientNeutre> getClients() {
        return clients;
    }
    
    public ServeurNeutre getServeur() {
        return serveur;
    }
    

    public void setClients(List<ClientNeutre> clients) {
        this.clients = clients;
    }
    public void setServeur(ServeurNeutre serveur) {
        this.serveur = serveur;
    }
    
    
    public void addClient(ClientNeutre c){
        if (this.isFree()){
            this.clients.add(c);
        }
    }
    
    public boolean isFree(){
        if(this.getClients().size()<4){
            return true;
        }
        else{
            return false;
        }
    }
}
