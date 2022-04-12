package fr.insarouen.asi.prog.asiaventure;

import java.util.Arrays;

/**
 * ConditionDeFinConjonctionDeConditionDeFin héritant de ConditionDeFin
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public class ConditionDeFinConjonctionDeConditionDeFin extends ConditionDeFin {
    /**
     * tableau des conditions de fin de jeux conjointe
     */
    ConditionDeFin[] cfs = null;

    public ConditionDeFinConjonctionDeConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs) {
        super(etatDuJeu);
        this.cfs = cfs;
    }

    /**
     * Vérifie la condition de fin de jeux
     */
    @Override
    public EtatDuJeu verifierCondition() {
        int taille = cfs.length;
        boolean estEnCours = false;
        int ite = 0;
        while (!estEnCours && ite < taille) {
            if (this.cfs[ite].verifierCondition().equals(EtatDuJeu.ENCOURS)) {
                estEnCours = true;
            }
            ite++;
        }
        return estEnCours ? EtatDuJeu.ENCOURS : super.getEtatConditionVerifiee();
    }

    @Override
    public String toString() {
        return "ConditionDeFinConjonctionDeConditionDeFin [cfs=" + Arrays.toString(cfs) + "]";
    }

}
