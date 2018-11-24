/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.GUI;

import java.util.ArrayList;
import java.util.List;
import miniprojet.Bar.Bar;
import miniprojet.Humains.*;
/**
 *
 * @author Louis
 */
public class RapportHeure {
    private List<ClientNeutre> clientsExclus = new ArrayList();
    
    
    public RapportHeure() {
        Bar.getInstance().getSimulation().simulerHeure();
        Simuler fen = new Simuler();
        
    }
    
}
