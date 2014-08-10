/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unités.newpackage;

/**
 *
 * @author Takazeuk
 */
public class monstres extends unités {
    public String nom;
    public int deplacement;
    public int type;

    public monstres(String nom, int deplacement, int type, int x, int y) {
        super(x, y);
        this.nom = nom;
        this.deplacement = deplacement;
        this.type = type;
    }
     
    public static void attaque(int type)
    {
        
    }
}
