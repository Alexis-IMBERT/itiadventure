package fr.insarouen.asi.prog.asiaventure;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;


public class Simulateur {
	//Attributs :
	Monde monde;

	public Simulateur(Reader reader) throws Exception, NomDEntiteDejaUtiliseDansLeMondeException{
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
                    break;
				default:
					throw new Exception("Le Type ne correspond à aucun type connu");
			}
		}
	}
}