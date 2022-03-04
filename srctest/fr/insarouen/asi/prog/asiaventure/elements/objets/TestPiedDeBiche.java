package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestPiedDeBiche {
	static Monde mondeTest;
	PiedDeBiche piedDeBicheTest;

	@BeforeClass
	public static void avantClasseTest(){
		mondeTest = new Monde("mondeTest");
	}
	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		piedDeBicheTest = new PiedDeBiche("piedDeBicheTest", mondeTest);
	}

	@Test
	public void testConstructeur(){
		assertEquals(piedDeBicheTest,piedDeBicheTest);
	}

	@Test
	public void testIsEstDeplacable(){
		assertTrue(piedDeBicheTest.isEstDeplacable());
	}

	@Test
	public void testSetEstDeplacable(){
		assertTrue(piedDeBicheTest.isEstDeplacable());
		piedDeBicheTest.setEstDeplacable(false);
		assertFalse(piedDeBicheTest.isEstDeplacable());
	}
}
