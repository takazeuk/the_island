/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import static MessageBox.Interaction.messageJoueur;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import joueurs.joueurs;
import partie.partie;
import unités.monstres;

/**
 *
 * @author Takazeuk
 */
public class MoustenerPetitPanel extends MouseAdapter
{
    PetitPanel selctionPanel;
    partie partieEnCours;
    
    public MoustenerPetitPanel(PetitPanel p, partie part)
    {
        this.selctionPanel= p;
        this.partieEnCours= part;
    }
       
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        System.out.println("grospanelDoitGererEvent  ="+grospanelDoitGereEvent());
        if (grospanelDoitGereEvent()) {
            System.out.println("je rentre dans grospanelDoitGererEvent ");
            selctionPanel.conteneur.clicDuPanel.mouseClicked(e);
            return;
        }
        messageJoueur(partieEnCours.flagAction+"clicPtitPanel");
        
        if (partieEnCours.flagAction==2) {
        
            joueurs joueur= partieEnCours.participant.get(partieEnCours.tourJoueur);
            
            //test pour l'explorateur
            if (this.selctionPanel.numeroUnite==joueur.couleur) {
                partieEnCours.exploDeplace= selctionPanel.conteneur.terrain.explorateurs.get(selctionPanel.numeroPetitPanel);
                partieEnCours.flagDeplacement=1;
                partieEnCours.flagAction=3;
                partieEnCours.origineExplorateur= selctionPanel.conteneur;
                partieEnCours.panelRefresh = selctionPanel;
                partieEnCours.panelRefresh.numeroUnite = 4;
                

                messageJoueur("explorateur séléctionné");
            }
            else if (this.selctionPanel.numeroPetitPanel==6) {
                System.out.println("je suis bien sur un bateau");
                if ((selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==partieEnCours.tourJoueur)||(selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==4)) {
                    System.out.println("je suis rentré dans le déplacement bateau");
                    partieEnCours.bateauDeplace= selctionPanel.conteneur.terrain.bateaux.get(0);
                    partieEnCours.flagDeplacement=1;
                    partieEnCours.flagAction=3;
                    partieEnCours.origineExplorateur= selctionPanel.conteneur;
                    partieEnCours.panelRefresh = selctionPanel;                    
                }
            }
            else
            {
              messageJoueur("vous ne pouvez pas sélectionner cette unité");
            }        
        }
        
        if (partieEnCours.flagAction==5) {
            System.out.println("je suis dans le déplacement des monstres");
            if (partieEnCours.choixMonstre!=selctionPanel.numeroUnite) {
                messageJoueur("vous ne pouvez pas sélectionner cette unité");
            }
            else
            {
                //on cherche dans le vecteur monstre celui qui correspond à celui que l'on peut déplacer
                for (monstres monstre : selctionPanel.conteneur.terrain.monstres) {
                    if (partieEnCours.choixMonstre==monstre.type) {
                        partieEnCours.monstreDeplace= monstre;
                    }
                }
                partieEnCours.flagAction=6;
                partieEnCours.origineExplorateur= selctionPanel.conteneur;
                partieEnCours.panelRefresh = selctionPanel;
                partieEnCours.panelRefresh.numeroUnite = 4;
                messageJoueur("monstre séléctionné");
            }
        }
    }
    
    //permet de ne pas prendre en compte le petitPanel quand le joueur doit cliquer sur le grosPanel
    private boolean grospanelDoitGereEvent() {
        if ((partieEnCours.flagAction != 2)&&(partieEnCours.flagAction != 5)) {
            return true;
        }
        return false;
    }
}
