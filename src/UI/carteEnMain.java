/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import partie.partie;
import terrain.tuiles;

/**
 *
 * @author Takazeuk
 */
public class carteEnMain extends javax.swing.JFrame {
    
    partie partieEnCours;
    JPanel[] tableauImage;
    JTextArea[] tableauTexte;
    JButton[] tableauBouton;
    /**
     * Creates new form carteEnMain
     */
    public carteEnMain(partie p) {
        initComponents();
        partieEnCours=p;
        tableauImage = new JPanel[]{imageCarte1};
        tableauTexte = new JTextArea[]{descriptionCarte1};
        tableauBouton = new JButton[]{valideCarte1};
        
        //je permet au zone de texte d'aller à la ligne
        for (JTextArea description : tableauTexte) {
            description.setLineWrap(true);
        }
    }
    
    public void placementTuile()
    {
        int i = 0;
        for (tuiles carteMain : partieEnCours.participant.get(partieEnCours.tourJoueur).cartesEnMain) {
            //tableauImage[i]= carteMain.type;
            tableauTexte[i].setText(carteMain.descriptionPouvoir);
        }        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Carte1 = new javax.swing.JPanel();
        valideCarte1 = new javax.swing.JButton();
        imageCarte1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionCarte1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Carte1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        valideCarte1.setText("Valider");
        valideCarte1.setName("0"); // NOI18N
        valideCarte1.setOpaque(false);
        valideCarte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valideCarteActionPerformed(evt);
            }
        });

        imageCarte1.setBorder(new javax.swing.border.MatteBorder(null));
        imageCarte1.setName("0"); // NOI18N

        javax.swing.GroupLayout imageCarte1Layout = new javax.swing.GroupLayout(imageCarte1);
        imageCarte1.setLayout(imageCarte1Layout);
        imageCarte1Layout.setHorizontalGroup(
            imageCarte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        imageCarte1Layout.setVerticalGroup(
            imageCarte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        descriptionCarte1.setEditable(false);
        descriptionCarte1.setColumns(20);
        descriptionCarte1.setRows(5);
        jScrollPane1.setViewportView(descriptionCarte1);

        javax.swing.GroupLayout Carte1Layout = new javax.swing.GroupLayout(Carte1);
        Carte1.setLayout(Carte1Layout);
        Carte1Layout.setHorizontalGroup(
            Carte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Carte1Layout.createSequentialGroup()
                .addGroup(Carte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Carte1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(valideCarte1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Carte1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(Carte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageCarte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        Carte1Layout.setVerticalGroup(
            Carte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Carte1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imageCarte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valideCarte1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Carte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Carte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(598, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valideCarteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valideCarteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valideCarteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(carteEnMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carteEnMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carteEnMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carteEnMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //paffichageCarte();

    }
    
    public void affichageCarte(){
        /*for (tuiles carte : partieEnCours.participant.get(partieEnCours.tourJoueur).cartesEnMain) {
            this.jList1.add(new JButton("toto"));
        }*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Carte1;
    private javax.swing.JTextArea descriptionCarte1;
    private javax.swing.JPanel imageCarte1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton valideCarte1;
    // End of variables declaration//GEN-END:variables
}
