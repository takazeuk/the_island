/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import ImagePanel.ImPan;
import UI.Int;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import joueurs.joueurs;
import partie.partie;
import terrain.tuiles;
import unités.unités;

/**
 *
 * @author TakazeukJo
 */
public class The_island {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner clavier= new Scanner(System.in);
        int nb;
   
        do
        {
            System.out.println("Combien de participants ? (4 maximums)");
            nb= clavier.nextInt();
            if(nb <= 4)
            {
               partie partie = new partie(nb); 
            }
            else
            {
                System.out.println("nombre de joueurs trop grand");
            }
        }
        while(nb > 4);
        
        
    }   
}
