package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import java.util.Map;

import java.util.HashMap;

/**
 * Classe représentant un monde
 */
public class Monde{
	//Attributs
	/**
	 * Attribut du type chaine de caractère pour défnir le nom du monde
	 */
	private String nomDuMonde;
	/**
	 * Attibut de type tableau d'entité pour connaitre les entité présent dans le monde
	 */
	private Map<String,Entite> entites;
	
	//constructeurs
	/**
	 * Constructeur d'un monde
	 * @param nomDuMonde chaine de caractère désignant le monde
	 */
	public Monde(String nomDuMonde){
		this.nomDuMonde =nomDuMonde;
		this.entites = new HashMap<String,Entite>();
	}
	//Methodes
	/**
	 * getter 
	 * @return le nom du monde
	 */
	public String getNom(){
		return this.nomDuMonde;
	}
	/**
	 * getter
	 * @param nomEntite : le nom de l'entité recherché
	 * @return un type Entite qui est l'entitée recherché
	 */
	public Entite getEntite(String nomEntite){
		return this.entites.get(nomEntite);
	}
	/**
	 * Ajoute une entitée dans le monde
	 * @param entite l'entitée à ajouter
	 */
	public void ajouter(Entite entite) throws NomDEntiteDejaUtiliseDansLeMondeException , EntiteDejaDansUnAutreMondeException {
		if(entite.getMonde()!=this){
			throw new EntiteDejaDansUnAutreMondeException();
		}
		if(this.entites.containsKey(entite.getNom())){
			throw new NomDEntiteDejaUtiliseDansLeMondeException();
		}
		this.entites.put(entite.getNom(),entite);
	}

	/**
	 * Rédéfinition de la méthode toString pour les mondes
	 */
	public String toString(){
		return String.format("%s",nomDuMonde);
	}
}