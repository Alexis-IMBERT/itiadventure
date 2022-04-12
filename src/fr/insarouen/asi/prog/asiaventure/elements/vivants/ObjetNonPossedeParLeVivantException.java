package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 * Classe d'exception l'objet n'est pas posséder par le vivant
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 */
public class ObjetNonPossedeParLeVivantException extends VivantException {
    /**
     * Constructeur d'exception l'objet n'est pas posséder par le vivant
     */
    public ObjetNonPossedeParLeVivantException() {
        super();
    }

    /**
     * Constructeur d'exception l'objet n'est pas posséder par le vivant
     * 
     * @param msg chaine de caractère pour expliquer l'erreur
     */
    public ObjetNonPossedeParLeVivantException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "ObjetNonPossedeParLeVivantException []";
    }
}