/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unités;

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
    public static void attaque(tuiles cible, monstres predateur)
    {
        if ((predateur.type==0)||(predateur.type==2)) {
            for(explorateurs victime: cible.explorateurs)
            {
                cible.explorateurs.remove(victime);
            }
        }
        if ((predateur.type==1)||(predateur.type==2))
        {
            for(bateaux navire: cible.bateaux)
            {
                cible.bateaux.remove(navire);
            }
        }
    }
}
