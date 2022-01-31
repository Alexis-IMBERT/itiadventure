package fr.insarouen.asi.prog.asiaventure.elements.objets ;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

public abstract class Objet extends Entite{
	//Attributs
	private boolean estDeplacable=false;
	//Constructeur
	public Objet(String nom, Monde monde){
		super(nom,monde);
	}
	//Methodes
	public boolean estDeplacable(){
		return this.estDeplacable;
	}
}
