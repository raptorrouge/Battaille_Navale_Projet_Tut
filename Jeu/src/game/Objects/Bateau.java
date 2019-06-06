package game.Objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Bateau{

	private static BufferedImage[] imgBateaux;
	public int orientation;
	private Coordonnees[] cases;
	public int x;
	public int y;
	public BufferedImage img;
	public int type;

	public Bateau(int x, int y, int o, int type){
		this.x = x;
		this.y = y;
		this.orientation = o;
		this.type = type;
		img = imgBateaux[type];
	}

	public static void loadBoatImages(){
		imgBateaux = new BufferedImage[5];
		try{
			imgBateaux[0] = ImageIO.read(Bateau.class.getResource("/images/batDeuxCases.png"));
			imgBateaux[1] = ImageIO.read(Bateau.class.getResource("/images/batTroisCase.png"));
			imgBateaux[2] = ImageIO.read(Bateau.class.getResource("/images/batDeuxCases.png"));
			imgBateaux[3] = ImageIO.read(Bateau.class.getResource("/images/batQuatreCase.png"));
			imgBateaux[4] = ImageIO.read(Bateau.class.getResource("/images/batCinqCase.png"));
		}catch(Exception e){

		}

		//ON LOADERA LES IMAGES LOL
	}

	public void setTaille(int taille){
		//On définit la taille du tableau de coordonnées dont on aura besoin
		cases = new Coordonnees[taille];
	}

	public boolean touche(int x, int y){
		//On vérifie si l'une des Coordonnée du Bateau est touchée 
		for(int i=0;i<this.cases.length;i++){
			if(this.cases[i].getX()==x && this.cases[i].getY()==y){
				this.cases[i].setTouche();
				
				return true;
			}
		}
		return false;
	}

	public void setCoordonnees(int c,int x, int y){
		//On définit les différentes coordonnés du bateau
		this.cases[c].setXY(x,y); 
	}

	//Retourne l'état du bateau, true = "en vie" et false = coulé
	public boolean getEnVie(){
		int verif = 0;
		//On regarde toutes les cases du bateau
		for(int i=0;i<this.cases.length;i++){
			//Si une case du bateau est touchée
			if(this.cases[i].getTouche() == true){
				verif++;
			}
		}
		//Si toutes les cases sont touchées, le bateau est coulé
		if(verif == this.cases.length){
			return false;
		}
		return true; //Le bateau est encore "en vie"
	}
}