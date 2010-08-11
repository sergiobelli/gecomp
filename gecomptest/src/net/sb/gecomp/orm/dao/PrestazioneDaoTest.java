package net.sb.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.Prestazione;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;


public class PrestazioneDaoTest extends TestCase {

	public PrestazioneDaoTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testGetInstance() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetPrestazione() {
		try {
			Prestazione prestazione = DbManagerFactory.getInstance().getPrestazioneDao().get(2501l);
			System.out.println(prestazione);
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public final void testListPrestazione() {
		try {
			List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list();
			for (Prestazione prestazione : prestazioni) {
				System.out.println(prestazione);
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public final void testInsertPrestazione() {
		fail("Not yet implemented"); // TODO
	}

	public final void testUpdatePrestazione() {
		fail("Not yet implemented"); // TODO
	}

	public final void testDeletePrestazione() {
		fail("Not yet implemented"); // TODO
	}

}
