package fr;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;


public class main{
	public static void main(String[] args){
		Monde monde = new Monde("MondeTest");
		System.out.println(String.format("Monde : %s\n",monde.toString()));
		Entite entite = new Entite("EntiteTest",monde);
		Entite entite2 =new Entite("EntiteTest2",monde);
		System.out.println(String.format("Entite : %s\n",entite.toString()));
		monde.ajouter(entite);
		monde.ajouter(entite2);
		System.out.println(monde.getEntite("EntiteTest").toString());
		System.out.println(monde.getEntite("EntiteTest2").toString());
	}
}
