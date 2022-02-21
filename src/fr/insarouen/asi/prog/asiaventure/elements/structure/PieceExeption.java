package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
* @throws Exception liée aux pièces
*/
public class PieceException extends ElementStructurelException{
	//Constructeur
	/**
	* Constructeur de l'exception de type PieceException qui hérite de ElementStructurelException
	*/
	public PieceException(){
		super();
	}
	
	/**
	* Constructeur de l'exception de type PieceException avec une chaine de caractère (un message) donné en paramètre qui hérite de ElementStructurelException
	*/
	public PieceException(java.lang.String msg){
		super(msg);
	}
}
