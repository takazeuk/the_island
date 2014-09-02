/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;


import MessageBox.Interaction;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import partie.partie;
import terrain.tuiles;
import unités.explorateurs;
import unités.unites;


/**
 *
 * @author Jonathan
 */
public class GrosPanel extends JPanel{
    public BufferedImage m_image, m_monstres;
    public int k, j;
    public tuiles terrain;
    public boolean b;
    public Vector <PetitPanel> affichageUnite;
    public MoustenerGrosPanel clicDuPanel;
    public partie partieEnCours;

    //public int nb;
    public GrosPanel(tuiles envoye, partie partie) throws IOException
    {
        super();
       
           k = envoye.x;
           j = envoye.y;
           terrain = envoye;
           //m_image = ImageIO.read(getClass().getResource("/images/eau.png"));
           this.setOpaque(false);
           affichageUnite = new Vector<PetitPanel>();
           this.partieEnCours= partie;
           clicDuPanel = new MoustenerGrosPanel(this, this.partieEnCours);
           this.addMouseListener(clicDuPanel);
           
    }
    
    /*public ImPan(int numJoueur)throws IOException
    {
        super();
        nb = numJoueur;
        m_image = ImageIO.read(getClass().getResource("/images/pawn_256.png"));
    }*/
    public void choixImage(tuiles terrain) throws IOException
    {
          
          if(terrain.type==0)
          {
            m_image = ImageIO.read(getClass().getResource("/images/Eau-vide.png"));
            b = true;
          }               
          else if(terrain.type==1)
          {
              m_image = ImageIO.read(getClass().getResource("/images/sable.png"));
              b = false;
          }
          else if(terrain.type==2)
          {
             m_image = ImageIO.read(getClass().getResource("/images/foret.png"));
             b = false;
          }
          else
          {
             m_image = ImageIO.read(getClass().getResource("/images/montagne.png"));
             b = false;
          }
          repaint();
    }
       
    public void placeUnité(tuiles terrain) throws IOException
    {
        
    }
    
    public void refreshImage() throws IOException
    {
        this.m_image = ImageIO.read(getClass().getResource("/images/Eau-vide.png"));
        repaint();
    }
    
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 120, 120, null);
        /*if(b)
        {
            g.fillOval(55, 55,5, 5);
            g.fillOval(30, 20,5, 5);
            g.fillOval(85, 25,5, 5);
            g.fillOval(25, 85,5, 5);
            g.fillOval(85, 85,5, 5);
            g.fillOval(15, 55,5, 5);
            g.fillOval(95, 55,5, 5);
        }*/
    }
    
    public boolean tuileAdjacenteEau(tuiles cible)
    {
       if (((k==cible.x)&&(j==cible.y-1))||((k==cible.x)&&(j==cible.y+1))||((k==cible.x+1)&&(j==cible.y))||((k==cible.x-1)&&(j==cible.y))||((k==cible.x-1)&&(j==cible.y-1))||((k==cible.x+1)&&(j==cible.y+1)))
       {
           if(terrain.type==0)
           {
               return true;
           }
       }
       return false;
    }
    
    
    public void AucunExplorateur() throws IOException
    {
        MessageBox.Interaction.messageJoueur("Je suis rentrer dans aucunExplorateur");
        if(this.terrain.explorateurs.size()==0)
        {
            MessageBox.Interaction.messageJoueur(""+this.terrain.explorateurs.size());
            for (PetitPanel petitPanel: affichageUnite)
            {
                if(petitPanel.numeroUnite==0 ||petitPanel.numeroUnite==1 || petitPanel.numeroUnite==2 || petitPanel.numeroUnite==3)
                {
                    MessageBox.Interaction.messageJoueur("Je passe les numeroUnite a 4");
                    petitPanel.numeroUnite=4;
                    petitPanel.refreshexplorateurs();
                }
            }
            
        }
    }
    
    public void gestionDesProprioBateau()
    {
        if(this.terrain.bateaux.get(0).marins.size()==3)
        {
            if(terrain.bateaux.get(0).marins.get(0).proprietaire==terrain.bateaux.get(0).marins.get(1).proprietaire)
            {
                terrain.bateaux.get(0).proprietaire = terrain.bateaux.get(0).marins.get(0).proprietaire;
            }
            if(terrain.bateaux.get(0).marins.get(0).proprietaire==terrain.bateaux.get(0).marins.get(2).proprietaire)
            {
                terrain.bateaux.get(0).proprietaire = terrain.bateaux.get(0).marins.get(0).proprietaire;
            }
            if(terrain.bateaux.get(0).marins.get(1).proprietaire==terrain.bateaux.get(0).marins.get(2).proprietaire)
            {
                terrain.bateaux.get(0).proprietaire = terrain.bateaux.get(0).marins.get(1).proprietaire;
            }
        }
        else if (this.terrain.bateaux.get(0).marins.size()==1)
        {
            terrain.bateaux.get(0).proprietaire = terrain.bateaux.get(0).marins.get(0).proprietaire;
        }
        else
        {
            terrain.bateaux.get(0).proprietaire = 4;
        }
    }
    
     public void refreshGrosPanel() throws IOException{
         for (PetitPanel image : this.affichageUnite) {            
             image.refreshexplorateurs();
             image.refreshMonstres();
             image.refreshBateau();            
         }
     }
    
                    
    
    
    /**
     *
     * @param
     */
    
}
