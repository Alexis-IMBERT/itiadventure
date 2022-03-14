package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

import org.junit.Test;
import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestPorte{
	public static Monde monde;
	public static Piece pieceA;
	public static Piece pieceB;
	public Porte porte;

	@BeforeClass
	public static void avantClasse() throws NomDEntiteDejaUtiliseDansLeMondeException{
		monde = new Monde("MondeTest");
		pieceA = new Piece("PieceA",monde);
		pieceB = new Piece("PieceB",monde);
	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		porte = new Porte("PorteTest",monde,pieceA,pieceB);
	}

	@Test
	public void test_getEtatEtActiver() throws ActivationImpossibleException{
		assertThat(porte.getEtat().equals(Etat.OUVERT),is(true));
		assertThat(porte.getEtat(), is(Etat.OUVERT));
		porte.activer();
		assertThat(porte.getEtat(), is(Etat.FERME));
		porte.activer();
		assertThat(porte.getEtat(), is(Etat.OUVERT));
	}

	@Test
	public void test_getPieceAutreCote(){
		assertThat(porte.getPieceAutreCote(pieceA),is(pieceB));
		assertThat(porte.getPieceAutreCote(pieceB),is(pieceA));
	}

	/*
	@Test(expected = ActivationImpossibleException)
	public void TestActiverAvecException1(){
		
	}
	*/
}