/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joueurs;

import java.util.Vector;
import terrain.newpackage.tuiles;
import unités.newpackage.explorateurs;

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

    public joueurs(String nom, int couleur) {
        this.nom = nom;
        this.couleur = couleur;
        this.deplacement=3;
        Vector<tuiles> cartesEnMain= new Vector<tuiles>();
        Vector<explorateurs> membres= new Vector<explorateurs>();
    }
    
    //test jo  
}
