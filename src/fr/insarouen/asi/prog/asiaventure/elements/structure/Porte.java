package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;

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

	private Serrure serrure=null;

	void setEtat(Etat etat) {
		this.etat = etat;
	}

	//Constructeur
	public Porte(String nom,Monde monde, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom,monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
	}
	public Porte(String nom,Monde monde, Serrure serrure, Piece pieceA, Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super(nom, monde);
		this.pieceA = pieceA;
		this.pieceB = pieceB;
		this.serrure= serrure;
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
	
    public void activerAvec(Objet objet) throws ActivationImpossibleAvecObjetException,ActivationImpossibleException{
		if(this.activableAvec(objet)){
			if (objet instanceof Clef){
				switch(this.etat){
					case CASSE:
						throw new ActivationImpossibleException("La porte est cassé");
					case FERME:
						this.etat=Etat.VERROUILLE;
						if(this.getSerrure()!=null){this.getSerrure().activerAvec(objet);}
						break;
					case OUVERT:
						this.etat=Etat.VERROUILLE;
						if(this.getSerrure()!=null){this.getSerrure().activerAvec(objet);}
						break;
					case VERROUILLE:
						this.etat = Etat.OUVERT;
						if(this.getSerrure()!=null){this.getSerrure().activerAvec(objet);}
						break;
					default:
						throw new ActivationImpossibleException("La porte n'est pas dans un état cohérent");
					
				}
			}
			else{if(objet instanceof PiedDeBiche){
				if(this.etat==Etat.VERROUILLE|this.etat==Etat.FERME){
					this.etat=Etat.CASSE;
				}
				else{
					throw new ActivationImpossibleException("La porte n'est n'y verrouille ni ferme");
				}
			}}
		}
		else{
			throw new ActivationImpossibleAvecObjetException("Vous ne pouvez pas activer la porte avec cet objet");
		}
    }
    public boolean activableAvec(Objet objet){
        return ((this.getSerrure()!=null ? this.getSerrure().activableAvec(objet) : false)| (objet instanceof PiedDeBiche));
    }
    public Serrure getSerrure(){
        return this.serrure;
    }
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