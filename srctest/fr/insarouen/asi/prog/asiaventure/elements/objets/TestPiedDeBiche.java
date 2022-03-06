package fr.insarouen.asi.prog.asiaventure.elements.objets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.core.Is.is;

import org.hamcrest.core.IsEqual;
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
		assertThat(piedDeBicheTest, IsEqual.equalTo(piedDeBicheTest));
	}

	@Test
	public void testIsEstDeplacable(){
		assertThat(piedDeBicheTest.isEstDeplacable(),is(true));
	}

	@Test
	public void testSetEstDeplacable(){
		assertThat(piedDeBicheTest.isEstDeplacable(),is(true));
		piedDeBicheTest.setEstDeplacable(false);
		assertThat(piedDeBicheTest.isEstDeplacable(),is(false));
	}
}
