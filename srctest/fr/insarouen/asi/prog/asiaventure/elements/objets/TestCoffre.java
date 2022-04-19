package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;

public class TestCoffre {
	static Monde monde;
	Coffre coffre;

	@BeforeClass
	public static void avantClasse() {
		monde = new Monde("nomDuMonde");
	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		coffre = new Coffre("nom", monde);
	}

	@Test
	public void test_constructeur() {
		assertThat(coffre.getNom(), IsEqual.equalTo("nom"));
		assertThat(coffre.getMonde(), IsEqual.equalTo(monde));
	}
/*
	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Coffre coffre2 = new Coffre("nom", monde);
	}
*/
	@Test
	public void test_estDeplacable() {
		assertThat(coffre.estDeplacable(), IsEqual.equalTo(false));
	}

	@Test
	public void test_activer() throws ActivationException {
		assertThat(coffre.getEtat(), IsEqual.equalTo(Etat.FERME));
		coffre.activer();
		assertThat(coffre.getEtat(), IsEqual.equalTo(Etat.OUVERT));
		coffre.activer();
		assertThat(coffre.getEtat(), IsEqual.equalTo(Etat.FERME));
	}

	@Test(expected = ActivationException.class)
	public void test_activer_avec() throws ActivationException {
		coffre.activerAvec(coffre);
	}
}
