/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partie.newpackage;

import java.util.Vector;
import joueurs.joueurs;
import terrain.newpackage.tuiles;
import unités.newpackage.unités;

/**
 *
 * @author Takazeuk
 */
public class partie {
    public Vector<joueurs> participant;
    public Vector<tuiles> carte;
    public Vector<unités> population;

    public partie() {
        Vector<joueurs> participant= new Vector<joueurs>();
        Vector<tuiles> carte= new Vector<tuiles>();
        Vector<unités> population= new Vector<unités>();
    }
    
    
}
