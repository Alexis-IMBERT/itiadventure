package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;

import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
/** */
public class JoueurHumain extends Vivant implements Executable{
    //Attributs
    private String ordre;
    //Constructeur
    public JoueurHumain(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet... objets)
            throws NomDEntiteDejaUtiliseDansLeMondeException {
        super(nom, monde, pointVie, pointForce, piece, objets);
    }
    //Methodes
    public void setOrdre(String ordre){
        this.ordre=ordre;
    }
    void commandePrendre(java.lang.String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
        this.prendre(nomObjet);
    }
    void commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException{
        this.deposer(nomObjet);
    }
    void commandeFranchir(String nomPorte) throws PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException, PorteFermeException{
        this.franchir(nomPorte);
    }
    void commandeOuvrirPorte(String nomPorte,String nomObjet) throws ObjetNonPossedeParLeVivantException, PorteInexistanteDansLaPieceException, VivantAbsentDeLaPieceException, PorteFermeException, ActivationImpossibleAvecObjetException, ActivationImpossibleException{
        Objet objet = this.getObjet(nomObjet);
        if(objet==null){
            throw new ObjetNonPossedeParLeVivantException(String.format("Le vivant %s ne possède pas cet objet : %s",this.getNom(),nomObjet));
        }
        Porte porte = this.getPiece().getPorte(nomPorte);
        if (porte == null){
            throw new PorteInexistanteDansLaPieceException(String.format("La porte %s n'existe pas dans la pièce %s", nomPorte,this.getPiece().getNom()));
        }
        porte.activerAvec(objet);
    }
    void commandeOuvrirPorte(String nomPorte) throws ActivationException, PorteInexistanteDansLaPieceException{
        Porte porte = this.getPiece().getPorte(nomPorte);
        if(porte==null){
            throw new PorteInexistanteDansLaPieceException(String.format("La porte %s n'existe pas dans la piece %s",nomPorte,this.getNom()));
        }
        porte.activer();
    }

    @Override
    public void executer() throws CommandeImpossiblePourLeVivantException, Throwable{
        String[] splitOrdre = this.ordre.split(" ");
        int nombreElem = splitOrdre.length - 1;
        Class[] typeParametre = new Class[nombreElem];
        Arrays.fill(typeParametre,String.class);
        String[] parametreEffectif = Arrays.copyOfRange(splitOrdre,1,nombreElem);
        Method method;
        // try{
            method = this.getClass().getDeclaredMethod("commande"+splitOrdre[0],typeParametre);
        // }
        // catch(java.lang.NoSuchMethodException e){
        //     throw new CommandeImpossiblePourLeVivantException("Introspection n'a pas trouver la méthode");
        // }

        try{
            method.invoke(this,(Object[])parametreEffectif);
        }
        catch(InvocationTargetException e){
            throw e.getTargetException();
        }
        catch(Exception e){
        }
    }
    public String getOrdre() {
        return ordre;
    }
}
