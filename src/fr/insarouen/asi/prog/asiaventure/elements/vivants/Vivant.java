package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

public abstract class Vivant extends Entite{
	//Attributs
	public int pointVie;
	public int pointForce;
	private Piece piece;
	private Objet[] objets;
	
	//Constructeurs
	public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets){
		super(nom,monde);
		this.pointVie = pointVie;
		this.pointForce = pointForce;
		this.piece = piece;
		this.objets = objets;
	}
	//Methodes
	public void deposer(Objet objet){
		int taille = objets.length;
		Objet[] newObjets = new Objet[taille-1];
		int i=0;
		int j=0;
		for(i=0;i<taille;i++){
			if(objets[i]!=objet){
				newObjets[j]=objets[i];
				j++;
			}
		}
		objets = newObjets;
	}
	public void deposer(String nomObj){
		int taille = objets.length;
		Objet[] newObjets = new Objet[taille-1];
		int i=0;
		int j=0;
		for(i=0;i<taille;i++){
			if(objets[i].getNom()!=nomObj){
				newObjets[j]=objets[i];
				j++;
			}
		}
		objets = newObjets;
	}
	
	public Objet[] getObjets(){
		return objets;
	}
	
	public Objet getObjet(String nomObjet){
		int taille = objets.length;
		int i=0;
		boolean estPresent = false;
		Objet res = null;
		while (i<taille && !estPresent){
			if (objets[i].getNom() == nomObjet){
				res = objets[i];
				estPresent=true;
			}
			i++;
		}
		return res;
	}
	
	public Piece getPiece(){
		return piece;
	}
	
	public int getPointForce(){
		return pointForce;
	}
	public int getPointVie(){
		return pointVie;
	}
	public boolean possede(Objet objet){
		int taille = objets.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (objets[i].equals(objet)){
				estPresent = true;
			}
			i++;
		}
		return estPresent;
	}
	
	public boolean possede(String nomObjet){
		int taille = objets.length;
		int i=0;
		boolean estPresent = false;
		while(i<taille && !estPresent){
			if (objets[i].getNom() == nomObjet){
				estPresent = true;
			}
			i++;
		}
		return estPresent;
	}
	
	public void prendre(Objet objet){
		int taille = objets.length;
		int i=0;
		Objet[] newObjets = new Objet[taille+1];
		for (i=0;i<taille;i++){
			newObjets[i] = objets[i];
		}
		newObjets[taille] = objet;
		objets = newObjets;
	}
	public void prendre(String nomObj){
		int taille = objets.length;
		int i=0;
		Objet objet = this.getPiece().retirer(nomObj);
		Objet[] newObjets = new Objet[taille+1];
		for (i=0;i<taille;i++){
			newObjets[i] = objets[i];
		}
		newObjets[taille] = objet;
		objets = newObjets;
	}
	public boolean estMort(){
		return (this.getPointVie()<=0);
	}
	
	public String toString(){
		return String.format("Vivant %s du monde %s a %d points de vie et %d points de Forces est dans la piece %s",this.getNom(),this.getMonde().toString(),this.getPointVie(),this.getPointForce(), this.getPiece());
	}
}













