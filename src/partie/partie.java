/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partie;

import ImagePanel.ImPan;
import UI.Int;
import java.io.IOException;
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

    public partie(int nbJoueur) throws IOException {
        this.participant= new Vector<joueurs>();
        this.carte= new Vector<tuiles>();
        this.population= new Vector<unités>();
        Int mine = new Int();
        mine.setLayout(null);
        
        //construction de la carte
        int compt=0;
        int j;             
        //transformer en boucle for
        while (compt!=13) {            
            switch(compt)
            {
                case 0: case 12:
                    for(j=2; j<9; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(150+j*60,compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                        
                    }
                break;
                case 1: case 3: case 9: case 11:
                    for(j=1; j<11; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(120+j*60,compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
                break;
                case 2: case 4: case 6: case 8: case 10:
                    for(j=0; j<11; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(30+j*60,compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
                break;
                case 5: case 7:
                    for(j=0; j<12; j++)
                    {
                        tuiles terrain= new tuiles(compt, j, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(j*60,compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
            }
            compt++;
        }
        
        mine.setSize(800, 800);
        mine.setVisible(true);
        
        //on prépare le nombre de joueur
        
    }    
}
