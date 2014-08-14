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
import unités.explorateurs;
import unités.unités;

/**
 *
 * @author Takazeuk
 */
public class partie {
    public Vector<joueurs> participant;
    public Vector<tuiles> carte;
    public Vector<unités> population;

    public partie() throws IOException {
        this.participant= new Vector<joueurs>();
        this.carte= new Vector<tuiles>();
        this.population= new Vector<unités>();      
    }
    
    //fonction pour créer le plateau de jeu avec les tuiles
    public void creationPlateau() throws IOException
    {
        Int mine = new Int();
        mine.setLayout(null);
        
        //construction de la carte
        int compt=0;
        int j;       
        int cordy;
        //transformer en boucle for
        while (compt!=13) {            
            switch(compt)
            {
                case 0: case 12:
                    for(j=0; j<7; j++)
                    {
                        cordy=j+2;
                        if (compt == 12)
                        {
                            cordy = j+8;
                        }
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(250+j*60,100+compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                        
                    }
                break;
                case 1: case 3: case 9: case 11:
                    for(j=0; j<10; j++)
                    {
                        cordy=j+1;
                        if (compt == 3)
                        {
                            cordy = j+2;
                        }
                        if (compt == 9)
                        {
                            cordy = j+5;
                        } 
                        if (compt == 11)
                        {
                            cordy = j+6;
                        }
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(160+j*60,100+compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
                break;
                case 2: case 4: case 6: case 8: case 10:
                    for(j=0; j<11; j++)
                    {
                        cordy=j+1;
                        if (compt == 4)
                        {
                            cordy = j+2;
                        }
                        if (compt == 6)
                        {
                            cordy = j+3;
                        } 
                        if (compt == 8)
                        {
                            cordy = j+4;
                        }
                        if (compt == 10)
                        {
                            cordy = j+5;
                        }
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(130+j*60,100+compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
                break;
                case 5: case 7:
                    for(j=0; j<12; j++)
                    {
                        cordy=j+2;
                        if (compt == 7)
                        {
                            cordy = j+3;
                        }
                        
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        ImPan lenouv = new ImPan(0, 0, terrain);
                        lenouv.setSize(60, 60);
                        lenouv.setVisible(true);
                        mine.getContentPane().add(lenouv);
                        lenouv.setLocation(100+j*60,100+compt*45);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
            }
            compt++;
        }
        
        mine.setSize(950, 850);
        mine.setVisible(true);
    }
      
    //création des explorateurs
    public void creationExplorateur(joueurs joueurCree)
    {
        explorateurs survivant;
        
        for(int compt=0; compt<10; compt++)
        {
            switch(compt)
            {
              case 0: case 1: case 2:
                  survivant= new explorateurs(1, 0, 0);
                  joueurCree.membres.add(survivant);
              break;
              case 3: case 4:
                  survivant= new explorateurs(2, 0, 0);
                  joueurCree.membres.add(survivant);
              break;
              case 5: case 6:
                  survivant= new explorateurs(3, 0, 0);
                  joueurCree.membres.add(survivant);
              break;
              case 7:
                  survivant= new explorateurs(4, 0, 0);
                  joueurCree.membres.add(survivant);
              break;
              case 8:
                  survivant= new explorateurs(5, 0, 0);
                  joueurCree.membres.add(survivant);
              break;
              case 9:
                  survivant= new explorateurs(6, 0, 0);
                  joueurCree.membres.add(survivant);
              break;
            }  
        }    
    }
}
