/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;
import java.util.ArrayList;
import miniprojet.president.*;
import miniprojet.Humains.*;

/**
 *
 * @author Louis
 */
public class TestClass2 {
    public void test2(){
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();
        ArrayList<ClientNeutre> joueurs = new ArrayList();
        joueurs.add(client1);
        joueurs.add(client2);
        joueurs.add(client3);
        joueurs.add(client4);
        President lancementPartie = new President(joueurs,1);
        lancementPartie.JeuVsPlayer();
        
    }
}
