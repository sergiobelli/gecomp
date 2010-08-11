package net.sb.gecomp.orm.model;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ModelTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.sb.gecomp.orm.model");
		//$JUnit-BEGIN$
		suite.addTestSuite(PrestazioneTest.class);
		//$JUnit-END$
		return suite;
	}

}
