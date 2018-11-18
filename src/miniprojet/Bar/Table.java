/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.util.ArrayList;
import java.util.List;
import miniprojet.Humans.*;
/**
 *
 * @author Louis
 */
public class Table {
    private List<Client> clients = new ArrayList<Client>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    

    public List<Client> getClients() {
        return clients;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    public void addClient(Client c){
        if(this.getNbClients()<4){
            this.clients.add(c);
        }
    }
    public void addCliente(Cliente c){
        if(this.getNbClients()<4){
            this.clientes.add(c);
        }
    }
    
    public int getNbClients(){
        return(this.getClients().size()+this.getClientes().size());
    }
    
    
    
}
