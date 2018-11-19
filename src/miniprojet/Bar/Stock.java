/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Louis
 */
public class Stock {
    private List <Boisson> boissons = new ArrayList <Boisson>();
    private List <Integer> quantites = new ArrayList <Integer>();
    
    public Stock(int qte){
        for(int i = 0 ; i < Boisson.values().length ; i++ ){
            boissons.add(Boisson.values()[i]);
            quantites.add(qte);
            Save();
        }
    }
    private Stock(){}

    public Stock(ArrayList<Boisson> boissons,ArrayList<Integer> quantites) {
        this.setBoissons(boissons);
        this.setQuantites(quantites);
    }
    public void Save(){     
        try{
            char separator= ';';
            File file=new File(".\\db\\stocks.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(int i = 0 ; i < this.boissons.size() ; i ++ ){
                bw.write(this.boissons.get(i).getName()+separator+this.quantites.get(i));  
                        // écrire une ligne dans le fichier clients.txt
                bw.write("\n"); // forcer le passage à la ligne
            }  
                        // écrire une ligne dans le fichier clients.txt
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}  
    } 
    
    public Stock modifyStock(Boisson boisson,int quantite){
        for(int i = 0 ; i < this.boissons.size() ; i++){
            if(boissons.get(i).getName().equals(boisson.getName())){
                this.quantites.set(i, quantite);
            }
        }
        Save();
        return(this);
    }
    public int getStock(Boisson boisson){
        for(int i = 0 ; i < this.boissons.size() ; i++){
            if(boissons.get(i).getName().equals(boisson.getName())){
                return(this.quantites.get(i));
            }
        }
        return(0);       
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
