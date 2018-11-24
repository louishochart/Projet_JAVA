/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import miniprojet.Bar.*;
import miniprojet.*;

/**
 *
 * @author Louis
 */
public class Caisse {

    float caisse;

    public Caisse(float caisse) {
        this.caisse = caisse;
    }

    public Caisse() {
    }

    public void addCaisse(float paiement){
        float temp=this.caisse;
        this.setCaisse(temp+paiement);
    }
    public void removeCaisse(float cash){
        float temp=this.caisse;
        this.setCaisse(temp-cash);
    }
    
        
    public float getCaisse() {
        return caisse;
    }

    public void setCaisse(float caisse) {
        this.caisse = caisse;
    }

}
