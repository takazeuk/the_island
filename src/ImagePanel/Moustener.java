/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import MessageBox.Interaction;
import static MessageBox.Interaction.messageJoueur;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class Moustener extends MouseAdapter
{
    int x;
    int y;
    
    public Moustener(GrosPanel P)
    {
        x = P.j;
        y = P.k;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
	messageJoueur(""+x+" "+y);
    }
    
    
		
}
