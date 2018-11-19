/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import miniprojet.Humans.*;
import miniprojet.Bar.*;
import miniprojet.*;
/**
 *
 * @author Louis
 */
public class Caisse {
    float caisse;
    
    public Caisse(float caisse){
        this.caisse=caisse;
        Save();
    }
    public Caisse(){}
    
    public void Save(){
        try{
            char separator= ';';
            File file=new File(".\\db\\caisse.txt"); // définir l'arborescence
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(Float.toString(this.caisse));  
                        // écrire une ligne dans le fichier clients.txt
            bw.close(); // fermer le fichier à la fin des traitements
        } 
        catch (Exception e){}
    }

    public float getCaisse() {
        return caisse;
    }
    

    public Caisse setCaisse(float caisse) {
        this.caisse = caisse;
        Save();
        return(this);
    }
    
    
}
