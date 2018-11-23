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
        int nbClientsAleatoire = (int)(clientsdispos.size()*(0.5)) + (int)(Math.random() * ((clientsdispos.size() - clientsdispos.size()*(0.5) + 1)));
        for (int i = 0; i < nbClientsAleatoire; i++) {
            int numeroTable = (int) (Math.random() * (Bar.getInstance().getFreeTables().size()));
            clientsdispos.get(i).setTable(Bar.getInstance().getFreeTables().get(numeroTable));
            Bar.getInstance().getFreeTables().get(numeroTable).addClient(clientsdispos.get(i));
        }
    }
}
