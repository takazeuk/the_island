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
        String nom;
   
        //lancement de la partie avec la demande du nombre de joueur. On vérifie que le nombre de joueur ne dépasse pas 4
        do
        {
            System.out.println("Combien de participants à la partie ? (4 maximums)");
            nb= clavier.nextInt();
            if(nb > 4)
            {
               System.out.println("nombre de joueurs trop grand");
            }
        }
        while(nb > 4);
        
        //on crée la classe partie pour accèder à nos fonctions de jeu
        partie partie = new partie();
        
        //on crée nos joueurs
        for(int i=0; i<nb; i++)
        {
            System.out.println("Joueur "+(i+1)+" ,quel sera votre nom?");
            nom= clavier.next();
            joueurs participant= new joueurs(nom, i);
            partie.creationExplorateur(participant);
        }
                
        //on crée le plateau de jeu
        partie.creationPlateau();
        
        
    }   
}
