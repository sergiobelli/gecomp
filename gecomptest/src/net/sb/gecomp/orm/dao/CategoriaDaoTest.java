package net.sb.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;
import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class CategoriaDaoTest extends TestCase {

	public CategoriaDaoTest(String name) {
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

	public final void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGet() {
		try {
			Categoria cat = DbManagerFactory.getInstance().getCategoriaDao().get(10l);
			System.out.println(cat);
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testInsert() {
		fail("Not yet implemented"); // TODO
	}

	public final void testList() {
		try {
			List<Categoria> cats = DbManagerFactory.getInstance().getCategoriaDao().list();
			for (Categoria cat : cats) {
				System.out.println(cat);	
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

}
