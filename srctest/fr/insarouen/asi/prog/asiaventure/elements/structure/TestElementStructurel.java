package fr.insarouen.asi.prog.asiaventure.elements.structure;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestElementStructurel {
	Monde monde;
	ElementStructurel elementStructurel;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		monde = new Monde("nomDuMonde");
		elementStructurel = new ElementStructurel("nom", monde) {
		};
	}

	@Test
	public void test_constructeur() {
		assertThat(elementStructurel.getNom(), IsEqual.equalTo("nom"));
		assertThat(elementStructurel.getMonde(), IsEqual.equalTo(monde));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new ElementStructurel("nom", monde) {
		};
	}

}
