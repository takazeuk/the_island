/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import ImagePanel.ImPan;
import MessageBox.Interaction;
import UI.Int;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import joueurs.joueurs;
import partie.partie;
import terrain.tuiles;
import unités.unites;

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
            nb = Interaction.demandeChoix("Combien de participants à la partie ? (4 maximums)");
            //System.out.println("Combien de participants à la partie ? (4 maximums)");
            //nb = clavier.nextInt();
            if(nb > 4)
            {
                Interaction.affiche("nombre de joueurs trop grand");
               //System.out.println("nombre de joueurs trop grand");
            }
            else if(nb<2)
            {
                Interaction.affiche("nombre de joueurs trop petit");
            }
        }
        while(nb > 4||nb<2);
        
        //on crée la classe partie pour accèder à nos fonctions de jeu
        partie partie = new partie(nb);
        
        //on crée nos joueurs
        for(int i=0; i<nb; i++)
        {
            nom = Interaction.demandeChaine("Joueur "+(i+1)+" ,quel sera votre nom?");
            //System.out.println("Joueur "+(i+1)+" ,quel sera votre nom?");
            // nom= clavier.next();
            joueurs participant= new joueurs(nom, i);
            partie.creationExplorateur(participant);
        }
                
        //on crée le plateau de jeu
        partie.creationPlateau();
        
        
    }   
}
