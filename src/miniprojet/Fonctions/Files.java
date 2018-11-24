/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Fonctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Louis
 */
public class Files {

    public void emptyFiles() {
        PrintWriter writer = null;
        try {
            File clients = new File(".\\db\\clients.txt");
            if (!clients.exists()) {
                clients.createNewFile();
            }
            writer = new PrintWriter(clients);
            writer.print("");
            writer.close();
            File clientes = new File(".\\db\\clientes.txt");
            if (!clientes.exists()) {
                clientes.createNewFile();
            }
            writer = new PrintWriter(clientes);
            writer.print("");
            writer.close();
            File barman = new File(".\\db\\barman.txt");
            if (!barman.exists()) {
                barman.createNewFile();
            }
            writer = new PrintWriter(barman);
            writer.print("");
            writer.close();
            File patronne = new File(".\\db\\patronne.txt");
            if (!patronne.exists()) {
                patronne.createNewFile();
            }
            writer = new PrintWriter(patronne);
            writer.print("");
            writer.close();
            File fournisseur = new File(".\\db\\fournisseur.txt");
            if (!fournisseur.exists()) {
                fournisseur.createNewFile();
            }
            writer = new PrintWriter(fournisseur);
            writer.print("");
            writer.close();
            File serveurs = new File(".\\db\\serveurs.txt");
            if (!serveurs.exists()) {
                serveurs.createNewFile();
            }
            writer = new PrintWriter(serveurs);
            writer.print("");
            writer.close();
            File serveuses = new File(".\\db\\serveuses.txt");
            if (!serveuses.exists()) {
                serveuses.createNewFile();
            }
            writer = new PrintWriter(serveuses);
            writer.print("");
            writer.close();
            File stocks = new File(".\\db\\stocks.txt");
            if (!stocks.exists()) {
                stocks.createNewFile();
            }
            writer = new PrintWriter(stocks);
            writer.print("");
            writer.close();
            File bar = new File(".\\db\\bar.txt");
            if (!bar.exists()) {
                bar.createNewFile();
            }
            writer = new PrintWriter(bar);
            writer.print("");
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }

    public boolean checkIfEmpty(String name) {
        try {
            File file = new File(".\\db\\" + name + ".txt"); // définir l'arborescence
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                return (false);
            }
            return (true);
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            return (false);
        }
    }

}
