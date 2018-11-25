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
 * l'objet Bar permet d'accéder à toutes les informations sur le bar. 
 * Il contient la totalité des données sauvegardées dans les fichier .txt
 */
public class Bar {

    private Patronne patronne;
    private String name;
    private Barman barman;
    private Fournisseur fournisseur;
    private ArrayList<Table> tables = new ArrayList();
    private ArrayList<ServeurNeutre> serveurs = new ArrayList();
    private ArrayList<ClientNeutre> clients = new ArrayList();
    private Stock stock = new Stock();
    private Caisse caisse = new Caisse();

    private Simulation simulation = new Simulation();

    /**
     * Holder
     */
    private static class BarHolder {

        /**
         * Instance unique non préinitialisée
         */
        private final static Bar INSTANCE = new Bar();
    }

    /**
     * Point d'accès pour l'instance unique du singleton
     *
     * @return
     */
    public static Bar getInstance() {
        try {
            return BarHolder.INSTANCE;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Constructor pour la classe Bar
     *
     * @param patronne
     * @param barman
     * @param fournisseur
     */
    private Bar(Patronne patronne, Barman barman, Fournisseur fournisseur) {
        this.patronne = patronne;
        this.name = "Chez " + this.patronne.getPrenom();
        this.barman = barman;
        this.fournisseur = fournisseur;
    }

    private Bar() {
    }

    /**
     * liste des tables qui ne sont pas pleines
     *
     * @return la liste des tables qui ne sont pas pleines
     */
    public ArrayList<Table> getFreeTables() {
        ArrayList<Table> freeTables = new ArrayList<Table>();
        for (int i = 0; i < this.getTables().size(); i++) {
            if (this.getTables().get(i).isFree()) {
                freeTables.add(this.getTables().get(i));
            }
        }
        return (freeTables);
    }

    /**
     * liste des serveurs qui ne sont pas assignés à une table
     *
     * @return la liste des serveurs qui ne sont pas assignés à une table
     */
    public List<ServeurNeutre> getFreeServeurs() {
        List<ServeurNeutre> freeServeurs = new ArrayList<ServeurNeutre>();
        for (int i = 0; i < this.getServeurs().size(); i++) {
            if (this.getServeurs().get(i).isFree()) {
                freeServeurs.add(this.getServeurs().get(i));

            }
        }
        return (freeServeurs);
    }

    /**
     * liste des serveurs qui ne sont pas assignés à une table
     *
     * @return la liste des clients qui ne sont pas exclus
     */
    public List<ClientNeutre> getClientsDispos() {
        List<ClientNeutre> dispos = new ArrayList();
        for (int i = 0; i < Bar.getInstance().getClients().size(); i++) {
            if (!Bar.getInstance().getClients().get(i).isExclu()) {
                dispos.add(Bar.getInstance().getClients().get(i));
            }
        }
        return dispos;
    }

    public void addTable(Table t) {
        if (this.tables.size() < 20) {
            this.tables.add(t);
        }
    }

    public void addServeur(ServeurNeutre s) {
        this.serveurs.add(s);
    }

    public void addClient(ClientNeutre c) {
        this.clients.add(c);
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

    public Simulation getSimulation() {
        return simulation;
    }

    /**
     * liste de clients utilisée pour la sauvegarde
     *
     * @return une liste de clients utilisée pour la sauvegarde
     */
    public List<Client> getClients_m() {
        ArrayList clients_m = new ArrayList();
        for (int i = 0; i < Bar.getInstance().getClients().size(); i++) {
            if (Bar.getInstance().getClients().get(i) instanceof Client) {
                clients_m.add(Bar.getInstance().getClients().get(i));
            }
        }
        return clients_m;
    }

    /**
     * liste de serveurs utilisée pour la sauvegarde
     *
     * @return une liste de serveurs utilisée pour la sauvegarde
     */
    public List<Cliente> getClientes_f() {
        ArrayList clientes_f = new ArrayList();
        for (int i = 0; i < Bar.getInstance().getClients().size(); i++) {
            if (Bar.getInstance().getClients().get(i) instanceof Cliente) {
                clientes_f.add(Bar.getInstance().getClients().get(i));
            }
        }
        return clientes_f;
    }

    /**
     * liste de serveurs utilisée pour la sauvegarde
     *
     * @return une liste de serveurs utilisée pour la sauvegarde
     */
    public List<Serveur> getServeurs_m() {
        ArrayList serveurs_m = new ArrayList();
        for (int i = 0; i < Bar.getInstance().getServeurs().size(); i++) {
            if (Bar.getInstance().getServeurs().get(i) instanceof Serveur) {
                serveurs_m.add(Bar.getInstance().getServeurs().get(i));
            }
        }
        return serveurs_m;
    }

    /**
     * liste de serveuses utilisée pour la sauvegarde
     *
     * @return une liste de serveuses utilisée pour la sauvegarde
     */
    public List<Serveuse> getServeuses_f() {
        ArrayList serveuses_f = new ArrayList();
        for (int i = 0; i < Bar.getInstance().getServeurs().size(); i++) {
            if (Bar.getInstance().getServeurs().get(i) instanceof Serveuse) {
                serveuses_f.add(Bar.getInstance().getServeurs().get(i));
            }
        }
        return serveuses_f;
    }

    public Stock getStock() {
        return stock;
    }

    public Caisse getCaisse() {
        return caisse;
    }

    public void setPatronne(Patronne patronne) {
        this.patronne = patronne;
        if (this.patronne == null) {
            this.name = null;
        } else {
            this.name = "Chez " + patronne.getPrenom();
        }
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    public void setBarman(Barman barman) {
        this.barman = barman;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public void setServeurs(ArrayList<ServeurNeutre> serveurs) {
        this.serveurs = serveurs;
    }

    public void setClients(ArrayList<ClientNeutre> clients) {
        this.clients = clients;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setCaisse(Caisse caisse) {
        this.caisse = caisse;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
