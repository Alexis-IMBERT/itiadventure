package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction extends ConditionDeFin{
	private ConditionDeFinConjonctionDeConditionDeFin cf = null ;
	public ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction(EtatDuJeu etatDuJeu, Vivant vivant, Piece piece, Objet... objets) {
		super(etatDuJeu);
		this.cf = new ConditionDeFinConjonctionDeConditionDeFin(etatDuJeu, new ConditionDeFinVivantDansPiece(etatDuJeu, vivant, piece), new ConditionDeFinVivantPossedeObjets(etatDuJeu, vivant, objets));
	}

	@Override
	public EtatDuJeu verifierCondition() {
		return cf.verifierCondition();
	}
	
}
