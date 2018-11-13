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
public class Human {
    private String firstname;
    private String surname;
    private float wallet;
    private float popularity;
    private String shout;

    public Human(String firstname, String surname, float wallet, float popularity, String shout) {
        this.firstname = firstname;
        this.surname = surname;
        this.wallet = wallet;
        this.popularity = popularity;
        this.shout = shout;
    }
    

    
    
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public void setShout(String shout) {
        this.shout = shout;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public float getWallet() {
        return wallet;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getShout() {
        return shout;
    }
    
    public void speak(){
        
    }
    public void drink(){
    
    }
    public void pay(){
        
    }
    public void offerdrink(){
        
    }
    public void introduceys(){
        
    }
}
