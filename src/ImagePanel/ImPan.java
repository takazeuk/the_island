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
    public BufferedImage m_image;
    public int k, j;
    public tuiles terrain;
    
    public ImPan(tuiles envoye) throws IOException
    {
        super();
       
           k = envoye.x;
           j = envoye.y;
           terrain = envoye;
           m_image = ImageIO.read(getClass().getResource("/images/exal.png"));
    }
    
    public void choixImage(tuiles terrain) throws IOException
    {
          /*if(terrain.type==0)
          {
            m_image = ImageIO.read(getClass().getResource("/images/eau.png"));           
          }               
          else if(terrain.type==1)
          {
              m_image = ImageIO.read(getClass().getResource("/images/sable.png"));
          }
          else if(terrain.type==2)
          {
             m_image = ImageIO.read(getClass().getResource("/images/foret.jpg"));
          }
          else
          {
             m_image = ImageIO.read(getClass().getResource("/images/montagne.png"));
          }  */
    }
    
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 80, 80, null);
    }
}
