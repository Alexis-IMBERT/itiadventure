package fr.insarouen.asi.prog.asiaventure.elements.objets ;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe PiedDeBiche basé sur la classe abstraite Objet
 * @see Objet
 */

public class PiedDeBiche extends Objet{
	
	//Constructeur
	
	/**
	 * Constructeur d'un Pied de biche
	 * @see Objet
	 * @param nom Chaine de caractère désignant le pied de biche
	 * @param monde Monde dans lequel se trouve le pied de biche
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 */
	
	public PiedDeBiche(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
	}

	public boolean estDeplacable() {
		return true;
	}
}
