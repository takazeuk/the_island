/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import MessageBox.Interaction;
import static MessageBox.Interaction.messageJoueur;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import joueurs.joueurs;
import partie.partie;
import terrain.tuiles;
import unités.bateaux;

/**
 *
 * @author Jonathan
 */
public class MoustenerGrosPanel extends MouseAdapter
{
    int x;
    int y;
    GrosPanel selctionPanel;
    partie partieEnCours;
    
    public MoustenerGrosPanel(GrosPanel p, partie part)
    {
        x = p.j;
        y = p.k;
        selctionPanel= p;
        partieEnCours= part;
    }
       
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        boolean placementValide = false;
        tuiles placement;               
        joueurs joueur= partieEnCours.participant.get(partieEnCours.tourJoueur);
        placement= selctionPanel.terrain;
        

            if(partieEnCours.flagAction==0){               
                try {
                placementValide=partieEnCours.deploiementExplorateurs(joueur, joueur.membresDeploiement.get(0), placement);
                } catch (IOException ex) {
                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (placementValide) {
                   joueur.membresDeploiement.remove(0);
                   partieEnCours.tourJoueur++;
                    if (partieEnCours.tourJoueur==partieEnCours.participant.size()) {
                        partieEnCours.tourJoueur=0;
                    }
                    
                    if (partieEnCours.participant.get(partieEnCours.tourJoueur).membresDeploiement.size()!=0) {
                       messageJoueur(partieEnCours.flagAction+""+partieEnCours.participant.get(partieEnCours.tourJoueur).nom+" , c'est à vous de placer un explorateur");
                    }
                    else
                    {
                        partieEnCours.flagAction=1;
                    }                   
                }
            }
            if(partieEnCours.flagAction==1){               
                try {
                placementValide=partieEnCours.deploiementBateaux(selctionPanel.terrain);
                } catch (IOException ex) {
                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if (placementValide) {
                   joueur.bateauxDeploiement--;
                   partieEnCours.tourJoueur++;
                    if (partieEnCours.tourJoueur==partieEnCours.participant.size()) {
                        partieEnCours.tourJoueur=0;
                    }
                    
                    if (partieEnCours.participant.get(partieEnCours.tourJoueur).bateauxDeploiement!=0) {
                       messageJoueur(partieEnCours.participant.get(partieEnCours.tourJoueur).nom+" , c'est à vous de placer un bateau");
                    }
                    else
                    {
                        partieEnCours.flagAction=2;
                    } 
                }
            }
            if (partieEnCours.flagAction==2) {
                boolean testDeplacement=partieEnCours.exploDeplace.deplacement(selctionPanel.terrain);
                if (testDeplacement) {
                    placement.explorateurs.add(partieEnCours.exploDeplace);
                    try {
                        partieEnCours.affichageExplorateurs(placement, partieEnCours.exploDeplace);
                    } catch (IOException ex) {
                        Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
    }		
}
