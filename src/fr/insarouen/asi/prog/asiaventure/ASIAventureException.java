package fr.insarouen.asi.prog.asiaventure;

/**
* @throws création du type d'exceptions de ASIAventure
*/
public class ASIAventureException extends java.lang.Exception{
	//Constructeur
	/**
	* Constructeur de l'exception de type ASIAventureException qui hérite de java.lang.Exception
	*/
	public ASIAventureException(){
		super();
	}
	
	/**
	* Constructeur de l'exception de type ASIAventureException avec une chaine de caractère qui hérite de java.lang.Exception
	*/
	public ASIAventureException(java.lang.String msg){
		super(msg);
	}
}
