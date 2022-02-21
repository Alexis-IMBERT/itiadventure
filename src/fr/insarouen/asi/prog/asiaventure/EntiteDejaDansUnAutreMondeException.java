package fr.insarouen.asi.prog.asiaventure;

/**
*@throws création du type d'exceptions de EntiteDejaDansUnAutreMondeException
*/


public class EntiteDejaDansUnAutreMondeException extends MondeException{
	
	//Constructeurs
	
	/**
	* Constructeur de l'exception de type EntiteDejaDansUnAutreMondeException qui hérite de MondeException
	*@param msg Chaine de caractère désignant EntiteDejaDansUnAutreMondeException
	*/
	
	public EntiteDejaDansUnAutreMondeException(String msg){
		super(msg);
	}
	
	/**
	* Constructeur de l'exception de type EntiteDejaDansUnAutreMondeException qui hérite de MondeException
	*/
	
	public EntiteDejaDansUnAutreMondeException(){
		super();
	}
}
