package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
	 * Classe d'exception d'objet non présent dans la pièce
	 */
public class ObjetAbsentDeLaPieceException extends PieceException{
	/**
	 * Méthode d'exception d'objet non présent dans la pièce 
	 */
	ObjetAbsentDeLaPieceException(){
		super();
	}
	/**
	 * Méthode d'exception d'objet non présent dans la pièce ave un message en paramètre
	 */
	ObjetAbsentDeLaPieceException(String msg){
		super(msg);
	}
}
