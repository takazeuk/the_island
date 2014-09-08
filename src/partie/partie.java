package partie;

import ImagePanel.Arrive;
import ImagePanel.GrosPanel;
import ImagePanel.ImagePanel;
import ImagePanel.PetitPanel;
import static MessageBox.Interaction.messageJoueur;
import UI.Int;
import UI.carteEnMain;
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
    public Vector<explorateurs> survivants;
    //vector pour stocker les tuiles et permettre de construire le plateau
    public Vector<tuiles> tuileConstruction= new Vector<tuiles>();
    //interface principale
    public Int mine;  
    //interface de scrooling
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
    //nous permet de connaitre le nombre de déplacement fait par le monstre
    public int deplacmentMonstre=0;
    //nous permet de faire les deplacements de carte pour bateau et marin avec le bonus de 3 déplacements
    public int deplacmentExploBateau=3;
    //flag pour savoir si la partie est terminée
    public int partieTermine=0;
    //GrosPanel contenant tout le plateau
    public JPanel legros = new ImagePanel("/images/Board.png");
    //Savoir si le joueur veut toujours deplacer l'unite que la carte lui permet
    public boolean reponseJoueur = true;
    // Savoir si on est dans l'utilisation des cartes en main
    public boolean ModePouvoir = false;
    //savoir dans quel partie du clic on se situe
    public int phaseDeJeu;
    // permet de savoir si le joueur veut descendre une xplo du bateau
    public boolean DescendreMarin =  false;
    
    public partie(int nombreJoueur) throws IOException {
        this.participant= new Vector<joueurs>();
        this.carte= new Vector<tuiles>();
        this.population= new Vector<unites>();
        this.imageTuile= new Vector<GrosPanel>();
        this.survivants = new Vector<explorateurs>();
    }
    
    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int hauteur = (int)tailleEcran.getHeight();
    int largeur = (int)tailleEcran.getWidth();
    
    //fonction pour créer le plateau de jeu avec les tuiles
    public void creationPlateau() throws IOException
    {
        mine = new Int(this);
        mine.setLayout(null);
        
        //construction de la carte
        int compt=0;
        int j;       
        int cordy;
        
        legros.setLayout(null);
        legros.setPreferredSize(new Dimension(1600,1300));
        // Créer les quatre iles d'arrive
        Arrive un = new Arrive(1, this);
        Arrive deux  = new Arrive(2, this);
        Arrive trois = new Arrive(3, this);
        Arrive quatre = new Arrive(4, this);
        //les inserer dans le Panel "legros" qui englobe tout
        legros.add(un);
        legros.add(deux);
        legros.add(trois);
        legros.add(quatre);
        // Leur donner la location
        un.setLocation(110, 110);
        deux.setLocation(1434, 130);
        trois.setLocation(130,1110);
        quatre.setLocation(1464, 1122);
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
                        tuiles terrain= new tuiles(cordy, compt, 0, 0,"");
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        terrain.panelLien= lenouv;
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
                        tuiles terrain= new tuiles(cordy, compt, 0, 0,"");
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        terrain.panelLien= lenouv;
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
                        tuiles terrain= new tuiles(cordy, compt, 0, 0,"");
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        terrain.panelLien= lenouv;
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
                        
                        tuiles terrain= new tuiles(cordy, compt, 0, 0,"");
                        carte.add(terrain);
                        GrosPanel lenouv = new GrosPanel(terrain, this);
                        terrain.panelLien= lenouv;
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
        creationTuiles();
           
        for (tuiles ile : carte) {
            if (ile.y==3) {
                if((ile.x>=5)&&(ile.x<=8)) {
                    randomMap(ile);
                }
            }
            else if(ile.y==4){
                if((ile.x>=5)&&(ile.x<=9))
                {
                   randomMap(ile); 
                }
            }
            else if(ile.y==5){
                if((ile.x>=4)&&(ile.x<=11))
                {
                   randomMap(ile); 
                }
            }
            else if(ile.y==6){
                if((ile.x>=5)&&(ile.x<=7))
                {
                   randomMap(ile); 
                }
                if((ile.x>=9)&&(ile.x<=11))
                {
                   randomMap(ile); 
                }
            }
            else if(ile.y==7){
                if((ile.x>=5)&&(ile.x<=12))
                {
                   randomMap(ile); 
                }
            }
            else if(ile.y==8){
                if((ile.x>=7)&&(ile.x<=11))
                {
                   randomMap(ile); 
                }
            }
            else if(ile.y==9){
                if((ile.x>=8)&&(ile.x<=11))
                {
                   randomMap(ile); 
                }
            }
        } 
        
        descriptionTuiles();
        
            /*for (tuiles terrain : this.carte) {
            if (terrain.type == 1) {
                terrain.pouvoir = 5;
            }           
        }*/
    }   
    
    public void randomMap(tuiles aChanger){
      Random r= new Random();
      int randomTuile= r.nextInt((int)tuileConstruction.size());
      aChanger.type=tuileConstruction.get(randomTuile).type;
      aChanger.pouvoir= tuileConstruction.get(randomTuile).pouvoir;
      tuileConstruction.remove(tuileConstruction.get(randomTuile));  
    }
    
    public boolean ajoutEplorateursTuile(tuiles cible, explorateurs uniteDeplacer) throws IOException{
        
        if (cible.explorateurs.size()!=3) {
            
            //affichageExplorateurs(cible, uniteDeplacer);
            cible.explorateurs.add(uniteDeplacer);
            affichageUniteTuile(cible);
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
            
            //affichageMonstre(cible, monstreDeplacer);
            cible.monstres.add(monstreDeplacer);
            affichageUniteTuile(cible);
            return true;
        }
        return false;
        //messagebox de refus du déplacement     
    }
    
    public boolean ajoutBateauTuile(tuiles cible, bateaux bateauDeplacer) throws IOException{
        if (cible.bateaux.size()==1) {
            return false;
            //messagebox de refus du déplacement
        }
        cible.bateaux.add(bateauDeplacer);
        affichageUniteTuile(cible);
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
    
    public void pouvoirImmediat(tuiles pouvoirJoueur) throws IOException
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
                affichageUniteTuile(pouvoirJoueur);
                //affichageMonstre(pouvoirJoueur, apparition);
                
                apparition.attaque(pouvoirJoueur);
                GrosPanel chercher;
                for (Component lesGros: legros.getComponents())
                {
                    if(lesGros instanceof GrosPanel)
                    {   
                        chercher = (GrosPanel) lesGros;                       
                        if((chercher.k == pouvoirJoueur.x) && (chercher.j == pouvoirJoueur.y))
                        {
                            messageJoueur(chercher.k +"   "+pouvoirJoueur.x+"    "+ "       "+chercher.j+"     "+pouvoirJoueur.y);
                            messageJoueur("j'utilise la fonction aucunExplorateur et refresh image");
                            chercher.AucunExplorateur();
                            chercher.refreshImage();
                        }
                    }

                }
                
            break;
            case 2:
                bateaux newbateau = new bateaux(pouvoirJoueur.x,pouvoirJoueur.y);
                pouvoirJoueur.bateaux.add(newbateau);
                affichageUniteTuile(pouvoirJoueur);
                //affichageBateaux(pouvoirJoueur, newbateau);
            break;
            case 3: //tourbillon fini
                pouvoir4DeLaTuile(pouvoirJoueur);
            break;
            case 4: //fin du jeu à faire plus tard
                //on compte les points pour chacun des Joueurs
                for (joueurs challenger : participant) {
                    calculPointJoueur(challenger);
                }
            break;                              
        }
    }
    
    public void pouvoirEnMainActiver(joueurs j, tuiles cibler)
    {   
        if(flagAction==4)
        {
            j.cartesEnMain.add(cibler);
            // frame qui affiche la carte piocher
        }
        else
        {
            messageJoueur("je rentre dans les pouvoirs yata");
            // Demander au joueur s'il veut jouer une carte en main si oui alors switch sinon passer à l'etape suivante
            // afficher dans un frame les cartes avec images du joueur et puis faire un return du type de pouvoir de la tuile choisi
            switch(cibler.pouvoir)
            {
                //pouvoir des déplacements dauphins
                case 5:
                    messageJoueur("je rentre dans les dauphins");
                    flagAction = 7;

                break;

                //pouvoir des déplacement bateaux
                case 6:
                    messageJoueur("je rentre dans les bateaux");
                    flagAction = 8;

                break;

                //pouvoir des déplacements de serpent de mer, requin et baleine
                case 7: case 8: case 9:
                    ModePouvoir = true;
                    if(cibler.pouvoir == 7)
                    {
                        choixMonstre = 7;
                    }
                    else if(cibler.pouvoir == 8)
                    {
                        choixMonstre = 5;
                    }
                    else
                    {
                        choixMonstre = 6;
                    }
                    flagAction = 5;

                break;
                                 
            }
        }
    }
    
    public boolean pouvoirDefense(tuiles pouvoirJoueur, tuiles cible, joueurs j)
    {
        boolean flag = false;
        
        switch(pouvoirJoueur.pouvoir)
        {
            //pouvoir de protection contre les requins
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
            
            //pouvoir de protection contre les baleines
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
            this.affichageUniteTuile(choisi);
            //choisi.panelLien.refreshGrosPanel();
            //affichageExplorateurs(choisi, pionschoisi);
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
                                this.affichageUniteTuile(choisi);
                                //territoire.affichageUnite.get(6).choixImageBateau();
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
        int valeurMin=7;
        int valeurMax= 7;
        Random r = new Random();
        int valeur = valeurMin + r.nextInt((valeurMax)+1 - valeurMin);// Remettre +1 a 
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
    
    public void calculPointJoueur(joueurs joueurPoint)
    {
        //fin de partie, on va compter les rescapé en les stockant dans un vecteur et enuiste on compte les point
        for (explorateurs valeurPion : survivants) {           
            if (valeurPion.proprietaire == joueurPoint.couleur) {
                joueurPoint.pointVictoire= joueurPoint.pointVictoire + valeurPion.points;
            }
        }
        
    }
    
    public joueurs vainqueur()
    {
        int i = 0;
        for(int j = 1  ; j < this.participant.size(); j++)
        {
            if (this.participant.get(i).pointVictoire < this.participant.get(j).pointVictoire) {
                i = j;
            }
        }
        return this.participant.get(i);
    }


    /*public boolean affichageExplorateurs(tuiles cible, explorateurs uniteDeplacer) throws IOException {
           
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
    }*/
    
    public void affichageUniteTuile(tuiles cible) throws IOException{
        
        for (int i = 0; i < 3; i++) {
            if (cible.explorateurs.size()>i) {
               cible.panelLien.affichageUnite.get(i).numeroUnite= cible.explorateurs.get(i).proprietaire;
                //messageJoueur(""+cible.panelLien.affichageUnite.get(i).numeroUnite);
            }
            else{
               cible.panelLien.affichageUnite.get(i).numeroUnite=4; 
            } 
            cible.panelLien.affichageUnite.get(i).choixImageExplorateur();
        }
        
        for (int i = 0; i < 3; i++) {
            if (cible.monstres.size()>i) {
               cible.panelLien.affichageUnite.get(i+3).numeroUnite= cible.monstres.get(i).type;
                //messageJoueur(""+cible.panelLien.affichageUnite.get(i).numeroUnite);
            }
            else{
               cible.panelLien.affichageUnite.get(i+3).numeroUnite=4; 
            } 
            cible.panelLien.affichageUnite.get(i+3).choixImageMonstre();
        }
        /*int i=3;
        if (cible.monstres.size()!=0) {
            
            for (monstres monstre : cible.monstres) {
                if (cible.monstres.get(i-3)!=null) {
                   cible.panelLien.affichageUnite.get(i).numeroUnite=monstre.type;                  
                }
                else
                {
                  cible.panelLien.affichageUnite.get(i).numeroUnite=4;
                }
                cible.panelLien.affichageUnite.get(i).choixImageMonstre();
                i++;
            }
        }
        else
        {
            for (int j = 3 ; j < 6 ; j++) {
                cible.panelLien.affichageUnite.get(j).numeroUnite=4;
                cible.panelLien.affichageUnite.get(j).choixImageMonstre();       
            }
        }*/
        
        if (cible.bateaux.size()!=0) {
            cible.panelLien.affichageUnite.get(6).choixImageBateau();
        }
        else
        {
            cible.panelLien.affichageUnite.get(6).refreshBateau();
        }
                
    }
        
    /*public boolean affichageMonstre(tuiles cible, monstres monstreDeplacer) throws IOException{
        
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
    }*/

    
    
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
    
    public void pouvoir4DeLaTuile(tuiles pouvoirJoueur) throws IOException
    {
        GrosPanel lePanel;
        for (Component laTuile : legros.getComponents()) {
            if(laTuile instanceof GrosPanel)
            {
                lePanel = (GrosPanel) laTuile;
                if((lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y) 
                        || (lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y-1 && lePanel.terrain.type==0)
                        || (lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y+1 && lePanel.terrain.type==0)
                        || (lePanel.terrain.x== pouvoirJoueur.x-1 && lePanel.terrain.y == pouvoirJoueur.y-1 && lePanel.terrain.type==0)
                        || (lePanel.terrain.x== pouvoirJoueur.x-1 && lePanel.terrain.y == pouvoirJoueur.y && lePanel.terrain.type==0)
                        || (lePanel.terrain.x== pouvoirJoueur.x+1 && lePanel.terrain.y == pouvoirJoueur.y+1 && lePanel.terrain.type==0)
                        || (lePanel.terrain.x== pouvoirJoueur.x && lePanel.terrain.y == pouvoirJoueur.y && lePanel.terrain.type==0)
                        || (lePanel.terrain.x== pouvoirJoueur.x+1 && lePanel.terrain.y == pouvoirJoueur.y) && lePanel.terrain.type==0)
                {
                    
                    lePanel.terrain.explorateurs.clear();
                    lePanel.terrain.monstres.clear();
                    lePanel.terrain.bateaux.clear();
                    this.affichageUniteTuile(lePanel.terrain);
                    
                }                    
            }
            
        }
    }
    
    
    
    
    
    public boolean balayageTuile()
    {
        boolean encoreDuSable = false;
        boolean uneTuileEauAdjacente = false;
        for (tuiles tuile : this.carte) {
            if(tuile.type==1)
            {
                encoreDuSable = true;
            }
            
        }
        messageJoueur("encore du sable "+encoreDuSable );
        
        if(encoreDuSable == true)
        {
            for (tuiles tuile : this.carte) {
                if(tuile.type==1)
                {
                    for(Component lesGros: legros.getComponents())
                    {
                        if(lesGros instanceof GrosPanel)
                        {
                            GrosPanel rechercher = (GrosPanel) lesGros;
                            if(rechercher.tuileAdjacenteEau(tuile))
                            {
                                uneTuileEauAdjacente = true;
                            }
                        }
                    }
            
                }
            }
                        messageJoueur("uneTuileEauAdjacente "+uneTuileEauAdjacente );
        }
        else
        {
            for (tuiles tuile : this.carte) {
                if(tuile.type==2)
                {
                    for(Component lesGros: legros.getComponents())
                    {
                        if(lesGros instanceof GrosPanel)
                        {
                            GrosPanel rechercher = (GrosPanel) lesGros;
                            if(rechercher.tuileAdjacenteEau(tuile))
                            {
                                uneTuileEauAdjacente = true;
                            }
                        }
                    }
                }
            
            }
        }
        return uneTuileEauAdjacente;
    }
    
    
    public boolean retirerTuile(tuiles cible) throws IOException
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
                if(rechercher.terrain.type==2)
                {
                    encoreDesForet = true;
                }
                //savoir si il y a une tuile d'eau adjacente à la tuile retirer
                if(rechercher.tuileAdjacenteEau(cible))
                {
                    eauAdjacente = true;
                }
            }
            
        }
        // regarder s'il y a une tuile qui est adjacente à l'eau
        if(balayageTuile()== true)
        {
            messageJoueur("ne pas accepter les tuiles sans eau adjacente");
            // si la tuile selectionner est adjacente a l'eau alors OK
            if(eauAdjacente)
            {
                if(encoreDuSable)
                {
                    if(cible.type!=1)
                    {
                        messageJoueur("vous devez d'abord retirer les cases sable");
                    }
                    else
                    {
                       return true; 
                    }
                }
                else if (encoreDesForet)
                {
                    if(cible.type!=2)
                    {
                        messageJoueur("vous devez d'abord retirer les cases forêts");
                    }
                    else
                    {
                       return true; 
                    }
                }
                else
                {
                    if(cible.type!=3)
                    {
                        messageJoueur("vous ne pouvez pas retirer une case d'eau");
                    }
                    else
                    {
                       return true; 
                    }
                }
            }
            // pas OK
            else
            {
                messageJoueur("vous ne pouvez pas cliquer sur cette case car il n'y a pas de case d'eau adjacente");
            }
        }
        // si il n' y a plus de case adjacente a l'eau
        else
        {
            messageJoueur("accepter les tuiles sans eau adjacente");
            if(encoreDuSable)
                {
                    if(cible.type!=1)
                    {
                        messageJoueur("vous devez d'abord retirer les cases sable");
                    }
                    else
                    {
                       return true; 
                    }
                }
                else if (encoreDesForet)
                {
                    if(cible.type!=2)
                    {
                        messageJoueur("vous devez d'abord retirer les cases forêts");
                    }
                    else
                    {
                       return true; 
                    }
                }
                else
                {
                    if(cible.type!=3)
                    {
                        messageJoueur("vous ne pouvez pas retirer une case d'eau");
                    }
                    else
                    {
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
    
    public  void creationTuiles()
    {
        
        int pouvoirSable[]= {0,0,0,1,1,1,2,5,5,5,6,6,7,8,9,10};
        for(int valeurPouvoir: pouvoirSable)
        {
           tuiles tuile= new tuiles(0,0,1,valeurPouvoir,"");
           tuileConstruction.add(tuile);
        }
        
        int pouvoirForet[]= {0,0,1,1,2,2,2,3,3,5,7,8,9,10,11,11};
        for(int valeurPouvoir: pouvoirForet)
        {
           tuiles tuile= new tuiles(0,0,2,valeurPouvoir,"");
           tuileConstruction.add(tuile);
        }
        
        int pouvoirMontagne[]= {0,3,3,3,3,4,10,11};
        for(int valeurPouvoir: pouvoirMontagne)
        {
           tuiles tuile= new tuiles(0,0,3,valeurPouvoir,"");
           tuileConstruction.add(tuile);
        }

    }
    
    public void descriptionTuiles(){
        
        for (tuiles terrain : this.carte) {
            switch(terrain.pouvoir)
            {
                case 0:
                    terrain.descriptionPouvoir = "Un pion Requin est placé sur la case de mer qu’occupait la tuile de Terrain. Tout Nageur occupant cette case de mer est retiré du jeu.";
                break;
                case 1:
                    terrain.descriptionPouvoir = "Un pion Baleine est placé sur la case de mer qu’occupait la tuile de Terrain. Si un bateau, sur lequel se trouve des explorateurs, se trouve sur cette case, le bateau est détruit.";
                break;
                case 2:
                    terrain.descriptionPouvoir = "Un Bateau est placé sur la case de mer qu’occupait la tuile de Terrain.";
                break;
                case 3:
                    terrain.descriptionPouvoir = "Tourbillon : retire du jeu toute les unités de la case de mer qu’occupait la tuile de Terrain et de toutes les cases mer adjacentes.";
                break;
                case 4:
                    terrain.descriptionPouvoir = "Éruption volcanique: fin de la partie!!!!! nous allons calculer les points pour connaitre le vainqueur";
                break;
                case 5:
                    terrain.descriptionPouvoir = "Un dauphin vient en aide à l’un de vos Nageurs  ! Déplacez un de vos Nageurs de 1 à 3 cases de mer";
                break;
                case 6:
                    terrain.descriptionPouvoir = "Les vents vous sont favorables ! Déplacez un des Bateaux que vous contrôlez de 1 à 3 cases de mer.";
                break;
                case 7:
                    terrain.descriptionPouvoir = "Déplacez le Serpent de mer de votre choix déjà présent sur le plateau de jeu sur n’importe quelle case de mer inoccupée.";
                break;
                case 8:
                    terrain.descriptionPouvoir = "Déplacez le Requin de votre choix déjà présent sur le plateau de jeu sur n’importe quelle case de mer inoccupée.";
                break;
                case 9:
                    terrain.descriptionPouvoir = "Déplacez la Baleine de votre choix déjà présente sur le plateau de jeu sur n’importe quelle case de mer inoccupée.";
                break;
                case 10:
                    terrain.descriptionPouvoir = "Déplacez la Baleine de votre choix déjà présente sur le plateau de jeu sur n’importe quelle case de mer inoccupée.";
                break;
                case 11:
                    terrain.descriptionPouvoir = "Déplacez la Baleine de votre choix déjà présente sur le plateau de jeu sur n’importe quelle case de mer inoccupée.";
                break;                   
            }
        }
    }
    
    
           
}

