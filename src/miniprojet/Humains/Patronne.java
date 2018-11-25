/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet.Humains;

import miniprojet.Bar.*;
import miniprojet.Fonctions.Random;

/**
 *
 * @author Louis
 */
public class Patronne extends Cliente {

    public Patronne(String prenom, String nom, double porte_monnaie, int popularite, String cri, Boisson boisson_fav_1, Boisson boisson_fav_2, float niveau_alcool, int nb_bijoux) {
        super(prenom, nom, porte_monnaie, popularite, cri, boisson_fav_1, boisson_fav_2, niveau_alcool, nb_bijoux);

    }

    public Patronne() {
        super(new Random().getRandomPrenom_f(), new Random().getRandomNom(), new Random().getRandomPorteMonnaie(), new Random().getRandomPopularite(), new Random().getRandomCri(), new Random().getRandomBoisson(), new Random().getRandomBoisson(), 0f, (int) Math.random() * 10);
    }

    public void exclure(ClientNeutre client) {
        this.parlerDestinataire(Bar.getInstance().getBarman(),"Fous "+client.getPrenom()+" "+client.getNom()+" dehors !");
        Bar.getInstance().getBarman().parlerDestinataire(client,"Dehors ! Je ne veux plus te voir dans ce bar ce soir ");
        client.setExclu(true);
        for(int i = 0 ; i < Bar.getInstance().getSimulation().getClients().size();i++){
            if(client.equals(Bar.getInstance().getSimulation().getClients().get(i))){
                Bar.getInstance().getSimulation().getClients().remove(Bar.getInstance().getSimulation().getClients().get(i));
                Bar.getInstance().getSimulation().getClients().get(i).setTable(new Table());
                for(int j = 0 ; j < Bar.getInstance().getSimulation().getTables().size();j++){
                    for(int k = 0 ; k < Bar.getInstance().getSimulation().getTables().get(j).getClients().size();k++ ){
                        if(client.equals(Bar.getInstance().getSimulation().getTables().get(j).getClients().get(k))){
                            Bar.getInstance().getSimulation().getTables().get(j).getClients().remove(Bar.getInstance().getSimulation().getTables().get(j).getClients().get(k));
                        }
                    }
                }
            }
        }
    }
    
    public void verifierCaisse(){
        if(Bar.getInstance().getCaisse().getCaisse()>100){
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
