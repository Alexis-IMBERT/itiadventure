package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction héritant de
 * ConditionDeFin
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public class ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction extends ConditionDeFin {
    /**
     * ConditionDeFinConjonctionDeConditionDeFin
     */
    private ConditionDeFinConjonctionDeConditionDeFin cf = null;

    /**
     * Constructeur
     * 
     * @param etatDuJeu
     * @param vivant
     * @param piece
     * @param objets
     */
    public ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction(EtatDuJeu etatDuJeu, Vivant vivant, Piece piece,
            Objet... objets) {
        super(etatDuJeu);
        this.cf = new ConditionDeFinConjonctionDeConditionDeFin(etatDuJeu,
                new ConditionDeFinVivantDansPiece(etatDuJeu, vivant, piece),
                new ConditionDeFinVivantPossedeObjets(etatDuJeu, vivant, objets));
    }

    @Override
    public EtatDuJeu verifierCondition() {
        return cf.verifierCondition();
    }

    @Override
    public String toString() {
        return "ConditionDeFinVivantDansPieceEtPossedeObjetsAvecConjonction [cf=" + cf + "]";
    }
}
