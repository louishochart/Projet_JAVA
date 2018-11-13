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
public class Client extends Human {

    private String favoritedrink;
    private String favoritedrink2;
    private float alcohollevel;
    

    public Client(String firstname, String surname, float wallet, float popularity, String shout, String favoritedrink, String favoritedrink2, float alcohollevel) {
        super(firstname,surname,wallet,popularity,shout);
        this.favoritedrink = favoritedrink;
        this.favoritedrink2 = favoritedrink2;
        this.alcohollevel = alcohollevel;
    }

    public void setFavoritedrink(String favoritedrink) {
        this.favoritedrink = favoritedrink;
    }

    public void setFavoritedrink2(String favoritedrink2) {
        this.favoritedrink2 = favoritedrink2;
    }

    public void setAlcohollevel(float alcohollevel) {
        this.alcohollevel = alcohollevel;
    }

    public String getFavoritedrink() {
        return favoritedrink;
    }

    public String getFavoritedrink2() {
        return favoritedrink2;
    }

    public float getAlcohollevel() {
        return alcohollevel;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" : ( Firstname : "+this.getFirstname()+", Surname : "+this.getSurname()+", Wallet : "
                +this.getWallet()+", Popularity : "+this.getPopularity()+", Shout : "+this.getShout() +", favoritedrink=" 
                + favoritedrink + ", favoritedrink2 : " + favoritedrink2 + ", alcohollevel : " + alcohollevel + " )";
    }
    
    
    
    public void getFreeDrink(){
        
    }
    public void introduceysother(){
        
    }
}
