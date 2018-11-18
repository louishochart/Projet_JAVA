/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;

/**
 *
 * @author Louis
 */
public enum Color {
    RED("RED"),
    BlUE("BLUE"),
    BLACK("BLACK"),
    GREEN("GREEN"),
    YELLOW("YELLOW"),
    WHITE("WHITE"),
    GREY("GREY"),
    ORANGE("ORANGE"),
    BROWN("BROWN");
    
    String name;

    private Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
