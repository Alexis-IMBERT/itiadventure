package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;


public class Monde{
	//Attributs
	private String nomDuMonde;
	private Entite[] entites;
	//constructeurs
	public Monde(String nomDuMonde){
		this.nomDuMonde =nomDuMonde;
		this.entites = new Entite[0];
	}
	//Methodes
	public String getNom(){
		return this.nomDuMonde;
	}
	public Entite getEntite(String nomEntite){
		boolean estPresent=false;
		int i=0;
		while(!estPresent && i<entites.length){
			if (entites[i].getNom()==nomEntite){
				estPresent = true;
			}
			else{
				i++;
			}
		}
		if(estPresent){
			return entites[i];
		}
		else{
			return (Entite)null;
		}
	}
	public void ajouter(Entite entite){
		int taille = this.entites.length;
		int i;
		Entite[] tmp = new Entite[taille+1];
		for(i=0;i<taille;i++){
			tmp[i]=this.entites[i];
		}
		tmp[taille]=entite;
		entites=tmp;
	}
	public String toString(){
		return String.format("%s",nomDuMonde);
	}
}
