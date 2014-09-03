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
import unités.explorateurs;
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
        
        if (partieEnCours.flagAction==2) {
        
            boolean flagDeplacementbateau = true;
            joueurs joueur= partieEnCours.participant.get(partieEnCours.tourJoueur);
            
            //test pour l'explorateur
            if (this.selctionPanel.numeroUnite==joueur.couleur) {
                partieEnCours.exploDeplace= selctionPanel.conteneur.terrain.explorateurs.get(selctionPanel.numeroPetitPanel);
                partieEnCours.flagDeplacement=1;
                partieEnCours.flagAction=3;
                partieEnCours.origineExplorateur= selctionPanel.conteneur;
                partieEnCours.panelRefresh = selctionPanel;
                // je l'ai changé de place!! partieEnCours.panelRefresh.numeroUnite = 4;
                
                messageJoueur("explorateur séléctionné selectionnez maintenant une case de destination");
            }
            else if ((this.selctionPanel.numeroPetitPanel==6)&&(selctionPanel.conteneur.terrain.bateaux.size()!=0)) {
                if ((selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==partieEnCours.participant.get(partieEnCours.tourJoueur).couleur)||(selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==4)) {
                    if(selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==4 && selctionPanel.conteneur.terrain.bateaux.get(0).marins.size()>0)
                    {
                             flagDeplacementbateau = false;
                                for (explorateurs explo : selctionPanel.conteneur.terrain.bateaux.get(0).marins) {
                                    if(explo.proprietaire == partieEnCours.participant.get(partieEnCours.tourJoueur).couleur)
                                    {
                                        flagDeplacementbateau = true;
                                    }
                                }   
                    }
                    if(flagDeplacementbateau)
                    {
                        messageJoueur("Vous ppouvez déplacer ce bateau");
                        partieEnCours.bateauDeplace= selctionPanel.conteneur.terrain.bateaux.get(0);
                        partieEnCours.flagDeplacement=1;
                        partieEnCours.flagAction=3;
                        partieEnCours.origineExplorateur= selctionPanel.conteneur;
                        partieEnCours.panelRefresh = selctionPanel;

                        messageJoueur("bateau séléctionné, selectionné maintenant une case de destination");
                    }
                    else
                    {
                        messageJoueur("Vous n'etes pas propriétaire de ce bateau");
                    }
                }
                else
                {
                    messageJoueur("Vous n'etes pas propriétaire de ce bateau");
                }
                
            }
            else
            {
              messageJoueur("vous ne pouvez pas sélectionner cette unité"+selctionPanel.numeroUnite);
            }        
        }
        
        if (partieEnCours.flagAction==5) {
            if (partieEnCours.choixMonstre!=selctionPanel.numeroUnite) {
                messageJoueur("vous ne pouvez pas sélectionner cette unité");
            }
            else
            {
                //on cherche dans le vecteur monstre celui qui correspond à celui que l'on peut déplacer
                if (selctionPanel.numeroUnite==partieEnCours.choixMonstre) {
                    for (monstres monstre : selctionPanel.conteneur.terrain.monstres) {
                        if (monstre.type==partieEnCours.choixMonstre) {
                        partieEnCours.monstreDeplace= monstre;
                        }
                    }
                }
                partieEnCours.flagAction=6;                
                partieEnCours.panelRefresh.numeroUnite = 4;
                partieEnCours.origineExplorateur= selctionPanel.conteneur;
                partieEnCours.panelRefresh = selctionPanel;
                messageJoueur("monstre séléctionné, selectionné maintenant une case de destination");
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
