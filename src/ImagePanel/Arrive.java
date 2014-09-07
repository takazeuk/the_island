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
public class Arrive extends JPanel{
    BufferedImage m;
    public Arrive() throws IOException
    {
        this.setLayout(null);
        this.setOpaque(false);
        this.setSize(56, 48);
        m = ImageIO.read(getClass().getResource("/images/Houses.png"));
    }
    
    public void paintComponent(Graphics g)
    {
        g.drawImage(m, 0, 0, 56, 48, null);
    }
}
