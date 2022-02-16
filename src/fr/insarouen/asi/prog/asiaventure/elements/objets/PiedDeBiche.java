package fr.insarouen.asi.prog.asiaventure.elements.objets ;

import fr.insarouen.asi.prog.asiaventure.Monde;

/**
 * Classe PiedDeBiche basé sur la classe abstraite Objet
 * @see Objet
 */

public class PiedDeBiche extends Objet{
	
	//Attributs
	
	/**
	 * Attribut de type Boolean indiquant que l'Objet est deplacable
	 */

	private boolean estDeplacable = true;
	
	//Constructeur
	
	/**
	 * Constructeur d'un Pied de biche
	 * @see Objet
	 * @param nom Chaine de caractère désignant le pied de biche
	 * @param monde Monde dans lequel se trouve le pied de biche
	 */
	
	public PiedDeBiche(String nom, Monde monde){
		super(nom,monde);
	}
}
