package partie;

import ImagePanel.GrosPanel;
import ImagePanel.ImagePanel;
import ImagePanel.PetitPanel;
import static MessageBox.Interaction.messageJoueur;
import UI.Int;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import static java.awt.PageAttributes.MediaType.C;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import joueurs.joueurs;
import terrain.tuiles;
import unités.bateaux;
import unités.explorateurs;
import unités.monstres;
import unités.unites;

/**
 *
 * @author Takazeuk
 */
public class partie {
    public Vector<joueurs> participant;
    public Vector<tuiles> carte;
    public Vector<unites> population;
    public Vector<GrosPanel> imageTuile;
    public Int mine;
    public JScrollPane Scroll;
    //nous permet de passer au joueur suivant
    public int tourJoueur=0;
    //nous permet de donner une action différentes à notre clic
    public int flagAction=0;
    //nous permet de stocker le pion explorateur que l'on déplace
    public explorateurs exploDeplace;
    //nous permet de stocker le pion bateau que l'on déplace
    public bateaux bateauDeplace;
    //nous permet de stocker le pion monstre que l'on déplace
    public monstres monstreDeplace;
    //nous permet de stocker le grosPanel d'origine du déplacement
    public GrosPanel origineExplorateur;
    //nous permet de stocker le petitPanel d'origine du déplacement
    public PetitPanel panelRefresh;
    //flag de déplacement
    public int flagDeplacement=0;
    //choix du monstre à déplacer
    public int choixMonstre;
    //GrosPanel contenant tout le plateau
    JPanel legros = new ImagePanel("/images/Board.png");
    
    public partie(int nombreJoueur) throws IOException {
        this.participant= new Vector<joueurs>();
        this.carte= new Vector<tuiles>();
        this.population= new Vector<unites>();
        this.imageTuile= new Vector<GrosPanel>();
    }
    
    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int hauteur = (int)tailleEcran.getHeight();
    int largeur = (int)tailleEcran.getWidth();
    
