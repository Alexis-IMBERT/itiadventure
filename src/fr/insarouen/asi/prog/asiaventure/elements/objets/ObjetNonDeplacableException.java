package fr.insarouen.asi.prog.asiaventure.elements.objets;

/**
 * Classe d'exception objet non déplçable
 */
public class ObjetNonDeplacableException extends ObjetException{
	/**
	 * Méthode objet non déplaçable
	 */
	public ObjetNonDeplacableException(){
		super();
	}

	/**
	 * Méthode objet non déplaceable avec un message en paramètre
	 */
	public ObjetNonDeplacableException(String msg){
		super(msg);
	}
}