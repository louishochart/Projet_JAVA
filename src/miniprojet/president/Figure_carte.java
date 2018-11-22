/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.president;

/**
 *
 * @author ISEN
 */
public enum Figure_carte {
    
    DEUX("DEUX"),
    TROIS("TROIS"),
    QUATRE("QUATRE"),
    CINQ("CINQ"),
    SIX("SIX"),
    SEPT("SEPT"),
    HUIT("HUIT"),
    NEUF("NEUF"),
    DIX("DIX"),
    VALET("VALET"),
    DAME("DAME"),
    ROI("ROI"),
    AS("AS");
    
    String figure;

    private Figure_carte(String figure) {
        this.figure = figure;
    }
    
    public String getFigure() {
        return figure;
    }

}
