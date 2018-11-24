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
 *
 * @author Louis
 */
public abstract class ServeurNeutre extends Humain {

    private final Boisson boisson = Boisson.EAU;
    private List<Table> table = new ArrayList();

    public ServeurNeutre(String prenom, String nom, double porte_monnaie, int popularite, String cri) {
        super(prenom, nom, porte_monnaie, popularite, cri);
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
