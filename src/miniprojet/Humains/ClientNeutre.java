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
 *
 * @author Louis
 */
public abstract class ClientNeutre extends Humain {

    private Boisson boisson_fav_1;
    private Boisson boisson_fav_2;
    private float niveau_alcool;
    private boolean exclu = false;
    private Table table;
    boolean player = false;
    private List<Carte> mainJoueur = new ArrayList();

    protected ClientNeutre(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.boisson_fav_1 = boisson_fav_1;
        this.boisson_fav_2 = boisson_fav_2;
        this.niveau_alcool = niveau_alcool;

    }

    public void boire(Boisson boisson) {
        if (this.canPay(boisson,1)) {
            this.payer(Bar.getInstance().getBarman(),boisson.getPrixVente());
            Bar.getInstance().getStock().removeFromStock(boisson, 1);
            this.setNiveau_alcool(this.getNiveau_alcool() + boisson.getDegree());
            this.parler("Je bois un verre de " + boisson.getName());
        } else {
            this.parler("Je n'ai pas assez d'argent");
        }
    }

    public void commander() {
        if (Bar.getInstance().getStock().getStock(this.getBoisson_fav_1()) > 0) {
            this.boire(this.getBoisson_fav_1());

        } else if (Bar.getInstance().getStock().getStock(this.getBoisson_fav_2()) > 0) {
            this.boire(getBoisson_fav_2());
        }
    }

    public void recevoirVerre(Humain expediteur, Boisson boisson) {
        Bar.getInstance().getStock().removeFromStock(boisson, 1);
        this.setNiveau_alcool(this.getNiveau_alcool() + boisson.getDegree());
        this.parlerDestinataire(expediteur, "Merci beaucoup !");
        
    }
    
    
    public void sePresenter(){
        this.parler("Salut, c'est moi");
    }
    
    
    public Boisson getBoisson_fav_1() {
        return boisson_fav_1;
    }

    public Boisson getBoisson_fav_2() {
        return boisson_fav_2;
    }

    public float getNiveau_alcool() {
        return niveau_alcool;
    }

    public List<Carte> getMainJoueur() {
        return this.mainJoueur;
    }

    public Table getTable() {
        return table;
    }

    public boolean isExclu() {
        return exclu;
    }

    public void setBoisson_fav_1(Boisson boisson_fav_1) {
        this.boisson_fav_1 = boisson_fav_1;
    }

    public void setBoisson_fav_2(Boisson boisson_fav_2) {
        this.boisson_fav_2 = boisson_fav_2;
    }

    public void setNiveau_alcool(float niveau_alcool) {
        this.niveau_alcool = niveau_alcool;
    }

    public void setExclu(boolean exclu) {
        this.exclu = exclu;
    }

    public void setTable(Table table) {
        this.table = table;
    }

}
