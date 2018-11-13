/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
/**
 *
 * @author Louis
 */
public class Client extends Human {
    
    private String boisson_fav_1;
    private String boisson_fav_2;
    private float niveau_alcool;

    public Client(String boisson_fav_1, String boisson_fav_2, float niveau_alcool, String prenom, String surnom, float porte_monnaie, float popularite, String cri) {
        super(prenom, surnom, porte_monnaie, popularite, cri);
        this.boisson_fav_1 = boisson_fav_1;
        this.boisson_fav_2 = boisson_fav_2;
        this.niveau_alcool = niveau_alcool;
        try{
            char separator= ';';
            File file=new File(".\\db\\clients.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
                System.out.println("c nv");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()+separator
                            +this.getPopularite()+separator+this.getCri()+separator+this.getBoisson_fav_1()+separator
                        +this.boisson_fav_2+separator+this.niveau_alcool);  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
  
    }
    public String getBoisson_fav_1() {
        return boisson_fav_1;
    }

    public String getBoisson_fav_2() {
        return boisson_fav_2;
    }

    public float getNiveau_alcool() {
        return niveau_alcool;
    }

    public void setBoisson_fav_1(String boisson_fav_1) {
        this.boisson_fav_1 = boisson_fav_1;
    }

    public void setBoisson_fav_2(String boisson_fav_2) {
        this.boisson_fav_2 = boisson_fav_2;
    }

    public void setNiveau_alcool(float niveau_alcool) {
        this.niveau_alcool = niveau_alcool;
    }

    @Override
    public String toString() {
        return "Client{ Prenom: "+this.getPrenom()+", Surnom : "+this.getSurnom()+", Porte Monnaie : "+this.getPorte_monnaie()
        +", Popularité : "+this.getPopularite()+", Cri : "+this.getCri()+", boisson_fav_1="+ boisson_fav_1 + ", boisson_fav_2=" + boisson_fav_2 + ", niveau_alcool=" + niveau_alcool + '}';
    } 
    
    public void verre_gratuit(){
        
    }
    public void se_presenter_court(){
        
    }
}
