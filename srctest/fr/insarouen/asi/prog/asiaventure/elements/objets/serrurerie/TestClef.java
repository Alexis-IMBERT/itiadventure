package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestClef {
	Monde monde;
	Clef clef;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("nomDuMonde");
		clef = new Clef("nom", monde);
	}

	@Test
	public void test_constructeur() {
		assertThat(clef.getNom(), IsEqual.equalTo("nom"));
		assertThat(clef.getMonde(), IsEqual.equalTo(monde));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Clef("nom", monde);
	}

	@Test
	public void test_estDeplacable() {
		assertThat(clef.estDeplacable(), IsEqual.equalTo(true));
	}
}
