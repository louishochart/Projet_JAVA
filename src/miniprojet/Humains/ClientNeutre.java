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

    private Boisson boissonFav1;
    private Boisson boissonFav2;
    private float niveauAlcool;
    private boolean exclu = false;
    private Table table;
    boolean player = false;
    private List<ArrayList> mainJoueur = new ArrayList<>();

    protected ClientNeutre(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool) {
        super(prenom, nom, porte_monnaie, popularite, cri);
        this.boissonFav1 = boisson_fav_1;
        this.boissonFav2 = boisson_fav_2;
        this.niveauAlcool = niveau_alcool;

    }

    public void boire(Boisson boisson) {
        if (this.canPay(boisson,1)) {
            this.payer(Bar.getInstance().getBarman(),boisson.getPrixVente());
            Bar.getInstance().getStock().removeFromStock(boisson, 1);
            this.setNiveauAlcool(this.getNiveauAlcool() + boisson.getDegree());
            this.parler("Je bois un verre de " + boisson.getName());
            if(this.getNiveauAlcool()>1){
                Bar.getInstance().getPatronne().parlerDestinataire(Bar.getInstance().getBarman(),"Ne sers plus "+this.prenom+" "+this.getNom()+", il n'est plus en état");
            }
        } else {
            this.parler("Je n'ai pas assez d'argent");
        }
    }

    public void commander(Boisson boisson) {
        this.parler("Barman ! Sers moi un verre de "+boisson.getName());
        if(this.getNiveauAlcool()>1.1){
            Bar.getInstance().getPatronne().exclure(this);
        }
        else{
            if (Bar.getInstance().getStock().getStock(this.getBoissonFav1()) > 0) {
                this.boire(boisson);
            } else {
                Bar.getInstance().getBarman().parler("Il n'y a plus de " + boisson.getName());
            }
        }
    }

    public void recevoirVerre(Humain expediteur, Boisson boisson) {
        Bar.getInstance().getStock().removeFromStock(boisson, 1);
        this.setNiveauAlcool(this.getNiveauAlcool() + boisson.getDegree());
        this.parlerDestinataire(expediteur, "Merci beaucoup !");
        
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

    public List<ArrayList> getMainJoueur() {
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
