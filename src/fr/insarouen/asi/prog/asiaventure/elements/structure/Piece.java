package fr.insarouen.asi.prog.asiaventure.elements.structure;

import java.util.HashMap;
import java.util.Map;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet ;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * Classe Pièce basé sur la classe abstraite ElementStructurel
 * @see ElementStructurel
 */
public class Piece extends ElementStructurel{
	//Attributs
	private Map<String,Porte> portes = new HashMap<String,Porte>();
	/**
	 * Attribut de la classe : liste d'objet présent dans la pièce initialisé à vide.
	 */
	private Map<String,Objet> objets = new HashMap<String,Objet>();
	/**
	 * Attribut de la classe : liste de vivant présent dans la pièce initialisé à vide.
	 */
	private Map<String,Vivant> vivants = new HashMap<String,Vivant>();
	//Constructeur
	/**
	 * Constructeur d'une pièce
	 * @see ElementStructurel
	 * @param nom chaine de caractère désignant l'élément
	 * @param monde monde de type Monde auquel appartient l'élément structurel
	 */
	public Piece(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}
	
	//methodes
	/**
	 * Méthode vérifiant la présence d'un objet dans la pièce
	 * @param objet : l'objet que l'on recherche
	 * @return boolean true : est présent dans la pièce, false : n'est pas présent
	 */
	public boolean contientObjet(Objet objet){
		return contientObjet(objet.getNom());
	}
	/**
	 * Méthode vérifiant la présence d'un objet dans la pièce
	 * @param nomObj : chaine de caractère désignant l'objet que l'on recherche
	 * @return boolean true : est présent dans la pièce, false : n'est pas présent
	 */
	public boolean contientObjet(String nomObj){
		return this.objets.containsKey(nomObj);
	}

	/**
	 * Ajoute une porte dans la pièce
	 * @param porte la porte a ajouter
	 */
	public void addPorte(Porte porte){
		this.portes.put(porte.getNom(),porte);
	}

	/**
	 * Vérifie la présence de la porte grace a son nom dans la pièce
	 * @param nomPorte nom de la porte 
	 * @return booleen : vrai si la porte est présente faux sinon
	 */
	public boolean aLaPorte(String nomPorte){
		return this.portes.containsKey(nomPorte);
	}

	/**
	 * Vérifie la présence de la porte dans la pièce
	 * @param porte porte dont on souhaite vérifier la présence dans la pièce
	 * @return booleen : vrai si la porte est présente faux sinon
	 */
	public boolean aLaPorte(Porte porte){
		return aLaPorte(porte.getNom());
	}

	/**
	 * retourne l'objet porte dont on a le nom
	 * @param nomPorte nom de la porte que l'on souhaite récupérer
	 * @return Une porte
	 */
	public Porte getPorte(String nomPorte){
		return this.portes.get(nomPorte);
	}

	/**
	 * Permet de déposer un objet dans une pièce
	 * @param obj Objet que l'on souhaite déposer dans la pièce
	 */
	public void deposer(Objet objet){
		this.objets.put(objet.getNom(),objet);
	}
	
	/**
	 * Permet de récupérer la liste d'objet de la pièce
	 * @return la liste des objets de la pièce
	 */
	public Map<String,Objet> getObjets(){
		return objets;
	}
	
	/**
	 * Permet de retirer un objet de la pièce
	 * @param obj Objet que l'on souhaite retirer de la liste
	 * @return retourne l'objet à retirer
	 */
	public Objet retirer(Objet objet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		return retirer(objet.getNom());
	}
	
	/**
	 * Permet de retirer un objet de la pièce grace à la chaine de caractère le désignant.
	 * @param nomObj : chaine de caractère désignant l'objet
	 * @return l'objet à retirer
	 */
	public Objet retirer(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
		if (!this.objets.containsKey(nomObj)){
			throw new ObjetAbsentDeLaPieceException();
		}
		Objet resultat = this.objets.get(nomObj) ;
		if (!resultat.estDeplacable()){
			throw new ObjetNonDeplacableException();
		}
		objets.remove(nomObj);
		return resultat;
	}
	/**
	 * Vérifie la présence d'un vivant dans la pièce
	 * @param vivant Vivant que l'on recherche dans la pièce
	 * @return boolean : true = est présent dans la pièce, false sinon.
	 */
	public boolean contientVivant(Vivant vivant){
		return contientVivant(vivant.getNom());
	}
	
	/**
	 * Recherche la présence d'un vivant dans la pièce grace à la chaine de caractère le désignant
	 * @param nomVivant : chaine de caractère désignant le vivant
	 * @return boolean : true = est présent dans la pièce, false sinon.
	 */
	public boolean contientVivant(String nomVivant){
		return this.vivants.containsKey(nomVivant);
	}
	/**
	 * Fait entré un vivant dans la pièce (ajoute le vivant dans la pièce)
	 * @param vivant vivant à faire rentrer
	 */
	public void entrer(Vivant vivant){
		this.vivants.put(vivant.getNom(),vivant);
	}
	
	/**
	 * @return la liste des vivants contenue dans la pièce
	 */
	public Map<String,Vivant> getVivants(){
		return this.vivants;
	}
	
	/**
	 * Fais sortir un vivant de la pièce (retire le vivant de la pièce)
	 * @param vivant vivant à retirer de la pièce
	 * @return le vivant en question
	 */
	public Vivant sortirVivant(Vivant vivant) throws VivantAbsentDeLaPieceException{
		return sortirVivant(vivant.getNom());
	}

	/**
	 * Sort un vivant de la pièce (le retire de la pièce) grace à la chaine de caractère le désignant
	 * @param nomVivant chaine de caractère désignant le vivant
	 * @return le vivant en question
	 */
	public Vivant sortirVivant(String nomVivant) throws VivantAbsentDeLaPieceException{
		if (!this.vivants.containsKey(nomVivant)){
			throw new VivantAbsentDeLaPieceException();
		}
		Vivant tmp = this.vivants.get(nomVivant);
		this.vivants.remove(nomVivant);
		return tmp;
	}		
}