package fr.insarouen.asi.prog.asiaventure.elements;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.objets.TestPiedDeBiche;

@RunWith(Suite.class)
@SuiteClasses({
	TestEntite.class,
	TestPiedDeBiche.class
})
public class AllTestsElements{}