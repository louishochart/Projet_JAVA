/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.util.ArrayList;
import java.util.List;

/**
 *  l'objet Stock permet de stocker l'inventaire du Bar
 * 
 */
public class Stock {

    private List<Boisson> boissons = new ArrayList();
    private List<Integer> quantites = new ArrayList();

    public Stock(int qte) {
        for (Boisson value : Boisson.values()) {
            boissons.add(value);
            quantites.add(qte);
        }
    }

    public Stock() {
    }

    public Stock(ArrayList<Boisson> boissons, ArrayList<Integer> quantites) {
        this.setBoissons(boissons);
        this.setQuantites(quantites);
    }

    public void removeFromStock(Boisson boisson, int quantite_a_enlever) {
        for (int i = 0; i < this.boissons.size(); i++) {
            if (boissons.get(i).getName().equals(boisson.getName())) {
                this.quantites.set(i, (this.quantites.get(i) - quantite_a_enlever));
                Bar.getInstance().getBarman().verifierStocks();
            }
        }
    }

    public int getStock(Boisson boisson) {
        for (int i = 0; i < this.boissons.size(); i++) {
            if (boissons.get(i).getName().equals(boisson.getName())) {
                return (this.quantites.get(i));
            }
        }
        return (0);
    }
    
    public void addStock(Boisson boisson, int quantite){
        for(int i = 0 ; i < this.getBoissons().size() ; i++){
            if (boisson.equals(this.getBoissons().get(i))){
                int temp=Bar.getInstance().getStock().getStock(boisson);
                Bar.getInstance().getStock().getQuantites().set(i, (quantite+temp));
            }
        }
    }

    public List<Boisson> getBoissons() {
        return boissons;
    }

    public List<Integer> getQuantites() {
        return quantites;
    }

    private void setBoissons(List<Boisson> boissons) {
        this.boissons = boissons;
    }

    private void setQuantites(List<Integer> quantites) {
        this.quantites = quantites;
    }

}
