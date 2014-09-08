/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import terrain.tuiles;

/**
 *
 * @author Jonathan
 */
public class imageCarte extends JPanel{
    tuiles carteTuile;
    BufferedImage image;
    public imageCarte(tuiles t)
    {
        carteTuile = t;
    }
    
    @Override
     public void paintComponent(Graphics g) 
    {
        try {
            switch(carteTuile.pouvoir)
            {
                case 5:
                    image = ImageIO.read(getClass().getResource("/images/unitesTuile/Perso-Rouge.png"));
                break;
                case 6:
                    image = ImageIO.read(getClass().getResource("/images/cartes/CarteBarque.png"));
                break;
                case 7:
                    image = ImageIO.read(getClass().getResource("/images/unitesTuile/SerpentDeMer.png"));
                break;
                case 8:
                    image = ImageIO.read(getClass().getResource("/images/unitesTuile/Requin.png"));
                break;
                case 9:
                    image = ImageIO.read(getClass().getResource("/images/unitesTuile/Baleine.png"));
                break;
            }
        } catch (IOException ex) {
            Logger.getLogger(imageCarte.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(image, 0, 0, 187, 129, null);
    }
}
