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
public class unites {
    public boolean enjeu;
    public int x;
    public int y;

    public unites(int x, int y) {
        this.enjeu = true;
        this.x = x;
        this.y = y;
    }
    
    public boolean deplacement(tuiles choisi)
    {
        int x= choisi.x;
        int y= choisi.y;
        int coorduniteX= this.x;
        int coorduniteY= this.y;
        
        if (((x==coorduniteX)&&(y==coorduniteY-1))||((x==coorduniteX)&&(y==coorduniteY+1))||((x==coorduniteX+1)&&(y==coorduniteY))||((x==coorduniteX-1)&&(y==coorduniteY))||((x==coorduniteX-1)&&(y==coorduniteY-1))||((x==coorduniteX+1)&&(y==coorduniteY+1))) {
            return true;
        }
        return false;        
    }
       
}
