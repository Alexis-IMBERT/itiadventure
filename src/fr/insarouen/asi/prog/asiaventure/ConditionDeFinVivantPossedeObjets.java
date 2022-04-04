package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin{
	private Vivant vivant;
	private Objet[] objets;

	public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatDuJeu,Vivant vivant, Objet[] objets) {
		super(etatDuJeu);
		this.vivant=vivant;
		this.objets=objets;
	}

	@Override
	public EtatDuJeu verifierCondition() {
		boolean aLesObjets = true;
		for (Objet objet : this.objets){
			aLesObjets = aLesObjets&&vivant.possede(objet);
		}
		return aLesObjets ? super.getEtatConditionVerifiee() : EtatDuJeu.ENCOURS;
	}
	
}
