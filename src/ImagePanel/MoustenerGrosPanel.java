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
import unités.monstres;

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
                        messageJoueur("placement bateau terminé");
                        partieEnCours.flagAction=2;
                    } 
                }
            }
            if (partieEnCours.flagAction==3) {
                
                System.out.println("je rentre dans la phase 3"+partieEnCours.bateauDeplace.deplacement(placement));
                
                //on fait le test du cas où ce serait un bateau qui doit être déplacé
                if (partieEnCours.panelRefresh.numeroPetitPanel==6) {
                    //on regarde si la case est adjacente
                    boolean testDeplacement=partieEnCours.bateauDeplace.deplacement(placement);
                    if ((testDeplacement)&&(placement.type==0)) {
                        //on regarde s'il n'y a pas déjà un autre bateau                      
                        if (placement.bateaux.size()==0) {
                            //on ajoute le bateau au vecteur
                            placement.bateaux.add(partieEnCours.bateauDeplace);
                            try {
                                partieEnCours.affichageBateaux(placement, partieEnCours.bateauDeplace);
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            //on donnes les coordonnées x y de la tuile de destination à l'explorateur
                            partieEnCours.bateauDeplace.x= placement.x;
                            partieEnCours.bateauDeplace.y= placement.y;
                            try {
                                partieEnCours.panelRefresh.refreshBateau();
                            } catch (IOException ex) {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //on remet le flag déplacement à 0
                            partieEnCours.flagDeplacement=0;

                            //on repasse flag action à 2 pour réactiver les clics sur les petitsPanels
                            partieEnCours.flagAction=2;

                            partieEnCours.origineExplorateur.terrain.bateaux.remove(partieEnCours.exploDeplace);
                            messageJoueur("le bateau a été déplacé"); 
                        }
                        else
                        {
                           messageJoueur("vous ne pouvez pas faire ce déplacement, il y a déjà 1 bateau sur cette case"); 
                        }
                        
                    }
                    else
                    {
                        messageJoueur("vouse ne pouvez pas vous déplacer sur cette case, elle n'est pas adjacente"); 
                    }       
                }
                //si ce n'est pas un bateau , c'est un explorateur
                else
                {
                     //on regarde si la case est adjacente
                    boolean testDeplacement=partieEnCours.exploDeplace.deplacement(placement);
                    if (testDeplacement) {
                        //on regarde s'il n'y a pas déjà un autre bateau                        
                        if (placement.explorateurs.size()<3) {
                            //on ajoute l'explorateur au vecteur
                            placement.explorateurs.add(partieEnCours.exploDeplace);
                            try {
                                partieEnCours.affichageExplorateurs(placement, partieEnCours.exploDeplace);
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            //on donnes les coordonnées x y de la tuile de destination à l'explorateur
                            partieEnCours.exploDeplace.x= placement.x;
                            partieEnCours.exploDeplace.y= placement.y;

                            //on remet le flag déplacement à 0
                            partieEnCours.flagDeplacement=0;

                            //on repasse flag action à 2 pour réactiver les clics sur les petitsPanels
                            partieEnCours.flagAction=2;

                            partieEnCours.origineExplorateur.terrain.explorateurs.remove(partieEnCours.exploDeplace);
                            try 
                            {
                                partieEnCours.panelRefresh.refreshexplorateurs();
                            } catch (IOException ex) 
                            {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            messageJoueur("votre explorateur a été déplacé"); 
                        }
                        else
                        {
                           messageJoueur("vous ne pouvez pas faire ce déplacement, il y a déjà 3 explorateurs sur cette case"); 
                        }
                        
                    }
                    else
                    {
                        messageJoueur("vouse ne pouvez pas vous déplacer sur cette case, elle n'est pas adjacente"); 
                    }
                }               
            }
            if (partieEnCours.flagAction==6) {
                int flag=0;
                boolean testDeplacement=partieEnCours.exploDeplace.deplacement(placement);
                if (testDeplacement){
                    if (placement.type==0) {
                        for (monstres monstre : placement.monstres) {
                            if (monstre.type==partieEnCours.choixMonstre) {
                                messageJoueur("vous ne pouvez pas vous déplacer sur cette case, elle possède déjà un monstre de ce type");
                                flag=1;
                            }
                        }
                        if (flag==0) {
                            placement.monstres.add(partieEnCours.monstreDeplace);
                            try {
                                partieEnCours.affichageMonstre(placement, partieEnCours.monstreDeplace);
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            //on donnes les coordonnées x y de la tuile de destination à l'explorateur
                            partieEnCours.monstreDeplace.x= placement.x;
                            partieEnCours.monstreDeplace.y= placement.y;

                            //on remet le flag déplacement à 0
                            partieEnCours.flagDeplacement=0;

                            //on repasse flag action à 2 pour réactiver les clics sur les petitsPanels
                            partieEnCours.flagAction=2;

                            partieEnCours.origineExplorateur.terrain.monstres.remove(partieEnCours.exploDeplace);
                            try 
                            {
                                partieEnCours.panelRefresh.refreshexplorateurs();
                            } catch (IOException ex) 
                            {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            
            }
    }		
}
