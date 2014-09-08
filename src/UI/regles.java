/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import javax.swing.JFrame;

/**
 *
 * @author Takazeuk
 */
public class regles extends javax.swing.JFrame {

    /**
     * Creates new form regles
     */
    public regles() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Phase Tuile Terrain\n\n-Une et une seule fois par tour, vous pouvez jouer une tuile de Pouvoir que vous avez obtenue lors d’un tour précédent.\n\n-Si vous ne souhaitez pas jouer de tuile Pouvoir, vous pouvez passer cette étape en indiquant « non » lors du Message de cette phase.\n\n-Pour jouer une tuile Pouvoir, il suffit de cliquer sur Carte(s) en main et de sélectionner le pouvoir. Suivez les instructions qui sont écrit sous la carte pour appliquer le pouvoir.\n");
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addTab("Phase Tuile Terrain", jScrollPane1);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Déplacez vos pions Explorateur et/ou Bateau\n\nVous pouvez déplacer n’importe quelle combinaison de pions Explorateur et/ou Bateau. Vous avez droit à trois cases de déplacement au total, sur terre ou sur mer. Par exemple, vous pouvez déplacer deux pions Explorateur d’une case pour les faire entrer dans un Bateau, puis déplacer le Bateau en question d’une case. Le but consiste à faire entrer vos Explorateurs dans des Bateaux et à les emmener vers les îles voisines. \n\nPour faire un déplacement cliquer sur l’unité que vous voulez déplacer. Vous aurez un message vous confirmant qu’elle est bien sélectionnée. Cliquer ensuite sur une case adjacente à cette unité.\n\nATTENTION : lorsqu’un explorateur passe sur une tuile d’eau, il ne peut plus retourner sur une tuile terre, de l’ile principale, il devient un nageur et ne plus se déplacer que sur des cases de type eau.\n");
        jScrollPane2.setViewportView(jTextArea2);

        jTabbedPane1.addTab("Déplacement", jScrollPane2);

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("Retirez une tuile de Terrain\n\nVous devez retirer une tuile de Terrain de l’île. Tout Explorateur qui y était placé se retrouve dans la case mer qu’elle occupait auparavant, et devient un Nageur. \n\nVous devez respecter deux conditions lorsque vous retirez une tuile de Terrain. Tout d’abord, vous devez choisir une tuile adjacente à au moins une case de mer (même s’il s’agit d’une case où se trouvait une autre tuile de Terrain auparavant).\n\nDeuxièmement, toutes les tuiles Plage doivent être retirées en premier, puis les tuiles Forêt, et finalement les tuiles Montagne. En effet, les Terrains plus proches du niveau de la mer sombrent en premier. Au cas où une tuile Plage serait entourée de tuiles Forêt et/ou Montagne, retirez la en tant que dernière tuile Plage (même si elle n’est pas adjacente à une case de mer). Il en va de même pour une éventuelle tuile Forêt entourée de Montagnes.\n");
        jScrollPane3.setViewportView(jTextArea3);

        jTabbedPane1.addTab("Retirer tuile", jScrollPane3);

        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("Monstres\n\nVous pouvez déplacer d’une ou plusieurs cases de mer une Créature (Serpent de mer, Requin ou Baleine) correspondant au résultat du dé et déjà présente sur le plateau de jeu.\n\nSerpent de mer\nSi le résultat du jet de dé est un Serpent de mer, déplacez l’une de ces créatures d’une case de mer. Si le Serpent de mer arrive dans une case de mer occupée par un Bateau contenant des passagers, retirez celui-ci et ses occupants du jeu. Retirez également tous les Nageurs occupant la case de mer. S’il s’agit d’un Bateau vide, il reste en place\nRequin\nSi le résultat du jet de dé est un Requin, déplacez l’une de ces créatures d’une ou deux cases de mer. Si le Requin entre sur une case de mer occupée par un ou plusieurs Nageurs, le mouvement du Requin s’achève. Retirez tous les Nageurs de la case de mer où le Requin s’est arrêté. Si la case où il se trouve contient un Bateau, le Requin ne l’affecte pas.\n\nBaleine\nSi le résultat du jet de dé est une Baleine, déplacez l’une de ces créatures d’une à trois cases de mer. Si la Baleine entre sur une case de mer occupée par un Bateau contenant un ou plusieurs passagers, son mouvement s’achève : le Bateau est retiré du jeu et ses occupants deviennent des Nageurs. Si la case de mer contient également un Requin, les Nageurs sont retirés du jeu. Une Baleine n’affecte ni les Nageurs ni le Bateau vide situés dans la même case de mer qu’elle.\n");
        jScrollPane4.setViewportView(jTextArea4);

