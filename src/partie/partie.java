/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package partie;

import ImagePanel.GrosPanel;
import ImagePanel.PetitPanel;
import UI.Int;
import java.awt.Component;
import java.awt.Dimension;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.Panel;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import joueurs.joueurs;
import terrain.tuiles;
import unités.bateaux;
import unités.explorateurs;
import unités.monstres;
import unités.unites;

/**
 *
 * @author Takazeuk
 */
public class partie {
    public Vector<joueurs> participant;
    public Vector<tuiles> carte;
    public Vector<unites> population;
    public Vector<GrosPanel> imageTuile;
    public Int mine;
    public JScrollPane Scroll;
    public partie(int nombreJoueur) throws IOException {
        this.participant= new Vector<joueurs>();
        this.carte= new Vector<tuiles>();
        this.population= new Vector<unites>();
        this.imageTuile= new Vector<GrosPanel>();
    }
    
    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int hauteur = (int)tailleEcran.getHeight();
    int largeur = (int)tailleEcran.getWidth();
    //fonction pour créer le plateau de jeu avec les tuiles
    public void creationPlateau() throws IOException
    {
         mine = new Int();
        mine.setLayout(null);
        
        //construction de la carte
        int compt=0;
        int j;       
        int cordy;
        JPanel legros = new JPanel();
        legros.setLayout(null);
        
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
                        GrosPanel lenouv = new GrosPanel(terrain);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        lenouv.setLocation((400) +j*120,50+compt*90);
                        //lenouv.setBounds((largeur/2 - 210) +j*80, (hauteur/2 -(285+(65/2)))+compt*65, 80, 80);
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
                        GrosPanel lenouv = new GrosPanel(terrain);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        //mine.getContentPane().add(lenouv);
                        lenouv.setLocation((220) +j*120,50+compt*90);
                        //lenouv.setBounds((largeur/2 - 300) +j*80, (hauteur/2 -(285+(65/2)))+compt*65, 80, 80);
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
                        GrosPanel lenouv = new GrosPanel(terrain);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        lenouv.setLocation((160)+j*120,50+compt*90);
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
                        GrosPanel lenouv = new GrosPanel(terrain);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        lenouv.setLocation((100) +j*120,50+compt*90);
                        System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
            }
            compt++;
        }
        this.creationIle();
        this.miseEnPlaceMonstre();
        
        for (GrosPanel image : imageTuile) {
            for (tuiles imageTuile : carte) {
                if ((image.j==imageTuile.y)&&(image.k==imageTuile.x)) {
                    image.choixImage(imageTuile);
                }
            }           
        }
        /*Scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Scroll.add(legros);
        Scroll.setMinimumSize(new Dimension(200, 200));
        Scroll.setVisible(true);*/
        Scroll = new JScrollPane(legros, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        legros.setPreferredSize(new Dimension(1600,1300));
        Scroll.setBounds(largeur/8, hauteur/8, 6*largeur/8, 6*hauteur/8);
        //legros.setBounds(0, 0, largeur, hauteur);
        
        mine.getContentPane().add(Scroll);
       // mine.getContentPane().add(Scroll);
        legros.setVisible(true);
        mine.setSize(largeur, hauteur);
        mine.setVisible(true);
    }
    public void miseEnPlaceDesPetitPanel() throws IOException
    {
        for (Component LesPanels : Scroll.getComponents()) 
        {
            System.out.println("1er for");
            if(LesPanels instanceof GrosPanel)
            {
                System.out.println("le premier if du premier for");
                GrosPanel panel = (GrosPanel) LesPanels;
                for (int i = 0; i < 7; i++) 
                {
                    System.out.println("le deuxieme for");
                    PetitPanel unite = null;
                    if(i==0)
                    {
                        unite = new PetitPanel();
                        unite.setLocation(45, 45);
                        System.out.println("1er if");
                        
                    }
                    else if(i==1)
                    {
                        unite = new PetitPanel();
                        unite.setLocation(20, 10);
                        System.out.println("2eme if");
                    }
                    else if(i==2)
                    {
                        unite = new PetitPanel();
                        unite.setLocation(75, 15);
                        System.out.println("3eme if");
                    }
                    else if(i==3)
                    {
                        unite = new PetitPanel();
                        unite.setLocation(15, 75);
                        System.out.println("4eme if");
                    }
                    else if(i==4)
                    {
                        unite = new PetitPanel();
                        unite.setLocation(75, 75);
                        System.out.println("5eme if");
                    }
                    else if(i==5)
                    {
                        unite = new PetitPanel();
                        unite.setLocation(5, 45);
                        System.out.println("6eme if");
                    }
                    else
                    {
                        unite = new PetitPanel();
                        unite.setLocation(85, 45);
                        System.out.println("7eme if");
                    }
                    panel.add(unite);
                    panel.affichageUnite.add(unite);
                    
                }
            }
            
        }
        GrosPanel truc = null;
        if(truc instanceof GrosPanel)
        {
            truc =(GrosPanel) Scroll.getComponent(3);
        }
        for (PetitPanel trucbis : truc.affichageUnite) {
            System.out.println(" "+trucbis.numeroJoueur);
        }
        
    }
    //création de l'ile
    public void creationIle()
    {
        for (tuiles ile : carte) {
            if (ile.y==3) {
                if ((ile.x==5)||(ile.x==7)) {
                   ile.type=1;
                }
                else if((ile.x==6)||(ile.x==8))
                {
                    ile.type=2;
                }
            }
            else if(ile.y==4){
               if ((ile.x==7)||(ile.x==9)) {
                   ile.type=1;
               }
               else if (ile.x==5) {
                   ile.type=2;
               }
               else if ((ile.x==6)||(ile.x==8)) {
                   ile.type=3;
               }
            }
            else if(ile.y==5){
               if ((ile.x==4)||(ile.x==7)||(ile.x==8)) {
                   ile.type=1;
               }
               else if ((ile.x==5)||(ile.x==6)||(ile.x==9)||(ile.x==10)||(ile.x==11)) {
                   ile.type=2;
               }
            }
            else if(ile.y==6){
               if ((ile.x==5)||(ile.x==10)||(ile.x==11)) {
                   ile.type=1;
               }
               else if ((ile.x==6)||(ile.x==7)||(ile.x==9)) {
                   ile.type=3;
               }
            }
            else if(ile.y==7){
               if ((ile.x==5)||(ile.x==9)||(ile.x==12)) {
                   ile.type=1;
               }
               else if ((ile.x==6)||(ile.x==7)||(ile.x==8)||(ile.x==10)) {
                   ile.type=2;
               }
               else if ((ile.x==11)) {
                   ile.type=3;
               }
            }
            else if(ile.y==8){
               if ((ile.x==9)) {
                   ile.type=1;
               }
               else if ((ile.x==7)||(ile.x==11)) {
                   ile.type=2;
               }
               else if ((ile.x==8)||(ile.x==10)) {
                   ile.type=3;
               }
            }
            else if(ile.y==9){
               if ((ile.x==8)||(ile.x==11)) {
                   ile.type=1;
               }
               else if ((ile.x==9)||(ile.x==10)) {
                   ile.type=2;
               }
            }
        }
  
    }
    
    public boolean ajoutEplorateursTuile(tuiles cible, explorateurs uniteDeplacer){
        
        if (cible.explorateurs.size()!=4) {
            cible.explorateurs.add(uniteDeplacer);
            return true;
        }
        return false;
        //messagebox de refus du déplacement
    }
    
    public boolean ajoutMonstresTuile(tuiles cible, monstres monstreDeplacer){
        
        if (cible.monstres.size()!=4) {
            for (monstres monstrePresent : cible.monstres) {
                if (monstreDeplacer.type==monstrePresent.type) {
                    return false;
                }
            }   
            cible.monstres.add(monstreDeplacer);
            return true;
        }
        return false;
        //messagebox de refus du déplacement     
    }
    
    public boolean ajoutBateauTuile(tuiles cible, bateaux bateauDeplacer){
        if (cible.bateaux.size()==1) {
            return false;
            //messagebox de refus du déplacement
        }
        cible.bateaux.add(bateauDeplacer);
        return true;
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
    
    //creation des premeirs monstres sur le plateau
    public void miseEnPlaceMonstre()
    {
        //mise en place des premiers monstres du début de partie
        monstres plateaumonstres1= new monstres("Serpent de mer", 1, 2, 1, 1);
        monstres plateaumonstres2= new monstres("Serpent de mer", 1, 2, 9, 2);
        monstres plateaumonstres3= new monstres("Serpent de mer", 1, 2, 5, 6);
        monstres plateaumonstres4= new monstres("Serpent de mer", 1, 2, 10, 10);
        monstres plateaumonstres5= new monstres("Serpent de mer", 1, 2, 15, 11);
        
        //ajout des monstres au vecteur unité de partie
        this.population.add(plateaumonstres1);
        this.population.add(plateaumonstres2);
        this.population.add(plateaumonstres3);
        this.population.add(plateaumonstres4);
        this.population.add(plateaumonstres5);
    }
    
    public void pouvoirImmediat(tuiles pouvoirJoueur)
    {
        monstres apparition;
        switch(pouvoirJoueur.pouvoir)
        {
            case 0: case 1:
                if (pouvoirJoueur.pouvoir==0) {
                    apparition= new monstres("Requin",2,0,pouvoirJoueur.x,pouvoirJoueur.y);
                }
                else
                {
                   apparition= new monstres("Baleine",3,1,pouvoirJoueur.x,pouvoirJoueur.y); 
                }               
                pouvoirJoueur.monstres.add(apparition);
                apparition.attaque(pouvoirJoueur, apparition);
            break;
            case 2:
                bateaux newbateau = new bateaux(pouvoirJoueur.x,pouvoirJoueur.y);
            break;
            case 3: //tourbillon à faire plus tard
            break;
            case 4: //fin du jeu à faire plus tard
                //on compte les points pour chacun des Joueurs
                for (joueurs challenger : participant) {
                    finDePartie(challenger);
                }
            break;                              
        }
    }
    
    public void pouvoirEnMain(tuiles pouvoirJoueur)
    {
        
    }
    
    public void pouvoirDefense(tuiles pouvoirJoueur)
    {
        
    }
    
    //phase de deploiement des explorateurs des joueurs
    public boolean deploiement(joueurs tourJoueur, explorateurs pionschoisi, tuiles choisi)
    {
        if ((choisi.type==0)||(choisi.explorateurs.size()!=0)) {
            return false;
        }
        else
        {
            //il faudra 
            choisi.explorateurs.add(pionschoisi);
            return true;
        }
    }
    
    //phase de déplacement des unités
    /*public void deplacementUnite(joueurs tourJoueur)
    {
        
    }*/
    
    //lance de dée de la créature
    public int deeCreature()
    {
        int valeurMin=0;
        int valeurMax= 2;
        Random r = new Random();
        int valeur = valeurMin + r.nextInt(valeurMax - valeurMin);
        return valeur;
    }
    
    public void finDePartie(joueurs joueurPoint)
    {
        //fin de partie, on va compter les rescapé en les stockant dans un vecteur et enuiste on compte les point
        Vector<explorateurs> survivants= new Vector<explorateurs>();
        
        for (explorateurs valeurPion : survivants) {           
            if (joueurPoint.membres.contains(valeurPion)) {
                joueurPoint.pointVictoire= joueurPoint.pointVictoire + valeurPion.points;
            }
        }
        
    }
}
