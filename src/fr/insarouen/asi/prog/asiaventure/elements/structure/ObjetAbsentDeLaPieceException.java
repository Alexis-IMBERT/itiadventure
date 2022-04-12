package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Classe d'exception d'objet non présent dans la pièce
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public class ObjetAbsentDeLaPieceException extends PieceException {
    /**
     * Méthode d'exception d'objet non présent dans la pièce
     */
    public ObjetAbsentDeLaPieceException() {
        super();
    }

    /**
     * Méthode d'exception d'objet non présent dans la pièce ave un message en
     * paramètre
     */
    public ObjetAbsentDeLaPieceException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "ObjetAbsentDeLaPieceException []";
    }
}
