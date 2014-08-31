/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import joueurs.joueurs;
import partie.partie;

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
        boolean valide=false;
        
        joueurs joueur= partieEnCours.participant.get(partieEnCours.tourJoueur);
        //test pour l'explorateur
        if (this.selctionPanel.numeroUnite==joueur.couleur) {
            partieEnCours.exploDeplace= selctionPanel.conteneur.terrain.explorateurs.get(selctionPanel.numeroPetitPanel);
            partieEnCours.flagDeplacement=1;
            valide=true;
        }
        else if (this.selctionPanel.numeroUnite==6) {
            //test du bateau mais pas encore fait
            valide=true;
        }
    }		
}
