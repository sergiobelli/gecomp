package net.sb.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;
import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class IscrizioneDaoTest extends TestCase {

	public IscrizioneDaoTest(String name) {super(name);}

	protected void setUp() throws Exception {super.setUp();}
	protected void tearDown() throws Exception {super.tearDown();}

	public void testDelete() {
		fail("Not yet implemented");
	}

	public void testGet() {
		try {
			Iscrizione iscrizione = DbManagerFactory.getInstance().getIscrizioneDao().get(1l);
			System.out.println(iscrizione);
		} catch (GeCompOrmException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testInsert() {
		fail("Not yet implemented");
	}

	public void testList() {
		try {
			List<Iscrizione> iscrizioni = DbManagerFactory.getInstance().getIscrizioneDao().list();
			for (Iscrizione iscrizione : iscrizioni) { System.out.println(iscrizione); }
		} catch (GeCompOrmException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public void testUpdate() {
		fail("Not yet implemented");
	}

}
