/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan
 */
public class PetitPanel extends JPanel{
    public BufferedImage m_image;
    public int numeroJoueur;
    public int numeroPetitPanel;
            
    public PetitPanel(int numero) throws IOException
    {
        numeroJoueur = 4;
        numeroPetitPanel = numero;
        this.setSize(10, 10);
        this.setVisible(true);
    }
    
    public void choixImage() throws IOException
    {          
          if(this.numeroJoueur==0)
          {
             m_image = ImageIO.read(getClass().getResource("/images/Perso-Rouge.png"));
          }               
          else if(this.numeroJoueur==1)
          {
             m_image = ImageIO.read(getClass().getResource("/images/sable.png"));
          }
          else if(this.numeroJoueur==2)
          {
             m_image = ImageIO.read(getClass().getResource("/images/foret.png"));
          }
          else if (this.numeroJoueur==3)
          {
             m_image = ImageIO.read(getClass().getResource("/images/montagne.png"));
          }
          else
          {
             m_image = ImageIO.read(getClass().getResource("/images/montagne.png"));  
          }
    }
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 10, 10, null);
    }
}
