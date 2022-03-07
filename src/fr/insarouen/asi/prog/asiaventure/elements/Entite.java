package fr.insarouen.asi.prog.asiaventure.elements ;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe abstraite servant à la construction des entités du jeux
*/
public abstract class Entite{

	//Attributs

	/**
	 * Attribut de type String désignant le nom de l'entité
	 */
	private String nom;
	
	/**
	 * Attribut de type Monde désignant le monde où se trouve l'entité
	 */
	private Monde monde;
	
	//Constructeur
	
	/**
	 * Constructeur d'une entité
	 */
	public Entite(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		this.nom=nom;
		this.monde=monde;
		if(monde.getEntite(nom) != null){
			throw new NomDEntiteDejaUtiliseDansLeMondeException();
		}
	}
	
	//methodes
	
	/**
	 * Permet de récupérer le nom de l'entité
	 * @return le nom de l'entité
	 */
	public String getNom(){
		return this.nom;
	}
	
	/**
	 * Permet de récupérer le monde où appartient l'entité
	 * @return le monde où appartient l'entité
	 */
	public Monde getMonde(){
		return this.monde;
	}
	
	/**
	 * recode de la fonction toString
	 */
	public String toString(){
		return String.format("Entite %s du monde %s",nom,monde.toString());
	}
	
	/**
	 * Vérifie l'égalité des deux objets
	 * @param o objet en question
	 * @return boolean : True s'ils sont égaux sinon False
	 */
	public boolean equals(Object o){
		if (o==this){
			return true;
		}
		if (o==null || this.getClass() != o.getClass()){
			return false;
		}
		Entite test = (Entite)o;
		if(this.nom == test.nom && this.monde == test.monde){
			return true;
		}
		return false;
	}
	
	/**
	 * Recode d'une fonction deja existante (Du meme nom) qui vérifie si deux objets sont identiques
	 * @return un entier naturel représentant la fonction codée
	 */
	public int hashCode(){
		return 2*nom.hashCode()+3*monde.hashCode() ;
	}
}
