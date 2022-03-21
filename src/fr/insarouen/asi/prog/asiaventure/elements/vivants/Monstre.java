package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;

import java.util.Map;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class Monstre extends Vivant{
	//Attributs
    //Constructeur
    public Monstre(Monde monde, int pointVie, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super("Laurent",monde,pointVie,100,piece,new Objet[0]);
    }
    //Methodes
    public void executer(){
        Piece piece = this.getPiece();
        Map<String,Objet> objets = piece.getObjets();
        Map<String,Porte> portes = piece.getPortes();
        while(!this.estMort()){
            //echanger les objets du vivant avec les objets de la piece
            //choisir une porte au hasard dans la pièce et la franchir (même si fermé donc try catch)
            //quand on franchit une porte on perd un point de vie 
        }
    }    
}