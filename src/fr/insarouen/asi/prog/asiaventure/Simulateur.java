package fr.insarouen.asi.prog.asiaventure;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;


public class Simulateur {
	//Attributs :
	Monde monde;

	public Simulateur(Reader reader) throws IOException, NomDEntiteDejaUtiliseDansLeMondeException{
        Scanner sc = new Scanner(reader);
		while(sc.hasNext()){
			String nomType = sc.next();
			switch(nomType){
				case "Monde":
					this.monde = new Monde(sc.next());
					break;
				case "Piece":
					new Piece(sc.next(),this.monde);
					break;
                case "PorteSerrure":
					new Porte(sc.next(), this.monde,new Serrure(this.monde),(Piece)this.monde.getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next()));
                    break;
                case "Porte":
                    new Porte(sc.next(),this.monde,(Piece)this.monde.getEntite(sc.next()), (Piece)this.monde.getEntite(sc.next()));
                    break;
                case "Clef":
					Clef cle =((Porte)this.monde.getEntite(sc.next())).getSerrure().creerClef();
					((Piece)this.monde.getEntite(sc.next())).deposer(cle);
                    break;
				case "JoueurHumain":
					new JoueurHumain(sc.next(), this.monde, sc.nextInt(),sc.nextInt(), (Piece)this.monde.getEntite(sc.next()),(Objet)null);
				default:
					throw new IOException("Le Type ne correspond à aucun type connu");
			}
		}
		sc.close();
	}

	public Simulateur(java.io.ObjectInputStream ois) throws java.io.IOException,java.lang.ClassNotFoundException{
		this.monde = (Monde)ois.readObject();
	}

	public void enregistrer(java.io.ObjectOutputStream oos) throws java.io.IOException{
		oos.writeObject(this.monde);
	}
}