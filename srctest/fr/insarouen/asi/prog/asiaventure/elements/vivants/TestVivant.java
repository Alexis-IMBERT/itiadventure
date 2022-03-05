package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.ObjetNonPossedeParLeVivantException;

public class TestVivant {
	static Monde mondeTest;
	Vivant vivantTest;
	Piece pieceTest;
	PiedDeBiche objetTest1;
	PiedDeBiche objetTest2;
	
	@BeforeClass
	public static void avantClasse(){
		mondeTest = new Monde("mondeTest");
	}

	@Before
	public void avantTest() throws NomDEntiteDejaUtiliseDansLeMondeException{
		pieceTest = new Piece("pieceTest", mondeTest);
		objetTest1 = new PiedDeBiche("objetTest1",mondeTest);
		objetTest2 = new PiedDeBiche("objetTest2",mondeTest);
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
		assertNotEquals(vivantTest.getPointVie(), 0);
	}

	@Test
	public void getMondeTest(){
		assertEquals(vivantTest.getMonde(), mondeTest);
	}

	@Test
	public void getPiece(){
		assertEquals(pieceTest, vivantTest.getPiece());
	}

	@Test
	public void estMortTest(){
		assertFalse(vivantTest.estMort());
		vivantTest.pointVie = 0 ;
		assertTrue(vivantTest.estMort());
	}

	@Test
	public void getObjetsTest(){
		Objet[] objetTheorique = new Objet[1];
		objetTheorique[0]=objetTest1;
		assertArrayEquals(vivantTest.getObjets(), objetTheorique);
	}

	@Test
	public void getObjetTest(){
		assertEquals(objetTest1, vivantTest.getObjet("objetTest1"));
		assertNull(vivantTest.getObjet("objetTest2"));
	}

	/*@Test
    public void test_prendre__deposer_possede() throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException, ObjetNonPossedeParLeVivantException{
        assertThat(vivantTest.possede(objetTest1), is(true));
		vivantTest.getPiece().deposer(objetTest2);
		vivantTest.prendre(objetTest2);
		assertThat(vivantTest.possede(objetTest2), is(true));
		vivantTest.deposer(objetTest2);
		assertThat(vivantTest.possede(objetTest2), is(false));
    }*/
/*
	@Test(expected = ObjetNonPossedeParLeVivantException.class)
	public void testObjetAbsentPiece() throws ObjetNonPossedeParLeVivantException{
		vivantTest.deposer(objetTest2);
	}*/


}
