/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package MessageBox;
import java.awt.Component;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import unités.explorateurs;
/**
 *
 * @author Jonathan
 */
public class Interaction {
    public static void affiche(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static int demandeChoix(String s, String l, Object[] tab) {
        return (int) JOptionPane.showInputDialog(
                null,
                s,
                l,
                JOptionPane.QUESTION_MESSAGE,
                null,
                tab,
                tab[0]
        );
    }
    
    public static int demandeChoixJoueur(String s)
    {
        return (int) JOptionPane.showConfirmDialog(null, s, "Oui ou Non... faite votre choix", JOptionPane.YES_NO_OPTION);
    }

    public static int demandeChoix(String s, String l, Vector v) {
        return demandeChoix(s, l, v.toArray());
    }

    public static int demandeChoix(String s) {
        
        return Integer.parseInt(JOptionPane.showInputDialog(s));
   }
    public static String demandeChaine(String s) {
        return JOptionPane.showInputDialog(s);
    }
    
    public static void messageJoueur(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    
    

    
}
