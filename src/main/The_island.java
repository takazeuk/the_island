/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import ImagePanel.GrosPanel;
import MessageBox.Interaction;
import static MessageBox.Interaction.messageJoueur;
import UI.Int;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import joueurs.joueurs;
import partie.partie;
import terrain.tuiles;
import unités.explorateurs;
import unités.monstres;
import unités.unites;

/**
 * 
 *
 * @author TakazeukJo
 */
public class The_island {

    /**
     * @param args the command line arguments
     */
    public int choixCreature=0;
    
    public static void main(String[] args) throws IOException {
        
        
        //Scanner clavier= new Scanner(System.in);
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
            partie.participant.add(participant);
            partie.creationExplorateur(participant);
        }
                
        //on crée le plateau de jeu
        partie.creationPlateau();
        
        //on met en place les monstres de départ
        partie.miseEnPlaceMonstre();
        int i=0;
        for (tuiles tuile : partie.carte) {
            System.out.println("case n"+i+" x= " +tuile.x+" y= "+tuile.y+" type= "+tuile.type+"" );
            i++;
        }
        
        
        //partie déploiement des pions par les joueurs
        messageJoueur("Phase de déploiement, tous les joueurs vont placer leurs explorateurs sur l'île");
        messageJoueur(partie.participant.get(0).nom+" , vous êtes le premier joueur, vous devez placer un pion sur l'ile, sur une case non occupée par un autre joueur");       
        while(partie.participant.get(nb-1).membresDeploiement.size()!=0){
            //on bloque le code tant que tous les pions n'ont pas été placés.
        }
        
        //partie déploiement des bateaux par les joueurs
        messageJoueur("phase de déploiement des explorateurs terminée, nous allons passé à la phase de déploiement des bateaux");
        messageJoueur(partie.participant.get(0).nom+" , vous êtes le premier joueur, vous devez placer un bateau sur une case d'eau non occupée et voisine à une case terrain");
        while(partie.participant.get(nb-1).bateauxDeploiement!=0){
            //on bloque le code tant que tous les bateaux n'ont pas été placés.
        }
        
        
        //partie déplacement des explorateurs/bateaux
        messageJoueur("phase de deplacement: "+partie.participant.get(partie.tourJoueur).nom+" selectionnez une unité à déplacer (un de vos explorateurs ou un bateau que vous controlez ou qui est controler par personne");   
        while(partie.flagDeplacement!=1){
            //on bloque le code tant que le joueur n'a pas sélectionné une tuile
        }
        messageJoueur("selectionnez maintenant une case de destination");
        while(partie.participant.get(nb-1).bateauxDeploiement!=0){
            //on bloque le code tant que le joueur n'a pas sélectionné une tuile
        }
        
        //partie de lancé de dés
        partie.deeCreature();
        
        /*
        //partie.miseEnPlaceDesPetitPanel();
        //partie.essai();
        explorateurs test = new explorateurs(10, 2, 3, 0);
        //partie.carte.get(6).explorateurs.add(test);
        partie.ajoutEplorateursTuile(partie.carte.get(132), test);
        */      
    }   
}

