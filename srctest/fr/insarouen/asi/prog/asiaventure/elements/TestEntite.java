package fr.insarouen.asi.prog.asiaventure.elements;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import org.junit.Before;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestEntite{
	//Attribut
	private static Monde mondeTest ;
	private Entite entiteTest ;
	@BeforeClass
	public static void avantClassesTest(){
		mondeTest = new Monde("mondeTest");
	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		entiteTest = new Entite("EntiteTest",mondeTest){}; //acolade pour creer une classe anonyme pcq la classe Entite est abstraite
	}

	@Test
	public void testConstructeur(){
		assertEquals(entiteTest, entiteTest);
	}

	@Test
	public void testGetNom(){
		try{
			assertEquals(entiteTest.getNom(),"EntiteTest");
		}catch(Exception e){};
	}

	@Test
	public void testGetMonde(){
		try{
			assertEquals(entiteTest.getMonde(),mondeTest);
		}catch(Exception e){};
	}

	@Test
	public void testHashCode(){
		try{
			assertEquals(entiteTest.hashCode(),2*entiteTest.getNom().hashCode()+3*entiteTest.getMonde().hashCode());
		}catch(Exception e){}
	}

	@Test
	public void testEquals(){
		try{
			assertTrue(entiteTest.equals(entiteTest)==true);
		}catch(Exception e){}
	}
}