package fr.insarouen.asi.prog.asiaventure;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;

public class TestMonde {
  static Monde mondeTest;

  @Before
  public void avantTest() {
    mondeTest = new Monde("MondeTest");
  }

  @Test
  public void testGetNom() {
    assertThat(mondeTest.getNom(), IsEqual.equalTo("MondeTest"));
  }

  @Test
  public void TestGetEntite() {
    try {
      Monde mondeTest = new Monde("MondeTest");
      Entite entite = new Entite("Entite", mondeTest) {
      };
      assertEquals(mondeTest.getEntite("Entite"), entite);
    } catch (Exception e) {
    }
    ;
  }

  @Test
  public void TestAjouter() throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException {
    Monde mondeTest = new Monde("MondeTest");
    Entite entite = new Entite("Entite1", mondeTest) {
    };
    assertEquals(mondeTest.getEntite("Entite1"), entite);
    ;
  }

  @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
  public void TestAjouter_avecExceptionDejaPresent()
      throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException {
    Monde mondeTest = new Monde("MondeTest");
    Entite entite = new Entite("Entite1", mondeTest) {
    };
    mondeTest.ajouter(entite);
  }

  @Test(expected = EntiteDejaDansUnAutreMondeException.class)
  public void TestAjouter_avecExceptionAutreMonde()
      throws NomDEntiteDejaUtiliseDansLeMondeException, EntiteDejaDansUnAutreMondeException {
    Monde mondeTest1 = new Monde("MondeTest1");
    Monde mondeTest2 = new Monde("MondeTest2");
    Entite entite = new Entite("Entite1", mondeTest1) {
    };

    mondeTest2.ajouter(entite);
    ;
  }
}