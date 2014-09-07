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
import javax.swing.JOptionPane;
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
        
        if (partieEnCours.flagAction==2 || partieEnCours.flagAction==7 || partieEnCours.flagAction==8) {
            boolean flagDeplacementexplo = false;
            boolean flagDeplacementbateau = true;
            Object []indiceExplo= new Object [1];
            // sert a connaitre le nombre d'element du tableau
            int compteur =0;
            
            joueurs joueur= partieEnCours.participant.get(partieEnCours.tourJoueur);
            
            partieEnCours.flag7 = 0;
            if(partieEnCours.flagAction==8)
            {
                partieEnCours.flag7 = 2;
            }
            if(partieEnCours.flagAction==2)
            {
                partieEnCours.flag7 = 3;
            }
            if(partieEnCours.flagAction==7)
            {
                if(this.selctionPanel.numeroUnite==joueur.couleur)
                {
                    if(selctionPanel.conteneur.terrain.explorateurs.get(selctionPanel.numeroPetitPanel).nageur == false)
                    {
                        partieEnCours.flag7 = 1;
                    }
                }
            }
            //test pour l'explorateur
            if(partieEnCours.flag7 == 1 || partieEnCours.flag7 == 3)
            {
                int value = JOptionPane.NO_OPTION;
                if (this.selctionPanel.numeroUnite==joueur.couleur) {
                    partieEnCours.exploDeplace= selctionPanel.conteneur.terrain.explorateurs.get(selctionPanel.numeroPetitPanel);
                    partieEnCours.flagDeplacement=1;
                    partieEnCours.flagAction=3;
                    partieEnCours.origineExplorateur= selctionPanel.conteneur;
                    partieEnCours.panelRefresh = selctionPanel;
                    // je l'ai changé de place!! partieEnCours.panelRefresh.numeroUnite = 4;

                    messageJoueur("explorateur séléctionné selectionnez maintenant une case de destination");
                }
                // Si on est dans le cas ou le joueur peut deplacer un bateau
                else if (this.selctionPanel.numeroPetitPanel==6 && (partieEnCours.flag7==3 || partieEnCours.flag7 == 2)) {
                    if(selctionPanel.conteneur.terrain.bateaux.get(0).marins.size()>0)
                    {
                        messageJoueur(" on est en train de debuguer!!!!!!!!!!!");
                        for (explorateurs explo : selctionPanel.conteneur.terrain.bateaux.get(0).marins) {
                            if (explo.proprietaire == partieEnCours.participant.get(partieEnCours.tourJoueur).couleur) {
                                flagDeplacementexplo = true;
                                // connaitre le nombre d'explo du joueur ppour alimenter mon tableau d'indice
                                compteur++;
                            }
                        }
                        if(flagDeplacementexplo==true)
                        {
                            // sert a connaitre l'indice du tableau
                            int k = 0;
                            indiceExplo = new Object[compteur];
                            for (explorateurs explo : selctionPanel.conteneur.terrain.bateaux.get(0).marins) {
                                if (explo.proprietaire == partieEnCours.participant.get(partieEnCours.tourJoueur).couleur) {
                                    
                                    // mettre le numero d'indice du vecteur marins dans le tableau d'indice
                                    indiceExplo[k] = selctionPanel.conteneur.terrain.bateaux.get(0).marins.indexOf(explo);
                                    k++;
                                }
                            }
                            // demander au joueur s'il veut deplacer un explo
                             value  = Interaction.monterSurBateau("Voulez-vous déplacer un de vos explorateurs ?");
                        }
                        
                    }
                    // dans le cas ou le joueur veut deplacer un de ses explo
                    if(value == JOptionPane.YES_OPTION)
                    {
                        partieEnCours.DescendreMarin = true;
                        //recupere l'indice du vecteur bateau choisi par le joueur
                        int indiceVecteurbateau = Interaction.demandeChoix("quel explorateur retirer-vous ?", "", indiceExplo);
                        partieEnCours.exploDeplace = selctionPanel.conteneur.terrain.bateaux.get(0).marins.get(indiceVecteurbateau);
                        partieEnCours.flagDeplacement=1;
                        partieEnCours.flagAction=3;
                        partieEnCours.origineExplorateur= selctionPanel.conteneur;
                        partieEnCours.panelRefresh = selctionPanel;
                        messageJoueur("explorateur séléctionné selectionnez maintenant une case de destination");
                    }
                    //sinon
                    else
                    {
                        // On regarde si le joueur est proprietaire du bateau
                        if ((selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==partieEnCours.participant.get(partieEnCours.tourJoueur).couleur)||(selctionPanel.conteneur.terrain.bateaux.get(0).proprietaire==4)) {
                            // on regarde si le proprio du bateau n'est personne alors on regarde s'il ya des explo et 
                            // si oui alors on regarde s'il y a un explo du joueuur en question auquel cas il peut deplacer le bateau
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
                    }
                    
                
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
                partieEnCours.origineExplorateur= selctionPanel.conteneur;
                partieEnCours.panelRefresh = selctionPanel;
                partieEnCours.panelRefresh.numeroUnite = 4;
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
