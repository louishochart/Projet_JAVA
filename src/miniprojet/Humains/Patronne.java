/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Bar.*;
import miniprojet.Fonctions.Random;

/**
 * L'objet Patronne hérité de l'objet Cliente
 */
public class Patronne extends Cliente {
    
    /**
     * Constructeur
     * @param prenom
     * @param nom
     * @param porte_monnaie
     * @param popularite
     * @param cri
     * @param boisson_fav_1
     * @param boisson_fav_2
     * @param niveau_alcool
     * @param nb_bijoux 
     */
    public Patronne(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool, int nb_bijoux) {
        super(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, nb_bijoux);

    }
    /**
     * Constructeur aléatoire
     */
    public Patronne() {
        super(new Random().getRandomPrenom_f(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri(), new Random().getRandomBoisson(), new Random().getRandomBoisson(), 0f, (int) Math.random() * 10);
    }
    /**
     * Permet à la patronne d'exclure un client du bar s'il commande après s'être fait dire d'arrêter
     * @param client 
     */
    public void exclure(ClientNeutre client) {
        this.parlerDestinataire(Bar.getInstance().getBarman(),"Fous "+client.getPrenom()+" "+client.getNom()+" dehors !");
        Bar.getInstance().getBarman().parlerDestinataire(client,"Dehors ! Je ne veux plus te voir dans ce bar ce soir ");
        client.setExclu(true);
        for(int i = 0 ; i < Bar.getInstance().getSimulation().getClients().size();i++){
            if(client.equals(Bar.getInstance().getSimulation().getClients().get(i))){
                Bar.getInstance().getSimulation().getClients().get(i).setTable(new Table());
                Bar.getInstance().getSimulation().getClients().remove(Bar.getInstance().getSimulation().getClients().get(i));              
                for(int j = 0 ; j < Bar.getInstance().getSimulation().getTables().size();j++){
                    for(int k = 0 ; k < Bar.getInstance().getSimulation().getTables().get(j).getClients().size();k++ ){
                        if(client.equals(Bar.getInstance().getSimulation().getTables().get(j).getClients().get(k))){
                            Bar.getInstance().getSimulation().getTables().get(j).getClients().remove(Bar.getInstance().getSimulation().getTables().get(j).getClients().get(k));
                        }
                    }
                }
                Bar.getInstance().getSimulation().getExclus().add(client);
                Bar.getInstance().getSimulation().getExclush().add(client);
            }
        }
    }
    /**
     * Permet à la patronne d'offrir une tournée générales
     * @param boisson 
     */
    public void offrirTournee(Boisson boisson) {       
        this.parler("Un verre de "+boisson.getName()+" pour tout le monde! Offert par la maison ! ");
        if(Bar.getInstance().getStock().getStock(boisson)>Bar.getInstance().getSimulation().getClients().size()){
            this.addPopularite(20);
            for (int i = 0 ; i < Bar.getInstance().getSimulation().getClients().size();i++){
                Bar.getInstance().getSimulation().getClients().get(i).recevoirVerre(this, boisson);
                Bar.getInstance().getSimulation().getClients().get(i).parler(Bar.getInstance().getSimulation().getClients().get(i).getCri());
            }                
            Bar.getInstance().getBarman().parler("TOURNEE GENERALE");
            Bar.getInstance().getPatronne().parler("Les affaires reprennent");

        }
        else{
            Bar.getInstance().getBarman().parler("Il n'y a pas assez de " + boisson.getName());
        }
    }
    /**
     * Permet à la patronne d'offrir un verre
     * @param destinataire
     * @param boisson 
     */
    public void offrirVerre(Humain destinataire, Boisson boisson) {        
        this.parlerDestinataire(destinataire, "Je t'offre un verre de " + boisson.getName());
        if(Bar.getInstance().getStock().getStock(boisson)>0){
            this.addPopularite(5);
            destinataire.recevoirVerre(this, boisson);
        }
        else{
            Bar.getInstance().getBarman().parler("Il n'y a plus de "+boisson.getName());
        }

    }
    /**
     * Permet à la patronne de vérifier la caisse à chaque fin d'heure et de récupérer le trop
     */
    public void verifierCaisse(){
        if(Bar.getInstance().getCaisse().getCaisse()>100){
            System.out.println("je verifie la caisse");
            this.recupererArgent(Bar.getInstance().getCaisse().getCaisse()-100);
        }
    }
    private void recupererArgent(float cash) {
        Bar.getInstance().getCaisse().removeCaisse(cash);
        this.porte_monnaie+=cash;
    }
    


    @Override
    public String toString() {
        return "Patronne{ Prenom: " + this.getPrenom() + " , Surnom : " + this.getNom() + " , Porte Monnaie : " + this.getPorte_monnaie()
                + " , Popularité : " + this.getPopularite() + " , Cri : " + this.getCri() + " , boisson_fav_1 : " + this.getBoissonFav1() + " , boisson_fav_2 : "
                + this.getBoissonFav2() + " , niveau_alcool : " + this.getNiveauAlcool() + " , nombre_bijoux : " + this.getNb_bijoux() + '}';
    } 
}
