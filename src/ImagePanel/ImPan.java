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
    
    public ImPan(int x, int y, tuiles envoye) throws IOException
    {
        super();
       
           k = x;
           j = y;
           terrain = envoye;
           m_image = ImageIO.read(getClass().getResource("/images/sable.png"));
           
          /* if(terrain.type==1)
           {
                m_image = ImageIO.read(getClass().getResource("/images/sable.png"));
           }
           else if(terrain.type==2)
           {
                m_image = ImageIO.read(getClass().getResource("/images/foret.png"));
           }
           else if(terrain.type==3)
           {
                m_image = ImageIO.read(getClass().getResource("/images/montagne.png"));
           }*/
    }
    
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, k, j, 60, 60, null);
    }
}
