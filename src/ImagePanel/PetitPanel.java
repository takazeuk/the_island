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
    public int numeroUnite;
    public int numeroPetitPanel;
            
    public PetitPanel(int numero) throws IOException
    {
        numeroUnite = 4;
        numeroPetitPanel = numero;
        this.setSize(10, 10);
        this.setVisible(true);
    }
    
    public void choixImageExplorateur() throws IOException
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
          repaint();
    }
    
    public void choixImageMonstre() throws IOException
    {          
          if(this.numeroUnite==0)
          {
             m_image = ImageIO.read(getClass().getResource("/images/requin.jpe"));
          }               
          else if(this.numeroUnite==1)
          {
             m_image = ImageIO.read(getClass().getResource("/images/baleine.jpe"));
          }
          else if(this.numeroUnite==2)
          {
             m_image = ImageIO.read(getClass().getResource("/images/serpentDeMer.jpe"));
          }
          repaint();
    }
    
    public void choixImageBateau() throws IOException
    {          
          if(this.numeroUnite==7)
          {
             m_image = ImageIO.read(getClass().getResource("/images/barque"));
          }
          repaint();
    }
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 10, 10, null);
    }
}
