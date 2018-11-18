/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import miniprojet.Humans.*;
import miniprojet.Bar.*;
import miniprojet.Functions.*;
import miniprojet.*;
import miniprojet.GUI.*;

/**
 *
 * @author Louis
 */
public class TestClass {
    
    public void test() throws FileNotFoundException, IOException{
       /*
        Client client1 = new Client("bière","pisse",10,"Samuel","Lefebvre",0.01f,0,"ooooooh");
        Client client2 = new Client("bière","pisse",10,"SAM","Lefebvre",0.01f,0,"ooooooh");
        System.out.println(client1);  
        */
                
        /*
        File file=new File(".\\db\\clients.txt"); // définir l'arborescence
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st; 
        while((st = br.readLine()) != null){ 
            String[] valeurs = st.split(";");
            for(int i = 0 ; i<valeurs.length;i++){
                System.out.println(valeurs[i]);
            }
        } 
       */
        
        /*
        Scanner scanner = new Scanner(System. in); 
        String input = scanner.nextLine();
        System.out.println(input);
        */
        /*
        Barman barman = new Barman("Louis", "Hoch",15,15,"oh",Boissons.Jus_d_Orange,Boissons.Eau);
        System.out.println(barman);
        */
        
        Interface1 gui  = new Interface1();
        
        /*
        Client c = new Client();
        System.out.println(c.getBoisson_fav_1());
        System.out.println(c.getBoisson_fav_1().getDegree());
        */
        /*
        Table t = new Table();
        t.addClient(new Client());
        t.addClient(new Client());
        t.addCliente(new Cliente());
        t.addClient(new Client());
        t.addClient(new Client());
        System.out.println(t.getClients().get(1));
        System.out.println(t.getNbClients());
        */
        
    }
}
