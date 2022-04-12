package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
/**
 * Classe implémentant les serrures
 */
public class Serrure extends Objet implements Activable {
	private Etat etat=Etat.VERROUILLE;
	private boolean PremireCle=true;
	Clef clef;

	/**
	 * Constructeur d'une serrure
	 * @param nom 
	 * @param monde
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 */
	public Serrure(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
		super(nom, monde);
	}

	/**
	 * Constructeur de serrure avec nom automatique
	 * @param monde
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 */
	public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super("Serrure"+Serrure.creerNom(monde),monde);
	}
	private static String creerNom(Monde monde){
		int nombre;
		String nom;
		do{
			nombre = (int)(Math.random()*256);
			nom=Integer.toString(nombre);
		}while(monde.getEntite((String)nom).equals(null));
		return nom;
	}

	/**
	 * Test si la serrure est activable avec l'objet en paramètre
	 * @param objet
	 * @return boolean : true si la serrure correspond à la clé donnée
	 */
	@Override
	public boolean activableAvec(Objet objet) {
		return this.clef.equals(objet);
	}

	/**
	 * Ne peut pas être utilisé pour une serrure qui ne s'ouvre qu'avec une clé
	 * @throws ActivationException
	 */
	@Override
	public void activer() throws ActivationException {
		throw new ActivationException("Une serrure doit s'activer avec une cle");
	}

	/**
	 * Change l'etat de serrure en fonction de l'objet passé en paramètre
	 * @param objet l'objet avec lequel on test d'activer la serrure
	 * @throws ActivationException
	 */
	@Override
	public void activerAvec(Objet objet) throws ActivationImpossibleAvecObjetException {
		if(this.activableAvec(objet)){
			if(this.etat.equals(Etat.VERROUILLE)){
				this.etat = Etat.DEVERROUILLE;
			}
			else{
				this.etat = Etat.VERROUILLE;
			}
		}
		else{
			throw new ActivationImpossibleAvecObjetException("L'objet donnée n'est pas la bonne clée pour ouvrir la porte");
		}
	}

	/**
	 * creer une cle unique pour la serrure
	 * @throws NomDEntiteDejaUtiliseDansLeMondeException
	 */
	public Clef creerClef() throws NomDEntiteDejaUtiliseDansLeMondeException{
		Clef res = null;
		if(this.PremireCle){
			res = new Clef(this.getNom()+"cle", this.getMonde());
			PremireCle = false;
			this.clef = res;
		}
		return res;
	}

	/**
	 * renvoie si la serrure est deplacable
	 */
	public boolean estDeplacable(){
		return false;
	}

	/**
	 * retourne l'etat de la serrure.
	 */
	public Etat getEtat(){
		return this.etat;
	}
	
}
