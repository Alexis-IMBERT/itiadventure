package fr.insarouen.asi.prog.asiaventure;

/**
*@throws création du type d'exceptions de NomDEntiteDejaUtiliseDansLeMondeException
*/

public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{
	
	//Constructeurs
	
	/**
	* Constructeur de l'exception de type NomDEntiteDejaUtiliseDansLeMondeException qui hérite de MondeException
	*/

	public NomDEntiteDejaUtiliseDansLeMondeException(){
		super();
	}
	
	/**
	* Constructeur de l'exception de type NomDEntiteDejaUtiliseDansLeMondeException qui hérite de MondeException
	*@param msg Chaine de caractère désignant NomDEntiteDejaUtiliseDansLeMondeException
	*/

	public NomDEntiteDejaUtiliseDansLeMondeException(String msg){
		super(msg);
	}
}
