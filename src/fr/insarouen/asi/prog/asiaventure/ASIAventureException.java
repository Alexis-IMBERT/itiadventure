package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;

/**
 * @throws création du type d'exceptions de ASIAventure
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 */
public class ASIAventureException extends java.lang.Exception implements Serializable{
    // Constructeur
    /**
     * Constructeur de l'exception de type ASIAventureException qui hérite de
     * java.lang.Exception
     */
    public ASIAventureException() {
        super();
    }

    /**
     * Constructeur de l'exception de type ASIAventureException avec une chaine de
     * caractère qui hérite de java.lang.Exception
     */
    public ASIAventureException(java.lang.String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "ASIAventureException []";
    }
}
