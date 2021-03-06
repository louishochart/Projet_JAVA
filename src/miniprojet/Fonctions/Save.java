/*
 * To change Bar.getInstance().getPatronne() license header, choose License Headers in Project Properties.
 * To change Bar.getInstance().getPatronne() template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Fonctions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import miniprojet.Bar.*;

/**
 * la classe Save permet de stocker les informations sur le bar dans des  fichiers txt
 */
public class Save {

    public Save() {
        new Files().emptyFiles();
        savePatronne();
        saveBarman();
        saveFournisseur();
        saveClients();
        saveClientes();
        saveServeurs();
        saveServeuses();
        saveStock();
        saveBar();
    }

    private void savePatronne() {
        try {
            char separator = ';';
            File file = new File(".\\db\\patronne.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(Bar.getInstance().getPatronne().getPrenom() + separator + Bar.getInstance().getPatronne().getNom() + separator + Bar.getInstance().getPatronne().getPorte_monnaie() + separator
                    + Bar.getInstance().getPatronne().getPopularite() + separator + Bar.getInstance().getPatronne().getCri() + separator + Bar.getInstance().getPatronne().getBoissonFav1() + separator
                    + Bar.getInstance().getPatronne().getBoissonFav2() + separator + Bar.getInstance().getPatronne().getNiveauAlcool() + separator + Bar.getInstance().getPatronne().getNb_bijoux());
            // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveBarman() {
        try {
            char separator = ';';
            File file = new File(".\\db\\barman.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(Bar.getInstance().getBarman().getPrenom() + separator + Bar.getInstance().getBarman().getNom() + separator + Bar.getInstance().getBarman().getPorte_monnaie() + separator
                    + Bar.getInstance().getBarman().getPopularite() + separator + Bar.getInstance().getBarman().getCri() + separator + Bar.getInstance().getBarman().getBoisson_fav_1() + separator
                    + Bar.getInstance().getBarman().getBoisson_fav_2());
            // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveFournisseur() {
        try {
            char separator = ';';
            File file = new File(".\\db\\fournisseur.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(Bar.getInstance().getFournisseur().getPrenom() + separator + Bar.getInstance().getFournisseur().getNom() + separator + Bar.getInstance().getFournisseur().getPorte_monnaie() + separator
                    + Bar.getInstance().getFournisseur().getPopularite() + separator + Bar.getInstance().getFournisseur().getCri());
            // écrire une ligne dans le fichier clients.txt
            bw.write("\n"); // forcer le passage à la ligne
            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveClients() {
        try {
            char separator = ';';
            File file = new File(".\\db\\clients.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < Bar.getInstance().getClients_m().size(); i++) {
                bw.write(Bar.getInstance().getClients_m().get(i).getPrenom() + separator + Bar.getInstance().getClients_m().get(i).getNom()
                        + separator + Bar.getInstance().getClients_m().get(i).getPorte_monnaie() + separator
                        + Bar.getInstance().getClients_m().get(i).getPopularite() + separator + Bar.getInstance().getClients_m().get(i).getCri()
                        + separator + Bar.getInstance().getClients_m().get(i).getBoissonFav1() + separator
                        + Bar.getInstance().getClients_m().get(i).getBoissonFav2() + separator + Bar.getInstance().getClients_m().get(i).getNiveauAlcool()
                        + separator + Bar.getInstance().getClients_m().get(i).getCouleur_tshirt().getName());
                // écrire une ligne dans le fichier clients.txt
                bw.write("\n"); // forcer le passage à la ligne
            }

            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void saveClientes() {
        try {
            char separator = ';';
            File file = new File(".\\db\\clientes.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < Bar.getInstance().getClientes_f().size(); i++) {
                bw.write(Bar.getInstance().getClientes_f().get(i).getPrenom() + separator + Bar.getInstance().getClientes_f().get(i).getNom()
                        + separator + Bar.getInstance().getClientes_f().get(i).getPorte_monnaie() + separator
                        + Bar.getInstance().getClientes_f().get(i).getPopularite() + separator + Bar.getInstance().getClientes_f().get(i).getCri()
                        + separator + Bar.getInstance().getClientes_f().get(i).getBoissonFav1() + separator
                        + Bar.getInstance().getClientes_f().get(i).getBoissonFav2() + separator + Bar.getInstance().getClientes_f().get(i).getNiveauAlcool()
                        + separator + Bar.getInstance().getClientes_f().get(i).getNb_bijoux());
                // écrire une ligne dans le fichier clients.txt
                bw.write("\n"); // forcer le passage à la ligne
            }

            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveServeurs() {
        try {
            char separator = ';';
            File file = new File(".\\db\\serveurs.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < Bar.getInstance().getServeurs_m().size(); i++) {
                bw.write(Bar.getInstance().getServeurs_m().get(i).getPrenom() + separator + Bar.getInstance().getServeurs_m().get(i).getNom()
                        + separator + Bar.getInstance().getServeurs_m().get(i).getPorte_monnaie()
                        + separator + Bar.getInstance().getServeurs_m().get(i).getPopularite() + separator + Bar.getInstance().getServeurs_m().get(i).getCri()
                        + separator + Bar.getInstance().getServeurs_m().get(i).getBoisson().getName() + separator + Bar.getInstance().getServeurs_m().get(i).getTailleBiceps());
                // écrire une ligne dans le fichier clients.txt
                bw.write("\n"); // forcer le passage à la ligne
            }

            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveServeuses() {
        try {
            char separator = ';';
            File file = new File(".\\db\\serveuses.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            for (int i = 0; i < Bar.getInstance().getServeuses_f().size(); i++) {
                bw.write(Bar.getInstance().getServeuses_f().get(i).getPrenom() + separator + Bar.getInstance().getServeuses_f().get(i).getNom()
                        + separator + Bar.getInstance().getServeuses_f().get(i).getPorte_monnaie()
                        + separator + Bar.getInstance().getServeuses_f().get(i).getPopularite() + separator + Bar.getInstance().getServeuses_f().get(i).getCri()
                        + separator + Bar.getInstance().getServeuses_f().get(i).getBoisson().getName() + separator + Bar.getInstance().getServeuses_f().get(i).getCoeffCharme());
                // écrire une ligne dans le fichier clients.txt
                bw.write("\n"); // forcer le passage à la ligne
            }
            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveStock() {
        try {
            char separator = ';';
            File file = new File(".\\db\\stocks.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < Bar.getInstance().getStock().getBoissons().size(); i++) {
                bw.write(Bar.getInstance().getStock().getBoissons().get(i).getName() + separator + Bar.getInstance().getStock().getQuantites().get(i));
                // écrire une ligne dans le fichier clients.txt
                bw.write("\n"); // forcer le passage à la ligne
            }
            // écrire une ligne dans le fichier clients.txt
            bw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {
        }
    }

    private void saveBar() {
        try {
            char separator = ';';
            File file = new File(".\\db\\bar.txt"); // définir l'arborescence
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(Float.toString(Bar.getInstance().getCaisse().getCaisse()));
            bw.write("\n");
            bw.write(Integer.toString(Bar.getInstance().getTables().size()));
            // écrire une ligne dans le fichier clients.txt
            bw.close(); // fermer le fichier à la fin des traitements
        } catch (IOException e) {
        }
    }
}
