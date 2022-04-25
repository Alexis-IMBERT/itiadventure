package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.util.HashMap;
import java.util.Map;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

/**
 * classe abstraite désignant un vivant
 * 
 * @author Alexis IMBERT et Mehdi Saissi Hassani
 */
public abstract class Vivant extends Entite {
    // Attributs
    /**
     * Attribut de type entier naturel désignant le nombre de point de vie du vivant
     */
    public int pointVie;

    /**
     * Attribut de type entier naturel désignant le nombre de point de force du
     * vivant
     */
    public int pointForce;

    /**
     * Attribut de type pièce désignant la pièce où se trouve le vivant
     */
    private Piece piece;

    /**
     * Attribut désignant les objets que porte le vivant
     */
    private Map<String, Objet> objets;

    // Constructeurs
    /**
     * Constructeur d'un vivant
     * 
     * @param nom        Chaine de caractère désignant le vivant
     * @param monde      Monde dans lequel évolue le vivant
     * @param pointVie   Entier naturel désignant le nombre de point de vie du
     *                   vivant
     * @param pointForce Entier naturel désignant le nombre de point de force du
     *                   vivant
     * @param piece      pièce dans laquelle se trouve le vivant
     * @param objets     liste d'objet que possède le vivant sur lui
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     */
    public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets)
            throws NomDEntiteDejaUtiliseDansLeMondeException {
        super(nom, monde);
        this.pointVie = pointVie;
        this.pointForce = pointForce;
        this.piece = piece;
        piece.entrer(this);
        this.objets = new HashMap<String, Objet>();
        int i;
        for (i = 0; i < objets.length; i++) {
            this.objets.put(objets[i].getNom(), objets[i]);
        }
    }

    // Methodes
    /**
     * Le vivant dépose un objet qu'il a en sa possesion (implique le retrait de
     * l'objet dans sa liste d'objet)
     * 
     * @param objet objet à déposer
     * @throws ObjetNonPossedeParLeVivantException l'objet n'est pas possédé par le
     *                                             vivant
     */
    public void deposer(Objet objet) throws ObjetNonPossedeParLeVivantException {
        deposer(objet.getNom());
    }

    /**
     * Dépose un objet en possesion du vivant grace à la chaine de caractère le
     * désignant (implique le retrait de l'objet dans la liste des objet possédé par
     * le vivant)
     * 
     * @param nomObj chaine de caratère désignant l'objet que l'on souhaite retirer
     * @throws ObjetNonPossedeParLeVivantException
     */
    public void deposer(String nomObj) throws ObjetNonPossedeParLeVivantException {
        if (!this.objets.containsKey(nomObj)) {
            throw new ObjetNonPossedeParLeVivantException();
        }
        Objet tmp = objets.get(nomObj);
        objets.remove(nomObj);
        this.getPiece().deposer(tmp);
    }

    /**
     * Franchissement de la porte en paramètre
     * 
     * @param porte porte à frnchir
     * @throws PorteFermeException                  exception si la porte est fermé
     * @throws PorteInexistanteDansLaPieceException exception si la porte n'est pas
     *                                              dans la pièce
     * @throws VivantAbsentDeLaPieceException
     */
    public void franchir(Porte porte)
            throws PorteFermeException, PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException {
        franchir(porte.getNom());
    }

    /**
     * Franchissement de la porte dont le nom est en paramètre
     * 
     * @param nomPorte
     * @throws PorteFermeException                  exception si la porte est fermé
     * @throws PorteInexistanteDansLaPieceException exception si la porte n'est pas
     *                                              dans la pièce
     * @throws VivantAbsentDeLaPieceException
     */
    public void franchir(String nomPorte)
            throws PorteFermeException, PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException {
        if (!this.getPiece().aLaPorte(nomPorte)) {
            throw new PorteInexistanteDansLaPieceException("La Porte n'existe pas.");
        }
        Etat etatPorte = this.getPiece().getPorte(nomPorte).getEtat();
        if (etatPorte.equals(Etat.FERME) || etatPorte.equals(Etat.VERROUILLE) || etatPorte.equals(Etat.CASSE)) {
            throw new PorteFermeException("La Porte est fermee, verrouille ou casse ");
        }
        Piece newPiece = this.getPiece().getPorte(nomPorte).getPieceAutreCote(this.getPiece());// on sotck la pièce dans
                                                                                                // laquelle on rentre
        newPiece.entrer(this.getPiece().sortirVivant(this));// on fait sortir le vivant de la pièce actuel pour le faire
                                                            // rentrer dans la nouvelle pièce
        this.piece = newPiece;// on change la pièce du vivant
    }

    /**
     * retourne la liste d'objet possédé par le vivant
     * 
     * @return la liste d'objet
     */
    public Map<String, Objet> getObjets() {
        return Map.copyOf(objets);
    }

    /**
     * Retourne l'objet possédé par le vivant grace à la chaine de caractère le
     * désignant
     * 
     * @param nomObjet chaine de caractère désignant l'objet
     * @return l'objet que l'on souhaite obtenir
     */
    public Objet getObjet(String nomObjet) {
        return this.objets.get(nomObjet);
    }

    /**
     * getter pour avoir le nom la pièce du vivant
     * 
     * @return la pièce dans laquelle se trouve le vivant
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * @return le nombre de point de force que possède le vivant
     */
    public int getPointForce() {
        return pointForce;
    }

    /**
     * @return le nombre de point de vie que possède le vivant
     */
    public int getPointVie() {
        return pointVie;
    }

    public void setPointsDeVie(int pointVie) {
        this.pointVie = pointVie;
    }

    /**
     * Vérifie la présence d'un objet sur le vivant
     * 
     * @param objet objet dont on souhaite vérifier la présence
     * @return boolean : true l'objet est présent false sinon
     */
    public boolean possede(Objet objet) {
        return possede(objet.getNom());
    }

    /**
     * Vérifie que le vivant possède un objet. Cet objet est désigné par son nom de
     * type chaine de caractère.
     * 
     * @param nomObjet chaine de caractère désignant le nom de l'objet
     * @return boolean : true l'objet est présent false sinon
     */
    public boolean possede(String nomObjet) {
        return this.objets.containsKey(nomObjet);
    }

    /**
     * Le vivant prend un objet de la pièce où il se trouve (ajoute l'objet dans la
     * liste des objets présent dans l'inventaire du vivant et donc le retire de la
     * liste des objet présent dans la pièce)
     * 
     * @param objet objet en question
     */
    public void prendre(Objet objet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
        prendre(objet.getNom());
    }

    /**
     * Prend l'objet l'objet présent dans la pièce et l'ajoute dans l'inventaire du
     * vivant
     * 
     * @param nomObj
     * @throws ObjetNonDeplacableException
     * @throws ObjetAbsentDeLaPieceException
     */
    public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
        Objet objet = this.getPiece().retirer(nomObj);
        this.objets.put(objet.getNom(), objet);
    }

    /**
     * vérifie si le vivant est mort, un vivant est mort si le nombre de point de
     * vie qu'il possède est inférieur à 0
     * 
     * @return true le vivant est mort false sinon
     */
    public boolean estMort() {
        return (this.getPointVie() <= 0);
    }

    /**
     * recode de la fonction toString
     */
    /* @Override
    public String toString() {
        return String.format("Vivant %s du monde %s a %d points de vie et %d points de Forces est dans la piece %s et a les objet %s",
                this.getNom(), this.getMonde().toString(), this.getPointVie(), this.getPointForce(), this.getPiece(),
                afficherObjet(this.objets));
    }

    private String afficherObjet(Map<String, Objet> objets){
        List<String> = 
        String resultat = "Objets : ";
        for(Objet objet : objets){
            resultat = String.format("%s,%s",resultat,objet.toString());
        }
        return resultat;
    }
     */
}
