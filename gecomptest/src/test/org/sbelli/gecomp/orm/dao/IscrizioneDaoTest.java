package test.org.sbelli.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Iscrizione;

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
