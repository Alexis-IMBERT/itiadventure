package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 * classe d'exception de commande impossible à effectuer sur le vivant en question
 */
public class CommandeImpossiblePourLeVivantException extends VivantException{
	/**
	 * constructeur d'exception de d'exception de commande impossible a faire sur le vivant
	 */
	public CommandeImpossiblePourLeVivantException(){
		super();
	}

	/**
	 * constructeur d'exception de d'exception de commande impossible a faire sur le vivant
	 * 
	 * @param msg chaine de caractère passé en paramètre pour expliquer l'erreur
	 */
	public CommandeImpossiblePourLeVivantException(String msg){
		super(msg);
	}
}