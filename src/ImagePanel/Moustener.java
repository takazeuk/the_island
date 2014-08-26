/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ImagePanel;

import MessageBox.Interaction;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 *
 * @author Jonathan
 */
public class Moustener extends MouseAdapter
{
 @Override 
 public void mouseClicked(MouseEvent e) 
    {
	int nb = Interaction.demandeChoix("Quel unité voulez-vous déplacer?");
    }
		
}
