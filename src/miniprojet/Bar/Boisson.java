/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Bar;

import miniprojet.Bar.*;
import miniprojet.*;

/**
 *
 * @author Louis
 */
public enum Boisson {
    // nom('de cb va augmenter le taux avec un verre','prix achat','prix vente')
    CIDRE("CIDRE", 0.05f, 0.5f, 1.55f),
    BIERE("BIERE", 0.15f, 1.2f, 2f),
    VIN("VIN", 0.2f, 2f, 6f),
    WHISKY("WHISKY", 0.3f, 3.5f, 8f),
    GIN("GIN", 0.4f, 3.5f, 8f),
    VODKA("VODKA", 0.4f, 2.5f, 7.5f),
    RHUM("RHUM", 0.45f, 2.75f, 7.75f),
    TEQUILA("TEQUILA", 0.25f, 1.75f, 6f),
    EAU("EAU", 0, 0.1f, 0.5f),
    JUSDEFRUIT("JUSDEFRUIT", 0, 0.3f, 1f),
    CAFE("CAFE", 0, 0.1f, 0.35f),
    SODA("SODA", 0, 0.2f, 0.9f);

    private final String name;
    private final float degree;
    private final float prixAchat;
    private final float prixVente;

    private Boisson(String name, float degree, float prixAchat, float prixVente) {
        this.name = name;
        this.degree = degree;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
    }

    public String getName() {
        return this.name;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public float getDegree() {
        return degree;
    }

}
