// @u:start Coffre

// Le coffre est un simple objet non déplaçable, c'est juste pour créer un nouveau type d'objet
// il ne contient pas d'objet
// il n'a pas de serrure
package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe Coffre hérite de la classe Objet et implemente Activable
 * Un coffre est défini par :
 * <ul>
 * <li>Son nom unique dans le monde</li>
 * <li>Son monde</li>
 * <li>Son Etat de la serrure soit :
 * <ul>
 * <li>Ferme</li>
 * <li>Ouvert</li>
 * </ul>
 * </li>
 * </ul>
 *
 * @see Activable
 *
 * @see Objet
 * @author Alexis et Mehdi
 */
public class Coffre extends Objet implements Activable {
	// Attributs

	/**
	 * la classe d'enumération de type Etat qui précise l'état possible du coffre
	 * il est soit :
	 * <ul>
	 * <li>Ferme</li>
	 * <li>Ouvert</li>
	 * </ul>
	 */
	private Etat etat = Etat.FERME;

	// Constructeur
	/**
	 * Constructeur du coffre
	 *
	 * @param nom   le nom unique dans le monde
	 * @param monde le monde
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException exception si une autre
	 *                                                   Entité a le même nom dans
	 *                                                   le monde
	 */
	public Coffre(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nom, monde);
	}

	// Methodes
	/**
	 * estDeplacable
	 *
	 * @return false
	 */
	public boolean estDeplacable() {
		return false;
	}

	/**
	 * vérifie si le coffre est activable avec un objet
	 *
	 * @param objet l'objet à tester
	 * @return boolean
	 */
	@Override
	public boolean activableAvec(Objet objet) {
		return false;
	}

	/**
	 * change l'etat du coffre
	 *
	 * @throws ActivationException
	 */
	@Override
	public void activer() throws ActivationException {
		switch (this.etat) {
			case FERME:
				this.etat = Etat.OUVERT;
				break;
			case OUVERT:
				this.etat = Etat.FERME;
				break;
			default:
				throw new ActivationException("le coffre n'est pas dans etat cohérent");
		}
	}

	/**
	 * @throws ActivationException ne peut pas être activer avec un objet
	 */
	@Override
	public void activerAvec(Objet objet) throws ActivationException {
		throw new ActivationException("Un coffre ne peut pas être activer avec un objet");
	}

	/**
	 * retourne l'etat du coffre
	 *
	 * @return Etat
	 */
	public Etat getEtat() {
		return this.etat;
	}

	public String toString() {
		return String.format("Coffre %s du monde %s dans l'etat %s", this.getNom(), this.getMonde().toString(),
				this.getEtat().toString());
	}
}

// @u:end Coffre
