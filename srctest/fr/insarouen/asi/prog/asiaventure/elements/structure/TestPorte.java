package fr.insarouen.asi.prog.asiaventure.elements.structure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;

public class TestPorte {
	public Monde monde;
	public Piece pieceA;
	public Piece pieceB;
	public Porte porteSansSerrurre;
	public Porte porteAvecSerrurre;
	public Serrure serrure;
	public Clef clef;
	public PiedDeBiche piedDeBiche;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("MondeTest");
		pieceA = new Piece("PieceA", monde);
		pieceB = new Piece("PieceB", monde);
		porteSansSerrurre = new Porte("porteSansSerrurre", monde, pieceA, pieceB);
		serrure = new Serrure(monde);
		porteAvecSerrurre = new Porte("porteAvecSerrure", monde, serrure, pieceA, pieceB);
		clef = serrure.creerClef();
		piedDeBiche = new PiedDeBiche("piedDeBiche", monde);
	}

	@Test
	public void test_constructeur() {
		assertThat(porteSansSerrurre.getNom(), IsEqual.equalTo("porteSansSerrurre"));
		assertThat(porteSansSerrurre.getMonde(), IsEqual.equalTo(monde));
		assertThat(porteAvecSerrurre.getNom(), IsEqual.equalTo("porteAvecSerrure"));
		assertThat(porteAvecSerrurre.getMonde(), IsEqual.equalTo(monde));
		assertThat(porteAvecSerrurre.getSerrure(), IsEqual.equalTo(serrure));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException1() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Porte("porteSansSerrurre", monde, pieceA, pieceB);
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException2() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Porte("porteAvecSerrure", monde, pieceA, pieceB);
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException3() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Porte("porteSansSerrurre", monde, serrure, pieceA, pieceB);
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException4() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Porte("porteAvecSerrure", monde, serrure, pieceA, pieceB);
	}

	@Test
	public void test_getEtatEtActiverEtActiverAvec()
			throws ActivationImpossibleException, NomDEntiteDejaUtiliseDansLeMondeException {
		assertThat(porteSansSerrurre.getEtat(), is(Etat.OUVERT));
		porteSansSerrurre.activer();
		assertThat(porteSansSerrurre.getEtat(), is(Etat.FERME));
		porteSansSerrurre.activer();
		assertThat(porteSansSerrurre.getEtat(), is(Etat.OUVERT));
		porteSansSerrurre.activer();
		assertThat(porteSansSerrurre.getEtat(), is(Etat.FERME));
		porteSansSerrurre.activerAvec(piedDeBiche);
		assertThat(porteSansSerrurre.getEtat(), is(Etat.CASSE));
		porteAvecSerrurre.activerAvec(clef);
		assertThat(porteAvecSerrurre.getEtat(), is(Etat.VERROUILLE));
		porteAvecSerrurre.activerAvec(clef);
		assertThat(porteAvecSerrurre.getEtat(), is(Etat.OUVERT));
		porteAvecSerrurre.activer();
		assertThat(porteAvecSerrurre.getEtat(), is(Etat.FERME));
		porteAvecSerrurre.activerAvec(clef);
		assertThat(porteAvecSerrurre.getEtat(), is(Etat.VERROUILLE));
		porteAvecSerrurre.activerAvec(piedDeBiche);
		assertThat(porteAvecSerrurre.getEtat(), is(Etat.CASSE));
	}

	@Test
	public void test_getPieceAutreCote() {
		assertThat(porteSansSerrurre.getPieceAutreCote(pieceA), is(pieceB));
		assertThat(porteSansSerrurre.getPieceAutreCote(pieceB), is(pieceA));
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvecException1() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.VERROUILLE);
		porteSansSerrurre.activer();
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvecException2() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.CASSE);
		porteSansSerrurre.activer();
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvecException3() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.DEVERROUILLE);
		porteSansSerrurre.activer();
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvec_AvecException1() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.DEVERROUILLE);
		porteSansSerrurre.activerAvec(clef);
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvec_AvecException2() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.CASSE);
		porteSansSerrurre.activerAvec(clef);
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvec_AvecException3() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.OUVERT);
		porteSansSerrurre.activerAvec(clef);
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvec_AvecException4() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.CASSE);
		porteSansSerrurre.activerAvec(clef);
	}

	@Test(expected = ActivationImpossibleException.class)
	public void TestActiverAvec_AvecException5() throws ActivationImpossibleException {
		porteSansSerrurre.setEtat(Etat.DEVERROUILLE);
		porteSansSerrurre.activerAvec(clef);
	}

	@Test(expected = ActivationImpossibleAvecObjetException.class)
	public void TestActiverAvec_AvecException6()
			throws ActivationImpossibleException, NomDEntiteDejaUtiliseDansLeMondeException {
		Objet objet = new Objet("objet", monde) {

		};
		porteSansSerrurre.activerAvec(objet);
	}

	@Test
	public void testActivableAvec() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Objet objet = new Objet("objet", monde) {

		};
		assertThat(porteAvecSerrurre.activableAvec(clef), Is.is(true));
		assertThat(porteSansSerrurre.activableAvec(clef), Is.is(false));
		assertThat(porteSansSerrurre.activableAvec(objet), Is.is(false));
		assertThat(porteSansSerrurre.activableAvec(piedDeBiche), Is.is(true));
	}

	@Test
	public void testgetSerrure() {
		assertThat(porteAvecSerrurre.getSerrure(), IsEqual.equalTo(serrure));
		assertThat(porteSansSerrurre.getSerrure(), IsNull.nullValue());
	}
}