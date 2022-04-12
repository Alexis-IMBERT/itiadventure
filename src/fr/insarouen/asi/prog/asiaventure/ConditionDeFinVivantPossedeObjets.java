package fr.insarouen.asi.prog.asiaventure;

import java.util.Arrays;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * ConditionDeFinVivantMort héritant de
 * ConditionDeFin
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin {
    /**
     * Vivant en question
     */
    private Vivant vivant;
    /**
     * Objets en questions
     */
    private Objet[] objets;

    /**
     * Constructeur de la condition de fin
     * 
     * @param etatDuJeu
     * @param vivant
     * @param objets
     */
    public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatDuJeu, Vivant vivant, Objet[] objets) {
        super(etatDuJeu);
        this.vivant = vivant;
        this.objets = objets;
    }

    @Override
    public EtatDuJeu verifierCondition() {
        boolean aLesObjets = true;
        for (Objet objet : this.objets) {
            aLesObjets = aLesObjets && vivant.possede(objet);
        }
        return aLesObjets ? super.getEtatConditionVerifiee() : EtatDuJeu.ENCOURS;
    }

    @Override
    public String toString() {
        return "ConditionDeFinVivantPossedeObjets [objets=" + Arrays.toString(objets) + ", vivant=" + vivant + "]";
    }

}
