/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

/**
 *
 * @author Louis
 */
public enum Color {
    ROUGE("ROUGE"),
    BlEU("BLEU"),
    NOIR("NOIR"),
    VERT("VERT"),
    JAUNE("JAUNE"),
    BLANC("BLANC"),
    GRIS("GRIS"),
    ORANGE("ORANGE"),
    VIOLET("VIOLET"),
    CYAN("CYAN"),
    MARRON("MARRON");

    String name;

    private Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
