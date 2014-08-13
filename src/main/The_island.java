/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import ImagePanel.ImPan;
import UI.Int;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import joueurs.joueurs;
import partie.partie;
import terrain.tuiles;
import unités.unités;

/**
 *
 * @author TakazeukJo
 */
public class The_island {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner clavier= new Scanner(System.in);
        int nb;
   
        do
        {
            System.out.println("Combien de participants ? (4 maximums)");
            nb= clavier.nextInt();
            if(nb <= 4)
            {
               partie partie = new partie(nb); 
            }
            else
            {
                System.out.println("nombre de joueurs trop grand");
            }
        }
        while(nb > 4);
        Int mine = new Int();
        mine.setLayout(null);
        int i=0;
        int j=0;
        for (i = 0; i < 7; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(150+i*60,j*45);
        }
        j++;
        for (i = 0; i < 10; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(60+i*60,j*45);
        }
        j++;
        for (i = 0; i < 11; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(30+i*60,j*45);
        }
        j++;
        for (i = 0; i < 10; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(60+i*60,j*45);
        }
        j++;
        for (i = 0; i < 11; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(30+i*60,j*45);
        }
        j++;
        for (i = 0; i < 12; i++) {
            
           ImPan lenouv = new ImPan(0, 0);
           lenouv.setSize(60, 60);
           lenouv.setVisible(true);
           mine.getContentPane().add(lenouv);
           lenouv.setLocation(i*60,j*45);
        }
        j++;
        for (i = 0; i < 11; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(30+i*60,j*45);
        }
        j++;
        for (i = 0; i < 12; i++) {
            
           ImPan lenouv = new ImPan(0, 0);
           lenouv.setSize(60, 60);
           lenouv.setVisible(true);
           mine.getContentPane().add(lenouv);
           lenouv.setLocation(i*60,j*45);
        }
        j++;
        for (i = 0; i < 11; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(30+i*60,j*45);
        }
        j++;
        for (i = 0; i < 10; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(60+i*60,j*45);
        }
        j++;
        for (i = 0; i < 11; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(30+i*60,j*45);
        }
        j++;
        for (i = 0; i < 10; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(60+i*60,j*45);
        }
        j++;
        for (i = 0; i < 7; i++) {
            
            ImPan lenouv = new ImPan(0, 0);
            lenouv.setSize(60, 60);
            lenouv.setVisible(true);
            mine.getContentPane().add(lenouv);
            lenouv.setLocation(150+i*60,j*45);
        }
        mine.setSize(800, 800);
        mine.setVisible(true);
        
    }   
}
