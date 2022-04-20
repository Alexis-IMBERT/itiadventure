package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

/**
 * Classe abstraite servant à la construction des élements structurels
 * du jeux
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public abstract class ElementStructurel extends Entite {
    /**
     * Constructeur d'un élément structurel
     * 
     * @param nom   chaine de caractère désignant l'élément
     * @param monde monde de type Monde auquel appartient l'élément structurel
     */
    public ElementStructurel(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException {
        super(nom, monde);
    }

    /**
     * Méthode toString permettant de transformer l'objet en chaine de caractère
     */
    @Override
    public String toString() {
        return String.format("ElementStructurel de nom %s dans le monde %s", this.getNom(), this.getMonde().toString());
    }
}
