package fr.insarouen.asi.prog.asiaventure.elements;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
//import static org.hamcrest.core.IsEqual;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;

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
}