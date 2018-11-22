/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Fonctions.Random;
import miniprojet.Bar.*;
import miniprojet.*;
        
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Louis
 */
public class Client extends ClientNeutre {
    
    private Color couleur_tshirt;

    public Client(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool, Color couleur_tshirt) {
        super(prenom, nom, porte_monnaie, popularite, cri,boisson_fav_1, boisson_fav_2, niveau_alcool);
        this.couleur_tshirt = couleur_tshirt;
    }
    
    

    
    
    public Client(){
        super(new Random().getRandomPrenom_m(),new Random().getRandomNom(),new Random().getRandomPorteMonnaie(),new Random().getRandomPopularite(),
                new Random().getRandomCri(),new Random().getRandomBoisson(),new Random().getRandomBoisson(),0f);
        
        while(this.getBoisson_fav_1().getName().equals(this.getBoisson_fav_2().getName())){
            this.setBoisson_fav_2(new Random().getRandomBoisson()); 
        }
        
        this.couleur_tshirt=new Random().getRandomCouleur();
    }
    
    public void parlerdestinataire(Humain destinataire, String phrase){     
        if(destinataire.getClass().getSimpleName().equals("Serveuse")&&this.getNiveau_alcool()>1){
            System.out.println(this.getPrenom()+" "+this.getNom()+" à "+destinataire.getPrenom()+" "+destinataire.getNom()+" : "+phrase+" poupée !");
        }
        else{
            System.out.println(this.getPrenom()+" "+this.getNom()+" à "+destinataire.getPrenom()+" "+destinataire.getNom()+" : "+phrase);
        }
    }

    public Color getCouleur_tshirt() {
        return couleur_tshirt;
    }

    public void setCouleur_tshirt(Color couleur_tshirt) {
        this.couleur_tshirt = couleur_tshirt;
    }
    
    
    
    
    
    


    
    
    
    @Override
    public String toString() {
        return "Client{ Prenom : "+this.getPrenom()+" , Surnom : "+this.getNom()+" , Porte Monnaie : "+this.getPorte_monnaie()
        +" , Popularité : "+this.getPopularite()+" , Cri : "+this.getCri()+" , boisson_fav_1 : "+ this.getBoisson_fav_1() + " , boisson_fav_2 : " 
                + this.getBoisson_fav_2() + " , niveau_alcool : " + this.getNiveau_alcool() +" , couleur_tshirt : "+couleur_tshirt+" , exclu? = "+this.isExclu()+ '}';
    } 
    
    public void verre_gratuit(){
        
    }
    public void se_presenter_court(){
        
    }
}
