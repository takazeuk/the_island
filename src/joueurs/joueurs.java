/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joueurs;

import java.util.Vector;
import terrain.tuiles;
import unités.explorateurs;

/**
 *
 * @author Takazeuk
 */
public class joueurs {
    public String nom;
    public int couleur;
    public int deplacement;
    public Vector<tuiles> cartesEnMain;
    public Vector<explorateurs> membres;
    public Vector<explorateurs> membresDeploiement;
    public int bateauxDeploiement=2;
    public int pointVictoire;

    public joueurs(String nom, int couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.deplacement=3;
        this.cartesEnMain= new Vector<tuiles>();
        this.membres= new Vector<explorateurs>();
        this.membresDeploiement= new Vector<explorateurs>();
        this.pointVictoire=0;
    }
    
    //test jo  
}
