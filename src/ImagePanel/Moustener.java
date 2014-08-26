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

/**
 *
 * @author Jonathan
 */
public class Moustener extends MouseAdapter
{
    int x;
    int y;
    int flagAction=0;
    GrosPanel selctionPanel;
    int numJoueur= 0;
    partie partieEnCours;
    
    public Moustener(GrosPanel p, partie part)
    {
        x = p.j;
        y = p.k;
        selctionPanel= p;
        partieEnCours= part;
    }
       
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        switch(flagAction)
        {
            case 0:
            {
                int CompteurPion=0;
                boolean placementValide = false;
                tuiles placement;
                
                joueurs joueur= partieEnCours.participant.get(numJoueur);
                placement= selctionPanel.terrain;
                
            try {
                placementValide=partieEnCours.deploiement(joueur, joueur.membresDeploiement.get(CompteurPion), placement);
            } catch (IOException ex) {
                Logger.getLogger(Moustener.class.getName()).log(Level.SEVERE, null, ex);
            }
                if (placementValide) {
                   numJoueur++;
                    if (numJoueur==partieEnCours.participant.size()) {
                        numJoueur=0;
                        CompteurPion++;
                    }
                    messageJoueur(partieEnCours.participant.get(numJoueur).nom+" , vous devez placer un pion sur l'ile, sur une case non occupé par un autre joueur");
                }

            }
                
        }
    }		
}
