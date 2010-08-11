package net.sb.gecomp.orm.dao;

import java.util.List;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Societa;

public class AtletaDaoTest extends TestCase {

	public AtletaDaoTest(String name) {
		super(name);
	}

	private static int ID_ATLETA = 0; 
	private static final String DUMMY_COGNOME = "DUMMY_COGNOME";
	private static final String DUMMY_NOME = "DUMMY_NOME";
	private static final String DUMMY_ANNO_NASCITA = "2010";
	private static final String DUMMY_SESSO = "S";
	
	private static final Long DUMMY_ID_SOCIETA = 1000l;
	private static final String DUMMY_NOME_SOCIETA = "DUMMY_NOME_SOCIETA";
	
	private static final String NEW_DUMMY_COGNOME = "NEW_DUMMY_COGNOME";
	private static final String NEW_DUMMY_NOME = "NEW_DUMMY_NOME";
	private static final String NEW_DUMMY_ANNO_NASCITA = "2020";
	private static final String NEW_DUMMY_SESSO = "T";
	
	private static final int NEW_DUMMY_ID_SOCIETA = 2000;
	private static final String NEW_DUMMY_NOME_SOCIETA = "NEW_DUMMY_NOME_SOCIETA";
	
	private Societa societa = null;
	private Atleta atleta = null;
	protected void setUp() throws Exception {
		super.setUp();
		
		atleta = new Atleta();
		atleta.setCognome(DUMMY_COGNOME);
		atleta.setNome(DUMMY_NOME);
		atleta.setAnnoNascita(DUMMY_ANNO_NASCITA);
		atleta.setSesso(DUMMY_SESSO);
		
		societa = new Societa();
		societa.setId(DUMMY_ID_SOCIETA);
		societa.setDenominazione(DUMMY_NOME_SOCIETA);
		atleta.setSocietaAppartenenza(societa);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testGetInstance() {
		fail("Not yet implemented"); // TODO
	}

//	
//	public void testAll () {
//		
//		try {
//			
//			set();
//			get();
//			
//			update();
//			getAfterUpdate();
//			
//			delete();
//			getAfterDelete();
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			fail(ex.getMessage());
//		}
//	}
//	
//	
//	private void getAfterDelete() {
//		
//		try {
//			
//			Atleta newAtleta = AtletaDao.getInstance().get(atleta.getIdAtleta());
//			
//			assertEquals(null, 					newAtleta);
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//
//		}
//	}
//
//	private void delete() {
//		
//		try {
//			
//			AtletaDao.getInstance().delete(atleta.getIdAtleta());			
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//	}
//
//	private void getAfterUpdate() {
//		
//		try {
//			
//			Atleta newAtleta = AtletaDao.getInstance().get(atleta.getIdAtleta());
//			
//			assertEquals(newAtleta.getNome(), 					NEW_DUMMY_COGNOME);
//			assertEquals(newAtleta.getCognome(), 				NEW_DUMMY_NOME);
//			assertEquals(newAtleta.getSesso(), 					NEW_DUMMY_SESSO);
//			assertEquals(newAtleta.getAnnoNascita(), 			NEW_DUMMY_ANNO_NASCITA);
//			assertEquals(newAtleta.getSocietaAppartenenza().getId(),		NEW_DUMMY_ID_SOCIETA);
//			assertEquals(newAtleta.getSocietaAppartenenza().getNomeSocieta(),	NEW_DUMMY_NOME_SOCIETA);
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//
//		}
//	}
//
//	private void update() {
//		
//		try {
//			
//			atleta.setCognome(NEW_DUMMY_COGNOME);
//			atleta.setNome(NEW_DUMMY_NOME);
//			atleta.setAnnoNascita(NEW_DUMMY_ANNO_NASCITA);
//			atleta.setSesso(NEW_DUMMY_SESSO);
//			
//			societa = new Societa();
//			societa.setId(NEW_DUMMY_ID_SOCIETA);
//			societa.setNomeSocieta(NEW_DUMMY_NOME_SOCIETA);
//			atleta.setSocietaAppartenenza(societa);
//			
//			AtletaDao.getInstance().update(atleta);
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//		
//	}
//
//	private void get() {
//		
//		try {
//			
//			Atleta tmpAtleta = null;
//			List<Atleta> atleti = AtletaDao.getInstance().list();
//			for (Atleta atleta : atleti) {
//				if (atleta.getCognome().equals(DUMMY_COGNOME)
//						&& atleta.getNome().equals(DUMMY_NOME)
//						&& atleta.getSesso().equals(DUMMY_SESSO)
//						&& atleta.getAnnoNascita().equals(DUMMY_ANNO_NASCITA)) {
//					tmpAtleta = atleta;
//				}
//			}
//			
//			
//			Atleta newAtleta = AtletaDao.getInstance().get(tmpAtleta.getIdAtleta());
//			assertEquals(newAtleta.getIdAtleta(), 				atleta.getIdAtleta());
//			assertEquals(newAtleta.getNome(), 					atleta.getNome());
//			assertEquals(newAtleta.getCognome(), 				atleta.getCognome());
//			assertEquals(newAtleta.getSesso(), 					atleta.getSesso());
//			assertEquals(newAtleta.getAnnoNascita(), 			atleta.getAnnoNascita());
//			assertEquals(newAtleta.getSocietaAppartenenza().getId(),		atleta.getSocietaAppartenenza().getId());
//			assertEquals(newAtleta.getSocietaAppartenenza().getNomeSocieta(),	atleta.getSocietaAppartenenza().getNomeSocieta());
//			
//			assertTrue(newAtleta.equals(atleta));
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//
//		}
//		
//	}
//
//	private void set() {
//		
//		try {
//			
//			AtletaDao.getInstance().insert(atleta);
//			List<Atleta> atleti = AtletaDao.getInstance().list();
//			for (Atleta atleta : atleti) {
//				if (atleta.getCognome().equals(DUMMY_COGNOME)
//						&& atleta.getNome().equals(DUMMY_NOME)
//						&& atleta.getSesso().equals(DUMMY_SESSO)
//						&& atleta.getAnnoNascita().equals(DUMMY_ANNO_NASCITA)) {
//					ID_ATLETA = atleta.getIdAtleta();
//				}
//			}
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//		
//	}

	public final void testGetAtleta() {
		try {
			Atleta atleta = DbManagerFactory.getInstance().getAtletaDao().get(101l);
			System.out.println(atleta);
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public final void testListAtleta() {
		try {
			List<Atleta> atleti = DbManagerFactory.getInstance().getAtletaDao().list();
			for (Atleta atleta : atleti) {
				System.out.println(atleta);
			}			
		} catch (GeCompException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	public final void testInsertAtleta() {
//		try {						
//			DbManagerFactory.getInstance().getAtletaDao().insert(atleta);			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
	}

	public final void testUpdateAtleta() {
//		try {
//			
//			Atleta atleta = DbManagerFactory.getInstance().getAtletaDao().get(1);
//			atleta.setNome(NEW_DUMMY_NOME);
//			DbManagerFactory.getInstance().getAtletaDao().update(atleta);
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//
//		}
	}

	public final void testDeleteAccount() {
//		try {
//			
//			List<Atleta> atleti = DbManagerFactory.getInstance().getAtletaDao().list();
//			for (Atleta atleta : atleti) {
//				if ("cognome".equals(atleta.getCognome())) {
//					DbManagerFactory.getInstance().getAtletaDao().delete(atleta.getIdAtleta());
//				}
//			}		
//			
//		} catch (GeCompException e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
	}

}
