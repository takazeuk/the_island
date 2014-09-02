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
        if ((this.type==5)||(this.type==7)) {
            if (cible.explorateurs.size()!=0) {
                cible.explorateurs.clear();
                return true;
            }                      
        }
        if ((this.type==6)||(this.type==7))
        {
            if ((cible.bateaux.size()!=0)&&(cible.bateaux.get(0).marins.size()!=0)) {
                for (explorateurs naufragés : cible.bateaux.get(0).marins) {
                    cible.explorateurs.add(naufragés);
                }
                cible.bateaux.clear();
                return true;
            }            
        }
        return false;        
    }
}
