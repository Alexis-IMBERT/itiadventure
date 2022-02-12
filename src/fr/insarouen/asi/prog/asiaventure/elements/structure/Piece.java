package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet ;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * Classe Pièce basé sur la classe abstraite ElementStructurel
 * @see ElementStructurel
 */
public class Piece extends ElementStructurel{
	//Attributs
	/**
	 * Attribut de la classe : liste d'objet présent dans la pièce initialisé à vide.
	 */
	Objet[] objets = new Objet[0];
	/**
	 * Attribut de la classe : liste de vivant présent dans la pièce initialisé à vide.
	 */
	Vivant[] vivants = new Vivant[0];
	//Constructeur
	/**
	 * Constructeur d'une pièce
	 * @see ElementStructurel
	 * @param nom chaine de caractère désignant l'élément
	 * @param monde monde de type Monde auquel appartient l'élément structurel
	 */
	public Piece(String nom, Monde monde){
		super(nom,monde);
	}
	//methodes
	/**
	 * Méthode vérifiant la présence d'un objet dans la pièce
	 * @param objet : l'objet que l'on recherche
	 * @return boolean true : est présent dans la pièce, false : n'est pas présent
	 */
	public boolean contientObjet(Objet objet){
		int taille = objets.length;
		int i = 0;
		boolean res = false;
		while (i<taille && !res){
			if (objets[i].equals(objet)){
				res=true;
			}
			i++;
		}
		return res;
	}
	
	/**
	 * Méthode vérifiant la présence d'un objet dans la pièce
	 * @param nomObj : chaine de caractère désignant l'objet que l'on recherche
	 * @return boolean true : est présent dans la pièce, false : n'est pas présent
	 */
	public boolean contientObjet(String nomObj){
		int taille = objets.length;
		int i = 0;
		boolean res = false;
		while (i<taille && !res){
			if (objets[i].getNom() == nomObj){
				res=true;
			}
			i++;
		}
		return res;
	}

	/**
	 * Permet de déposer un objet dans une pièce
	 * @param obj Objet que l'on souhaite déposer dans la pièce
	 */
	public void deposer(Objet obj){
		int taille = objets.length;
		Objet[] newObjets = new Objet[taille+1];
		int i=0;
		for (i=0;i<taille;i++){
			newObjets[i] = this.objets[i];
		}
		newObjets[taille] = obj ;
		this.objets = newObjets ;
	}
	
	/**
	 * Permet de récupérer la liste d'objet de la pièce
	 * @return la liste des objets de la pièce
	 */
	public Objet[] getObjets(){
		return objets;
	}
	
	/**
	 * Permet de retirer un objet de la pièce
	 * @param obj Objet que l'on souhaite retirer de la liste
	 * @return retourne l'objet à retirer
	 */
	public Objet retirer(Objet obj){
		int taille = objets.length;
		int i=0;
		int j=0;
		Objet[] newObjets = new Objet[taille-1];
		Objet res=null;
		for (i=0;i<taille;i++){
			if (!objets[i].equals(obj)){
				newObjets[j]=this.objets[i];
				j++;
			}
			else {
				res = this.objets[i];
			}
		}
		this.objets = newObjets ;
		return res;
	}
	
	/**
	 * Permet de retirer un objet de la pièce grace à la chaine de caractère le désignant.
	 * @param nomObj : chaine de caractère désignant l'objet
	 * @return l'objet à retirer
	 */
	public Objet retirer(String nomObj){
		int taille = objets.length;
		int i=0;
		int j=0;
		Objet[] newObjets = new Objet[taille-1];
		Objet res=null;
		for (i=0;i<taille;i++){
			if (objets[i].getNom() != nomObj){
				newObjets[j]=this.objets[i];
				j++;
			}
			else {
				res = this.objets[i];
			}
		}
		this.objets = newObjets ;
		return res;
	}
	
	/**
	 * Vérifie la présence d'un vivant dans la pièce
	 * @param vivant Vivant que l'on recherche dans la pièce
	 * @return boolean : true = est présent dans la pièce, false sinon.
	 */
	public boolean contientVivant(Vivant vivant){
		int taille = vivants.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (vivants[i].equals(vivant)){
				estPresent=true;
			}
			i++;
		}
		return estPresent;
	}
	
	/**
	 * Recherche la présence d'un vivant dans la pièce grace à la chaine de caractère le désignant
	 * @param nomVivant : chaine de caractère désignant le vivant
	 * @return boolean : true = est présent dans la pièce, false sinon.
	 */
	public boolean contientVivant(String nomVivant){
		int taille = vivants.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (vivants[i].getNom() == nomVivant){
				estPresent=true;
			}
			i++;
		}
		return estPresent;
	}
	
	/**
	 * Fait entré un vivant dans la pièce (ajoute le vivant dans la pièce)
	 * @param vivant vivant à faire rentrer
	 */
	public void entrer(Vivant vivant){
		int taille = vivants.length;
		Vivant[] newVivants = new Vivant[taille+1];
		int i=0;
		for(i=0;i<taille;i++){
			newVivants[i] = vivants[i];
		}
		newVivants[taille] = vivant;
		vivants = newVivants;
	}
	
	/**
	 * @return la liste des vivants contenue dans la pièce
	 */
	public Vivant[] getVivant(){
		return this.vivants;
	}
	
	/**
	 * Fais sortir un vivant de la pièce (retire le vivant de la pièce)
	 * @param vivant vivant à retirer de la pièce
	 * @return le vivant en question
	 */
	public Vivant sortirVivant(Vivant vivant){
		int taille = vivants.length;
		int i=0;
		int j=0;
		Vivant[] newVivants = new Vivant[taille-1];
		Vivant res=null;
		for (i=0;i<taille;i++){
			if (!vivants[i].equals(vivant)){
				newVivants[j]=this.vivants[i];
				j++;
			}
			else {
				res = this.vivants[i];
			}
		}
		this.vivants = newVivants ;
		return res;
	}

	/**
	 * Sort un vivant de la pièce (le retire de la pièce) grace à la chaine de caractère le désignant
	 * @param nomVivant chaine de caractère désignant le vivant
	 * @return le vivant en question
	 */
	public Vivant sortirVivants(String nomVivant){
		int taille = vivants.length;
		int i=0;
		int j=0;
		Vivant[] newVivants = new Vivant[taille-1];
		Vivant res=null;
		for (i=0;i<taille;i++){
			if (vivants[i].getNom() != nomVivant){
				newVivants[j]=this.vivants[i];
				j++;
			}
			else {
				res = this.vivants[i];
			}
		}
		this.vivants = newVivants ;
		return res;
	}
}





















