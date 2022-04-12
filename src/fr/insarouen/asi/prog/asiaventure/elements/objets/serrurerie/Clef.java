package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
 * Classe définissant les clef elle hérite de Objet
 * Une clef est carctérisé par :
 * <ul>
 * <li>Son nom</li>
 * <li>Le monde dans lequel est la porte</li>
 * </ul>
 *
 * @author Alexis et Mehdi
 */
public class Clef extends Objet {
	// Constructeurs
	/**
	 * Constructeur d'une clef ne pouvant être utilisé que par objet du même paquet
	 *
	 * @param nom   le nom désignant de manière unique la clef
	 * @param monde le monde dans laquelle est la clef et donc la porte et la
	 *              serrure dont elle dépend
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException Exception si le nom donnée
	 *                                                   est déjà utilisé
	 */
	protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nom, monde);
	}

	// Methodes
	/**
	 * Méthode estDeplacable retournant vrai
	 */
	@Override
	public boolean estDeplacable() {
		return true;
	}

	public String toString() {
		return String.format("Clef portant le nom %s dans le monde %s", this.getNom(), this.getMonde());
	}

}
