package fr;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet ;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurel ;

import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.MondeException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PieceException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.CommandeImpossiblePourLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;


public class main{
	public static void main(String[] args){
		//TP02
		System.out.println("\n ------------------------TP02-------------------------------");
		Monde monde = new Monde("MondeTest");
		System.out.println(String.format("Monde : %s\n",monde.toString()));
		Entite entite = new EntiteConcrete("EntiteTest",monde);//avec changement en class anonyme TP03
		Entite entite2 = new EntiteConcrete("EntiteTest2",monde);//avec changement en class anonyme TP03
		System.out.println(String.format("Entite : %s\n",entite.toString()));
		monde.ajouter(entite);
		monde.ajouter(entite2);
		System.out.println(monde.getEntite("EntiteTest").toString());
		System.out.println(monde.getEntite("EntiteTest2").toString());
		
		//TP03
		System.out.println("\n ------------------------TP03-------------------------------");
		Piece piece1 = new Piece("Piece1",monde);
		System.out.println(piece1.contientObjet("Test"));
		Objet objet1 = new ObjetConcret("Objet1",monde);
		Objet objet2 = new ObjetConcret("Objet2",monde);
		piece1.deposer(objet1);
		System.out.println(piece1.getObjets()[0]);
		piece1.deposer(objet2);
		System.out.println(piece1.getObjets()[0]);
		System.out.println(piece1.getObjets()[1]);
		piece1.retirer(objet1);
		System.out.println(piece1.getObjets()[0]);
		piece1.retirer("Objet2");
		System.out.println(piece1.getObjets().length);
	}
	static class EntiteConcrete extends Entite{
		public EntiteConcrete(String nom, Monde monde){
			super(nom,monde);
		}
	}
	static class ObjetConcret extends Objet{
		public ObjetConcret(String nom, Monde monde){
			super(nom, monde);
		}
	}
}
