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
import partie.partie;

/**
 *
 * @author Jonathan
 */
public class Arrive extends JPanel{
    BufferedImage m;
    int emplacement;
    public MoustenerArrive clicArrive;
    partie partieEnCours;
    public Arrive(int e, partie p) throws IOException
    {
        //
        partieEnCours = p;
        emplacement = e;
        this.setLayout(null);
        this.setOpaque(false);
        this.setSize(56, 48);
        m = ImageIO.read(getClass().getResource("/images/unitesTuile/Houses.png"));
        clicArrive = new MoustenerArrive(this, partieEnCours);
        this.addMouseListener(clicArrive);
    }
    
    public void paintComponent(Graphics g)
    {
        g.drawImage(m, 0, 0, 56, 48, null);
    }
}