        jTabbedPane1.addTab("Monstres", jScrollPane4);

        jTextArea5.setColumns(20);
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(5);
        jTextArea5.setText("Les Explorateurs sur terre\n\n• Vous pouvez déplacer un pion Explorateur depuis une tuile de Terrain vers une tuile de Terrain adjacente, même si cette dernière est déjà occupée par un ou plusieurs pions Explorateur. ATTENTION : il ne peut y avoir que 3 explorateurs par cases\n\n• Vous pouvez déplacer un pion Explorateur depuis une tuile de Terrain vers un Bateau placé sur une case de mer adjacente.\n\n• Vous pouvez déplacer un pion Explorateur dans un Bateau déjà occupé par des Explorateurs d’une autre couleur (mais pas plus de 3 personnes par bateau).\n\n• Vous ne pouvez pas déplacer les pions Explorateur d’un autre joueur.\n\n• Une fois qu’un pion Explorateur quitte l’île (en montant sur un Bateau ou en devenant un Nageur), il ne peut plus retourner sur une tuile de Terrain\n\nLes Explorateurs dans l’eau (Les Nageurs)\n\nLes pions Explorateur deviennent des Nageurs lorsqu’ils se déplacent dans une case mer à partir d’une tuile de Terrain adjacente, ou quand ils vont sur un bateau.\n\nVous ne pouvez déplacer un Nageur sur un Bateau que s’ils occupent tous deux la même case de mer ou s’il monte dedans depuis la rive.\n\nUne case de mer peut accueillir plusieurs Nageurs (3 maximums)\n\nSi vous déplacez un Nageur dans une case de mer contenant un Serpent de mer ou un Requin, le Nageur est immédiatement retiré du jeu. \n\nLes Bateaux\n\nQuand un Bateau est vide, n’importe quel joueur peut le déplacer d’une case de mer à l’autre comme il le désire (à raison d’un déplacement par case).\n\nUne case de mer ne peut contenir qu’un seul Bateau à la fois.\n\nChaque Bateau peut transporter jusqu’à trois pions Explorateur au maximum (quelles que soient leurs couleurs).\n\nQuand un Bateau contient des Explorateurs appartenant à plusieurs joueurs, c’est celui qui a le plus d’Explorateurs à bord qui le contrôle. Quand vous contrôlez un Bateau, vous seul pouvez le déplacer.\n\nQuand plusieurs joueurs ont le même nombre d’Explorateurs dans un Bateau, chaque joueur contrôle le Bateau.\n\nSi vous déplacez un Bateau contenant un ou plusieurs Explorateurs dans une case de mer contenant un Serpent de mer ou une Baleine, le Bateau est immédiatement retiré du jeu, et ses occupants deviennent des Nageurs (n’oubliez pas que si la case mer contient un Requin ou un Serpent de mer, ces Nageurs sont retirés du jeu).\n");
        jScrollPane5.setViewportView(jTextArea5);

        jTabbedPane1.addTab("Explorateurs", jScrollPane5);

        jTextArea6.setColumns(20);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setText("Atteindre le Village\n\nLes Explorateurs peuvent débarquer d’un Bateau placé sur une des deux cases de mer adjacentes à l’une des îles sûres. Chaque pion Explorateur qui sort du Bateau pour entrer sur l’île coûte un déplacement. Le Bateau reste sur la même case de mer jusqu’à ce qu’on le déplace à nouveau.\n\nUn nageur peut aussi atteindre l’un des villages à la nage, celui lui coutera également un déplacement et il doit aussi passer par une des deux cases adjacentes\nVos Explorateurs peuvent débarquer sur n’importe quelle île sûre, pas seulement sur celle qui se trouve devant vous.\n");
        jScrollPane6.setViewportView(jTextArea6);

        jTabbedPane1.addTab("Village", jScrollPane6);

        jTextArea7.setColumns(20);
        jTextArea7.setLineWrap(true);
        jTextArea7.setRows(5);
        jTextArea7.setText("Fin du Jeu\n\nSous une des tuiles Montagne se trouve un volcan. Dès qu’un joueur révèle cette tuile, une éruption volcaniquedétruit ce qui reste de l’île ainsi que les Explorateurs qui n’ont pas\nencore débarqué sur les îles sûres.\n\nLa partie est terminée");
        jScrollPane7.setViewportView(jTextArea7);

        jTabbedPane1.addTab("Fin Du Jeu", jScrollPane7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(regles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new regles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    // End of variables declaration//GEN-END:variables
}