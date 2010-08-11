package net.sb.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.Societa;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;


public class SocietaDaoTest extends TestCase {

	public SocietaDaoTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testGetSocieta() {
		try {
			Societa soc = DbManagerFactory.getInstance().getSocietaDao().get(21l);
			System.out.println(soc);
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testListSocieta() {
		try {
			List<Societa> socs = DbManagerFactory.getInstance().getSocietaDao().list();
			for (Societa soc : socs) {
				System.out.println(soc);	
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}
}
