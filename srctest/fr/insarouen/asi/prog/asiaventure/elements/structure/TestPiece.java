package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;

import org.junit.Test;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestPiece {

	public static Monde m1;
	public static Piece unePiece;
	public static Vivant v1;

	@BeforeClass
	public static void chargement() throws NomDEntiteDejaUtiliseDansLeMondeException {
		m1 = new Monde("m1");
		String nom = new String("Mehdi");
		int pv = 1;
		int pf = 4;

		Objet[] objs = new Objet[2];
		objs[0] = new PiedDeBiche("pdb1", m1);
		objs[1] = new PiedDeBiche("pdb2", m1);

		unePiece = new Piece("p1", m1);
		v1 = new Vivant(nom, m1, pv, pf, unePiece, objs) {
		};

	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Piece pieceTest = new Piece("Piecetest", m1);
		Piece pieceB = new Piece("PieceB", m1);
		Porte porteTest = new Porte("PorteTest", m1, pieceTest, pieceB);
	}

	@Test
	public void test_constructeur() {
		assertThat(unePiece.getNom(), IsEqual.equalTo("p1"));
		assertThat(unePiece.getMonde(), IsEqual.equalTo(m1));
	}

	/*
	 * @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
	 * public void test_constructeur_avecException() throws
	 * NomDEntiteDejaUtiliseDansLeMondeException{
	 * Piece deuPiece = new Piece("p1", m1){};
	 * }
	 */
	@Test
	public void test_contientObjet() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetAbsentDeLaPieceException,
			ObjetNonDeplacableException {
		PiedDeBiche unPiedDeBiche = new PiedDeBiche("PiedDeBiche1", m1);
		assertThat(unePiece.contientObjet(unPiedDeBiche), is(false));

		unePiece.deposer(unPiedDeBiche);
		assertThat(unePiece.contientObjet(unPiedDeBiche), is(true));

		unePiece.retirer(unPiedDeBiche);
		assertThat(unePiece.contientObjet(unPiedDeBiche), is(false));

	}

	@Test(expected = ObjetAbsentDeLaPieceException.class)
	public void test_contientObjet_avecExceptionAbsentPiece() throws NomDEntiteDejaUtiliseDansLeMondeException,
			ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		PiedDeBiche unPiedDeBiche = new PiedDeBiche("PiedDeBiche2", m1);
		unePiece.retirer(unPiedDeBiche);
	}

	@Test(expected = ObjetNonDeplacableException.class)
	public void test_contientObjet_avecExceptionNonDeplacable() throws NomDEntiteDejaUtiliseDansLeMondeException,
			ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		Objet unObjet = new Objet("obj1", m1) {
			public boolean estDeplacable() {
				return false;
			}
		};
		assertThat(unePiece.contientObjet(unObjet), is(false));
		unePiece.deposer(unObjet);
		assertThat(unePiece.contientObjet(unObjet), is(true));
		unePiece.retirer(unObjet);
	}

	@Test
	public void test_contientVivant() throws VivantAbsentDeLaPieceException {
		assertThat(unePiece.contientVivant(v1), is(true));

		unePiece.sortirVivant(v1);
		assertThat(unePiece.contientVivant(v1), is(false));

		unePiece.entrer(v1);
		assertThat(unePiece.contientVivant(v1), is(true));

	}

	@Test(expected = VivantAbsentDeLaPieceException.class)
	public void test_contientVivant_exceptionVivantabsent() throws VivantAbsentDeLaPieceException {
		unePiece.sortirVivant(v1);
		unePiece.sortirVivant(v1);
	}

/*
	@Test
	public void test_aLaPorte() {
	MatcherAssert.assertThat(pieceTest.aLaPorte(porteTest), Is.is(true));
	MatcherAssert.assertThat(pieceTest.aLaPorte("NomPorteTest"), Is.is(true));
	}
*/
/*	
	@Test
	public void test_getPorte() {
	MatcherAssert.assertThat(pieceTest.getPorte("NomPorteTest"),
	IsEqual.equalTo(porteTest));
	}
*/
/*
	@Test
	public void test_addPorte() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Piece uneAutrePiece = new Piece("p2", m1);
		Porte unePorte = new Porte("maPorte", m1, uneAutrePiece, uneAutrePiece);
		assertThat(unePiece.aLaPorte(unePorte), is(false));
		Porte uneAutrePorte = new Porte("maPorte2", m1, unePiece, uneAutrePiece); // le constructeur de porte ajoute à
																					// la piece
		assertThat(unePiece.aLaPorte(uneAutrePorte), is(true));
	}
*/
/*
	@Test
		public void test_getPorte() throws NomDEntiteDejaUtiliseDansLeMondeException{
		Piece uneAutrePiece = new Piece("p3", m1);
		Porte unePorte = new Porte ("maPorte3", m1, unePiece, uneAutrePiece);
		assertThat(unePiece.getPorte("maPorte3"), IsEqual.equalTo(unePorte));
	}
	*/
}