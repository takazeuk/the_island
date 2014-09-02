/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unités;

import ImagePanel.GrosPanel;
import java.awt.Component;
import javafx.beans.binding.Bindings;
import terrain.tuiles;

/**
 *
 * @author Takazeuk
 */
public class monstres extends unites {
    public String nom;
    public int deplacement;
    public int type;

    public monstres(String nom, int deplacement, int type, int x, int y) {
        super(x, y);
        this.nom = nom;
        this.deplacement = deplacement;
        this.type = type;
    }
    
    //fonction pour l'attaque des requins, des baleines, des serpents de mer
    public boolean attaque(tuiles cible)
    {
        if (this.type==5) {
            if (cible.explorateurs.size()!=0 && cible.explorateurs != null) {
                cible.explorateurs.clear();
                return true;
            }                      
        }
        if (this.type==6)
        {
            if ((cible.bateaux.size()!=0)&&(cible.bateaux.get(0).marins.size()!=0)) {
                for (explorateurs naufragés : cible.bateaux.get(0).marins) {
                    cible.explorateurs.add(naufragés);
                }
                cible.bateaux.clear();
                return true;
            }            
        }
        if (this.type==7) {
            int flag=0;
            if ((cible.bateaux.size()!=0)&&(cible.bateaux.get(0).marins.size()!=0)){
                cible.bateaux.clear();
                flag=1;
            }
            if (cible.explorateurs.size()!=0 && cible.explorateurs != null) {
                cible.explorateurs.clear();
                flag=1;
            }
            if (flag==1) {
                return true;
            }
        }
        return false;        
    }
}
