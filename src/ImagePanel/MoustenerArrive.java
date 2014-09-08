/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import MessageBox.Interaction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import partie.partie;

/**
 *
 * @author Jonathan
 */
public class MoustenerArrive extends MouseAdapter{
    partie partieEnCours;
    Arrive panelArrive;
    public MoustenerArrive(Arrive a, partie p)
    {
        panelArrive = a;
        partieEnCours = p;
    }
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        boolean autoriser = false;
        if(partieEnCours.flagAction == 3)
        {
            // Regarder les x et y de la tuile d'origine
            int x = partieEnCours.origineExplorateur.terrain.x;
            int y = partieEnCours.origineExplorateur.terrain.y;
            if(((x==1)&&(y==1))||((x == 1)&&(y==2)))
            {
                if(panelArrive.emplacement==1)
                {
                    autoriser = true;
                }
            }
            if(((x==10)&&(y==1))||((x == 11)&&(y==2)))
            {
                if(panelArrive.emplacement==2)
                {
                    autoriser = true;
                }
            }
            if(((x==5)&&(y==10))||((x == 6)&&(y==11)))
            {
                if(panelArrive.emplacement==3)
                {
                    autoriser = true;
                }
            }
            if(((x==15)&&(y==10))||((x == 15)&&(y==11)))
            {
                if(panelArrive.emplacement==4)
                {
                    autoriser = true;
                }
            }
            if(autoriser == true)
            {
                Interaction.messageJoueur("Votre explorateur est sauvé");
                partieEnCours.survivants.add(partieEnCours.exploDeplace);
                partieEnCours.origineExplorateur.terrain.explorateurs.remove(partieEnCours.exploDeplace);
                partieEnCours.exploDeplace = null;
                try {
                    partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                    //partieEnCours.affichageBateaux(placement, partieEnCours.bateauDeplace);
                } catch (IOException ex) {
                    Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                // décrémenter le déplacement du joueur de 1
                partieEnCours.participant.get(partieEnCours.tourJoueur).deplacement--;
                if(partieEnCours.participant.get(partieEnCours.tourJoueur).deplacement!=0)
                {
                    partieEnCours.flagAction = 2;
                }
            }
            else
            {
                Interaction.messageJoueur("Vous ne pouvez pas encore venir sur cette case");
            }
        }
    }
    
}
