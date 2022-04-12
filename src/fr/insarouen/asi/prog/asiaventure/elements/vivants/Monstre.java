package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class Monstre extends Vivant{
	//Attributs
    //Constructeur
    public Monstre(Monde monde, int pointVie, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException{
		super("Laurent",monde,pointVie,100,piece,new Objet[0]);
    }
    //Methodes
    public void executer() throws ObjetNonPossedeParLeVivantException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException, PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException, PorteFermeException{
        while(!this.estMort()){
            //echanger les objets du vivant avec les objets de la piece
            echangerObjetDansPiece();
            //choisir une porte au hasard dans la pièce et la franchir (même si fermé donc try catch)
            franchir();
            //quand on franchit une porte on perd un point de vie 
            this.setPointsDeVie(this.getPointVie()-1);
        }
    }
    private void echangerObjetDansPiece() throws ObjetNonPossedeParLeVivantException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
        List<Objet> objetDeplaceable = this.getPiece().getObjets().values().stream()
                                    .filter(Objet::estDeplacable).collect(Collectors.toList());
        List<Objet> ObjetsDuMonstre = (List<Objet>)this.getObjets().values();
        for(Iterator<Objet> i = ObjetsDuMonstre.iterator();i.hasNext();){
            this.deposer((Objet)i.next());
        }
        for(Iterator<Objet> i=objetDeplaceable.iterator();i.hasNext();){
            this.prendre((Objet)i.next());
        }
    }
    private void franchir() throws PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException, PorteFermeException{
        Piece piece = this.getPiece();
        List<Porte> portes = new ArrayList<Porte>();
        portes.addAll(piece.getPortes().values());
        int taille = portes.size();
        int numeroPorte  = (int)(Math.random()*taille);
        this.franchir(portes.get(numeroPorte));
    }
}