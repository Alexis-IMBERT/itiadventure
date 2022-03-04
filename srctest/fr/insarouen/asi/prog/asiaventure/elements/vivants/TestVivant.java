package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

public class TestVivant {
	static Monde mondeTest;
	Vivant vivantTest;
	Piece pieceTest;
	Objet objetTest1;
	Objet objetTest2;
	Objet objetTest3;
	@BeforeClass
	public static void avantClasse(){
		mondeTest = new Monde("mondeTest");
	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		pieceTest = new Piece("pieceTest", mondeTest);
		objetTest1 = new Objet("objetTest1",mondeTest){};
		objetTest2 = new Objet("objetTest2",mondeTest){};
		pieceTest.deposer(objetTest1);
		vivantTest = new Vivant("vivantTest", mondeTest, 10, 10, pieceTest, objetTest1){};
	}

	@Test
	public void getNomTest(){
		assertEquals(vivantTest.getNom(),"vivantTest");
		assertNotEquals(vivantTest.getNom(), "vivant");
	}

	@Test
	public void getPointForceTest(){
		assertEquals(vivantTest.getPointForce(), 10);
		assertNotEquals(vivantTest.getPointForce(), 5);
		vivantTest.pointForce = 5;
		assertEquals(vivantTest.getPointForce(), 5);
		assertNotEquals(vivantTest.getPointForce(), 10);
	}

	@Test
	public void getPointVieTest(){
		assertEquals(vivantTest.getPointVie(), 10);
	}

	@Test
	public void getMondeTest(){
		assertEquals(vivantTest.getMonde(), mondeTest);
	}

	@Test
	public void estMortTest(){
		assertFalse(vivantTest.estMort());
		vivantTest.pointVie = 0 ;
		assertTrue(vivantTest.estMort());
	}

	
}
