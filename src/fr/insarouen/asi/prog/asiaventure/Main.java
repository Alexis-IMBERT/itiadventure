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

/**
 * Class main du jeux
 * 
 * @author Alexis Imbert et Mehdi Saissi Hassani
 * 
 */
public class Main extends Object {
    public void main() {
    }

    public static void main(String[] args) throws Throwable {
        boolean quitter = false;
        Simulateur simulateur = null;
        while (!quitter) {
            afficherMenu();
            switch (choisirAction()) {
                case 2:
                    simulateur = chargerFichierDescription();
                    break;
                case 3:
                    if (simulateur != null) {
                        sauvegarderPartie(simulateur);
                    }
                case 4:
                    simulateur = chargerSauvegarde();
                    break;
                case 5:
                    quitter = true;
                    break;
                default:
                    System.err.println("Erreur : Le nombre saisie est invalide.");
                    break;
            }
        }
    }

    /**
     * Méthode pour charger un fichier de Description d'un jeux
     * 
     * @return
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static Simulateur chargerFichierDescription()
            throws NomDEntiteDejaUtiliseDansLeMondeException, FileNotFoundException, IOException {
        return new Simulateur(new BufferedReader(new FileReader(lireNomFichier())));
    }

    /**
     * Méthode pour sauvegarder la partie en cours
     * 
     * @param simulateur
     * @throws IOException
     */
    private static void sauvegarderPartie(Simulateur simulateur) throws IOException {
        ObjectOutputStream flot = new ObjectOutputStream(new FileOutputStream(lireNomFichier()));
        simulateur.enregistrer(flot);
        flot.flush();
    }

    /**
     * Méthode pour charger une partie sauvegardé
     * 
     * @return
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static Simulateur chargerSauvegarde() throws ClassNotFoundException, FileNotFoundException, IOException {
        return new Simulateur(new ObjectInputStream(new FileInputStream(lireNomFichier())));
    }

    /**
     * méthode pour choisir l'action a effectué depuis le menu
     * 
     * @return
     */
    private static int choisirAction() {
        System.out.print("Faites votre choix : ");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        sc.close();
        return res;
    }

    /**
     * Menu à afficher
     */
    private static void afficherMenu() {
        System.out.println();
        System.out.println(" --- Menu ---");
        System.out.println("1/ jouer");
        System.out.println("2/ charger un fichier de description");
        System.out.println("3/ sauver la partie actuelle");
        System.out.println("4/ charger une partie");
        System.out.println("5/ quitter");
    }

    /**
     * Lis le nom du fichier à selectionner
     * 
     * @return
     */
    private static String lireNomFichier() {
        System.out.print("Entrer un nom de fichier: ");
        Scanner sc = new Scanner(System.in);
        String res = sc.next();
        sc.close();
        return res;
    }

    @Override
    public String toString() {
        return "Main []";
    }
}
