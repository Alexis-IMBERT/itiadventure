package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

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

	@Test
	public void test_constructeur() throws NomDEntiteDejaUtiliseDansLeMondeException {
		try{
			unObjet = new Objet("Objet1", MondeTest1){ public boolean estDeplacable(){return false;} };
			assertThat(unObjet.getNom(), IsEqual.equalTo("Objet1"));
			assertThat(unObjet.getMonde(), IsEqual.equalTo(MondeTest1));

		}catch(Exception e){};
	}

	
	@Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
	public void test_constructeur_avecException() throws NomDEntiteDejaUtiliseDansLeMondeException{
		unObjet = new Objet("Objet1", MondeTest1){ public boolean estDeplacable(){return false;} };
		Objet deuxiemeObjet = new Objet("Objet1", MondeTest1){ public boolean estDeplacable(){return false;} };
	}

}