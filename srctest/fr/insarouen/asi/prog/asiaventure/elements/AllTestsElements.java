package fr.insarouen.asi.prog.asiaventure.elements;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.objets.TestPiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.TestVivant;

@RunWith(Suite.class)
@SuiteClasses({
	TestEntite.class,
	TestPiedDeBiche.class,
	TestVivant.class
})
public class AllTestsElements{}