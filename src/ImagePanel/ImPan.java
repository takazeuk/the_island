/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import terrain.tuiles;

/**
 *
 * @author Jonathan
 */
public class ImPan extends JPanel{
    public BufferedImage m_image, m_monstres;
    public int k, j;
    public tuiles terrain;
    boolean b;
    public ImPan(tuiles envoye) throws IOException
    {
        super();
       
           k = envoye.x;
           j = envoye.y;
           terrain = envoye;
           m_image = ImageIO.read(getClass().getResource("/images/eau.png"));
    }
    
    public void choixImage(tuiles terrain) throws IOException
    {
          
          if(terrain.type==0)
          {
            m_image = ImageIO.read(getClass().getResource("/images/eau.png"));
            m_monstres = ImageIO.read(getClass().getResource("/images/SDM.png"));
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
    }
    
    public void placeUnité(tuiles terrain) throws IOException
    {
        
    }
    
    
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 120, 120, null);
        if(b)
        {
            g.fillOval(55, 55,5, 5);
            g.fillOval(30, 20,5, 5);
            g.fillOval(85, 25,5, 5);
            g.fillOval(25, 85,5, 5);
            g.fillOval(85, 85,5, 5);
            g.fillOval(15, 55,5, 5);
            g.fillOval(95, 55,5, 5);
        }
        
    }
}
