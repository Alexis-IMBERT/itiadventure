package fr.insarouen.asi.prog.asiaventure.elements.objets ;

import fr.insarouen.asi.prog.asiaventure.Monde;

public class PiedDeBiche extends Objet{
	//Attributs
	private boolean estDeplacable = true;
	//Constructeur
	public PiedDeBiche(String nom, Monde monde){
		super(nom,monde);
	}
}
