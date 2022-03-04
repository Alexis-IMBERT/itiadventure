package fr.insarouen.asi.prog.asiaventure.elements;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class TestEntite{
	//Attribut
	private static Monde mondeTest ;
	private Entite entiteTest ;
	@BeforeClass
	public static void avantTest(){
		mondeTest = new Monde("mondeTest");
	}

	@Test
	public void testGetNom(){
		try{
			entiteTest = new Entite("EntiteTest",mondeTest){}; //acolade pour creer une classe anonyme pcq la classe Entite est abstraite
			assertEquals(entiteTest.getNom(),"EntiteTest");
		}catch(Exception e){};
	}
	@Test
	public void testGetMonde(){
		try{
			entiteTest = new Entite("EntiteTest",mondeTest){}; //acolade pour creer une classe anonyme pcq la classe Entite est abstraite
			assertEquals(entiteTest.getMonde(),mondeTest);
		}catch(Exception e){};
	}
	/*@Test
	public void testHashCode(){
		try{
			entiteTest = new Entite("EntiteTest",mondeTest){}; //acolade pour creer une classe anonyme pcq la classe Entite est abstraite
			assertEquals(entiteTest.hashCode(),);
		}catch(Exception e){}
	}
	@Test
	public void testEquals(){
		try{
			entiteTest1 = new Entite("EntiteTest",mondeTest);
			entiteTest2 = new Entite("EntiteTest",mondeTest); 
			assertEquals(entiteTest1.equals(entiteTest2),true);
		}catch(Exception e){}
	}*/
}