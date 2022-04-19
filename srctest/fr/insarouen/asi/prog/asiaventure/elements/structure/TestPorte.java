package fr.insarouen.asi.prog.asiaventure.elements.structure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

public class TestPorte {
	public Monde monde;
	public Piece pieceA;
	public Piece pieceB;
	public Porte porte;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("MondeTest");
		pieceA = new Piece("PieceA", monde);
		pieceB = new Piece("PieceB", monde);
		porte = new Porte("PorteTest", monde, pieceA, pieceB);
	}

	@Test
	public void test_getEtatEtActiver() throws ActivationImpossibleException {
		assertThat(porte.getEtat().equals(Etat.OUVERT), is(true));
		assertThat(porte.getEtat(), is(Etat.OUVERT));
		porte.activer();
		assertThat(porte.getEtat(), is(Etat.FERME));
		porte.activer();
		assertThat(porte.getEtat(), is(Etat.OUVERT));
	}

	@Test
	public void test_getPieceAutreCote() {
		assertThat(porte.getPieceAutreCote(pieceA), is(pieceB));
		assertThat(porte.getPieceAutreCote(pieceB), is(pieceA));
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvecException1() throws ActivationImpossibleException {
		porte.setEtat(Etat.VERROUILLE);
		porte.activer();
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvecException2() throws ActivationImpossibleException {
		porte.setEtat(Etat.CASSE);
		porte.activer();
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvecException3() throws ActivationImpossibleException {
		porte.setEtat(Etat.DEVERROUILLE);
		porte.activer();
	}
}