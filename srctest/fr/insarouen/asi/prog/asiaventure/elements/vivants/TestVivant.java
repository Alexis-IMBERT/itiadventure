package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;

public class TestVivant {
	static Monde mondeTest;
	Vivant vivantTest;
	Piece pieceTest;
	Piece uneAutrePiece;
	PiedDeBiche objetTest1;
	PiedDeBiche objetTest2;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		mondeTest = new Monde("mondeTest");
		pieceTest = new Piece("pieceTest", mondeTest);
		objetTest1 = new PiedDeBiche("objetTest1", mondeTest);
		// objetTest1.setEstDeplacable(true);
		objetTest2 = new PiedDeBiche("objetTest2", mondeTest);
		vivantTest = new Vivant("vivantTest", mondeTest, 10, 10, pieceTest, objetTest1) {
		};
	}

	@Test
	public void getNomTest() {
		assertEquals(vivantTest.getNom(), "vivantTest");
		assertNotEquals(vivantTest.getNom(), "vivant");
	}

	@Test
	public void getPointForceTest() {
		assertEquals(vivantTest.getPointForce(), 10);
		assertNotEquals(vivantTest.getPointForce(), 5);
		vivantTest.pointForce = 5;
		assertEquals(vivantTest.getPointForce(), 5);
		assertNotEquals(vivantTest.getPointForce(), 10);
	}

	@Test
	public void getPointVieTest() {
		assertEquals(vivantTest.getPointVie(), 10);
		assertNotEquals(vivantTest.getPointVie(), 0);
	}

	@Test
	public void getMondeTest() {
		assertEquals(vivantTest.getMonde(), mondeTest);
	}

	@Test
	public void getPiece() {
		assertEquals(pieceTest, vivantTest.getPiece());
	}

	@Test
	public void estMortTest() {
		assertFalse(vivantTest.estMort());
		vivantTest.pointVie = 0;
		assertTrue(vivantTest.estMort());
	}

	@Test
	public void getObjetsTest() {
		Map<String, Objet> objetTheorique = new HashMap<String, Objet>();
		objetTheorique.put(objetTest1.getNom(), objetTest1);
		assertEquals(vivantTest.getObjets(), objetTheorique);
	}

	@Test
	public void getObjetTest() {
		assertEquals(objetTest1, vivantTest.getObjet("objetTest1"));
		assertNull(vivantTest.getObjet("objetTest2"));
	}

	@Test
	public void possedeTest()
			throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException, ObjetNonPossedeParLeVivantException {
		assertThat(vivantTest.possede(objetTest1), is(true));
		assertThat(vivantTest.possede("objetTest1"), is(true));
		assertThat(vivantTest.possede(objetTest2), is(false));
		assertThat(vivantTest.possede("objetTest2"), is(false));
	}

	@Test
	public void deposerObjetTest() {
		try {
			vivantTest.deposer(objetTest1);
		} catch (ObjetNonPossedeParLeVivantException e) {
			e.printStackTrace();
		}
		assertThat(vivantTest.possede(objetTest1), is(false));
		assertThat(vivantTest.possede("objetTest1"), is(false));
	}

	@Test
	public void deposerNomObjetTest() {
		try {
			vivantTest.deposer("objetTest1");
		} catch (Exception e) {
		}
		assertThat(vivantTest.possede(objetTest1), is(false));
		assertThat(vivantTest.possede("objetTest1"), is(false));
	}

	@Test(expected = ObjetNonPossedeParLeVivantException.class)
	public void testObjetAbsentPiece() throws ObjetNonPossedeParLeVivantException {
		vivantTest.deposer(objetTest2);
	}

	@Test
	public void prendreTest()
			throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException, ObjetNonPossedeParLeVivantException {
		vivantTest.deposer(objetTest1);
		vivantTest.prendre(objetTest1);
		assertThat(vivantTest.getObjet("objetTest1"), is(objetTest1));
	}

	@Test(expected = ObjetAbsentDeLaPieceException.class)
	public void prendreTestexception() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException,
			NomDEntiteDejaUtiliseDansLeMondeException {
		Objet objetTest3 = new Objet("objetTest3", mondeTest) {
		};
		vivantTest.getPiece().deposer(objetTest2);
		vivantTest.getPiece().deposer(objetTest3);
		vivantTest.prendre(objetTest1);
	}

	/*
	 * @Test
	 * public void test_franchir() throws PorteFermeException,
	 * PorteInexistanteDansLaPieceException,
	 * NomDEntiteDejaUtiliseDansLeMondeException, ActivationImpossibleException,
	 * VivantAbsentDeLaPieceException {
	 * Porte unePorte = new Porte("maPorte5", mondeTest, pieceTest, uneAutrePiece);
	 * unePorte.activer();
	 * 
	 * assertThat(vivantTest.getPiece(), IsEqual.equalTo(pieceTest));
	 * vivantTest.franchir(unePorte);
	 * assertThat(vivantTest.getPiece(), IsEqual.equalTo(uneAutrePiece));
	 * }
	 */
	/*
	 * @Test(expected = PorteFermeException.class)
	 * public void test_franchirAvecErreurPorteFermee() throws PorteFermeException,
	 * PorteInexistanteDansLaPieceException,
	 * NomDEntiteDejaUtiliseDansLeMondeException, VivantAbsentDeLaPieceException {
	 * Porte unePorte = new Porte("maPorte6", mondeTest, pieceTest, uneAutrePiece);
	 * vivantTest.franchir(unePorte);
	 * }
	 */
	@Test(expected = PorteInexistanteDansLaPieceException.class)
	public void test_franchirAvecErreurPorteInexistante()
			throws PorteFermeException, PorteInexistanteDansLaPieceException, NomDEntiteDejaUtiliseDansLeMondeException,
			VivantAbsentDeLaPieceException {
		Porte unePorte = new Porte("maPorte7", mondeTest, uneAutrePiece, uneAutrePiece);
		vivantTest.franchir(unePorte);
	}
}