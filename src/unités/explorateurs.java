/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unités;

/**
 *
 * @author Takazeuk
 */
public class explorateurs extends unites {
    public int points;
    public boolean nageur;
    public int proprietaire;

    public explorateurs(int points, int x, int y, int joueur) {
        super(x, y);
        this.points = points;
        this.proprietaire= joueur;
        boolean nageur = false;
    }
    
    
       
}
