package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Classe PorteInexistanteDansLaPieceException
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public class PorteInexistanteDansLaPieceException extends PieceException {
    /**
     * Constructeur sans paramètre de l'exception
     */
    public PorteInexistanteDansLaPieceException() {
        super();
    }

    /**
     * Constructeur avec un message en paramètre
     * 
     * @param msg message levé par l'exception
     */
    public PorteInexistanteDansLaPieceException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "PorteInexistanteDansLaPieceException []";
    }
}