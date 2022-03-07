package fr;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.TestMonde;
import fr.insarouen.asi.prog.asiaventure.elements.AllTestsElements;

@RunWith(Suite.class)
@SuiteClasses({
	AllTestsElements.class,
	TestMonde.class
})
public class AllTests{}