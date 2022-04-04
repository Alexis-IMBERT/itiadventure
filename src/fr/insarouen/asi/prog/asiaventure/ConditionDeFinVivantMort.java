package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantMort extends ConditionDeFin{
	Vivant vivant=null;

	public ConditionDeFinVivantMort(EtatDuJeu etatDuJeu,Vivant vivant) {
		super(etatDuJeu);
		this.vivant=vivant;
	}

	@Override
	public EtatDuJeu verifierCondition() {//si estMort alors renvoyer super ... sinon ENCOURS
		return vivant.estMort() ? super.getEtatConditionVerifiee() : EtatDuJeu.ENCOURS ;
	}
	
}
