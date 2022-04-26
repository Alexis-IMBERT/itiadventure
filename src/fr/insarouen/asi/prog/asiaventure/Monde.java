package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;

import java.util.Map;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Classe représentant un monde
 *
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public class Monde extends Object implements Serializable {
	// Attributs
	/**
	 * Attribut du type chaine de caractère pour défnir le nom du monde
	 */
	private String nomDuMonde;
	/**
	 * Attibut de type tableau d'entité pour connaitre les entité présent dans le
	 * monde
	 */
	private Map<String, Entite> entites;

	// constructeurs
	/**
	 * Constructeur d'un monde
	 *
	 * @param nomDuMonde chaine de caractère désignant le monde
	 */
	public Monde(String nomDuMonde) {
		this.nomDuMonde = nomDuMonde;
		this.entites = new HashMap<String, Entite>();
	}

	// Methodes
	/**
	 * getter
	 *
	 * @return le nom du monde
	 */
	public String getNom() {
		return this.nomDuMonde;
	}

	/**
	 * getter
	 *
	 * @param nomEntite : le nom de l'entité recherché
	 * @return un type Entite qui est l'entitée recherché
	 */
	public Entite getEntite(String nomEntite) {
		return this.entites.get(nomEntite);
	}

	/**
	 * Ajoute une entitée dans le monde
	 *
	 * @param entite l'entitée à ajouter
	 */
	public void ajouter(Entite entite)
			throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException {
		if (entite.getMonde() != this) {
			throw new EntiteDejaDansUnAutreMondeException(
					String.format("L'entité est présente dans un autre monde et ne peut etre ajouté dans le monde %s",
							this.nomDuMonde));
		}
		if (this.entites.containsKey(entite.getNom())) {
			throw new NomDEntiteDejaUtiliseDansLeMondeException(String
					.format("Le nom %s de l'entité est déjà utilisé dans ce monde %s", entite.getNom(), nomDuMonde));
		}
		this.entites.put(entite.getNom(), entite);
	}

	/**
	 * getter des entite
	 *
	 * @return
	 */
	public Map<String, Entite> getEntites() {
		return Map.copyOf(this.entites);
	}

	/**
	 * Retourne les executable du monde
	 *
	 * @return
	 */
	public java.util.Collection<Executable> getExecutables() {
		Collection<Executable> resultat = new LinkedList<Executable>();
		Collection<Entite> lesEntitesDuMonde = this.entites.values();
		for (Entite entite : lesEntitesDuMonde) {
			if (entite instanceof Executable) {// l'entite est executable
				resultat.add((Executable) entite);
			}
		}
		return resultat;
	}

	/**
	 * Retourne les joueur Humain
	 *
	 * @return
	 */
	public Collection<JoueurHumain> getJoueurHumain() {
		Collection<JoueurHumain> resultat = new LinkedList<JoueurHumain>();
		Collection<Executable> lExecutables = this.getExecutables();
		for (Executable executable : lExecutables) {
			if (executable instanceof JoueurHumain) {
				resultat.add((JoueurHumain) executable);
			}
		}
		return resultat;
	}

	/**
	 * Rédéfinition de la méthode toString pour les mondes
	 */
	public String toString() {
		return String.format("Monde de nom : %s", nomDuMonde);
	}
}