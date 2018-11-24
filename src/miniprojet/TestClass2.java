/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojet;
import miniprojet.president.*;

/**
 *
 * @author Louis
 */
public class TestClass2 {
    public void test2(){
        Paquet newpaquet=new Paquet();
        System.out.println(newpaquet.getCartes());
        newpaquet.coupe(1);
        System.out.println(newpaquet.getCartes());
        newpaquet.bat();
        System.out.println(newpaquet.getCartes());
    }
}
