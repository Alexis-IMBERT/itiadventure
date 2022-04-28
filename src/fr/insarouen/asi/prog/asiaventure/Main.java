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
        Scanner sc = new Scanner(System.in);
        while (!quitter) {
            afficherMenu();
            int resutltat = choisirAction(sc);
            switch (resutltat) {
                case 1:
                    jouer(simulateur, sc);
                    break;
                case 2:
                    System.out.println("Dans le main Switch 2");
                    simulateur = chargerFichierDescription(sc);
                    break;
                case 3:
                    if (simulateur != null) {
                        sauvegarderPartie(simulateur,sc);
                    }
                    break;
                case 4:
                    simulateur = chargerSauvegarde(sc);
                    break;
                case 5:
                    quitter = true;
                    break;
                default:
                    System.out.println("Erreur : Le nombre saisie est invalide.");
                    break;
            }
        }
        sc.close();
    }

    private static void jouer(Simulateur simulateur, Scanner sc)throws Throwable{
        boolean onContinue = true;
        boolean choix = true;
        if(simulateur==null){
            System.out.println("Aucune partie n'est chargé : veuillez soit charger un fichier de description soit une partie");
            main(new String[0]);
        }
        while(onContinue){
            simulateur.executerUnTour(sc);
            System.out.println("Voulez-vous continuez ?(O/N)");
            while(choix){
                String tmp = sc.next();
                switch(tmp){
                    case "O":
                        choix = false;
                        break;
                    case "N":
                        main(new String[0]);
                        onContinue=false;
                        choix=false;
                        break;
                    default:
                        System.out.println("Merci d'indiquez O ou N");
                        break;
                }
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
    private static Simulateur chargerFichierDescription(Scanner sc)
            throws NomDEntiteDejaUtiliseDansLeMondeException, FileNotFoundException, IOException {
        return new Simulateur(new BufferedReader(new FileReader(lireNomFichier(sc))));
    }

    /**
     * Méthode pour sauvegarder la partie en cours
     * 
     * @param simulateur
     * @throws IOException
     */
    private static void sauvegarderPartie(Simulateur simulateur,Scanner sc) throws IOException {
        ObjectOutputStream flot = new ObjectOutputStream(new FileOutputStream(lireNomFichier(sc)));
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
    private static Simulateur chargerSauvegarde(Scanner sc) throws ClassNotFoundException, FileNotFoundException, IOException {
        return new Simulateur(new ObjectInputStream(new FileInputStream(lireNomFichier(sc))));
    }

    /**
     * méthode pour choisir l'action a effectué depuis le menu
     * 
     * @return
     */
    private static int choisirAction(Scanner sc) {
        System.out.print("Faites votre choix : ");
        int res = sc.nextInt();
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
    private static String lireNomFichier(Scanner scanner) {
        System.out.println("Entrer un nom de fichier: ");
        String res = scanner.next();
        return res;
    }

    @Override
    public String toString() {
        return "Main []";
    }
}
