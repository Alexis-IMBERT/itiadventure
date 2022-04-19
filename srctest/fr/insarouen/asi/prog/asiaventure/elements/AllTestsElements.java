package fr.insarouen.asi.prog.asiaventure.elements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.objets.TestCoffre;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestObjets;
import fr.insarouen.asi.prog.asiaventure.elements.objets.TestPiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.TestSerrure;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestElementStructurel;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPiece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.TestPorte;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.TestVivant;

@RunWith(Suite.class)
@SuiteClasses({
		TestEntite.class,
		TestPiedDeBiche.class,
		TestVivant.class,
		TestPiece.class,
		TestObjets.class,
		TestPorte.class,
		TestSerrure.class,
		TestCoffre.class,
		TestElementStructurel.class
})
public class AllTestsElements {
}