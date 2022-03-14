package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

/**
 * @author Alexis Imbert et Mehdi Saissi Hassani
 * Interface de l'activable

 */
public interface Activable{
	public boolean ActivableAvec(Objet objet);
	public void activer() throws ActivationException;
	public void activerAvec(Objet objet) throws ActivationException;
}