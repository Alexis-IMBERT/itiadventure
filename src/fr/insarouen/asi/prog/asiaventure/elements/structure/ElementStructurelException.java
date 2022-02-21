package fr.insarouen.asi.prog.asiaventure.elements.structure

/**
*@throws création du type d'exceptions de ElementStructurelException
*/


public class ElementStructurelException extends ASIAventureException{
	
	//Constructeurs
	
	/**
	* Constructeur de l'exception de type ElementStructurelException qui hérite de ASIAventureException
	*@param msg Chaine de caractère désignant ElementStructurelException
	*/
	
	public ElementStructurelException(String msg){
		super(msg);
	}
	
	/**
	* Constructeur de l'exception de type ElementStructurelException qui hérite de ASIAventureException
	*/
	
	public ElementStructurelException(){
		super();
	}
}
