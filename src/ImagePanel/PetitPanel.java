/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import partie.partie;
import unités.explorateurs;

/**
 *
 * @author Jonathan
 */
public class PetitPanel extends JPanel{
    public BufferedImage m_image;
    public int numeroUnite;
    public int numeroPetitPanel;
    public GrosPanel conteneur;
    public MoustenerPetitPanel clicDuPetitPanel;
    public partie partieEnCours;
            
    public PetitPanel(int numero, GrosPanel envoye, partie p) throws IOException
    {
        numeroUnite = 4;
        numeroPetitPanel = numero;
        conteneur= envoye;
        partieEnCours= p;
        this.setSize(30, 30);
        this.setVisible(true);
        clicDuPetitPanel = new MoustenerPetitPanel(this, this.partieEnCours);
        this.addMouseListener(clicDuPetitPanel);
        this.setOpaque(false);
        //il faut mettre un déactivé que l'on active que lorsqu'il y a une unité
    }
    
    public void choixImageExplorateur() throws IOException
    {          
          if(this.numeroUnite==0)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Perso-Rouge.png"));
          }               
          else if(this.numeroUnite==1)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Perso-Vert.png"));
          }
          else if(this.numeroUnite==2)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Perso-Rose.png"));
          }
          else if(this.numeroUnite==3)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Perso-Jaune.png"));
          }
          else
          {
             m_image = null; 
          }
          repaint();
    }
    
    public void choixImageMonstre() throws IOException
    {          
          if(this.numeroUnite==5)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Requin.png"));
          }               
          else if(this.numeroUnite==6)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Baleine.png"));
          }
          else if(this.numeroUnite==7)
          {
             m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/SerpentDeMer.png"));
          }
          else
          {
              m_image = null;
          }
          repaint();
    }
    
    public void choixImageBateau() throws IOException
    {          
      
        m_image = ImageIO.read(getClass().getResource("/images/unitesTuile/Barque.png"));
    
        repaint();
    }
    
    public void refreshBateau() throws IOException
    {
        
        m_image = null;
    
        repaint();
    }
    
    
    
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 30, 30, null);
        if(this.numeroPetitPanel==6 && this.conteneur.terrain.bateaux.size()==1)
        {
            if(this.conteneur.terrain.bateaux.get(0).marins.size()>0)
            {
                int h = 8;
                for (explorateurs marins : this.conteneur.terrain.bateaux.get(0).marins) {
                    if(marins.proprietaire==0)
                    {
                        try {
                            m_image = ImageIO.read(getClass().getResource("/images/marinBateau/Marin-Rouge.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(PetitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(marins.proprietaire==1)
                    {
                       try {
                            m_image = ImageIO.read(getClass().getResource("/images/marinBateau/Marin-Vert.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(PetitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                    }
                    else if(marins.proprietaire==2)
                    {
                        try {
                            m_image = ImageIO.read(getClass().getResource("/images/marinBateau/Marin-Rose.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(PetitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else if(marins.proprietaire==3)
                    {
                        try {
                            m_image = ImageIO.read(getClass().getResource("/images/marinBateau/Marin-Jaune.png"));
                        } catch (IOException ex) {
                            Logger.getLogger(PetitPanel.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    g.drawImage(m_image, 11, h, 9, 5, null);
                    h+=6;
                }
            }
        }
            
        //mettre les pions sur le bateau grâce à cela
        /*try {
            g
        } catch (IOException ex) {
            Logger.getLogger(PetitPanel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    
}
