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
import UI.carteEnMain;
import java.awt.Color;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        lancementPartie();
        
    }
    
    public static void lancementPartie() throws IOException
    {
        
        String Newligne=System.getProperty("line.separator"); 
        int nb = 3;
        String nom;
        boolean b = false;
        //lancement de la partie avec la demande du nombre de joueur. On vérifie que le nombre de joueur ne dépasse pas 4
        do
        {
            try{
		nb = Integer.parseInt(""+Interaction.demandeChoix("Bienvenue dans The Island, Combien d'aventuriers seront dans la partie ? (4 maximums)"));
                if(nb > 4)
                {
                    Interaction.affiche("nombre de joueurs trop grand");
                }
                else if(nb<2)
                {
                    Interaction.affiche("nombre de joueurs trop petit");
                }
                b = true;
            }catch ( NumberFormatException e ){
                Interaction.affiche("Le nombre de joueur doit etre un entier");
            }

            
            
        }
        while((nb > 4||nb<2) || b == false);
        
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
            if(i==0)
            {
                participant.couleurduJoueur = Color.RED;
            }
            else if (i==1)
            {
                participant.couleurduJoueur = Color.GREEN;
            }
            else if (i==2)
            {
                participant.couleurduJoueur = Color.PINK;
            }
            else
            {
                participant.couleurduJoueur = Color.YELLOW;
            }
        }
                
        //on crée le plateau de jeu
        partie.creationPlateau();
        // Autoriser le retour à la ligne
        partie.mine.getjTextArea1().setLineWrap(true);
        // Interdir l'ecriture sur le textArea
        partie.mine.getjTextArea1().setEditable(false);
        //on met en place les monstres de départ
        partie.miseEnPlaceMonstre();
                     
        // test d'ajout d'une tuile
            //tuiles tuile= new tuiles(0,0,1,6, "toto");
            //tuiles tuile1= new tuiles(0,0,1,7, "tata");
            //tuiles tuile2= new tuiles(0,0,1,8, "titi");
            //tuiles tuile3= new tuiles(0,0,1,9, "tete");
            //partie.participant.get(partie.tourJoueur).cartesEnMain.add(tuile);
            //partie.participant.get(partie.tourJoueur).cartesEnMain.add(tuile1);
            //partie.participant.get(partie.tourJoueur).cartesEnMain.add(tuile2);
            //partie.participant.get(partie.tourJoueur).cartesEnMain.add(tuile3);*/
        
        //on désactive les deux boutons de cartes pour le moment
        partie.mine.activeBouton(false);
        MessageBox.Interaction.introduction("Vous dirigez de valeureux explorateurs en mission sur une île dangereuse dissimulant de fabuleux trésors.\n"
                + "Mais un volcan autrefois éteint a décidé de donner de la voix! La terre se met à trembler et l’île s’enfonce dans la mer.\n"
                + "Vous devez sauver un maximum de vos aventuriers pour remporter la partie.\n"
                + "Pour ce faire, ammenez vos explorateurs jusqu'au villages dans les 4 coins du plateau autour de l'île.\n"
                + "Bonne chance!");
        //partie déploiement des pions par les joueurs
        String s = "Phase de déploiement, tous les joueurs vont placer leurs explorateurs sur l'île";
        messageJoueur(s);
        partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+""+s+Newligne);
        messageJoueur(partie.participant.get(0).nom+" , vous êtes le premier joueur, vous devez placer un pion sur l'ile, sur une case non occupée par un autre joueur"); 
        while(partie.participant.get(nb-1).membresDeploiement.size()!=0){
            //on bloque le code tant que tous les pions n'ont pas été placés.
        }
        
        //partie déploiement des bateaux par les joueurs
        s = "phase de déploiement des explorateurs terminée, nous allons passé à la phase de déploiement des bateaux";
        messageJoueur(s);
        partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+""+s+Newligne);
        messageJoueur(partie.participant.get(0).nom+" , vous êtes le premier joueur, vous devez placer un bateau sur une case d'eau non occupée et voisine à une case terrain sur l'île principale");
        
        while(partie.participant.get(nb-1).bateauxDeploiement!=0){
            //on bloque le code tant que tous les bateaux n'ont pas été placés.
        }
               
        while (partie.partieTermine == 0) {
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(The_island.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            partie.mine.getjTextArea1().setBackground(partie.participant.get(partie.tourJoueur).couleurduJoueur);
            
            if ((partie.participant.get(partie.tourJoueur).cartesEnMain != null)&&(partie.participant.get(partie.tourJoueur).cartesEnMain.size() > 0 )) {
                s = "phase de tuile pouvoir: vous pouvez sélectionner une tuile à jouer dans la fenêtre carte en cliquant sur le bouton cartes en main";
                int value = MessageBox.Interaction.demandeChoixJoueur(s);
                partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
                if (value == JOptionPane.YES_OPTION)
                {
                    //on active les deux boutons utilisés pour les cartes
                    partie.mine.activeBouton(true);
                    while((partie.deplacmentExploBateau>0)&&(partie.mine.finMvt == false))
                    {
                        
                    }
                }
            }
            
            //on désactive les deux boutons de cartes
            partie.mine.activeBouton(false);
            // on remet à 3 les bonus déplacements donné par les cartes pour un bateau ou un nageur
            partie.deplacmentExploBateau = 3;
            //on remet finMvt à false pour la prochaine carte joué par un joueur
            partie.mine.finMvt = false;
            //on met flagAction à 2 pour permettre les déplacements
            partie.flagAction = 2;
            //on passe à la phase de déplacement
            s = "phase de deplacement: "+partie.participant.get(partie.tourJoueur).nom+" , selectionnez une unité à déplacer (un de vos explorateurs ou un bateau que vous controlez ou qui n'est controlé par aucun joueur";
            messageJoueur(s);
            partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
            while (partie.participant.get(partie.tourJoueur).deplacement!=0) {                
                //on bloque le joueur tant qu'il n'a pas fait tout ses déplacements
            }
            s = "vous avez effectué tous vos déplacements";
            messageJoueur(s);
            partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
            //on passe à la phase où l'on retire une tuile
            s = "vous devez retirer une tuile terrain: retirez une tuile adjacente à l'eau en commencant par les tuiles sables, puis forêt et enfin montagne."
                           + " Si les dernières tuiles d'un types ne sont pas adjacentes à l'eau, vous pouvez les retirer";
            messageJoueur(s);
            partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
            //on met le flagAction sur 4 pour passer à la phase retirer tuile terrain
            partie.flagAction = 4;
            while(partie.flagAction == 4)
            {
                
            }
            
            //on vérifie si la partie n'est pas terminée. Le volcan est un tuilePouvoir a effet immédiat, on n'aura donc pas besoin de déplacer les monstres
            if (partie.partieTermine == 0) {
                //phase de monstre
                //partie de lancé de dés pour définir quel monstre on va déplacer
                partie.deeCreature();
                boolean monstrePresent = false;
                monstres monstre;
                //on vérifie si le type de monstre obtenu en random est présent sur le plateau
                for (unites unitetotale : partie.population) {
                    if (unitetotale instanceof monstres) {
                        monstre = (monstres) unitetotale;
                        if (monstre.type == partie.choixMonstre) {
                            monstrePresent = true;
                        }
                    }
                }

                if (monstrePresent) {
                    s = "Vous pouvez déplacer un monstre de type: " + partie.typeMonstre(partie.choixMonstre) + " , seléctionnez un monstre correspondant";
                    messageJoueur(partie.participant.get(partie.tourJoueur).nom + " , vous pouvez déplacer un monstre de type: " + partie.typeMonstre(partie.choixMonstre) + " , seléctionnez un monstre correspondant");
                    partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
                } 
                else {
                    s = "Le monstre tiré au sort est de type: " + partie.typeMonstre(partie.choixMonstre) + ". Mais il n'y en a pas sur la carte, nous allons donc passé à la prochaine phase de jeu";
                    messageJoueur(partie.participant.get(partie.tourJoueur).nom + ", le monstre tiré au sort est de type: " + partie.typeMonstre(partie.choixMonstre) + ". Mais il n'y en a pas sur la carte, nous allons donc passé à la prochaine phase de jeu");
                    partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
                }

                while (((partie.monstreDeplace == null) || (partie.deplacmentMonstre != partie.monstreDeplace.deplacement)) && (monstrePresent == true)) {
                    //on bloque le joueur tant qu'il n'a pas fait tout les déplacements du monstres
                }
                s = "vous avez effectué tous les déplacements de votre monstre";
                
                if (monstrePresent) {
                    messageJoueur(s);
                }
                partie.mine.getjTextArea1().setText(partie.mine.getjTextArea1().getText()+partie.participant.get(partie.tourJoueur).nom+"   "+s+Newligne);
                //on remet à zéro les capacités de déplacement
                partie.participant.get(partie.tourJoueur).deplacement = 3;
                partie.flagDeplacement = 0;
                partie.deplacmentMonstre = 0;

                //on passe au joueur suivant
                if (partie.tourJoueur == partie.participant.size() - 1) {

                    partie.tourJoueur = 0;
                }
                else {
                    partie.tourJoueur++;
                }

                partie.flagAction = 2;
            }   
        }
    }
}
