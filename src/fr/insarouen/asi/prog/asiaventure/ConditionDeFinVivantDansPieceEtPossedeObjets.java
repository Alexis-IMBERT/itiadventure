package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFin{
	private ConditionDeFinVivantDansPiece conditionDeFinVivantDansPiece=null;
	private ConditionDeFinVivantPossedeObjets conditionDeFinVivantPossedeObjets=null;
	
	public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatDuJeu, Vivant vivant, Piece piece, Objet... objets) {
		super(etatDuJeu);
		this.conditionDeFinVivantDansPiece = new ConditionDeFinVivantDansPiece(etatDuJeu, vivant, piece);
		this.conditionDeFinVivantPossedeObjets= new ConditionDeFinVivantPossedeObjets(etatDuJeu, vivant, objets);
	}

	@Override
	public EtatDuJeu verifierCondition() {
		if(this.conditionDeFinVivantDansPiece.verifierCondition().equals(EtatDuJeu.ENCOURS)){
			return EtatDuJeu.ENCOURS;
		}
		if(this.conditionDeFinVivantPossedeObjets.verifierCondition().equals(EtatDuJeu.ENCOURS)){
			return EtatDuJeu.ENCOURS;
		}
		return super.getEtatConditionVerifiee();
	}
	
}
