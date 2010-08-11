package net.sb.gecomp.orm;

import net.sb.gecomp.orm.dao.AtletaDaoTest;
import net.sb.gecomp.orm.dao.CategoriaDaoTest;
import net.sb.gecomp.orm.dao.CompetizioneDaoTest;
import net.sb.gecomp.orm.dao.GaraDaoTest;
import net.sb.gecomp.orm.dao.PrestazioneDaoTest;
import net.sb.gecomp.orm.dao.SocietaDaoTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class GeCompDaoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for net.sb.gecomp.orm.dao");
		
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
