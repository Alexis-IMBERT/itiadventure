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
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe Définissant un Monstre héritant de Vivant
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 * 
 */
public class Monstre extends Vivant {
    // Constructeur
    /**
     * Constructeur du monstre
     * 
     * @param monde    Monde dans lequel vie le monstre
     * @param pointVie le nombre de point de vie du monstre
     * @param piece    la pièce initiale du monstre
     * @throws NomDEntiteDejaUtiliseDansLeMondeException exception si le nom est
     *                                                   déjà présent dans le monde
     */
    public Monstre(Monde monde, int pointVie, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException {
        super("Laurent", monde, pointVie, 100, piece, new Objet[0]);
    }

    // Methodes
    /**
     * méthode indiquant les actions du monstre
     * 
     * @see echangerObjetDansPiece
     * @see franchir
     * @throws ObjetNonPossedeParLeVivantException  exception si le monstre ne
     *                                              possède pas l'objet
     * @throws ObjetAbsentDeLaPieceException        si l'objet est absent de la
     *                                              pièce
     * @throws ObjetNonDeplacableException          si on essaye de prendre un objet
     *                                              non deplacable
     * @throws PorteInexistanteDansLaPieceException si la porte n'est pas présent
     *                                              dans la pièce actuel du monstre
     * @throws VivantAbsentDeLaPieceException       si le vivant n'est pas dans la
     *                                              pièce
     * @throws PorteFermeException                  si la porte est fermé
     */
    public void executer()
            throws ObjetNonPossedeParLeVivantException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException,
            PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException, PorteFermeException {
        while (!this.estMort()) {
            echangerObjetDansPiece();
            franchir();
        }
    }

    /**
     * lorsque un monstre entre dans une pièce il échange les objet qu'il a sur lui
     * avec ceux de la pièce
     * 
     * @throws ObjetNonPossedeParLeVivantException
     * @throws ObjetAbsentDeLaPieceException
     * @throws ObjetNonDeplacableException
     */
    private void echangerObjetDansPiece()
            throws ObjetNonPossedeParLeVivantException, ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
        List<Objet> objetDeplaceable = this.getPiece().getObjets().values().stream()
                .filter(Objet::estDeplacable).collect(Collectors.toList());
        List<Objet> ObjetsDuMonstre = (List<Objet>) this.getObjets().values();
        for (Iterator<Objet> i = ObjetsDuMonstre.iterator(); i.hasNext();) {
            this.deposer(i.next());
        }
        for (Iterator<Objet> i = objetDeplaceable.iterator(); i.hasNext();) {
            this.prendre(i.next());
        }
    }

    /**
     * le monstre change de pièce dès qu'il a fini son action, que la porte soit
     * fermé ou pas
     * 
     * @throws PorteInexistanteDansLaPieceException
     * @throws VivantAbsentDeLaPieceException
     * @throws PorteFermeException
     */
    private void franchir()
            throws PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException, PorteFermeException {
        List<Porte> portes = new ArrayList<Porte>();
        Piece piece = this.getPiece();
        portes.addAll(piece.getPortes().values());
        int taille = portes.size();
        int numeroPorte = (int) (Math.random() * taille);
        Porte porteChoisi = portes.get(numeroPorte);
        porteChoisi.getPieceAutreCote(piece).entrer(piece.sortirVivant(this));

        this.setPointsDeVie(this.getPointVie() - 1);
    }

    @Override
    public String toString() {
        return String.format("%s est un Monstre", super.toString());
    }
}