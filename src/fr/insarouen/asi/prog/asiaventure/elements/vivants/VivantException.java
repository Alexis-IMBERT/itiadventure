package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * Classe d'exception mère pour les vivant
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 */
public class VivantException extends ASIAventureException {
    /**
     * Constructeur d'exception mère pour les vivant
     */
    public VivantException() {
        super();
    }

    /**
     * Constructeur d'exception mère pour les vivant
     * 
     * @param msg chaine de caractère expliquer l'erreur
     */
    public VivantException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "VivantException []";
    }
}