package test.org.sbelli.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Gara;

public class GaraDaoTest extends TestCase {

	public GaraDaoTest(String name) {
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

	public final void testGetGara() {
		try {
			Gara gara = DbManagerFactory.getInstance().getGaraDao().get(1l);
			System.out.println(gara.getIdGara());
			System.out.println(gara.getNome());
			System.out.println(gara.getCompetizione());
			System.out.println(gara.getData());
			System.out.println(gara.getDistanza());
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testListGara() {
		try {
			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list();
			for (Gara gara : gare) {
				System.out.println(gara.getIdGara());
				System.out.println(gara.getNome());
				System.out.println(gara.getCompetizione());
				System.out.println(gara.getData());
				System.out.println(gara.getDistanza());	
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testInsertGara() {
		fail("Not yet implemented"); // TODO
	}

	public final void testUpdateGara() {
		fail("Not yet implemented"); // TODO
	}

	public final void testDeleteGara() {
		fail("Not yet implemented"); // TODO
	}

}
