package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

/**
 * Classe abstraite de conditions de fins héritant de Object et implémentant
 * Serializable
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public abstract class ConditionDeFin extends java.lang.Object implements Serializable {
    /**
     * EtatDuJeu lorsque la condition de fin serra respecté
     */
    private EtatDuJeu etat = null;

    /**
     * Constructeur de la condition de fin
     * 
     * @param etatDuJeu
     */
    public ConditionDeFin(EtatDuJeu etatDuJeu) {
        this.etat = etatDuJeu;
    }

    /**
     * getter de l'etat lorsque la condition de fin du jeux serra respecté
     * 
     * @return EtatDuJeu
     */
    public EtatDuJeu getEtatConditionVerifiee() {
        return etat;
    }

    /**
     * vérfie la condition du jeux et retourne l'etat en conséquence
     * 
     * @return EtatDuJeu
     */
    public abstract EtatDuJeu verifierCondition();

    @Override
    public String toString() {
        return "ConditionDeFin [etat=" + etat + "]";
    }
}
