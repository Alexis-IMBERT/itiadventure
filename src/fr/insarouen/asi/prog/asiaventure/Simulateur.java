package fr.insarouen.asi.prog.asiaventure;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

/**
 * Simulateur de monde
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public class Simulateur {
    //Attributs :
    /**
     * Monde simulé
     */
    Monde monde=null;
    /**
     * Les conditions de fins
     */
    List<ConditionDeFin> conditionDeFins = new ArrayList<ConditionDeFin>();
    /**
     * L'etat du jeux
     */
    EtatDuJeu etatDuJeu=null;

    /**
     * Constructeur à partir d'un fichier de description de partie
     * @param reader
     * @throws IOException
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     */
    public Simulateur(Reader reader) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
        Scanner sc = new Scanner(reader);
        String ligne;
        String[] partie;
        String nomType;
        String nom;
        Piece piece,pieceA,pieceB;
        Porte porte;
        Clef cle;
        EtatDuJeu etatDuJeu;
        Vivant vivant;
        Objet[] lesObjets;
        while(sc.hasNextLine()){
            ligne = sc.nextLine();
            partie = ligne.split(" ");
            nomType = partie[0];
            switch(nomType){
                case "Monde":
                    this.monde = new Monde(partie[1]);
                    break;
                case "Piece":
                    new Piece(partie[1],this.monde);
                    break;
                case "PorteSerrure":
                    nom = partie[1];
                    pieceA = (Piece)this.monde.getEntite(partie[2]);
                    if(pieceA==null){
                        throw new IOException("Le nom de la PieceA n'existe pas");
                    }
                    pieceB = (Piece)this.monde.getEntite(partie[3]);
                    if(pieceB==null){
                        throw new IOException("Le nom de la PieceB n'existe pas");
                    }
                    new Porte(nom, this.monde,new Serrure(this.monde),pieceA,pieceB );
                    break;
                case "Porte":
                    nom = partie[1];
                    pieceA = (Piece)this.monde.getEntite(partie[2]);
                    if(pieceA==null){
                        throw new IOException("Le nom de la PieceA n'existe pas");
                    }
                    pieceB = (Piece)this.monde.getEntite(partie[3]);
                    if(pieceB==null){
                        throw new IOException("Le nom de la PieceB n'existe pas");
                    }
                    new Porte(nom,this.monde,pieceA, pieceB);
                    break;
                case "Clef":
                    porte = ((Porte)this.monde.getEntite(partie[1]));
                    if (porte==null){
                        throw new IOException("Le nom de la porte n'existe pas");
                    }
                    piece = (Piece)this.monde.getEntite(partie[2]);
                    if(piece==null){
                        throw new IOException("Le nom de la pièce n'existe pas");
                    }
                    cle = porte.getSerrure().creerClef();
                    piece.deposer(cle);
                    break;
                case "JoueurHumain":
                    nom = partie[1];
                    int nombrePV;
                    int nombrePF;
                    nombrePV = Integer.parseInt(partie[2]);
                    nombrePF = Integer.parseInt(partie[3]);
                    piece = (Piece)this.monde.getEntite(partie[4]);
                    if(piece==null){
                        throw new IOException("Le nom de la pièce n'existe pas");
                    }
                    lesObjets = lisObjets(partie,5);
                    new JoueurHumain(nom, this.monde, nombrePV,nombrePF, piece,lesObjets);
                    break;
                case "ConditionDeFinVivantMort":
                    etatDuJeu = succesOuEchec(partie[1]);
                    vivant = (Vivant)this.monde.getEntite(sc.next());
                    if(vivant==null){
                        throw new IOException("Le nom du vivant n'existe pas");
                    }
                    this.conditionDeFins.add(new ConditionDeFinVivantMort(etatDuJeu,vivant));
                    break;
                case "ConditionDeFinVivantPossedeObjets":
                    etatDuJeu = succesOuEchec(partie[1]);
                    vivant = (Vivant)this.monde.getEntite(partie[2]);
                    if(vivant==null){
                        throw new IOException("Le nom du vivant n'existe pas");
                    }
                    lesObjets = lisObjets(partie,3);
                    this.conditionDeFins.add(new ConditionDeFinVivantPossedeObjets(etatDuJeu,vivant,lesObjets));
                    break;
                case "ConditionDeFinVivantDansPiece":
                    etatDuJeu = succesOuEchec(partie[1]);
                    vivant = (Vivant)this.monde.getEntite(partie[2]);
                    if(vivant==null){
                        throw new IOException("Le nom du vivant n'existe pas");
                    }
                    piece = (Piece)this.monde.getEntite(partie[3]);
                    if(piece==null){
                        throw new IOException("Le nom de la pièce n'existe pas");
                    }
                    this.conditionDeFins.add(new ConditionDeFinVivantDansPiece(etatDuJeu, vivant, piece));
                    break;
                case "ConditionDeFinVivantDansPieceEtPossedeObjets" :
                    etatDuJeu = succesOuEchec(partie[1]);
                    vivant = (Vivant)this.monde.getEntite(partie[2]);
                    if(vivant==null){
                        throw new IOException("Le nom du vivant n'existe pas");
                    }
                    piece = (Piece)this.monde.getEntite(partie[3]);
                    if(piece==null){
                        throw new IOException("Le nom de la pièce n'existe pas");
                    }
                    lesObjets = lisObjets(partie, 4);
                    this.conditionDeFins.add(new ConditionDeFinVivantDansPieceEtPossedeObjets(etatDuJeu, vivant, piece, lesObjets));
                    break;
                default:
                    throw new IOException("Le Type ne correspond à aucun type connu");
            }
        }
        sc.close();
    }

    /**
     * Constructeur à partir d'une sauvegarde de partie
     * @param ois
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public Simulateur(java.io.ObjectInputStream ois) throws java.io.IOException,java.lang.ClassNotFoundException{
        this.monde = (Monde)ois.readObject();
        this.etatDuJeu=(EtatDuJeu)ois.readObject();
        this.conditionDeFins = (List<ConditionDeFin>)ois.readObject();//warning mais on peut rien y faire
    }

    /**
     * Enregistre la partie en cours
     * @param oos
     * @throws java.io.IOException
     */
    public void enregistrer(java.io.ObjectOutputStream oos) throws java.io.IOException{
        oos.writeObject(this.monde);
        oos.writeObject(this.etatDuJeu);
        oos.writeObject(this.conditionDeFins);
    }

    /**
     * Transcript la chaine de caractère SUCCES ou ECHEC dans le type correspondant
     * @param chaineEtat
     * @return
     */
    private EtatDuJeu succesOuEchec(String chaineEtat){
        if(chaineEtat.equals("SUCCES")){
            return EtatDuJeu.SUCCES;
        }
        else{//discutable si ni l'un ni l'autre
            return EtatDuJeu.ECHEC;
        }
    }

    /**
     * lis les objets en fin de liste
     * @param leStrings
     * @param debut
     * @return
     * @throws IOException
     */
    private Objet[] lisObjets(String[] leStrings, int debut)throws IOException{
        Objet[] res = new Objet[leStrings.length-debut];
        for(int i=debut; i<leStrings.length;i++){
            res[i-debut] = (Objet)this.monde.getEntite(leStrings[i]);
            if (res[i-debut]==null){
                throw new IOException("Le nom de l'objet n'existe pas");
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Simulateur [conditionDeFins=" + conditionDeFins + ", etatDuJeu=" + etatDuJeu + ", monde=" + monde + "]";
    }

    public EtatDuJeu executerUnTour() throws java.lang.Throwable{
        //récupérer les joueur humain
        JoueurHumain[] joueurHumains = null;
        //afficher sa situation
        for(JoueurHumain joueurHumain : joueurHumains){
            System.out.println(joueurHumain.toString());
        }
        //pour chaque Executable appeler la méthode executer
        // v´erifier chaque condition de fin et retourner ENCOURS si aucune n’est vérifiée, sinon retourner l’état
        return null;
    }

    public EtatDuJeu executerJusquALaFin() throws java.lang.Throwable{
        EtatDuJeu etatDuJeu = EtatDuJeu.ENCOURS;
        while(etatDuJeu == EtatDuJeu.ENCOURS){
            etatDuJeu = executerUnTour();
        }
        return etatDuJeu;
    }
}