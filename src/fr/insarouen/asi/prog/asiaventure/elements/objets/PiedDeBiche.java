package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe PiedDeBiche basé sur la classe abstraite Objet
 *
 * @see Objet
 * @author Alexis et Mehdi
 *
 */

public class PiedDeBiche extends Objet {

    // Constructeur

    /**
     * Constructeur d'un Pied de biche
     *
     * @see Objet
     * @param nom   Chaine de caractère désignant le pied de biche
     * @param monde Monde dans lequel se trouve le pied de biche
     * @throws NomDEntiteDejaUtiliseDansLeMondeException exceotion si le nom de
     *                                                   l'entité est déjà utilisé
     */
    public PiedDeBiche(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
        super(nom, monde);
    }

    /**
     * @return true pour un PiedDeBiche
     */
    public boolean estDeplacable() {
        return true;
    }

    public String toString() {
        return String.format("Pied de Biche de nom %s, dans le monde %s, est par normalement déplacable", this.getNom(),
                this.getMonde().toString());
    }
}
