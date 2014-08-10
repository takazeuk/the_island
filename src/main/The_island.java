/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import terrain.newpackage.tuiles;
import partie.newpackage.partie;

/**
 *
 * @author TakazeukJo
 */
public class The_island {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        partie partie = new partie();
        
        int cpt=0;
        
        for (int i = 0; i < 16; i++) {
            
            for (int j = 0; j < 13; j++) {
                tuiles tuiles= new tuiles(i, j, 0, 0);
                //partie.carte.add(tuiles);
                System.out.println("tuiles générés"+tuiles.x+""+tuiles.y);
                /* pour calculer le nombre de tuile*/cpt++;
            }
            
        }
        
        System.out.println(cpt);
    }
    
}
