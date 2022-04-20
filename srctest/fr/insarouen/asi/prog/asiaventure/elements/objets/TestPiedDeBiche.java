package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestPiedDeBiche {
	Monde monde;
	PiedDeBiche piedDeBicheTest;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("monde");
		piedDeBicheTest = new PiedDeBiche("piedDeBicheTest", monde);
	}

	@Test
	public void test_Constructeur() {
		assertThat(piedDeBicheTest, IsEqual.equalTo(piedDeBicheTest));
	}
	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException{
		new PiedDeBiche("piedDeBicheTest", monde);
	}

	@Test
	public void test_estDeplacable() {
		assertThat(piedDeBicheTest.estDeplacable(), is(true));
	}
}
