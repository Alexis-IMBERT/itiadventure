package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.core.IsEqual;

public class TestObjets {
	public static Monde MondeTest1;
	public Objet unObjet;
    public Objet deuxiemeObjet;

	@BeforeClass
	public static void avantClasse(){
		MondeTest1 = new Monde("MondeTest1");
    }

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		unObjet = new Objet("Objet1", MondeTest1){ 
			public boolean estDeplacable(){
				return false;
			} 
		};
	}

	@Test
	public void test_constructeur() throws NomDEntiteDejaUtiliseDansLeMondeException {
		assertThat(unObjet.getNom(), IsEqual.equalTo("Objet1"));
		assertThat(unObjet.getMonde(), IsEqual.equalTo(MondeTest1));
	}

	@Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException{
		Objet deuxiemeObjet = new Objet("Objet1", MondeTest1){ 
			public boolean estDeplacable(){
				return false;
			} 
		};
	}

}