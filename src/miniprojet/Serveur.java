/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author Louis
 */
public class Serveur extends Human{

    public Serveur(String prenom, String surnom, float porte_monnaie, float popularite, String cri) {
        super(prenom, surnom, porte_monnaie, popularite, cri);
        
        try{
            char separator= ';';
            File file=new File(".\\db\\clients.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
                System.out.println("c nv");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(this.getPrenom()+separator+this.getSurnom()+separator+this.getPorte_monnaie()+separator);  
                        // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }
    
    
}
