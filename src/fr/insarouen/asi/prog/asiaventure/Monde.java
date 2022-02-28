package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

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
	private Entite[] entites;
	//constructeurs
	/**
	 * Constructeur d'un monde
	 * @param nomDuMonde chaine de caractère désignant le monde
	 */
	public Monde(String nomDuMonde){
		this.nomDuMonde =nomDuMonde;
		this.entites = new Entite[0];
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
		boolean estPresent=false;
		int i=0;
		while(!estPresent && i<entites.length){
			if (entites[i].getNom()==nomEntite){
				estPresent = true;
			}
			else{
				i++;
			}
		}
		if(estPresent){
			return entites[i];
		}
		else{
			return (Entite)null;
		}
	}
	/**
	 * Ajoute une entitée dans le monde
	 * @param entite l'entitée à ajouter
	 */
	public void ajouter(Entite entite) throws NomDEntiteDejaUtiliseDansLeMondeException , EntiteDejaDansUnAutreMondeException{
		int taille = this.entites.length;
		int i;
		Entite[] tmp = new Entite[taille+1];
		if (this!=entite.getMonde()){
			EntiteDejaDansUnAutreMondeException e2 = new EntiteDejaDansUnAutreMondeException();
			throw e2;
		}
		for(i=0;i<taille;i++){
			if (!this.entites[i].equals(entite)){
				tmp[i]=this.entites[i];
			}
			else{
				NomDEntiteDejaUtiliseDansLeMondeException e = new NomDEntiteDejaUtiliseDansLeMondeException();
				throw e;
			}
		}

		tmp[taille]=entite;
		entites=tmp;
	}
	/**
	 * Rédéfinition de la méthode toString pour les mondes
	 */
	public String toString(){
		return String.format("%s",nomDuMonde);
	}
}
