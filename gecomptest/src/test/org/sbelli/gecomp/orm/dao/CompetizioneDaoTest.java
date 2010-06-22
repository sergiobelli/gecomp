package test.org.sbelli.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;

public class CompetizioneDaoTest extends TestCase {

	public CompetizioneDaoTest(String name) {
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

	public final void testGetCompetizione() {
		try {
			Competizione competizione = DbManagerFactory.getInstance().getCompetizioneDao().get(6l);
			System.out.println(competizione);
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testListCompetizione() {
		try {
			List<Competizione> competizioni = DbManagerFactory.getInstance().getCompetizioneDao().list();
			for (Competizione competizione : competizioni) {
				System.out.println(competizione);	
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	public final void testInsertCompetizione() {
		fail("Not yet implemented"); // TODO
	}

	public final void testUpdateAtleta() {
		fail("Not yet implemented"); // TODO
	}

	public final void testDeleteAtleta() {
		fail("Not yet implemented"); // TODO
	}

}
