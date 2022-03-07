package fr.insarouen.asi.prog.asiaventure.elements;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.objets.TestObjets;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestPiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPiece;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.TestVivant;

@RunWith(Suite.class)
@SuiteClasses({
	TestEntite.class,
	TestPiedDeBiche.class,
	TestVivant.class,
	TestPiece.class,
	TestObjets.class
})
public class AllTestsElements{}