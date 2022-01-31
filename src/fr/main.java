package fr;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet ;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel ;

public class main{
	public static void main(String[] args){
		//TP02
		Monde monde = new Monde("MondeTest");
		System.out.println(String.format("Monde : %s\n",monde.toString()));
		//Entite entite = new Entite("EntiteTest",monde); 
		//Entite entite2 =new Entite("EntiteTest2",monde);
		//System.out.println(String.format("Entite : %s\n",entite.toString()));
		//monde.ajouter(entite);
		//monde.ajouter(entite2);
		//System.out.println(monde.getEntite("EntiteTest").toString());
		//System.out.println(monde.getEntite("EntiteTest2").toString());
	}
}
