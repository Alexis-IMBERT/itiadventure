package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestObjets {
	public Monde MondeTest1;
	public Objet unObjet;
	public Objet deuxiemeObjet;

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException {
		MondeTest1 = new Monde("MondeTest1");
		unObjet = new Objet("Objet1", MondeTest1) {
			public boolean estDeplacable() {
				return false;
			}
		};
	}

	@Test
	public void test_constructeur() throws NomDEntiteDejaUtiliseDansLeMondeException {
		assertThat(unObjet.getNom(), IsEqual.equalTo("Objet1"));
		assertThat(unObjet.getMonde(), IsEqual.equalTo(MondeTest1));
	}

	@Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException {
		new Objet("Objet1", MondeTest1) {
		};
	}

	@Test
	public void test_estDeplacable() {
		assertThat(unObjet.estDeplacable(), IsEqual.equalTo(false));
	}

}