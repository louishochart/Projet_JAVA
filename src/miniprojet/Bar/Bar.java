/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import miniprojet.Humains.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import miniprojet.Bar.*;
import miniprojet.*;

/**
 *
 * @author Louis
 */


public class Bar {
    
    private Patronne patronne ;
    private String name ;
    private Barman barman;
    private Fournisseur fournisseur;
    private List<Table> tables = new ArrayList<Table>();
    List<ServeurNeutre> serveurs = new ArrayList<ServeurNeutre>();
    List<ClientNeutre> clients = new ArrayList<ClientNeutre>();
    private List<Boisson> boissons = new ArrayList<Boisson>();
    private Stock stock = new Stock();
    private Caisse caisse = new Caisse();
      
    /** Holder */
    private static class BarHolder
    {       
        /** Instance unique non préinitialisée */
        private final static Bar instance = new Bar();
    }
 
    /** Point d'accès pour l'instance unique du singleton */
    public static Bar getInstance()
    {   
        try{ 
            return BarHolder.instance;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    private Bar(Patronne patronne, Barman barman, Fournisseur fournisseur) {
        this.patronne = patronne;
        this.name = "Chez " + this.patronne.getPrenom();
        this.barman = barman;
        this.fournisseur = fournisseur;
    }    
    private Bar() 
    {
    }

    public void addTable(Table t){
        if(this.tables.size()<10){
            this.tables.add(t);
        }
    }
    public void addServeur(ServeurNeutre s){
        this.serveurs.add(s);
    }
    public void addClient(ClientNeutre c){
        this.clients.add(c);
    }
    public void addBoisson(Boisson b){
        this.boissons.add(b);
    }
    
    public Patronne getPatronne() {
        return patronne;
    }
    public String getName() {
        return name;
    }
    public List<Table> getTables() {
        return tables;
    }
    public Barman getBarman() {
        return barman;
    }
    public Fournisseur getFournisseur() {
        return fournisseur;
    }   
    public List<ServeurNeutre> getServeurs() {
        return serveurs;
    }
    public List<ClientNeutre> getClients() {
        return clients;
    }

    
    public List<ClientNeutre> getClientsDispos(){
        List<ClientNeutre> dispos = new ArrayList<ClientNeutre>();
        for(int i = 0 ; i < Bar.getInstance().getClients().size() ; i++){
            if(!Bar.getInstance().getClients().get(i).isExclu()){
                dispos.add(Bar.getInstance().getClients().get(i));
            }
        }
        return dispos;
    }
    
    public List<Client> getClients_m(){
        ArrayList clients = new ArrayList();
        for(int i = 0 ; i < Bar.getInstance().getClients().size() ; i++){
            if(Bar.getInstance().getClients().get(i).getClass().getSimpleName().equals("Client")){
                clients.add(Bar.getInstance().getClients().get(i));
            }
        }
        return clients;
    }    
    public List<Cliente> getClientes_f(){
        ArrayList clientes = new ArrayList();
        for(int i = 0 ; i < Bar.getInstance().getClients().size() ; i++){
            if(Bar.getInstance().getClients().get(i).getClass().getSimpleName().equals("Cliente")){
                clientes.add(Bar.getInstance().getClients().get(i));
            }
        }
        return clientes;
    }    
    public List<Serveur> getServeurs_m(){
        ArrayList serveurs = new ArrayList();
        for(int i = 0 ; i < Bar.getInstance().getServeurs().size() ; i++){
            if(Bar.getInstance().getServeurs().get(i).getClass().getSimpleName().equals("Serveur")){
                serveurs.add(Bar.getInstance().getServeurs().get(i));
            }
        }
        return serveurs;
    }    
    public List<Serveuse> getServeuses_f(){
        ArrayList serveuses = new ArrayList();
        for(int i = 0 ; i < Bar.getInstance().getServeurs().size() ; i++){
            if(Bar.getInstance().getServeurs().get(i).getClass().getSimpleName().equals("Serveuse")){
                serveuses.add(Bar.getInstance().getServeurs().get(i));
            }
        }
        return serveuses;
    }    
    
    public List<Boisson> getBoissons() {
        return boissons;
    }
    public Stock getStock() {
        return stock;
    }
    public Caisse getCaisse() {
        return caisse;
    }
    
    

    public void setPatronne(Patronne patronne) {
        this.patronne = patronne;
        if(this.patronne==null){
            this.name=null;
        }
        else{
            this.name = "Chez " + patronne.getPrenom();
        }
    }
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
    public void setBarman(Barman barman) {
        this.barman = barman;
    }
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }   
    public void setServeurs(List<ServeurNeutre> serveurs) {
        this.serveurs = serveurs;
    }
    public void setClients(List<ClientNeutre> clients) {
        this.clients = clients;
    }
    public void setBoissons(List<Boisson> boissons) {
        this.boissons = boissons;
    }
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }
    
    public List<Table> getFreeTables(){
        List<Table> freeTables = new ArrayList<Table>();
        for(int i = 0 ; i < this.getTables().size() ; i++){
            if(this.getTables().get(i).isFree()){
                freeTables.add(this.getTables().get(i));
            }
        }
        return(freeTables);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
