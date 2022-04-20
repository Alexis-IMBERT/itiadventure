package fr.insarouen.asi.prog.asiaventure.elements.structure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;

public class TestPiece {

	public Monde monde;
	public Piece Piece1;
	public Piece Piece2;
	public Piece Piece3;
	public Vivant vivant;
	public Porte porteTest;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("monde");
		String nom = new String("Mehdi");
		int pv = 1;
		int pf = 4;

		Objet[] objs = new Objet[2];
		objs[0] = new PiedDeBiche("pdb1", monde);
		objs[1] = new PiedDeBiche("pdb2", monde);

		Piece1 = new Piece("p1", monde);
		vivant = new Vivant(nom, monde, pv, pf, Piece1, objs) {};
		Piece2 = new Piece("Piece2", monde);
		Piece3 = new Piece("Piece3", monde);
		porteTest = new Porte("PorteTest", monde, Piece2, Piece3);
	}

	@Test
	public void test_constructeur() {
		assertThat(Piece1.getNom(), IsEqual.equalTo("p1"));
		assertThat(Piece1.getMonde(), IsEqual.equalTo(monde));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Piece("p1", monde) {};
	}

	@Test
	public void test_contientObjet() throws NomDEntiteDejaUtiliseDansLeMondeException, ObjetAbsentDeLaPieceException,
			ObjetNonDeplacableException {
		PiedDeBiche unPiedDeBiche = new PiedDeBiche("PiedDeBiche1", monde);
		assertThat(Piece1.contientObjet(unPiedDeBiche), is(false));

		Piece1.deposer(unPiedDeBiche);
		assertThat(Piece1.contientObjet(unPiedDeBiche), is(true));

		Piece1.retirer(unPiedDeBiche);
		assertThat(Piece1.contientObjet(unPiedDeBiche), is(false));

	}

	@Test(expected = ObjetAbsentDeLaPieceException.class)
	public void test_retirerObjet_avecExceptionAbsentPiece() throws NomDEntiteDejaUtiliseDansLeMondeException,
			ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		PiedDeBiche unPiedDeBiche = new PiedDeBiche("PiedDeBiche2", monde);
		Piece1.retirer(unPiedDeBiche);
	}

	@Test(expected = ObjetNonDeplacableException.class)
	public void test_contientObjet_avecExceptionNonDeplacable() throws NomDEntiteDejaUtiliseDansLeMondeException,
			ObjetAbsentDeLaPieceException, ObjetNonDeplacableException {
		Objet unObjet = new Objet("obj1", monde) {
			public boolean estDeplacable() {
				return false;
			}
		};
		assertThat(Piece1.contientObjet(unObjet), is(false));
		Piece1.deposer(unObjet);
		assertThat(Piece1.contientObjet(unObjet), is(true));
		Piece1.retirer(unObjet);
	}

	@Test
	public void test_contientVivant() throws VivantAbsentDeLaPieceException {
		assertThat(Piece1.contientVivant(vivant), is(true));
		assertThat(Piece1.contientVivant(vivant.getNom()), is(true));

		Piece1.sortirVivant(vivant);
		assertThat(Piece1.contientVivant(vivant), is(false));

		Piece1.entrer(vivant);
		assertThat(Piece1.contientVivant(vivant), is(true));

		Piece1.sortirVivant(vivant.getNom());
		assertThat(Piece1.contientVivant(vivant), is(false));

		Piece1.entrer(vivant);
		assertThat(Piece1.contientVivant(vivant), is(true));
	}

	@Test(expected = VivantAbsentDeLaPieceException.class)
	public void test_contientVivant_exceptionVivantabsent() throws VivantAbsentDeLaPieceException {
		Piece1.sortirVivant(vivant);
		Piece1.sortirVivant(vivant);
	}

	@Test
	public void test_aLaPorte() {
		assertThat(this.Piece2.aLaPorte(this.porteTest), Is.is(true));
		assertThat(this.Piece3.aLaPorte(this.porteTest), Is.is(true));
		assertThat(this.Piece2.aLaPorte("PorteTest"), Is.is(true));
		assertThat(this.Piece3.aLaPorte("PorteTest"), Is.is(true));
	}

	@Test
	public void test_getPorte() {
		assertThat(this.Piece2.getPorte("PorteTest"), IsEqual.equalTo(porteTest));
		assertThat(this.Piece3.getPorte("PorteTest"), IsEqual.equalTo(porteTest));
	}

	@Test
	public void test_addPorte() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Piece uneAutrePiece = new Piece("p2", monde);
		Porte unePorte = new Porte("maPorte", monde, uneAutrePiece, uneAutrePiece);
		assertThat(Piece1.aLaPorte(unePorte), is(false));
		Porte uneAutrePorte = new Porte("maPorte2", monde, Piece1, uneAutrePiece); // le constructeur de porte ajoute à
		// la piece
		assertThat(Piece1.aLaPorte(uneAutrePorte), is(true));
	}
}