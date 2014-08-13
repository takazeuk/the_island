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

/**
 *
 * @author Jonathan
 */
public class ImPan extends JPanel{
    public BufferedImage m_image;
    int k, j;
    public ImPan(int x, int y) throws IOException
    {
        super();
       
           k = x;
           j = y;
           m_image = ImageIO.read(getClass().getResource("/images/exal.png"));
       
       
    }
    
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, k, j, 60, 60, null);
    }
}
