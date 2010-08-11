package org.sbelli.gecomp.console.iscrizioni.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

public class EliminaIscrizioneExecuter extends ModificaIscrizioneExecuter {

	public String salva() {
		try {
			logger.info("Deleting iscrizione...");
			delegate.delete(getIscrizione());
			logger.info("Deleted iscrizione...");
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.LISTA_ISCRIZIONI;
	}
	
}
