package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
 * Interface de l'activable
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 */
public interface Activable {
    /**
     * Retourne si l'objet est activable ou pas avec un autre objet
     * 
     * @param objet
     * @return boolean
     */
    public boolean activableAvec(Objet objet);

    /**
     * active l'objet
     * 
     * @throws ActivationException si les conditions d'activations ne sont pas
     *                             complète
     */
    public void activer() throws ActivationException;

    /**
     * active l'objet avec un autre objet donné en paramètre
     * 
     * @param objet
     * @throws ActivationException si les conditions d'activations ne sont pas
     *                             complète
     */
    public void activerAvec(Objet objet) throws ActivationException;

    @Override
    String toString();
}