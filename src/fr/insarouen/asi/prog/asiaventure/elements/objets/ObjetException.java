package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * @throws création du type d'exceptions de ObjetException
 * @author Alexis et Mehdi
 *
 */
public class ObjetException extends ASIAventureException {

    // Constructeurs

    /**
     * Constructeur de l'exception de type ObjetException qui hérite de
     * ASIAventureException
     *
     * @param msg Chaine de caractère désignant ObjetException
     */
    public ObjetException(String msg) {
        super(msg);
    }

    /**
     * Constructeur de l'exception de type ObjetException qui hérite de
     * ASIAventureException
     */
    public ObjetException() {
        super();
    }

    @Override
    public String toString() {
        return "ObjetException []";
    }
}
