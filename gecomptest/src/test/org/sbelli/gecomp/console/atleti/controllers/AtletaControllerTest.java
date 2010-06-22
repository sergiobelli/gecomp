package test.org.sbelli.gecomp.console.atleti.controllers;

import junit.framework.TestCase;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.atleti.controllers.AtletaController;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Societa;

public class AtletaControllerTest extends TestCase {
	
	private static final String NOME = "nome";
	private static final String COGNOME = "cognome";
	private static final String SESSO = "M";
	private static final String ANNO_NASCITA = "2000";
	private static final Societa SOCIETA_APPARTENENZA = new Societa();
	private Atleta atleta;
	private AtletaController atletaController;
	public AtletaControllerTest(String name) {
		super(name);		
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		

		atleta = new Atleta();
		atleta.setNome(NOME);
		atleta.setCognome(COGNOME);
		atleta.setSesso(SESSO);
		atleta.setAnnoNascita(ANNO_NASCITA);
		atleta.setSocietaAppartenenza(SOCIETA_APPARTENENZA);

		atletaController = new AtletaController();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public final void testAtletaController() {
		fail("Not yet implemented"); // TODO
	}
	
	public final void testChecks() {
		fail("Not yet implemented"); // TODO
	}
	
	public final void testChecksSocietaDiAppartenenza() {
		fail("Not yet implemented"); // TODO
	}
	
	public final void testChecksNome() {
		fail("Not yet implemented"); // TODO
	}
	
	public final void testChecksCognome() {
		fail("Not yet implemented"); // TODO
	}
	
	public final void testChecksAnnoDiNascita() {
		fail("Not yet implemented"); // TODO
	}
	
	public final void testChecksSessoOk() {
		try {
			atleta.setSesso("M");
			atletaController = new AtletaController();
	    atletaController.checks(atleta);
	    
			atleta.setSesso("F");
			atletaController = new AtletaController();
	    atletaController.checks(atleta);
	    
    } catch (GeCompException e) {
	    e.printStackTrace();
	    fail();
    }
	}
	public final void testChecksSessoKo4NullSesso() {
		try {
			atleta.setSesso(null);
			atletaController = new AtletaController();
	    atletaController.checks(atleta);
	    fail();
    } catch (GeCompException e) {
	    e.printStackTrace();
    }
	}
	public final void testChecksSessoKo4EmptySesso() {
		try {
			atleta.setSesso("");
			atletaController = new AtletaController();
	    atletaController.checks(atleta);
	    fail();
    } catch (GeCompException e) {
	    e.printStackTrace();
    }
	}
	public final void testChecksSessoKo4BadLenghtSesso() {
		try {
			atleta.setSesso("MM");
			atletaController = new AtletaController();
	    atletaController.checks(atleta);
	    fail();
    } catch (GeCompException e) {
	    e.printStackTrace();
    }
	}
	public final void testChecksSessoKo4BadWordSesso() {
		try {
			atleta.setSesso("f");
			atletaController = new AtletaController();
	    atletaController.checks(atleta);
	    fail();
    } catch (GeCompException e) {
	    e.printStackTrace();
    }
	}
}
