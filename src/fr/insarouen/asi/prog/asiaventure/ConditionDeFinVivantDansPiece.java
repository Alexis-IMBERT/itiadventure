package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * ConditionDeFinVivantDansPiece héritant de ConditionDeFin
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 * 
 */
public class ConditionDeFinVivantDansPiece extends ConditionDeFin {
    /**
     * vivant en question
     */
    private Vivant vivant = null;
    /**
     * Piece en question
     */
    private Piece piece = null;

    /**
     * Constructeur
     * 
     * @param etatDuJeu
     * @param vivant
     * @param piece
     */
    public ConditionDeFinVivantDansPiece(EtatDuJeu etatDuJeu, Vivant vivant, Piece piece) {
        super(etatDuJeu);
        this.vivant = vivant;
        this.piece = piece;
    }

    /**
     * vérification de la condition
     */
    @Override
    public EtatDuJeu verifierCondition() {
        return piece.equals(vivant.getPiece()) ? super.getEtatConditionVerifiee() : EtatDuJeu.ENCOURS;
    }

    @Override
    public String toString() {
        return "ConditionDeFinVivantDansPiece [piece=" + piece + ", vivant=" + vivant + "]";
    }

}
