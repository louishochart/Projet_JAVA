/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import java.util.ArrayList;
import java.util.List;
import miniprojet.Bar.*;

/**
 * L'objet Serveur hérité de l'objet Humain
 */
public abstract class ServeurNeutre extends Humain {

    private final Boisson boisson = Boisson.EAU;
    private List<Table> table = new ArrayList();
    
    /**
     * Constructeur
     * @param prenom
     * @param nom
     * @param porte_monnaie
     * @param popularite
     * @param cri 
     */
    public ServeurNeutre(String prenom, String nom, double porte_monnaie, int popularite, String cri) {
        super(prenom, nom, porte_monnaie, popularite, cri);
    }
    
    /**
     * Permet à un serveur de recevoir un verre
     * @param expediteur
     * @param boisson 
     */
    public void recevoirVerre(Humain expediteur, Boisson boisson) {
        System.out.println("Merci " + expediteur.getPrenom() + ", tu es vraiment un bon client !");
        Bar.getInstance().getSimulation().incrementVerresBus();
    }
    public Boisson getBoisson() {
        return boisson;
    }

    public List<Table> getTables() {
        return table;
    }

    public void setTables(List<Table> table) {
        this.table = table;
    }

    public boolean isFree() {
        if (this.getTables().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
