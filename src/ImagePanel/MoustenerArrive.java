/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import MessageBox.Interaction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                // ne pas oublier de gerer le deplacement
            }
            else
            {
                Interaction.messageJoueur("Vous ne pouvez pas encore venir sur cette case");
            }
        }
    }
    
}
