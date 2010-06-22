package test.org.sbelli.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.CategoriaGara;

public class CategoriaGaraDaoTest extends TestCase {

	public CategoriaGaraDaoTest(String name) {
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
			CategoriaGara catComp = DbManagerFactory.getInstance().getCategoriaGaraDao().get(46l);
			System.out.println(catComp);
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
			List<CategoriaGara> catComps = DbManagerFactory.getInstance().getCategoriaGaraDao().list();
			for (CategoriaGara catComp : catComps) {
				System.out.println(catComp);
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	public final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	public final void testListCategorie() {
		fail("Not yet implemented"); // TODO
	}

}
