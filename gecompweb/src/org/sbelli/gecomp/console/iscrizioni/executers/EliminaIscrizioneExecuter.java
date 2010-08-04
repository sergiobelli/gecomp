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
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.eliminazione.ko.descrizione");
			return GeCompOutcomes.NULL;
		}
		return GeCompOutcomes.LISTA_ISCRIZIONI;
	}
	
}
