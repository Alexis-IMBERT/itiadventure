package fr.insarouen.asi.prog.asiaventure.elements ;

import fr.insarouen.asi.prog.asiaventure.Monde;

public class Entite{
	//Attributs
	private String nom;
	private Monde monde;
	//Constructeur
	public Entite(String nom, Monde monde){
		this.nom=nom;
		this.monde=monde;
	}
	//methodes
	public String getNom(){
		return this.nom;
	}
	
	public Monde getMonde(){
		return this.monde;
	}
	
	public String toString(){
		return String.format("Entite %s du monde %s",nom,monde.toString());
	}
	
	public boolean equals(Object o){
		if (o==this){
			return true;
		}
		if (o==null || this.getClass() != o.getClass()){
			return false;
		}
		Entite test = (Entite)o;
		if(this.nom == test.nom && this.monde == test.monde){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		return 2*nom.hashCode()+3*monde.hashCode() ;
	}
}
