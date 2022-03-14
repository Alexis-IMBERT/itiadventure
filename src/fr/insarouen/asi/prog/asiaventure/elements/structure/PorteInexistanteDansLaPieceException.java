package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.structure.ElementStructurelException;

public class PorteInexistanteDansLaPieceException extends PieceException{
	public PorteInexistanteDansLaPieceException(){
		super();
	}
	public PorteInexistanteDansLaPieceException(String msg){
		super(msg);
	}
}