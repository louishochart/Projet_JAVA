/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import miniprojet.Bar.*;
import miniprojet.*;
import miniprojet.Fonctions.Random;

/**
 *
 * @author Louis
 */
public class Barman extends Humain{
    
    private Boisson boisson_fav_1;
    private Boisson boisson_fav_2;
    
    public Barman(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2) {
        
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.setBoisson_fav_1(boisson_fav_1);
        this.setBoisson_fav_2(boisson_fav_2);
    }
    
    public Barman(){
        super(new Random().getRandomPrenom_m(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),new Random().getRandomCri());
        this.boisson_fav_1=new Random().getRandomSoft();
        Boisson b = new Random().getRandomSoft();
        
        while(boisson_fav_1.getName().equals(b.getName())){
            b = new Random().getRandomSoft();
        }
        this.boisson_fav_2=b;
    }
    
    public void parler(String phrase){
        System.out.println(this.getPrenom()+" "+this.getNom()+" : "+phrase);
    }
    public void parlerdestinataire(Humain destinataire, String phrase){     
        System.out.println(this.getPrenom()+" "+this.getNom()+" à "+destinataire.getPrenom()+" "+destinataire.getNom()+" : "+phrase+" coco !");
    }
    
    public void boire(){
        
    }
    public void recevoir_paiement(float paiement){
    }

    @Override
    public String toString() {
        return "Barman{ Prenom: "+this.getPrenom()+" , Surnom : "+this.getNom()+" , Porte Monnaie : "+this.getPorte_monnaie()
        +" , Popularité : "+this.getPopularite()+" , Cri : "+this.getCri()+" , boisson_fav_1 : "+ boisson_fav_1 + " , boisson_fav_2 : " + boisson_fav_2 + '}';
    }
    
    
    
    
    
    
    public Boisson getBoisson_fav_1() {
        return boisson_fav_1;
    }

    public Boisson getBoisson_fav_2() {
        return boisson_fav_2;
    }

    public void setBoisson_fav_1(Boisson boisson_fav_1) {
        if (boisson_fav_1.getDegree()!=0){
            System.out.println("Le Barman déteste l'aloool");
        }
        else{
            this.boisson_fav_1 = boisson_fav_1;
        }
    }

    public void setBoisson_fav_2(Boisson boisson_fav_2) {
        if (boisson_fav_2.getDegree()!=0){
            System.out.println("Le Barman déteste l'aloool");
        }
        else{
            this.boisson_fav_2 = boisson_fav_2;
        }
    }

    
    
    

}
