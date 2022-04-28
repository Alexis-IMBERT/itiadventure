package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNull;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;
import fr.insarouen.asi.prog.asiaventure.elements.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.VivantException;
import java.util.Map;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestJoueurHumain {/* 
    static Monde mondeTest;
    JoueurHumain Joueur1;
    public Piece pieceATest;
    public Piece pieceBTest;
    public Porte porteTest;
	PiedDeBiche couteau;
    public Map<String, Objet> objetsPieceA;
    public Map<String, Objet> objetsDuJoueurHumain;

    String ordre = "Prendre couteau";
    
    @Before
    public void avantTest() throws Exception {
        mondeTest = new Monde("NomMondeTest");
        pieceATest = new Piece("NomPieceATest", mondeTest);
        pieceBTest = new Piece("NomPieceBTest", mondeTest);
        porteTest = new Porte("NomPorteTest", mondeTest, pieceATest, pieceBTest);
        objetsDuJoueurHumain = new HashMap();
        for (int i = 0; i< 9; i++){
            objetsDuJoueurHumain.put(String.format("NomObjetJoueur1 %s", i), new PiedDeBiche(String.format("NomObjetJoueur1 %s", i), mondeTest) {});
        }
        objetsPieceA = new HashMap();
        for (int i = 0; i< 9; i++){
            objetsPieceA.put(String.format("NomObjetPieceATest %s", i), new PiedDeBiche(String.format("NomObjetPieceATest %s", i), mondeTest) {});
        }
        for (Objet obj : objetsPieceA.values()) {
            pieceATest.deposer(obj);
        }
        joueur1 = new JoueurHumain("Joueur1Nom", mondeTest, 10, 10, pieceATest, objetsDuJoueurHumain);

    }

    @Test
    public void test_executer() throws CommandeImpossiblePourLeVivantException, Throwable{
        JoueurHumain.setOrdre(ordre);
        assertThat(JoueurHumain.getObjets(), IsEqual.equalTo(null));
        JoueurHumain.executer();
        assertThat(JoueurHumain.getObjet('couteau'), IsEqual.equalTo(couteau));
    }

    @Test 
    public void test_setOrdre() throws Exception {

    }

    @Test
    public void Test_commandePrendre(String nomObjet) throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
        joueur1.commandePrendre("NomObjetPieceATest 2");
        assertThat(joueur1.possede(joueur1.getObjet("NomObjetPieceATest 2")),IsEqual.equalTo(true));
    }

    @Test(expected = ObjetAbsentDeLaPieceException.class)
    public void test_commandePrendreObjetsAbsentDeLaPieceException() throws Exception {
        joueur1.commandePrendre("NomObjetJoueurHumain 3");
    }


    @Test(expected = ObjetNonDeplacableException.class)
    public void test_commandePrendreoBJETnONdEPLACABLEeXCEPTION() throws Exception {
        Objet objetNonDeplacable = new Objet("ObjetNonDeplacableNom", mondeTest) {};
        pieceATest.deposer(objetNonDeplacable);
        joueur1.commandePrendre("ObjetNonDeplacableNom");
    }

    @Test
    public void Test_commandePoser(String nomObjet) throws ObjetNonPossedeParLeVivantException{
        joueur1.commandePoser("NomObjetJoueur1 2");
        assertThat(pieceATest.contientObjet("NomObjetJoueur1 2"),IsEqual.equalTo(true));
    }

    @Test(expected=ObjetNonPossedeParLeVivantException.class)
    public void tests_objetNonPosseseParLeVivantException() throws Exception {
        Objet objetNonPossedeParLeVivant = new Objet("objetNonPossedeParLeVivant", mondeTest) {};
        joueur1.commandePoser("objetNonPossedeParLeVivant");
    }

    @Test
    public void test_commandeFranchir() throws Exception {
        porteTest.activer();
        joueur1.commandeFranchir("NomPorteTest");
        assertThat(joueur1.getPiece(),IsEqual.equalTo(pieceBTest));
    }

/*  @Test (expected = PorteFermeException.class)
    public void test_porteFermeException() throws Exception {
        joueur1.commandeFranchir("NomPorteTest");
    }

    @Test (expected = PorteInexistanteDansLaPieceException.class)
    public void test_porteInexistanteDansLaPieceException() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Porte portePieceBC = new Porte("NomPorteBC", mondeTest, pieceBTest, PieceCTest);
        portePieceBC.activer();
        joueur1.commandeFranchir("NomPorteBC");

    }
    @Test 
    public void test_commandeOuvrirPorte() throws Exception {
        joueur1.commandeOuvrirPorte("NomPorteTest");
        assertThat(porteTest.getEtat(),IsEqual.equalTo(Etat.OUVERT));
    }
    @Test (expected = PorteInexistanteDansLaPieceException.class)
    public void test_porteInexistanteDansLaPieceExceptionOuvrirPorte() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Porte portePieceBC = new Porte("NomPorteBC", mondeTest, pieceBTest, PieceCTest);
        joueur1.commandeOuvrirPorte("NomPorteBC");
    }
/*
    @Test (expected = ActivationImpossibleAvecObjetException.class)
    public void test_activationException() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Porte porteCassee = new Porte("NomPorteFermee", mondeTest, pieceATest, PieceCTest);
        porteCassee.setEtat(Etat.CASSE);
        joueur1.commandeOuvrirPorte("NomPorteFermee");
    }

    @Test 
    public void test_commandeOuvrirPorteAvecObjet() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Serrure serrureTest = new Serrure("NomSerrureTest", mondeTest);
        Clef clefTest = serrureTest.creerClef();
        pieceATest.deposer(clefTest);
        joueur1.prendre(clefTest);
        Porte porteAC = new Porte("NomPorteAC", serrureTest, mondeTest, pieceATest, PieceCTest);
        joueur1.commandeOuvrirPorte("NomPorteAC", clefTest.getNom());
        assertThat(porteAC.getEtat(),IsEqual.equalTo(Etat.OUVERT));
    }
    @Test (expected = ObjetNonPossedeParLeVivantException.class)
    public void test_ObjetNonPossedeParLeVivantcommandeOuvrirPorteAvecObjet() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Serrure serrureTest = new Serrure("NomSerrureTest", mondeTest);
        Clef clefTest = serrureTest.creerClef();
        pieceATest.deposer(clefTest);
        Porte porteAC = new Porte("NomPorteAC", serrureTest, mondeTest, pieceATest, PieceCTest);
        joueur1.commandeOuvrirPorte("NomPorteAC", clefTest.getNom());
    }

    @Test (expected = PorteInexistanteDansLaPieceException.class)
    public void test_PorteInexistanteDansLaPieceExceptioncommandeOuvrirPorteAvecObjet() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Serrure serrureTest = new Serrure("NomSerrureTest", mondeTest);
        Clef clefTest = serrureTest.creerClef();
        pieceATest.deposer(clefTest);
        joueur1.prendre(clefTest);
        Porte portePieceBC = new Porte("NomPorteBC", serrureTest, mondeTest, pieceBTest, PieceCTest);
        joueur1.commandeOuvrirPorte("NomPorteBC", clefTest.getNom());
    }

    @Test (expected = ActivationImpossibleAvecObjetException.class)
    public void test_ActivationExceptioncommandeOuvrirPorteAvecObjet() throws Exception {
        Piece PieceCTest = new Piece("NomPieceCTest", mondeTest);
        Serrure serrureTest = new Serrure("NomSerrureTest", mondeTest);
        Clef clefTest = serrureTest.creerClef();
        Porte porteAC = new Porte("NomPorteAC", serrureTest, mondeTest, pieceATest, PieceCTest);
        pieceATest.deposer(clefTest);
        joueur1.prendre(clefTest);
        porteAC.setEtat(Etat.CASSE);
        joueur1.commandeOuvrirPorte("NomPorteAC", clefTest.getNom());
    }
     */
}