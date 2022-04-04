package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

public abstract class ConditionDeFin extends java.lang.Object implements Serializable{
	private EtatDuJeu etat=null;
	public ConditionDeFin(EtatDuJeu etatDuJeu){
		this.etat = etatDuJeu;
	}
	
	public EtatDuJeu getEtatConditionVerifiee(){
		return etat;
	}
	public abstract EtatDuJeu verifierCondition();
}
