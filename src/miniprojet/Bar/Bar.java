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
    private List<Boissons> boissons = new ArrayList<Boissons>();

    public Bar(Patronne patronne, Barman barman, Fournisseur fournisseur) {
        this.patronne = patronne;
        this.name = "Chez" + this.patronne.getPrenom();
        this.barman = barman;
        this.fournisseur = fournisseur;
    }    
    public Bar() throws IOException{
        this.patronne = new Patronne();
        this.name = "Chez " + this.patronne.getPrenom();
        this.barman = new Barman();
        this.fournisseur = new Fournisseur();
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
    public void addBoisson(Boissons b){
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
    public List<Boissons> getBoissons() {
        return boissons;
    }

    public void setPatronne(Patronne patronne) {
        this.patronne = patronne;
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
    public void setBoissons(List<Boissons> boissons) {
        this.boissons = boissons;
    }
    
    
    
    
    
    
    
    
    
    
    
}
