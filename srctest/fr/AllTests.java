package fr;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.insarouen.asi.prog.asiaventure.elements.AllTestsElements;

@RunWith(Suite.class)
@SuiteClasses({
	AllTestsElements.class
})
public class AllTests{}