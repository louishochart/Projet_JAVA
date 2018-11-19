/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import miniprojet.Humans.*;
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
    private List<Serveur> serveurs = new ArrayList<Serveur>();
    private List<Serveuse> serveuses = new ArrayList<Serveuse>();
    private List<Client> clients = new ArrayList<Client>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Boisson> boissons = new ArrayList<Boisson>();
    private Stock stock;
    private Caisse caisse;
      
    /** Holder */
    private static class BarHolder
    {       
        /** Instance unique non préinitialisée */
        private final static Bar instance = new Bar();
    }
 
    /** Point d'accès pour l'instance unique du singleton */
    public static Bar getInstance()
    {
        return BarHolder.instance;
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
    public void addServeur(Serveur s){
        this.serveurs.add(s);
    }
    public void addServeuse(Serveuse s){
        this.serveuses.add(s);
    }
    public void addClient(Client c){
        this.clients.add(c);
    }
    public void addCliente(Cliente c){
        this.clientes.add(c);
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
    public List<Serveur> getServeurs() {
        return serveurs;
    }
    public List<Serveuse> getServeuses() {
        return serveuses;
    }
    public List<Client> getClients() {
        return clients;
    }
    public List<Cliente> getClientes() {
        return clientes;
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
        this.name = "Chez " + patronne.getPrenom();
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
    public void setServeurs(List<Serveur> serveurs) {
        this.serveurs = serveurs;
    }
    public void setServeuses(List<Serveuse> serveuses) {
        this.serveuses = serveuses;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
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
    
    
    
    
    
    
    
    
    
    
    
    
}
