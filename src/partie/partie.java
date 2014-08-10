/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partie;

import java.util.Vector;
import joueurs.joueurs;
import terrain.tuiles;
import unités.unités;

/**
 *
 * @author Takazeuk
 */
public class partie {
    public Vector<joueurs> participant;
    public Vector<tuiles> carte;
    public Vector<unités> population;

    public partie(int nbJoueur) {
        this.participant= new Vector<joueurs>();
        this.carte= new Vector<tuiles>();
        this.population= new Vector<unités>();
        
        //construction de la carte
        int compt=0;
        int j;             
        //transformer en boucle for
        while (compt!=13) {            
            switch(compt)
            {
                case 0: case 12:
                    for(j=0; j<7; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                    }
                break;
                case 1: case 3: case 9: case 11:
                    for(j=0; j<10; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                    }
                break;
                case 2: case 4: case 6: case 8: case 10:
                    for(j=0; j<11; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                    }
                break;
                case 5: case 7:
                    for(j=0; j<12; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                    }
            }
            compt++;
        }
        for (int k=0; k<133; k++)
        {
           System.out.println(this.carte.get(k).x+" "+ carte.get(k).y+" ");
        }
        
        //on prépare le nombre de joueur
        
    }    
}
