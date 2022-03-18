package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
 * Classe Porte basé sur la classe abstraite ElementStructurel
 * @see ElementStructurel
 *
 */
public class Porte extends ElementStructurel implements Activable{
	//Attributs
    
    /**
	 * Attribut de type Monde désignant le monde où se trouve la porte
	 */
	private Monde monde;

    /**
	 * Attribut de type Pièce désignant la pièce "A" où se trouve la porte
	 */    
	private Piece pieceA;

    /**
	 * Attribut de type Pièce désignant la pièce "B" où se trouve la porte
	 */  
	private Piece pieceB;

    /**
    * la classe d'enumération de type Etat qui précise l'état possible d'un objet 
    */
	private Etat etat = Etat.OUVERT;

	void setEtat(Etat etat) {
		this.etat = etat;
	}

	//Constructeur
	public Porte(String nom,Monde monde, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
	}

	//Méthodes
	public Etat getEtat(){
		return this.etat;
	}

	public void activer() throws ActivationImpossibleException{
		
		switch(this.getEtat()){
			case CASSE:
				throw new ActivationImpossibleException("La porte est Cassée");
				//Pas de break après un throw
			case VERROUILLE:
				throw new ActivationImpossibleException("La porte est vérrouillé");
			case OUVERT: 
				this.etat = Etat.FERME;
				break;
			case FERME:	this.etat = Etat.OUVERT;
				break;
			default:
				throw new ActivationImpossibleException("La porte n'est pas dans un etat logique : deverrouille");
		}
    }
	
    public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException,ActivationImpossibleException{
        //pass;-> serrure
    }
    public boolean ActivableAvec(Objet obj){
        return true;
		//pass;-> serrure
    }
	/*
    public Serrure getSerrure(){
        return this.serrure;
    }*/
    public Piece getPieceAutreCote(Piece piece){
        if (piece.equals(this.pieceA)){
            return this.pieceB;
        }
        else{
            return this.pieceA;
        }
    }
    public String toString(){
        return String.format("Porte %s du monde %s",this.getNom(),monde.toString());
    }
} 