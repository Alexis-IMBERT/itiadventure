package fr.insarouen.asi.prog.asiaventure;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.bouncycastle.util.Arrays;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;


public class Simulateur {
	//Attributs :
	Monde monde=null;
	List<ConditionDeFin> conditionDeFins = new ArrayList<ConditionDeFin>();
	EtatDuJeu etatDuJeu=null;
	List<ConditionDeFin> c = new LinkedList<>();

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

	public Simulateur(java.io.ObjectInputStream ois) throws java.io.IOException,java.lang.ClassNotFoundException{
		this.monde = (Monde)ois.readObject();
		this.etatDuJeu=(EtatDuJeu)ois.readObject();
		this.conditionDeFins = (List<ConditionDeFin>)ois.readObject();//warning mais on peut rien y faire
	}

	public void enregistrer(java.io.ObjectOutputStream oos) throws java.io.IOException{
		oos.writeObject(this.monde);
		oos.writeObject(this.etatDuJeu);
		oos.writeObject(this.conditionDeFins);
	}

	private EtatDuJeu succesOuEchec(String chaineEtat){
		if(chaineEtat.equals("SUCCES")){
			return EtatDuJeu.SUCCES;
		}
		else{//discutable si ni l'un ni l'autre
			return EtatDuJeu.ECHEC;
		}
	}

	private Objet[] lisObjets(String[] leStrings, int debut){
		Objet[] res = new Objet[leStrings.length-debut];
		for(int i=debut; i<leStrings.length;i++){
			res[i-debut] = (Objet)this.monde.getEntite(leStrings[i]);
		}
		return res;
	}
}