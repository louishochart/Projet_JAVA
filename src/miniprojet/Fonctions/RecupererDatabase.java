/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Fonctions;

import miniprojet.Humains.Color;
import miniprojet.Humains.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import miniprojet.Bar.*;

/**
 * Permet de récupérer les informations du Bar stockées dans les fichiers .txt
 */
public class RecupererDatabase {

    public RecupererDatabase() {

        Bar.getInstance().setPatronne(patronne());
        Bar.getInstance().setBarman(barman());
        Bar.getInstance().setFournisseur(fournisseur());
        Bar.getInstance().setClients(getClients());
        Bar.getInstance().setServeurs(getServeurs());
        Bar.getInstance().setStock(stock());
        Bar.getInstance().setCaisse(caisse());
        Bar.getInstance().setTables(tables());

    }

    public Patronne patronne() {
        BufferedReader br = null;
        try {
            File file = new File(".\\db\\patronne.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boisson[] boissons = Boisson.values();
                Boisson boisson_fav_1 = null;
                Boisson boisson_fav_2 = null;
                for (Boisson boisson : boissons) {
                    if (boisson.getName().equals(valeurs[5])) {
                        boisson_fav_1 = boisson;
                    }
                    if (boisson.getName().equals(valeurs[6])) {
                        boisson_fav_2 = boisson;
                    }
                }
                float niveau_alcool = parseFloat(valeurs[7]);
                Color couleur_tshirt = null;
                int nb_bijoux = parseInt(valeurs[8]);
                return (new Patronne(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, nb_bijoux));
            }
            return (null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Barman barman() {
        BufferedReader br = null;
        try {
            File file = new File(".\\db\\barman.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boisson[] boissons = Boisson.values();
                Boisson boisson_fav_1 = null;
                Boisson boisson_fav_2 = null;
                for (Boisson boisson : boissons) {
                    if (boisson.getName().equals(valeurs[5])) {
                        boisson_fav_1 = boisson;
                    }
                    if (boisson.getName().equals(valeurs[6])) {
                        boisson_fav_2 = boisson;
                    }
                }
                return (new Barman(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2));
            }
            return (null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Fournisseur fournisseur() {
        BufferedReader br = null;
        try {
            File file = new File(".\\db\\fournisseur.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                return (new Fournisseur(prenom, nom, porte_monnaie, popularite, cri));
            }
            return (null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<ClientNeutre> getClients() {
        ArrayList<ClientNeutre> total = new ArrayList();
        ArrayList<Client> clients = clients();
        ArrayList<Cliente> clientes = clientes();
        for (int i = 0; i < clients.size(); i++) {
            total.add(clients.get(i));
        }
        for (int i = 0; i < clientes.size(); i++) {
            total.add(clientes.get(i));
        }
        return total;
    }

    public ArrayList<Client> clients() {
        BufferedReader br = null;
        ArrayList<Client> liste = new ArrayList();
        try {

            File file = new File(".\\db\\clients.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boisson[] boissons = Boisson.values();
                Boisson boisson_fav_1 = null;
                Boisson boisson_fav_2 = null;
                for (Boisson boisson : boissons) {
                    if (boisson.getName().equals(valeurs[5])) {
                        boisson_fav_1 = boisson;
                    }
                    if (boisson.getName().equals(valeurs[6])) {
                        boisson_fav_2 = boisson;
                    }
                }
                float niveau_alcool = parseFloat(valeurs[7]);
                Color couleur_tshirt = null;
                Color[] couleurs = Color.values();
                for (Color couleur : couleurs) {
                    if (couleur.getName().equals(valeurs[8])) {
                        couleur_tshirt = couleur;
                    }
                }
                Client c = new Client(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, couleur_tshirt);
                liste.add(c);
            }
            return (liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public ArrayList<Cliente> clientes() {
        BufferedReader br = null;
        ArrayList<Cliente> liste = new ArrayList();
        try {

            File file = new File(".\\db\\clientes.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                Boisson[] boissons = Boisson.values();
                Boisson boisson_fav_1 = null;
                Boisson boisson_fav_2 = null;
                for (Boisson boisson : boissons) {
                    if (boisson.getName().equals(valeurs[5])) {
                        boisson_fav_1 = boisson;
                    }
                    if (boisson.getName().equals(valeurs[6])) {
                        boisson_fav_2 = boisson;
                    }
                }
                float niveau_alcool = parseFloat(valeurs[7]);
                int nb_bijoux = parseInt(valeurs[8]);
                Cliente c = new Cliente(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, nb_bijoux);
                liste.add(c);
            }
            return (liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<ServeurNeutre> getServeurs() {
        ArrayList<ServeurNeutre> total = new ArrayList();
        ArrayList<Serveur> serveurs = serveurs();
        ArrayList<Serveuse> serveuses = serveuses();
        for (int i = 0; i < serveurs.size(); i++) {
            total.add(serveurs.get(i));
        }
        for (int i = 0; i < serveuses.size(); i++) {
            total.add(serveuses.get(i));
        }
        return total;
    }

    public ArrayList<Serveur> serveurs() {
        BufferedReader br = null;
        ArrayList<Serveur> liste = new ArrayList();
        try {
            File file = new File(".\\db\\serveurs.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                int taille_biceps = parseInt(valeurs[6]);
                liste.add(new Serveur(prenom, nom, porte_monnaie, popularite, cri, taille_biceps));
            }
            return (liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Serveuse> serveuses() {
        BufferedReader br = null;
        ArrayList<Serveuse> liste = new ArrayList();
        try {
            File file = new File(".\\db\\serveuses.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                String prenom = valeurs[0];
                String nom = valeurs[1];
                double porte_monnaie = parseDouble(valeurs[2]);
                int popularite = parseInt(valeurs[3]);
                String cri = valeurs[4];
                int coeff_charme = parseInt(valeurs[6]);
                liste.add(new Serveuse(prenom, nom, porte_monnaie, popularite, cri, coeff_charme));
            }
            return (liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Stock stock() {
        BufferedReader br = null;
        try {
            File file = new File(".\\db\\stocks.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            ArrayList<Boisson> boissons = new ArrayList();
            ArrayList<Integer> quantites = new ArrayList();
            while ((st = br.readLine()) != null) {
                String[] valeurs = st.split(";");
                Boisson boisson = null;
                for (Boisson value : Boisson.values()) {
                    if (value.getName().equals(valeurs[0])) {
                        boisson = value;
                    }
                }
                boissons.add(boisson);
                quantites.add(parseInt(valeurs[1]));
            }
            return (new Stock(boissons, quantites));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (null);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Caisse caisse() {
        BufferedReader br = null;
        float caisse = 0f;
        try {
            File file = new File(".\\db\\bar.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            if ((st = br.readLine()) != null) {
                caisse = parseFloat(st);
            }
            return (new Caisse(caisse));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (new Caisse(caisse));
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (new Caisse(caisse));
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Table> tables() {
        BufferedReader br = null;
        ArrayList<Table> liste = new ArrayList();
        try {

            File file = new File(".\\db\\bar.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            br = new BufferedReader(new FileReader(file));
            String st;
            if ((st = br.readLine()) != null) {
                st = br.readLine();
                for (int i = 0; i < parseInt(st); i++) {
                    liste.add(new Table());
                }
            }

            return (liste);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } catch (IOException ex) {
            Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            return (liste);
        } finally {

            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(RecupererDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
