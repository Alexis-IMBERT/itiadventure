package fr.insarouen.asi.prog.asiaventure.elements.structure ;
import fr.insarouen.asi.prog.asiaventure.Monde;
public abstract class ElementStructurel{
	private String nom;
	private Monde monde;
	
	public ElementStructurel(String nom, Monde monde){
		this.monde = monde;
		this.nom = nom;
	}
}
