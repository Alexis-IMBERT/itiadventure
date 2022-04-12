package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * ConditionDeFinVivantMort héritant de
 * ConditionDeFin
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public class ConditionDeFinVivantMort extends ConditionDeFin {
    /**
     * Vivant en question
     */
    Vivant vivant = null;

    /**
     * Constructeur de la condition de fin
     * @param etatDuJeu
     * @param vivant
     */
    public ConditionDeFinVivantMort(EtatDuJeu etatDuJeu, Vivant vivant) {
        super(etatDuJeu);
        this.vivant = vivant;
    }

    @Override
    public EtatDuJeu verifierCondition() {// si estMort alors renvoyer super ... sinon ENCOURS
        return vivant.estMort() ? super.getEtatConditionVerifiee() : EtatDuJeu.ENCOURS;
    }

    @Override
    public String toString() {
        return "ConditionDeFinVivantMort [vivant=" + vivant + "]";
    }

}
