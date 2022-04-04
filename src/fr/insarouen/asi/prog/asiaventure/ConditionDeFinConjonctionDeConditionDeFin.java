package fr.insarouen.asi.prog.asiaventure;

public class ConditionDeFinConjonctionDeConditionDeFin extends ConditionDeFin{
	ConditionDeFin[] cfs = null;

	public ConditionDeFinConjonctionDeConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs) {
		super(etatDuJeu);
		this.cfs = cfs;
	}

	@Override
	public EtatDuJeu verifierCondition() {
		int taille = cfs.length;
		boolean estEnCours = false;
		int ite = 0;
		while(!estEnCours && ite<taille){
			if(this.cfs[ite].verifierCondition().equals(EtatDuJeu.ENCOURS)){
				estEnCours = true;
			}
			ite++;
		}
		return estEnCours ? EtatDuJeu.ENCOURS : super.getEtatConditionVerifiee();
	}
	
}
