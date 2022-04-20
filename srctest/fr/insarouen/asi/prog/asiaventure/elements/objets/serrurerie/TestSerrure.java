package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

public class TestSerrure {
	Monde monde = null;
	Serrure serrure = null;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("mondeTest");
		serrure = new Serrure("nom", monde);
	}

	@Test
	public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException {
		assertThat(serrure.getNom(), IsEqual.equalTo("nom"));
		assertThat(serrure.getMonde(), IsEqual.equalTo(monde));
		Serrure serrure2 = new Serrure(monde);
		assertThat(serrure2.getMonde(), IsEqual.equalTo(monde));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Serrure("nom", monde);
	}

	@Test
	public void test_activableAvec() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Clef clef = serrure.creerClef();
		assertThat(serrure.activableAvec(clef), IsEqual.equalTo(true));
		assertThat(serrure.activableAvec(serrure), IsEqual.equalTo(false));
	}

	@Test(expected = ActivationException.class)
	public void test_activer() throws ActivationException {
		this.serrure.activer();
	}

	@Test
	public void test_activerAvec()
			throws NomDEntiteDejaUtiliseDansLeMondeException, ActivationImpossibleAvecObjetException {
		Clef clef = serrure.creerClef();
		assertThat(serrure.getEtat(), IsEqual.equalTo(Etat.VERROUILLE));
		serrure.activerAvec(clef);
		assertThat(serrure.getEtat(), IsEqual.equalTo(Etat.DEVERROUILLE));
		serrure.activerAvec(clef);
		assertThat(serrure.getEtat(), IsEqual.equalTo(Etat.VERROUILLE));
	}

	@Test
	public void test_creerClef() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Clef clef = serrure.creerClef();
		assertThat(clef.getNom(), IsEqual.equalTo("nomcle"));
		assertThat(clef.getMonde(), IsEqual.equalTo(monde));
		Clef clef2 = serrure.creerClef();
		assertThat(clef2, IsEqual.equalTo(null));
	}

	@Test
	public void test_estDeplacable() {
		assertThat(serrure.estDeplacable(), IsEqual.equalTo(false));
	}

	@Test
	public void test_getEtat() {
		assertThat(serrure.getEtat(), IsEqual.equalTo(Etat.VERROUILLE));
	}
}
