package net.sb.gecomp.console.controllers;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sb.gecomp.console.atleti.controllers.AtletaControllerTest;
import net.sb.gecomp.console.categorie.controllers.CategoriaControllerTest;



public class ControllersTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.sb.gecomp.console.controllers");
		suite.addTestSuite(AtletaControllerTest.class);
		suite.addTestSuite(CategoriaControllerTest.class);
		return suite;
	}
}
