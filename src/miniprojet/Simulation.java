/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniprojet.Bar.*;
import miniprojet.Humains.*;

/**
 *
 * @author Louis
 */
public class Simulation {
    public void entrerClients(){
        List<ClientNeutre> clientsdispos = Bar.getInstance().getClientsDispos();
        Collections.shuffle(clientsdispos);
//        List<Table> tables = Bar.getInstance().getTables();
//        int nombreAleatoire = (int)(tables.size()*(2)) + (int)(Math.random() * ((tables.size()*4 - tables.size()*2) + 1));
//        System.out.println(clientsdispos);
//        System.out.print(nombreAleatoire);
//        for(int i = 0 ; i < nombreAleatoire ; i++){
//            
//            try {
//                System.out.println(" ");
//                
//                System.out.println(Bar.getInstance().getFreeTables());
//                int numeroTable =(int)(Math.random() * (Bar.getInstance().getFreeTables().size()));
//                System.out.println(numeroTable);
//                System.out.println("________________");
//                TimeUnit.SECONDS.sleep(1);
//                Bar.getInstance().getFreeTables().get(numeroTable).addClient(clientsdispos.get(i));
//                clientsdispos.get(i).setTable(Bar.getInstance().getFreeTables().get(numeroTable));
//                System.out.println(" ");
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Simulation.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }
}
