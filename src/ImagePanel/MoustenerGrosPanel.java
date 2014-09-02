/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import MessageBox.Interaction;
import static MessageBox.Interaction.messageJoueur;
import static MessageBox.Interaction.monterSurBateau;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import joueurs.joueurs;
import partie.partie;
import terrain.tuiles;
import unités.bateaux;
import unités.explorateurs;
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
                System.out.println("je rentre dans la phase 3");
                
                //on fait le test du cas où ce serait un bateau qui doit être déplacé
                if (partieEnCours.panelRefresh.numeroPetitPanel==6) {
                    //on regarde si la case est adjacente
                    boolean testDeplacement=partieEnCours.bateauDeplace.deplacement(placement);
                    if ((testDeplacement)&&(placement.type==0)&& ((placement.explorateurs.size()+partieEnCours.bateauDeplace.marins.size())<=3)) {
                        //on regarde s'il n'y a pas déjà un autre bateau
                        
                                if (placement.bateaux.size()==0) {
                            //on ajoute le bateau au vecteur
                                placement.bateaux.add(partieEnCours.bateauDeplace);
                                partieEnCours.origineExplorateur.terrain.bateaux.remove(partieEnCours.bateauDeplace);
                                try {
                                    partieEnCours.affichageUniteTuile(placement);
                                    partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                                    //partieEnCours.affichageBateaux(placement, partieEnCours.bateauDeplace);
                                } 
                                catch (IOException ex) {
                                    Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                //on donnes les coordonnées x y de la tuile de destination à l'explorateur
                                partieEnCours.bateauDeplace.x= placement.x;
                                partieEnCours.bateauDeplace.y= placement.y;
                                for (explorateurs equipage : partieEnCours.bateauDeplace.marins) {
                                     equipage.x = placement.x;
                                     equipage.y = placement.y;
                                }
                                //on remet le flag déplacement à 0
                                partieEnCours.flagDeplacement=0;

                                //on repasse flag action à 2 pour réactiver les clics sur les petitsPanels !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! repasser en 2
                                partieEnCours.flagAction=2;

                                partieEnCours.origineExplorateur.terrain.bateaux.remove(partieEnCours.exploDeplace);
                                partieEnCours.participant.get(partieEnCours.tourJoueur).deplacement--;
                                messageJoueur("le bateau a été déplacé"+partieEnCours.flagAction); 
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
                    if((partieEnCours.exploDeplace.x == selctionPanel.k) && (partieEnCours.exploDeplace.y == selctionPanel.j))
                    {
                        if(selctionPanel.terrain.bateaux.size()==1)
                        {
                            if(((selctionPanel.terrain.bateaux.get(0).marins.size()+selctionPanel.terrain.explorateurs.size())<3) && (selctionPanel.terrain.bateaux.get(0).marins.size()<3))
                            {
                                placement.bateaux.get(0).marins.add(partieEnCours.exploDeplace);
                                messageJoueur("L'explorateur est bien monter sur le bateau");
                                partieEnCours.origineExplorateur.terrain.explorateurs.remove(partieEnCours.exploDeplace);
                                //partieEnCours.panelRefresh.numeroUnite = 4;
                                try 
                                {
                                    partieEnCours.affichageUniteTuile(placement);
                                    partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                                    //partieEnCours.panelRefresh.refreshexplorateurs();
                                } catch (IOException ex) 
                                {
                                    Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                partieEnCours.flagAction=2;
                                partieEnCours.participant.get(partieEnCours.tourJoueur).deplacement--;
                                selctionPanel.gestionDesProprioBateau();
                            }
                        }
                    }
                    else if (testDeplacement) {
                        if((partieEnCours.exploDeplace.nageur==true) && (placement.type!=0))
                        {
                            messageJoueur("Votre pion est un nageur donc vous ne pouvez plus retourner sur une case terrain");
                            partieEnCours.flagAction=2;
                        }
                        else
                        {
                            //partieEnCours.panelRefresh.numeroUnite = 4;
                            //on regarde s'il n'y a pas déjà un autre bateau 
                            //messageJoueur(""+placement.explorateurs.size()+ "   "+placement.bateaux.get(0).marins.size());
                            int nb = 0; // connaitre le nombre d'explorateur sur la tuile
                            if(placement.bateaux.size()==1) // s'il ya un bateau il faut additionner le nombre d'explo de la tuile et du bateau
                            {
                                nb = placement.explorateurs.size() + placement.bateaux.get(0).marins.size();
                            }
                            else // sinon que de la tuile
                            {
                                nb = placement.explorateurs.size();
                            }
                            if (nb < 3) { //si le nombre d'explo total est inferieur a 3 alors...
                                //on ajoute l'explorateur au vecteur
                                placement.explorateurs.add(partieEnCours.exploDeplace);
                                partieEnCours.origineExplorateur.terrain.explorateurs.remove(partieEnCours.exploDeplace);
                                
                                if((placement.bateaux.size()==1) && (partieEnCours.exploDeplace.nageur==false))
                                {
                                    String a = "Voulez-vous monter sur le bateau ?";
                                    int value = monterSurBateau(a);
                                    if(value == JOptionPane.YES_OPTION)
                                    {
                                        placement.bateaux.get(0).marins.add(partieEnCours.exploDeplace);
                                        messageJoueur("L'explorateur est bien monter sur le bateau");
                                        placement.explorateurs.remove(partieEnCours.exploDeplace);
                                        selctionPanel.gestionDesProprioBateau();
                                    }
                                    else
                                    {
                                        try {
                                            partieEnCours.affichageUniteTuile(placement);
                                            partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                                             //partieEnCours.affichageExplorateurs(placement, partieEnCours.exploDeplace);
                                        } 
                                        catch (IOException ex) {
                                        Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                                else
                                {
                                    try {
                                        partieEnCours.affichageUniteTuile(placement);
                                        partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                                        //partieEnCours.affichageExplorateurs(placement, partieEnCours.exploDeplace);
                                    } 
                                    catch (IOException ex) {
                                    Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }


                                //on donnes les coordonnées x y de la tuile de destination à l'explorateur
                                partieEnCours.exploDeplace.x= placement.x;
                                partieEnCours.exploDeplace.y= placement.y;
                                // On attribue le statut de nageur a l'explo dans le cas ou le panel de destination est de type eau
                                if(placement.type==0)
                                {
                                    partieEnCours.exploDeplace.nageur = true;
                                }
                                //on remet le flag déplacement à 0
                                partieEnCours.flagDeplacement=0;

                                //on repasse flag action à 2 pour réactiver les clics sur les petitsPanels !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! repasser en 2
                                partieEnCours.flagAction=2;

                                partieEnCours.origineExplorateur.terrain.explorateurs.remove(partieEnCours.exploDeplace);
                                try 
                                {
                                    partieEnCours.affichageUniteTuile(placement);
                                    partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                                    //partieEnCours.panelRefresh.refreshexplorateurs();
                                } catch (IOException ex) 
                                {
                                    Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                partieEnCours.participant.get(partieEnCours.tourJoueur).deplacement--;
                                messageJoueur("votre explorateur a été déplacé"+partieEnCours.flagAction);
                                
                            }
                            else
                            {
                               messageJoueur("vous ne pouvez pas faire ce déplacement, il y a déjà 3 explorateurs sur cette case"); 
                            }
                        }
                        
                    }
                    else
                    {
                        messageJoueur("vouse ne pouvez pas vous déplacer sur cette case, elle n'est pas adjacente"); 
                    }
                }               
            }
            
            if (partieEnCours.flagAction == 4) {
                messageJoueur(""+placement.pouvoir);
            try {               
                if (partieEnCours.retirerTuile(placement)) { 
                    placement.type = 0;
                    partieEnCours.flagAction=5;
                    try {
                        selctionPanel.refreshImage();
                    } catch (IOException ex) {
                        Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    partieEnCours.pouvoirImmediat(placement);
                }               
            } catch (IOException ex) {
                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            if (partieEnCours.flagAction==6) {
                int flag=0;
                boolean testDeplacement=partieEnCours.monstreDeplace.deplacement(placement);
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
                            partieEnCours.origineExplorateur.terrain.monstres.remove(partieEnCours.monstreDeplace);
                            messageJoueur("tableau monstre: t"+partieEnCours.origineExplorateur.terrain.monstres.size());
                            /*try {
                                partieEnCours.affichageUniteTuile(placement);
                                //partieEnCours.affichageMonstre(placement, partieEnCours.monstreDeplace);
                            } 
                            catch (IOException ex) {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }*/
                            //on donnes les coordonnées x y de la tuile de destination à l'explorateur
                            partieEnCours.monstreDeplace.x= placement.x;
                            partieEnCours.monstreDeplace.y= placement.y;

                            //on remet le flag déplacement à 0
                            partieEnCours.flagDeplacement=0;

                            //on repasse flag action à 5 pour réactiver les clics sur les petitsPanels
                            partieEnCours.flagAction=5;
                           
                            //on modifie le déplacement
                            partieEnCours.deplacementMonstre++;
                            
                            //on fait la fonction attaque
                            if(partieEnCours.monstreDeplace.attaque(placement)){
                                partieEnCours.deplacementMonstre= partieEnCours.monstreDeplace.deplacement;
                            }
                            
                            //on refresh les images de la case
                            try {
                                partieEnCours.affichageUniteTuile(partieEnCours.origineExplorateur.terrain);
                                partieEnCours.affichageUniteTuile(placement);
                                //selctionPanel.refreshGrosPanel();
                            } catch (IOException ex) {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            messageJoueur("votre monstre a été déplacé "+partieEnCours.monstreDeplace.deplacement);
                            
                            /*try 
                            {
                                partieEnCours.affichageUniteTuile(placement);
                                //partieEnCours.panelRefresh.refreshexplorateurs();
                            } catch (IOException ex) 
                            {
                                Logger.getLogger(MoustenerGrosPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }*/
                        }
                    }
                }
            
            }
    }		
}
