package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/** */
public class TestClef {
	Monde monde;
	Clef clef;

	@BeforeClass
	public void avantClasse() {
		monde = new Monde("nomDuMonde");
	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		clef = new Clef("nom", monde);
	}

	@Test
	public void test_constructeur() {
		assertThat(clef.getNom(), IsEqual.equalTo("nom"));
		assertThat(clef.getNom(), IsEqual.equalTo(monde));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		Clef clef2 = new Clef("nom", monde);
	}

	@Test
	public void test_estDeplacable() {
		assertThat(clef.estDeplacable(), IsEqual.equalTo(true));
	}
}
