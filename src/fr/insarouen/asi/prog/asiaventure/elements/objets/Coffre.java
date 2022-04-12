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
 * Classe Coffre basé sur la classe Objet
 * @see Objet
 *
 */
public class Coffre extends Objet implements Activable{
    //Attributs
    
    /**
    * la classe d'enumération de type Etat qui précise l'état possible du coffre 
    */
    private Etat etat = Etat.FERME;
    //Constructeur
    public Coffre(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
    }
    
    //Methodes

    public boolean estDeplacable(){
        return false;
    }

	@Override
	public boolean activableAvec(Objet objet) {
		return false;
	}

	@Override
	public void activer() throws ActivationException {
		
	}

	@Override
	public void activerAvec(Objet objet) throws ActivationException {
		
	}
    public Etat getEtat(){
        return this.etat;
    }
    
    public String toString(){
        return String.format("Coffre %s du monde %s",this.getNom(),this.getMonde().toString());
    }
}

// @u:end Coffre
