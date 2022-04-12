package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * ConditionDeFinVivantDansPieceEtPossedeObjets héritant de ConditionDeFin
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 * 
 */
public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFin {
    /**
     * Conjonxrion de condition de fin
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
    public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatDuJeu, Vivant vivant, Piece piece,
            Objet... objets) {
        super(etatDuJeu);
        this.cf = new ConditionDeFinConjonctionDeConditionDeFin(etatDuJeu,
                new ConditionDeFinVivantDansPiece(etatDuJeu, vivant, piece),
                new ConditionDeFinVivantPossedeObjets(etatDuJeu, vivant, objets));
    }

    /**
     * vérification de l'etat de la condition
     */
    @Override
    public EtatDuJeu verifierCondition() {
        return cf.verifierCondition();
    }

    @Override
    public String toString() {
        return "ConditionDeFinVivantDansPieceEtPossedeObjets [cf=" + cf + "]";
    }

}