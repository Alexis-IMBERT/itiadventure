package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
/**
 * classe abstraite désignant un vivant
 */
public abstract class Vivant extends Entite{
	//Attributs
	/**
	 * Attribut de type entier naturel désignant le nombre de point de vie du vivant
	 */
	public int pointVie;

	/**
	 * Attribut de type entier naturel désignant le nombre de point de force du vivant
	 */
	public int pointForce;

	/**
	 * Attribut de type pièce désignant la pièce où se trouve le vivant
	 */
	private Piece piece;

	/**
	 * Attribut désignant les objets que porte le vivant
	 */
	private Objet[] objets;
	
	//Constructeurs
	/**
	 * Constructeur d'un vivant
	 * @param nom Chaine de caractère désignant le vivant
	 * @param monde Monde dans lequel évolue le vivant
	 * @param pointVie Entier naturel désignant le nombre de point de vie du vivant
	 * @param pointForce Entier naturel désignant le nombre de point de force du vivant
	 * @param piece pièce dans laquelle se trouve le vivant
	 * @param objets liste d'objet que possède le vivant sur lui
	 */
	public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets){
		super(nom,monde);
		this.pointVie = pointVie;
		this.pointForce = pointForce;
		this.piece = piece;
		this.objets = objets;
	}
	
	//Methodes
	/**
	 * Le vivant dépose un objet qu'il a en sa possesion (implique le retrait de l'objet dans sa liste d'objet)
	 * @param objet objet à déposer
	 */
	public void deposer(Objet objet){
		int taille = objets.length;
		Objet[] newObjets = new Objet[taille-1];
		int i=0;
		int j=0;
		for(i=0;i<taille;i++){
			if(objets[i]!=objet){
				newObjets[j]=objets[i];
				j++;
			}
		}
		objets = newObjets;
	}

	/**
	 * Dépose un objet en possesion du vivant grace à la chaine de caractère le désignant (implique le retrait de l'objet dans la liste des objet possédé par le vivant) 
	 * @param nomObj chaine de caratère désignant l'objet que l'on souhaite retirer
	 */
	public void deposer(String nomObj){
		int taille = objets.length;
		Objet[] newObjets = new Objet[taille-1];
		int i=0;
		int j=0;
		for(i=0;i<taille;i++){
			if(objets[i].getNom()!=nomObj){
				newObjets[j]=objets[i];
				j++;
			}
		}
		objets = newObjets;
	}
	
	/**
	 * retourne la liste d'objet possédé par le vivant
	 * @return la liste d'objet
	 */
	public Objet[] getObjets(){
		return objets;
	}
	
	/**
	 * Retourne l'objet possédé par le vivant grace à la chaine de caractère le désignant 
	 * @param nomObjet chaine de caractère désignant l'objet
	 * @return l'objet que l'on souhaite obtenir
	 */
	public Objet getObjet(String nomObjet){
		int taille = objets.length;
		int i=0;
		boolean estPresent = false;
		Objet res = null;
		while (i<taille && !estPresent){
			if (objets[i].getNom() == nomObjet){
				res = objets[i];
				estPresent=true;
			}
			i++;
		}
		return res;
	}
	
	/**
	 * 
	 * @return la pièce dans laquelle se trouve le vivant
	 */
	public Piece getPiece(){
		return piece;
	}
	
	/**
	 * @return le nombre de point de force que possède le vivant
	 */
	public int getPointForce(){
		return pointForce;
	}

	/**
	 * @return le nombre de point de vie que possède le vivant
	 */
	public int getPointVie(){
		return pointVie;
	}

	/**
	 * Vérifie la présence d'un objet sur le vivant
	 * @param objet objet dont on souhaite vérifier la présence
	 * @return boolean : true l'objet est présent false sinon
	 */
	public boolean possede(Objet objet){
		int taille = objets.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (objets[i].equals(objet)){
				estPresent = true;
			}
			i++;
		}
		return estPresent;
	}
	
	/**
	 * Vérifie que le vivant possède un objet. Cet objet est désigné par son nom de type chaine de caractère.
	 * @param nomObjet chaine de caractère désignant le nom de l'objet
	 * @return boolean : true l'objet est présent false sinon
	 */
	public boolean possede(String nomObjet){
		int taille = objets.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (objets[i].getNom() == nomObjet){
				estPresent = true;
			}
			i++;
		}
		return estPresent;
	}
	
	/**
	 * Le vivant prend un objet de la pièce où il se trouve (ajoute l'objet dans la liste des objets présent dans l'inventaire du vivant et donc le retire de la liste des objet présent dans la pièce)
	 * @param objet objet en question
	 */
	public void prendre(Objet objet){
		int taille = objets.length;
		int i=0;
		Objet[] newObjets = new Objet[taille+1];
		for (i=0;i<taille;i++){
			newObjets[i] = objets[i];
		}
		newObjets[taille] = objet;
		objets = newObjets;
	}
	/**
	 * Prend l'objet l'objet présent dans la pièce et l'ajoute dans l'inventaire du vivant
	 * @param nomObj
	 */
	public void prendre(String nomObj){
		int taille = objets.length;
		int i=0;
		Objet objet = this.getPiece().retirer(nomObj);
		Objet[] newObjets = new Objet[taille+1];
		for (i=0;i<taille;i++){
			newObjets[i] = objets[i];
		}
		newObjets[taille] = objet;
		objets = newObjets;
	}

	/**
	 * vérifie si le vivant est mort, un vivant est mort si le nombre de point de vie qu'il possède est inférieur à 0
	 * @return true le vivant est mort false sinon
	 */
	public boolean estMort(){
		return (this.getPointVie()<=0);
	}
	
	/**
	 * recode de la fonction toString
	 */
	public String toString(){
		return String.format("Vivant %s du monde %s a %d points de vie et %d points de Forces est dans la piece %s",this.getNom(),this.getMonde().toString(),this.getPointVie(),this.getPointForce(), this.getPiece());
	}
}













