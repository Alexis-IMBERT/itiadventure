package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantDansPiece extends ConditionDeFin{
	private Vivant vivant=null;
	private Piece piece=null;

	public ConditionDeFinVivantDansPiece(EtatDuJeu etatDuJeu, Vivant vivant, Piece piece) {
		super(etatDuJeu);
		this.vivant=vivant;
		this.piece=piece;
	}

	@Override
	public EtatDuJeu verifierCondition() {
		return piece.equals(vivant.getPiece()) ? super.getEtatConditionVerifiee() : EtatDuJeu.ENCOURS;
	}
	
}
