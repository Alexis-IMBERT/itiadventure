package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * PorteFermeException hérite de ElementStructurelException
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public class PorteFermeException extends ElementStructurelException {
    /**
     * Constructeur sans paramètre de l'exception
     */
    public PorteFermeException() {
        super();
    }

    /**
     * Constructeur avec un message en paramètre
     * 
     * @param msg message levé par l'exception
     */
    public PorteFermeException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "PorteFermeException []";
    }
}