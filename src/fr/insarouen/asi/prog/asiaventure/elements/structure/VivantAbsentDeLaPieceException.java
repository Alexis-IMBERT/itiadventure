package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Classe d'exception le vivant appelé n'est pas présent dans la pièce
 */
public class VivantAbsentDeLaPieceException extends PieceException{
	//Constructeur
	/**
	 * Méthode d'exception le vivant appelé n'est pas présent dans la pièce
	 */
	public VivantAbsentDeLaPieceException(){
		super();
	}

	/**
	 * Méthode d'exception le vivant appelé n'est pas présent dans la pièce
	 * @param msg le message passé
	 */
	public VivantAbsentDeLaPieceException(String msg){
		super(msg);
	}
}
