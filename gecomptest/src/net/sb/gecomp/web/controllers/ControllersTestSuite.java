package net.sb.gecomp.web.controllers;

import junit.framework.Test;
import junit.framework.TestSuite;
import net.sb.gecomp.web.atleti.controllers.AtletaControllerTest;
import net.sb.gecomp.web.categorie.controllers.CategoriaControllerTest;
import net.sb.gecomp.web.iscrizioni.controllers.IscrizioneControllerTest;



public class ControllersTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.sb.gecomp.web.controllers");
		suite.addTestSuite(AtletaControllerTest.class);
		suite.addTestSuite(CategoriaControllerTest.class);
		suite.addTestSuite(IscrizioneControllerTest.class);
		return suite;
	}
}
