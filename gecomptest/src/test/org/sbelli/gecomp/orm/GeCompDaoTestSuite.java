package test.org.sbelli.gecomp.orm;

import junit.framework.Test;
import junit.framework.TestSuite;
import test.org.sbelli.gecomp.orm.dao.AtletaDaoTest;
import test.org.sbelli.gecomp.orm.dao.CategoriaDaoTest;
import test.org.sbelli.gecomp.orm.dao.CompetizioneDaoTest;
import test.org.sbelli.gecomp.orm.dao.GaraDaoTest;
import test.org.sbelli.gecomp.orm.dao.PrestazioneDaoTest;
import test.org.sbelli.gecomp.orm.dao.SocietaDaoTest;

public class GeCompDaoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for test.org.sbelli.gecomp.orm.dao");
		
		//$JUnit-BEGIN$
		suite.addTestSuite(GaraDaoTest.class);
		suite.addTestSuite(SocietaDaoTest.class);
		suite.addTestSuite(CompetizioneDaoTest.class);
		suite.addTestSuite(PrestazioneDaoTest.class);
		suite.addTestSuite(AtletaDaoTest.class);
		suite.addTestSuite(CategoriaDaoTest.class);
		//$JUnit-END$
		
		return suite;
	}

}
