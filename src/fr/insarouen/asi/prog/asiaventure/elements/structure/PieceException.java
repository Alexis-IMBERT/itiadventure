package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * @throws Exception liée aux pièces
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public class PieceException extends ElementStructurelException {
    // Constructeur
    /**
     * Constructeur de l'exception de type PieceException qui hérite de
     * ElementStructurelException
     */
    public PieceException() {
        super();
    }

    /**
     * Constructeur de l'exception de type PieceException avec une chaine de
     * caractère (un message) donné en paramètre qui hérite de
     * ElementStructurelException
     * 
     * @param msg message passé en paramètre
     */
    public PieceException(java.lang.String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "PieceException []";
    }
}
