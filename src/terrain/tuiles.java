/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package terrain;

import ImagePanel.GrosPanel;
import java.util.Vector;
import unités.bateaux;
import unités.explorateurs;
import unités.monstres;
import unités.unites;

/**
 *
 * @author Takazeuk
 */
public class tuiles {
    public int x;
    public int y;
    public int type;
    public int pouvoir;
    public Vector<explorateurs> explorateurs;
    public Vector<bateaux> bateaux;
    public Vector<monstres> monstres;
    public GrosPanel panelLien;
    public String descriptionPouvoir;

    public tuiles(int x, int y, int type, int pouvoir, String desc) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.pouvoir = pouvoir;
        this.explorateurs= new Vector<explorateurs>();
        this.bateaux= new Vector<bateaux>();
        this.monstres= new Vector<monstres>();
        this.descriptionPouvoir = desc;
    }

   public static void action()
   {

   }
   
   
}
