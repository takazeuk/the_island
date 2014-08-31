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
 * @author Takazeuk
 */
public class ImagePanel extends JPanel{
    public BufferedImage m_image;

    public ImagePanel(String s) throws IOException {
        m_image = ImageIO.read(getClass().getResource(s));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(m_image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
    
    
}
