package fr.insarouen.asi.prog.asiaventure;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

public class TestMonde{
	static Monde mondeTest;

	@Before
	public void avantTest(){
		mondeTest = new Monde("MondeTest");
	}

	@Test
	public void testGetNom(){
		try{
			assertEquals(mondeTest.getNom(),"MondeTest");
		}catch(Exception e){};
	}
  @Test
  public void TestGetEntite(){
    try{
      Monde mondeTest = new Monde("MondeTest");
      Entite entite = new Entite("Entite", mondeTest){};
      assertEquals(mondeTest.getEntite("Entite"),entite);
    }catch(Exception e){};
  }


  @Test
  public void TestAjouter() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    try{
      Monde mondeTest = new Monde("MondeTest");
      Entite entite = new Entite("Entite1", mondeTest){};
      assertEquals(mondeTest.getEntite("Entite1"),entite);
    }catch(Exception e){};
  }


  @Test (expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void TestAjouter_avecExceptionDejaPresent() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    try{
      Monde mondeTest = new Monde("MondeTest");
      Entite entite =new Entite("Entite1", mondeTest){};

      mondeTest.ajouter(entite);
      assertEquals(mondeTest.getEntite("Entite1"),entite);
    }catch(Exception e){};
  }

  @Test (expected = EntiteDejaDansUnAutreMondeException.class)
  public void TestAjouter_avecExceptionAutreMonde() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException{
    try{
      Monde mondeTest1 = new Monde("MondeTest1");
      Monde mondeTest2 = new Monde("MondeTest2");
      Entite entite =new Entite("Entite1", mondeTest1){};

      mondeTest2.ajouter(entite);
      assertEquals(mondeTest1.getEntite("Entite1"),mondeTest2.getEntite("Entite1"));
    }catch(Exception e){};
  }
}