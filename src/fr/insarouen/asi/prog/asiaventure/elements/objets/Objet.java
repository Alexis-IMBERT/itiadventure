package fr.insarouen.asi.prog.asiaventure.elements.objets ;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

/**
 * Classe abstraite désignant un objet
*/

public abstract class Objet extends Entite{
	//Attributs
	
	/**
	 * Attribut de type Boolean indiquant que l'Objet n'est pas deplacable
	 */

	private boolean estDeplacable=false;
	
	//Constructeur
	
	/**
	 * Constructeur d'un objet
	 * @see Entite
	 * @param nom Chaine de caractère désignant l'objet
	 * @param monde Monde dans lequel se trouve l'objet
	 */
	
	public Objet(String nom, Monde monde){
		super(nom,monde);
	}
	
	//Methodes
	
	/**
	 * Vérifie si l'objet est déplacable
	 * @return boolean : True si l'objet est déplacable ,False sinon
	 */

	public boolean estDeplacable(){
		return this.estDeplacable;
	}
}
