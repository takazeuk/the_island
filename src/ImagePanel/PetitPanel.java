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
    public PetitPanel() throws IOException
    {
        numeroJoueur = 4;
        this.setSize(10, 10);
        m_image = ImageIO.read(getClass().getResource("/images/Perso-Rouge.png"));
        this.setVisible(true);
    }
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 10, 10, null);
    }
}