    //fonction pour créer le plateau de jeu avec les tuiles
    public void creationPlateau() throws IOException
    {
        mine = new Int();
        mine.setLayout(null);
        
        //construction de la carte
        int compt=0;
        int j;       
        int cordy;
        
        legros.setLayout(null);
        //transformer en boucle for
        while (compt!=13) {            
            switch(compt)
            {
                case 0: case 12:
                    for(j=0; j<7; j++)
                    {
                        cordy=j+2;
                        if (compt == 12)
                        {
                            cordy = j+8;
                        }
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        
                        lenouv.setLayout(null);
                        miseEnPlaceDesPetitPanel(lenouv);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        lenouv.setLocation((400) +j*120,50+compt*90);
                        //lenouv.setBounds((largeur/2 - 210) +j*80, (hauteur/2 -(285+(65/2)))+compt*65, 80, 80);
                        //System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);                       
                    }
                break;
                case 1: case 3: case 9: case 11:
                    for(j=0; j<10; j++)
                    {
                        cordy=j+1;
                        if (compt == 3)
                        {
                            cordy = j+2;
                        }
                        if (compt == 9)
                        {
                            cordy = j+5;
                        } 
                        if (compt == 11)
                        {
                            cordy = j+6;
                        }
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        lenouv.setLayout(null);
                        miseEnPlaceDesPetitPanel(lenouv);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        //mine.getContentPane().add(lenouv);
                        lenouv.setLocation((220) +j*120,50+compt*90);
                        //lenouv.setBounds((largeur/2 - 300) +j*80, (hauteur/2 -(285+(65/2)))+compt*65, 80, 80);
                        //System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
                break;
                case 2: case 4: case 6: case 8: case 10:
                    for(j=0; j<11; j++)
                    {
                        cordy=j+1;
                        if (compt == 4)
                        {
                            cordy = j+2;
                        }
                        if (compt == 6)
                        {
                            cordy = j+3;
                        } 
                        if (compt == 8)
                        {
                            cordy = j+4;
                        }
                        if (compt == 10)
                        {
                            cordy = j+5;
                        }
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        lenouv.setLayout(null);
                        miseEnPlaceDesPetitPanel(lenouv);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        lenouv.setLocation((160)+j*120,50+compt*90);
                        //System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
                break;
                case 5: case 7:
                    for(j=0; j<12; j++)
                    {
                        cordy=j+2;
                        if (compt == 7)
                        {
                            cordy = j+3;
                        }
                        
                        tuiles terrain= new tuiles(cordy, compt, 0, 0);
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        lenouv.setLayout(null);
                        miseEnPlaceDesPetitPanel(lenouv);
                        imageTuile.add(lenouv);
                        lenouv.setSize(120, 120);
                        lenouv.setVisible(true);
                        legros.add(lenouv);
                        lenouv.setLocation((100) +j*120,50+compt*90);
                        //System.out.println("x="+ lenouv.terrain.x+ "y= "+ lenouv.terrain.y);
                    }
            }
            compt++;
        }
        this.creationIle();
        this.miseEnPlaceMonstre();
        
        for (GrosPanel image : imageTuile) {
            for (tuiles imageTuile : carte) {
                if ((image.j==imageTuile.y)&&(image.k==imageTuile.x)) {
                    image.choixImage(imageTuile);
                }
            }           
        }
        /*Scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        Scroll.add(legros);
        Scroll.setMinimumSize(new Dimension(200, 200));
        Scroll.setVisible(true);*/
        //miseEnPlaceDesPetitPanel();
        Scroll = new JScrollPane(legros, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        legros.setPreferredSize(new Dimension(1600,1300));
        Scroll.setBounds(largeur/8, hauteur/8, 6*largeur/8, 6*hauteur/8);
        
        //legros.setBounds(0, 0, largeur, hauteur);
        
        mine.getContentPane().add(Scroll);
       // mine.getContentPane().add(Scroll);
        legros.setVisible(true);
        mine.setSize(largeur, hauteur);
        mine.setVisible(true);
    }
    public void miseEnPlaceDesPetitPanel(GrosPanel tuile) throws IOException
    {
        int longueur = 30;
        int hauteur = 30;
        
        /*for (Component LesPanels : legros.getComponents()) 
        {
            System.out.println("1er for"+LesPanels.getClass().getName());
            if(LesPanels instanceof GrosPanel)
            {
                System.out.println("le premier if du premier for");
                GrosPanel panel = (GrosPanel) LesPanels;*/
                for (int i = 0; i < 7; i++) 
                {
                    PetitPanel unite;
                    if(i==0)
                    {
                       unite = new PetitPanel(0, tuile, this);
                       // unite.setSize(15, 15);
                        tuile.add(unite);
                        unite.setBounds(22, 15, 30, 30);
                        //unite.setLocation(20, 10);
                         
                    }
                    else if(i==1)
                    {
                       unite = new PetitPanel(1, tuile, this);
                        //unite.setSize(15, 15);
                        tuile.add(unite);
                        unite.setBounds(7, 45, hauteur, longueur);
                        //unite.setLocation(5, 45);
                        
                    }
                    else if(i==2)
                    {
                        unite = new PetitPanel(2, tuile, this);
                        //unite.setSize(15, 15);
                        tuile.add(unite);
                        unite.setBounds(22, 77, hauteur, longueur);
                        //unite.setLocation(15, 75);
                        
                    }
                    else if(i==3)
                    {
                        unite = new PetitPanel(3, tuile, this);
                        //unite.setSize(15, 15);
                        tuile.add(unite);
                        unite.setBounds(70, 80, hauteur, longueur);
                        //unite.setLocation(75, 75);
                        
                    }
                    else if(i==4)
                    {
                        unite = new PetitPanel(4, tuile, this);
                        //unite.setSize(15, 15);
                        tuile.add(unite);
                        unite.setBounds(90, 45, hauteur, longueur);
                        //unite.setLocation(85, 45);
                                            }
                    else if(i==5)
                    {
                        unite = new PetitPanel(5, tuile, this);
                        //unite.setSize(15, 15);
                        tuile.add(unite);
                        unite.setBounds(70, 10, hauteur, longueur);
                        //unite.setLocation(75, 15);
                        
                    }
                    else
                    {
                        //unite.setSize(10, 10);
                        //unite.setLocation(45, 45);
                        unite = new PetitPanel(6, tuile, this);
                        tuile.add(unite);
                        unite.setBounds(47, 45, hauteur, longueur);
                        //unite.setBounds(60, 60, 10, 10);
                        
                        
                    }
                    tuile.affichageUnite.add(unite);
                       
                }
            }
            
        
        /*Component c = legros.getComponent(3);
        System.out.println(" "+c.getClass().getName());
        GrosPanel g = (GrosPanel) c;
        System.out.println(" "+g.affichageUnite);
        /*GrosPanel truc = (GrosPanel)legros;
        if(truc instanceof GrosPanel)
        {
            truc =(GrosPanel) legros.getComponent(3);
        }
        System.out.println(""+truc.affichageUnite);*/
        /*for (PetitPanel trucbis : g.affichageUnite) {
            
            System.out.println(" "+trucbis.numeroUnite);
        }/**/
        
    
    //création de l'ile
    public void creationIle()
    {
        for (tuiles ile : carte) {
            if (ile.y==3) {
                if ((ile.x==5)||(ile.x==7)) {
                   ile.type=1;
                }
                else if((ile.x==6)||(ile.x==8))
                {
                    ile.type=2;
                }
            }
            else if(ile.y==4){
               if ((ile.x==7)||(ile.x==9)) {
                   ile.type=1;
               }
               else if (ile.x==5) {
                   ile.type=2;
               }
               else if ((ile.x==6)||(ile.x==8)) {
                   ile.type=3;
               }
            }
            else if(ile.y==5){
               if ((ile.x==4)||(ile.x==7)||(ile.x==8)) {
                   ile.type=1;
               }
               else if ((ile.x==5)||(ile.x==6)||(ile.x==9)||(ile.x==10)||(ile.x==11)) {
                   ile.type=2;
               }
            }
            else if(ile.y==6){
               if ((ile.x==5)||(ile.x==10)||(ile.x==11)) {
                   ile.type=1;
               }
               else if ((ile.x==6)||(ile.x==7)||(ile.x==9)) {
                   ile.type=3;
               }
            }
            else if(ile.y==7){
               if ((ile.x==5)||(ile.x==9)||(ile.x==12)) {
                   ile.type=1;
               }
               else if ((ile.x==6)||(ile.x==7)||(ile.x==8)||(ile.x==10)) {
                   ile.type=2;
               }
               else if ((ile.x==11)) {
                   ile.type=3;
               }
            }
            else if(ile.y==8){
               if ((ile.x==9)) {
                   ile.type=1;
               }
               else if ((ile.x==7)||(ile.x==11)) {
                   ile.type=2;
               }
               else if ((ile.x==8)||(ile.x==10)) {
                   ile.type=3;
               }
            }
            else if(ile.y==9){
               if ((ile.x==8)||(ile.x==11)) {
                   ile.type=1;
               }
               else if ((ile.x==9)||(ile.x==10)) {
                   ile.type=2;
               }
            }
        }
  
    }   
    
    public boolean ajoutEplorateursTuile(tuiles cible, explorateurs uniteDeplacer) throws IOException{
        
        if (cible.explorateurs.size()!=3) {
            affichageExplorateurs(cible, uniteDeplacer);
            cible.explorateurs.add(uniteDeplacer);
            return true;
        }
        return false;
        //messagebox de refus du déplacement
    }
    
    public boolean ajoutMonstresTuile(tuiles cible, monstres monstreDeplacer) throws IOException{
        
        if (cible.monstres.size()<3) {
            for (monstres monstrePresent : cible.monstres) {
                if (monstreDeplacer.type==monstrePresent.type) {
                    return false;
                }
            }
            affichageMonstre(cible, monstreDeplacer);
            cible.monstres.add(monstreDeplacer);
            return true;
        }
        return false;
        //messagebox de refus du déplacement     
    }
    
    public boolean ajoutBateauTuile(tuiles cible, bateaux bateauDeplacer){
        if (cible.bateaux.size()==1) {
            return false;
            //messagebox de refus du déplacement
        }
        cible.bateaux.add(bateauDeplacer);
        return true;
    }
    
    //création des explorateurs
    public void creationExplorateur(joueurs joueurCree)
    {
        explorateurs survivant;
        
        for(int compt=0; compt<3; compt++)
        {
            switch(compt)
            {
              case 0: case 1: case 2:
                  survivant= new explorateurs(1, 0, 0, joueurCree.couleur);
                  joueurCree.membres.add(survivant);
              break;
              /*case 3: case 4:
                  survivant= new explorateurs(2, 0, 0, joueurCree.couleur);
                  joueurCree.membres.add(survivant);
              break;
              case 5: case 6:
                  survivant= new explorateurs(3, 0, 0, joueurCree.couleur);
                  joueurCree.membres.add(survivant);
              break;
              case 7:
                  survivant= new explorateurs(4, 0, 0, joueurCree.couleur);
                  joueurCree.membres.add(survivant);
              break;
              case 8:
                  survivant= new explorateurs(5, 0, 0, joueurCree.couleur);
                  joueurCree.membres.add(survivant);
              break;
              case 9:
                  survivant= new explorateurs(6, 0, 0, joueurCree.couleur);
                  joueurCree.membres.add(survivant);
              break;*/
                  
                  
            }  
        }
        joueurCree.membresDeploiement=joueurCree.membres;
    }
    
    //creation des premeirs monstres sur le plateau
    public void miseEnPlaceMonstre() throws IOException
    {
        //mise en place des premiers monstres du début de partie
        monstres plateaumonstres1= new monstres("Serpent de mer", 1, 7, 1, 1);
        monstres plateaumonstres2= new monstres("Serpent de mer", 1, 7, 9, 2);
        monstres plateaumonstres3= new monstres("Serpent de mer", 1, 7, 5, 6);
        monstres plateaumonstres4= new monstres("Serpent de mer", 1, 7, 10, 10);
        monstres plateaumonstres5= new monstres("Serpent de mer", 1, 7, 15, 11);
        
        //ajout des monstres au vecteur unité de partie
        this.population.add(plateaumonstres1);
        this.population.add(plateaumonstres2);
        this.population.add(plateaumonstres3);
        this.population.add(plateaumonstres4);
        this.population.add(plateaumonstres5);
        
        this.ajoutMonstresTuile(this.carte.get(7), plateaumonstres1);
        this.ajoutMonstresTuile(this.carte.get(27), plateaumonstres2);
        this.ajoutMonstresTuile(this.carte.get(66), plateaumonstres3);
        this.ajoutMonstresTuile(this.carte.get(105), plateaumonstres4);
        this.ajoutMonstresTuile(this.carte.get(125), plateaumonstres5);
    }
    
    public void pouvoirImmediat(tuiles pouvoirJoueur)
    {
        monstres apparition;
        switch(pouvoirJoueur.pouvoir)
        {
            case 0: case 1:
                if (pouvoirJoueur.pouvoir==0) {
                    apparition= new monstres("Requin",2,5,pouvoirJoueur.x,pouvoirJoueur.y);
                }
                else
                {
                   apparition= new monstres("Baleine",3,6,pouvoirJoueur.x,pouvoirJoueur.y); 
                }               
                pouvoirJoueur.monstres.add(apparition);
                apparition.attaque(pouvoirJoueur, apparition);
            break;
            case 2:
                bateaux newbateau = new bateaux(pouvoirJoueur.x,pouvoirJoueur.y);
            break;
            case 3: //tourbillon fini
                pouvoir4DeLaTuile(pouvoirJoueur);
            break;
            case 4: //fin du jeu à faire plus tard
                //on compte les points pour chacun des Joueurs
                for (joueurs challenger : participant) {
                    finDePartie(challenger);
                }
            break;                              
        }
    }
    
    public boolean pouvoirEnMain(tuiles pouvoirJoueur, tuiles cible, joueurs j)
    {
        monstres deplacer;
        
        switch(pouvoirJoueur.pouvoir)
        {
            case 5:
                for (explorateurs nageurs : pouvoirJoueur.explorateurs) {
                    if(nageurs.proprietaire==j.couleur)
                    {
                        if(autoriserDeplacementPouvoirTuile(pouvoirJoueur, cible))
                        {
                            cible.explorateurs.add(nageurs);
                            return true;
                        }
                    }
                }
            break;
                
            case 6:
                for(bateaux tousLesBateaux : pouvoirJoueur.bateaux)
                {
                    if(tousLesBateaux.proprietaire==j.couleur || tousLesBateaux.proprietaire == 4)
                    {
                        if(autoriserDeplacementPouvoirTuile(pouvoirJoueur, cible))
                        {
                            cible.bateaux.add(tousLesBateaux);
                            return true;
                        }
                    }
                }
                    
            break;
                
            case 7: 
                if(cible.type==0)
                {
                    deplacer = new monstres("Serpent de mer", 1, 7, cible.x, cible.y);
                    cible.monstres.add(deplacer);
                    for (monstres serpentDeMer : pouvoirJoueur.monstres) {
                        if(serpentDeMer.type==2)
                        {
                            pouvoirJoueur.monstres.remove(serpentDeMer);
                        }
                        
                    }
                    return true;
                }
            break;
                
            case 8: 
                if(cible.type==0)
                {
                    deplacer = new monstres("Requin", 2, 5, cible.x, cible.y);
                    cible.monstres.add(deplacer);
                    for (monstres Requin : pouvoirJoueur.monstres) {
                        if(Requin.type==0)
                        {
                            pouvoirJoueur.monstres.remove(Requin);
                        }
                        
                    }
                    return true;
                }
            break;
                
            case 9:
                if(cible.type==0)
                {
                    deplacer = new monstres("Baleine", 3, 6, cible.x, cible.y);
                    cible.monstres.add(deplacer);
                    for (monstres Baleine : pouvoirJoueur.monstres) {
                        if(Baleine.type==1)
                        {
                            pouvoirJoueur.monstres.remove(Baleine);
                        }
                        
                    }
                    return true;
                }
            break;                              
        }
        return false;
    }
    
    public boolean pouvoirDefense(tuiles pouvoirJoueur, tuiles cible, joueurs j)
    {
        boolean flag = false;
        
        switch(pouvoirJoueur.pouvoir)
        {
            
            case 10:
                
                for(explorateurs pions: cible.explorateurs)
                {
                    if(pions.proprietaire == j.couleur)
                    {
                        flag = true;
                    }
                }
                
                if(flag)
                {
                    for(monstres creature: cible.monstres)
                    {
                        if(creature.deplacement==2)
                        {
                            cible.monstres.remove(creature);
                            return true;
                        }
                    }
                }
                
            break;
                
            case 11:
                
                for(bateaux barques: cible.bateaux)
                {
                    if(barques.proprietaire == j.couleur)
                    {
                        flag = true;
                    }
                }
                
                if(flag)
                {
                    for(monstres creature: cible.monstres)
                    {
                        if(creature.deplacement==2)
                        {
                            cible.monstres.remove(creature);
                            return true;
                        }
                    }
                }
            break;
        }
        // jo the best
        return false;
    }
    
    //phase de deploiementExplorateurs des explorateurs des joueurs
    public boolean deploiementExplorateurs(joueurs tourJoueur, explorateurs pionschoisi, tuiles choisi) throws IOException
    {
        if ((choisi.type==0)||(choisi.explorateurs.size()>0)) {
            if(choisi.type==0){
                messageJoueur("Vous ne pouvez pas mettre un explorateur sur une case d'eau lors de la phase de déploiement");
            }
            else{               
                messageJoueur(choisi.explorateurs.size()+"Vous ne pouvez pas mettre un pion sur cette case car il y a déjà un explorateur");
            }
            return false;
        }
        else
        {
            //il faudra 
            choisi.explorateurs.add(pionschoisi);
            pionschoisi.x=choisi.x;
            pionschoisi.y=choisi.y;
            affichageExplorateurs(choisi, pionschoisi);
            return true;
        }
    }
    
    public boolean deploiementBateaux(tuiles choisi) throws IOException
    {
        tuiles adjacente;
        int FlagType=0;
        for (tuiles tuilesCarte : carte) {
            //on regarde s'il y a une tuile adjecente de terre autour de l'endroit où on veut mettre le bateau
           if (((tuilesCarte.x==choisi.x)&&(tuilesCarte.y==choisi.y-1))||((tuilesCarte.x==choisi.x)&&(tuilesCarte.y==choisi.y+1))||((tuilesCarte.x==choisi.x+1)&&(tuilesCarte.y==choisi.y))||((tuilesCarte.x==choisi.x-1)&&(tuilesCarte.y==choisi.y))||((tuilesCarte.x==choisi.x-1)&&(tuilesCarte.y==choisi.y-1))||((tuilesCarte.x==choisi.x+1)&&(tuilesCarte.y==choisi.y+1))) {
               adjacente= tuilesCarte;
               if (adjacente.type!=0) {
                   FlagType=1;
               }
           }
                if ((choisi.type==0)&&(choisi.bateaux.isEmpty())&&(FlagType==1)&&(choisi.monstres.size()==0)) {
                    bateaux bateauxPlacement= new bateaux(choisi.x,choisi.y);
                    choisi.bateaux.add(bateauxPlacement);
                    for (Component temp  : legros.getComponents()) {
            
                        if(temp instanceof GrosPanel)
                        {               
                            GrosPanel territoire = (GrosPanel) temp;
                            if (territoire.terrain==choisi) {
                                territoire.affichageUnite.get(6).choixImageBateau();
                            }
                        }
                    }
                    return true;
                }
                FlagType=0;
        }         
        return false;
    }
       
    //phase de déplacement des unités
    /*public void deplacementUnite(joueurs tourJoueur)
    {
        
    }*/
    
    //lance de dée de la créature
    public void deeCreature()
    {
        int valeurMin=5;
        int valeurMax= 7;
        Random r = new Random();
        int valeur = valeurMin + r.nextInt(valeurMax - valeurMin);
        choixMonstre= valeur;
    }
    
    public String typeMonstre(int type){
        if (type==5) {
            return "Requin";
        }
        else if(type==6){
            return "Baleine";
        }
        else
        {
            return "Serpent de mer";
        }
    }
    
    public void finDePartie(joueurs joueurPoint)
    {
        //fin de partie, on va compter les rescapé en les stockant dans un vecteur et enuiste on compte les point
        Vector<explorateurs> survivants= new Vector<explorateurs>();
        
        for (explorateurs valeurPion : survivants) {           
            if (joueurPoint.membres.contains(valeurPion)) {
                joueurPoint.pointVictoire= joueurPoint.pointVictoire + valeurPion.points;
            }
        }
        
    }

    public boolean affichageExplorateurs(tuiles cible, explorateurs uniteDeplacer) throws IOException {
           
        for (Component temp  : legros.getComponents()) {
            
            if(temp instanceof GrosPanel)
            {
                
                GrosPanel territoire = (GrosPanel) temp;
                
                if (territoire.terrain==cible) {
                    
                    for (int i = 0; i < 3; i++) {
                        
                        //on cherche dans les petitspanels celui qui n'est pas occupé par un pion explorateur, 4 voulant dire qu'il n'y a personne
                        if (territoire.affichageUnite.get(i).numeroUnite==4) {
                            
                            territoire.affichageUnite.get(i).numeroUnite= uniteDeplacer.proprietaire;
                            territoire.affichageUnite.get(i).choixImageExplorateur();
                            return true;
                         //il faut mettre une fonction qui retire de l'ancien petit pannel le numero du joueur qui déplace l'unité pour enlever le pion de son ancienne position   
                        }
                    }
                }
            }
        }
        return false;
    }
        
    public boolean affichageMonstre(tuiles cible, monstres monstreDeplacer) throws IOException{
        
        for (Component temp  : legros.getComponents()) {
            
            if(temp instanceof GrosPanel)
            {
                
                GrosPanel territoire = (GrosPanel) temp;
                
                if (territoire.terrain==cible) {
                    
                    for (int i = 3; i < 6; i++) {
                        
                        //on cherche dans les petitspanels celui qui n'est pas occupé par un pion explorateur, 4 voulant dire qu'il n'y a personne
                        if (territoire.affichageUnite.get(i).numeroUnite==4) {
                            
                            territoire.affichageUnite.get(i).numeroUnite= monstreDeplacer.type;
                            territoire.affichageUnite.get(i).choixImageMonstre();
                            return true;
                         //il faut mettre une fonction qui retire de l'ancien petit pannel le numero du joueur qui déplace l'unité pour enlever le pion de son ancienne position   
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean affichageBateaux(tuiles cible, bateaux bateauDeplacer ) throws IOException{
        
        for (Component temp  : legros.getComponents()) {
            
            if(temp instanceof GrosPanel)
            {
                
                GrosPanel territoire = (GrosPanel) temp;
                
                if (territoire.terrain==cible) {
                                                                    
                    territoire.affichageUnite.get(6).choixImageBateau();
                    return true;                        
                }               
            }           
        }
        return false;
    }

    
    
    public boolean autoriserDeplacementPouvoirTuile(tuiles depart, tuiles arrive)
    {
        if(depart.x==arrive.x)
        {
            if(arrive.y==depart.y-1 || arrive.y==depart.y-2 || arrive.y==depart.y-3)
            {
                return true;
            }
            else if(arrive.y==depart.y+1 || arrive.y==depart.y+2 || arrive.y==depart.y+3)
            {
                return true;
            }
        }
        else if(depart.y==arrive.y)
        {
            if(arrive.x==depart.x-1 || arrive.x==depart.x-2 || arrive.x==depart.x-3)
            {
                return true;
            }
            else if(arrive.x==depart.x+1 || arrive.x==depart.x+2 || arrive.x==depart.x+3)
            {
                return true;
            }
        }
        else if((depart.x-1 == arrive.x && depart.y-1 == arrive.y) || (depart.x-2 == arrive.x && depart.y-2 == arrive.y) || (depart.x-3 == arrive.x && depart.y-3 == arrive.y))
        {
            return true;
        }
        else if((depart.x+1 == arrive.x && depart.y+1 == arrive.y) || (depart.x+2 == arrive.x && depart.y+2 == arrive.y) || (depart.x+3 == arrive.x && depart.y+3 == arrive.y))
        {
            return true;
        }
        return false;
    }
    
    public void pouvoir4DeLaTuile(tuiles pouvoirJoueur)
    {
        GrosPanel lePanel;
        for (Component laTuile : legros.getComponents()) {
            if(laTuile instanceof GrosPanel)
            {
                lePanel = (GrosPanel) laTuile;
                if((lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y) 
                        || (lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y-1)
                        || (lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y+1)
                        || (lePanel.terrain.x== pouvoirJoueur.x-1 && lePanel.terrain.y == pouvoirJoueur.y-1)
                        || (lePanel.terrain.x== pouvoirJoueur.x-1 && lePanel.terrain.y == pouvoirJoueur.y)
                        || (lePanel.terrain.x== pouvoirJoueur.x+1 && lePanel.terrain.y == pouvoirJoueur.y+1)
                        || (lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y)
                        || (lePanel.terrain.x== pouvoirJoueur.x+1 && lePanel.terrain.y == pouvoirJoueur.y))
                {
                    for (explorateurs exploRetirer : lePanel.terrain.explorateurs) {
                    lePanel.terrain.explorateurs.remove(exploRetirer);
                    }
                    for (monstres monstRetirer : lePanel.terrain.monstres) {
                    lePanel.terrain.monstres.remove(monstRetirer);
                    }
                    for (bateaux bateauRetirer : lePanel.terrain.bateaux) {
                    lePanel.terrain.monstres.remove(bateauRetirer);
                    }
                }                    
            }
        }
    }
    
    public boolean retirerTuile(tuiles cible, joueurs j) throws IOException
    {
        boolean eauAdjacente =false;
        boolean encoreDuSable = false;
        boolean encoreDesForet = false;
        GrosPanel rechercher;
        
        for(Component lesGros: legros.getComponents())
        {
            if(lesGros instanceof GrosPanel)
            {
                rechercher = (GrosPanel) lesGros;
                // savoir s'il y a toujours des tuile de sable
                if(rechercher.terrain.type==1)
                {
                    encoreDuSable = true;
                }
                // savoir s'il y a toujours des tuile de foret
                if(rechercher.terrain.type==1)
                {
                    encoreDesForet = true;
                }
                //savoir si il y a une tuile d'eau adjacente à la tuile retirer
                if(rechercher.terrain.tuileAdjacenteEau(cible))
                {
                    eauAdjacente = true;
                }
            }
            
        }
        
        if(eauAdjacente)
        {
            if(encoreDuSable)
            {
                if(cible.type==1)
                {
                    j.cartesEnMain.add(cible);
                    refreshTuile(cible);
                    return true;
                }
            }
            else if (encoreDesForet)
            {
                if(cible.type==2)
                {
                    j.cartesEnMain.add(cible);
                    refreshTuile(cible);
                    return true;
                }
            }
            else
            {
                if(cible.type==3)
                {
                    j.cartesEnMain.add(cible);
                    refreshTuile(cible);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void refreshTuile (tuiles cible) throws IOException
    {
        GrosPanel chercher;
        for (Component lesGros: legros.getComponents())
        {
            if(lesGros instanceof GrosPanel)
            {
                chercher = (GrosPanel) lesGros;
                if((chercher.k == cible.x) && (chercher.j == cible.y))
                {
                    chercher.refreshImage();
                }
            }
        }
    }
        
}

