/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unités;

import java.util.Vector;

/**
 *
 * @author Takazeuk
 */
public class bateaux extends unites {
    public Vector<explorateurs> marins;

    public bateaux(int x, int y) {
        super(x, y);
        this.marins= new Vector<>();
    }
 
}
