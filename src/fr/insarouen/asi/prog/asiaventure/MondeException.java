package fr.insarouen.asi.prog.asiaventure;

/**
*@throws création du type d'exceptions de MondeException
*/

public class MondeException extends ASIAventureException{
	
	//Constructeurs
	
	/**
	* Constructeur de l'exception de type MondeException qui hérite de ASIAventureException
	*@param msg Chaine de caractère désignant MondeException
	*/
	
	public MondeException(String msg){
		super(msg);
	}
	
	/**
	* Constructeur de l'exception de type MondeException qui hérite de ASIAventureException
	*/
	public MondeException(){
		super();
	}
}
