package fr.insarouen.asi.prog.asiaventure;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main extends Object{
	public void Main(){}
	public static void main(String[] args) throws Throwable{
		boolean quitter = false;
		Simulateur simulateur = null;
		while(!quitter){
			afficherMenu();
			switch(choisirAction()){
				case 2:
					simulateur = chargerFichierDescription();
					break;
				case 3:
					if(simulateur !=null){
						sauvegarderPartie(simulateur);
					}
				case 4:
					simulateur = chargerSauvegarde();
					break;
				case 5:
					quitter=true;
					break;
				default:
				System.err.println("Erreur : Le nombre saisie est invalide.");
				break;
			}
		}
	}
	private static Simulateur chargerFichierDescription() throws NomDEntiteDejaUtiliseDansLeMondeException, FileNotFoundException, IOException{
		return new Simulateur(new BufferedReader(new FileReader(lireNomFichier())));
	}
	private static void sauvegarderPartie(Simulateur simulateur) throws IOException {
		ObjectOutputStream flot = new ObjectOutputStream(new FileOutputStream(lireNomFichier()));
		simulateur.enregistrer(flot);
		flot.flush();
	}
	private static Simulateur chargerSauvegarde() throws ClassNotFoundException, FileNotFoundException, IOException {
		return new Simulateur(new ObjectInputStream(new FileInputStream(lireNomFichier())));
	}
	private static int choisirAction() {
		System.out.print("Faites votre choix : ");
		Scanner sc = new Scanner(System.in);
		int res = sc.nextInt();
		sc.close();
		return res;
	}
	private static void afficherMenu() {
		System.out.println();
		System.out.println(" --- Menu ---");
		System.out.println("1/ jouer");
		System.out.println("2/ charger un fichier de description");
		System.out.println("3/ sauver la partie actuelle");
		System.out.println("4/ charger une partie");
		System.out.println("5/ quitter");
	}
	private static String lireNomFichier(){
		System.out.print("Entrer un nom de fichier: ");
		Scanner sc = new Scanner(System.in);
		String res = sc.next();
		sc.close();
		return res;
	}
}
