/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package MessageBox;
import java.awt.Component;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JOptionPane;
/**
 *
 * @author Jonathan
 */
public class Interaction {
    public static void affiche(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    public static int demandeChoix(String s, Object[] tab) {
        return (int) JOptionPane.showInputDialog(
                null,
                s,
                "titre",
                JOptionPane.OK_OPTION,
                null,
                tab,
                tab[tab.length-1]
        );
    }

    public static int demandeChoix(String s, Vector v) {
        return demandeChoix(s, v.toArray());
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
