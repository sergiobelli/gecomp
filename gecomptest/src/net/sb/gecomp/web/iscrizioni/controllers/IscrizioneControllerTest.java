package net.sb.gecomp.web.iscrizioni.controllers;

import static org.junit.Assert.fail;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.utils.Eval;

import org.junit.Test;

public class IscrizioneControllerTest {

	@Test
	public void testCheckAtleta_ok() {
		fail("Not yet implemented");
		protected void checkAtleta(IscrizioneView iscrizione) throws GeCompException {
			if (Eval.isNull(iscrizione.getAtleta())
					|| Eval.isNull(iscrizione.getAtleta().getIdAtleta())) {
				throw new GeCompException("net.sb.gecomp.console.iscrizioni.controllers.error.atleta.empty");
			}
		}
	}
	
	public void testCheckAtleta_ok() {
		
	}
	
	@Test
	public void testCheckGara() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckCompetitivo() {
		fail("Not yet implemented");
	}

}
