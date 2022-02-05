package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet ;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
public class Piece extends ElementStructurel{
	//Attributs
	Objet[] objets = new Objet[0];
	Vivant[] vivants = new Vivant[0];
	//Constructeur
	public Piece(String nom, Monde monde){
		super(nom,monde);
	}
	//methodes
	public boolean contientObjet(Objet objet){
		int taille = objets.length;
		int i = 0;
		boolean res = false;
		while (i<taille && !res){
			if (objets[i].equals(objet)){
				res=true;
			}
			i++;
		}
		return res;
	}
	
	public boolean contientObjet(String nomObj){
		int taille = objets.length;
		int i = 0;
		boolean res = false;
		while (i<taille && !res){
			if (objets[i].getNom() == nomObj){
				res=true;
			}
			i++;
		}
		return res;
	}
	
	public void deposer(Objet obj){
		int taille = objets.length;
		Objet[] newObjets = new Objet[taille+1];
		int i=0;
		for (i=0;i<taille;i++){
			newObjets[i] = this.objets[i];
		}
		newObjets[taille] = obj ;
		this.objets = newObjets ;
	}
	
	public Objet[] getObjets(){
		return objets;
	}
	
	public Objet retirer(Objet obj){
		int taille = objets.length;
		int i=0;
		int j=0;
		Objet[] newObjets = new Objet[taille-1];
		Objet res=null;
		for (i=0;i<taille;i++){
			if (!objets[i].equals(obj)){
				newObjets[j]=this.objets[i];
				j++;
			}
			else {
				res = this.objets[i];
			}
		}
		this.objets = newObjets ;
		return res;
	}
	
	public Objet retirer(String nomObj){
		int taille = objets.length;
		int i=0;
		int j=0;
		Objet[] newObjets = new Objet[taille-1];
		Objet res=null;
		for (i=0;i<taille;i++){
			if (objets[i].getNom() != nomObj){
				newObjets[j]=this.objets[i];
				j++;
			}
			else {
				res = this.objets[i];
			}
		}
		this.objets = newObjets ;
		return res;
	}
	
	public boolean contientVivant(Vivant vivant){
		int taille = vivants.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (vivants[i].equals(vivant)){
				estPresent=true;
			}
			i++;
		}
		return estPresent;
	}
	
	public boolean contientVivant(String nomVivant){
		int taille = vivants.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (vivants[i].getNom() == nomVivant){
				estPresent=true;
			}
			i++;
		}
		return estPresent;
	}
	
	public void entrer(Vivant vivant){
		int taille = vivants.length;
		Vivant[] newVivants = new Vivant[taille+1];
		int i=0;
		for(i=0;i<taille;i++){
			newVivants[i] = vivants[i];
		}
		newVivants[taille] = vivant;
		vivants = newVivants;
	}
	
	public Vivant[] getVivant(){
		return this.vivants;
	}
	
	public Vivant sortirVivant(Vivant vivant){
		int taille = vivants.length;
		int i=0;
		int j=0;
		Vivant[] newVivants = new Vivant[taille-1];
		Vivant res=null;
		for (i=0;i<taille;i++){
			if (!vivants[i].equals(vivant)){
				newVivants[j]=this.vivants[i];
				j++;
			}
			else {
				res = this.vivants[i];
			}
		}
		this.vivants = newVivants ;
		return res;
	}
	public Vivant sortirVivants(String nomVivant){
		int taille = vivants.length;
		int i=0;
		int j=0;
		Vivant[] newVivants = new Vivant[taille-1];
		Vivant res=null;
		for (i=0;i<taille;i++){
			if (vivants[i].getNom() != nomVivant){
				newVivants[j]=this.vivants[i];
				j++;
			}
			else {
				res = this.vivants[i];
			}
		}
		this.vivants = newVivants ;
		return res;
	}
}





















