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
    public void attaque(tuiles cible, monstres predateur)
    {
        if ((predateur.type==5)||(predateur.type==7)) {
            cible.explorateurs.clear();
        }
        if ((predateur.type==6)||(predateur.type==7))
        {
            cible.bateaux.clear();
        }
        
        
            
    }
}
