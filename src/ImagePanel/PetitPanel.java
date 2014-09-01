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
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import partie.partie;

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
             m_image = ImageIO.read(getClass().getResource("/images/Perso-Rouge.png"));
          }               
          else if(this.numeroUnite==1)
          {
             m_image = ImageIO.read(getClass().getResource("/images/Perso-Vert.png"));
          }
          else if(this.numeroUnite==2)
          {
             m_image = ImageIO.read(getClass().getResource("/images/Perso-Rouge.png"));
          }
          repaint();
    }
    
    public void choixImageMonstre() throws IOException
    {          
          if(this.numeroUnite==5)
          {
             m_image = ImageIO.read(getClass().getResource("/images/Requin.png"));
          }               
          else if(this.numeroUnite==6)
          {
             m_image = ImageIO.read(getClass().getResource("/images/baleine.jpe"));
          }
          else if(this.numeroUnite==7)
          {
             m_image = ImageIO.read(getClass().getResource("/images/serpentDeMer.jpe"));
          }
          repaint();
    }
    
    public void choixImageBateau() throws IOException
    {          
      
        m_image = ImageIO.read(getClass().getResource("/images/barque.jpe"));
    
        repaint();
    }
    
    public void refreshexplorateurs() throws IOException
    {
        if(this.numeroUnite==0)
        {
            m_image = ImageIO.read(getClass().getResource("/images/Perso-Rouge.png"));
        }               
        else if(this.numeroUnite==1)
        {
            m_image = ImageIO.read(getClass().getResource("/images/sable.png"));
        }
        else if(this.numeroUnite==2)
        {
            m_image = ImageIO.read(getClass().getResource("/images/foret.png"));
        }
        else if (this.numeroUnite==3)
        {
            m_image = ImageIO.read(getClass().getResource("/images/montagne.png"));
        }
        else
        {
            m_image = null;
        }
        
        
        repaint();
    }
    
    public void refreshMonstres() throws IOException
    {
        if(this.numeroUnite==5)
        {
            m_image = ImageIO.read(getClass().getResource("/images/Requin.png"));
        }               
        else if(this.numeroUnite==6)
        {
            m_image = ImageIO.read(getClass().getResource("/images/baleine.jpe"));
        }
        else if(this.numeroUnite==7)
        {
            m_image = ImageIO.read(getClass().getResource("/images/serpentDeMer.jpe"));
        }
        
        else
        {
            m_image = null;
        }
        
        
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
    }

    
}
