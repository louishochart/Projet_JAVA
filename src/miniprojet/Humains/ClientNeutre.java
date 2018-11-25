package miniprojet.Humains;

import java.util.ArrayList;
import java.util.List;
import miniprojet.Bar.*;
import miniprojet.president.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * l'objet ClientNeutre est la classe mère de l'objet Client et l'objet Cliente
 * Il regroupe toutes les actions et variables communes
 */
public abstract class ClientNeutre extends Humain {

    private Boisson boissonFav1;
    private Boisson boissonFav2;
    private float niveauAlcool;
    private boolean exclu = false;
    private Table table;
    boolean player = false;
    private List<ArrayList> mainJoueur = new ArrayList<>();

    /**
     * Constructeur de l'objet ClientNeutre
     * @param prenom
     * @param nom
     * @param porte_monnaie
     * @param popularite
     * @param cri
     * @param boisson_fav_1
     * @param boisson_fav_2
     * @param niveau_alcool 
     */
    protected ClientNeutre(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.boissonFav1 = boisson_fav_1;
        this.boissonFav2 = boisson_fav_2;
        this.niveauAlcool = niveau_alcool;

    }
    /**
     * Permet à un client de boire un verre d'une boisson donnée
     * @param boisson 
     */
    public void boire(Boisson boisson) {
        if (this.canPay(boisson,1)) {
            this.payer(Bar.getInstance().getBarman(),boisson.getPrixVente());
            Bar.getInstance().getStock().removeFromStock(boisson, 1);
            this.setNiveauAlcool(this.getNiveauAlcool() + boisson.getDegree());
            this.parler("Je bois un verre de " + boisson.getName());
            Bar.getInstance().getSimulation().incrementVerresBus();
            if(this.getNiveauAlcool()>1){
                Bar.getInstance().getPatronne().parlerDestinataire(Bar.getInstance().getBarman(),"Ne sers plus "+this.prenom+" "+this.getNom()+", il n'est plus en état");
            }
        } else {
            this.parler("Je n'ai pas assez d'argent");
        }
    }
    
    /**
     * Permet à un client de commander un verre d'une boisson donnée
     * @param boisson 
     */
    public void commander(Boisson boisson) {
        this.parler("Barman ! Sers moi un verre de "+boisson.getName());
        if(this.getNiveauAlcool()>1.1){
            Bar.getInstance().getPatronne().exclure(this);
        }
        else{
            if (Bar.getInstance().getStock().getStock(boisson) > 0) {
                this.boire(boisson);
            } else {
                Bar.getInstance().getBarman().parler("Il n'y a plus de " + boisson.getName());
            }
        }
    }
    /**
     * Permet à un client de recevoir un verre d'une boisson donnée
     * @param expediteur
     * @param boisson 
     */
    public void recevoirVerre(Humain expediteur, Boisson boisson) {
        Bar.getInstance().getStock().removeFromStock(boisson, 1);
        this.setNiveauAlcool(this.getNiveauAlcool() + boisson.getDegree());
        Bar.getInstance().getSimulation().incrementVerresOfferts();
        Bar.getInstance().getSimulation().incrementVerresBus();
        this.parlerDestinataire(expediteur, "Merci beaucoup !");
        
    }
    /**
     * permet à un client d'offrir une tournée générale
     * @param boisson 
     */
    public void offrirTournee(Boisson boisson) {
        if (this.canPay(boisson,Bar.getInstance().getSimulation().getClients().size())) {
            this.parler("Un verre de "+boisson.getName()+" pour tout le monde ! ");
            if(Bar.getInstance().getStock().getStock(boisson)>Bar.getInstance().getSimulation().getClients().size()){
                this.addPopularite(20);
                this.payer(Bar.getInstance().getBarman(),boisson.getPrixVente()*Bar.getInstance().getSimulation().getClients().size());
                for (int i = 0 ; i < Bar.getInstance().getSimulation().getClients().size();i++){
                    Bar.getInstance().getSimulation().getClients().get(i).recevoirVerre(this, boisson);
                    Bar.getInstance().getSimulation().getClients().get(i).parler(Bar.getInstance().getSimulation().getClients().get(i).getCri());
                }                
                Bar.getInstance().getBarman().parler("TOURNEE GENERALE");
                Bar.getInstance().getPatronne().parler("Les affaires reprennent");
                Bar.getInstance().getSimulation().getTournees().add(this);
                Bar.getInstance().getSimulation().getTourneesh().add(this);
                
            }
            else{
                Bar.getInstance().getBarman().parler("Il n'y a pas assez de " + boisson.getName());
            }
        }
    }
    
    
    public void sePresenter(){
        this.parler("Salut, c'est moi");
    }
    
    
    public Boisson getBoissonFav1() {
        return boissonFav1;
    }

    public Boisson getBoissonFav2() {
        return boissonFav2;
    }

    public float getNiveauAlcool() {
        return niveauAlcool;
    }

    public List<ArrayList> getMain() {
        return this.mainJoueur;
    }

    public Table getTable() {
        return table;
    }

    public boolean isExclu() {
        return exclu;
    }

    public void setBoissonFav1(Boisson boissonFav1) {
        this.boissonFav1 = boissonFav1;
    }

    public void setBoissonFav2(Boisson boissonFav2) {
        this.boissonFav2 = boissonFav2;
    }
    
    public void setNiveauAlcool(float niveauAlcool) {
        this.niveauAlcool = niveauAlcool;
    }

    public void setExclu(boolean exclu) {
        this.exclu = exclu;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
