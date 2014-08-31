/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import partie.partie;

/**
 *
 * @author Jonathan
 */
public class PetitPanel extends JPanel implements ActionListener{
    public BufferedImage m_image;
    public int numeroUnite;
    public int numeroPetitPanel;
    public GrosPanel conteneur;
    public MoustenerPetitPanel clicDuPetitPanel;
    public partie partieEnCours;
            
    public PetitPanel(int numero, GrosPanel envoye) throws IOException
    {
        numeroUnite = 4;
        numeroPetitPanel = numero;
        conteneur= envoye;
        this.setSize(10, 10);
        this.setVisible(true);
        clicDuPetitPanel = new MoustenerPetitPanel(this, this.partieEnCours);
        this.addMouseListener(clicDuPetitPanel);
        //il faut mettre un déactivé que l'on active que lorsqu'il y a une unité
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
      
        m_image = ImageIO.read(getClass().getResource("/images/barque.jpe"));
    
        repaint();
    }
    @Override public void paintComponent(Graphics g)
    {
        g.drawImage(m_image, 0, 0, 10, 10, null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
