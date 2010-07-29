package org.sbelli.gecomp.console.competizione.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.orm.model.Competizione;

public class InserisciCompetizioneExecuter extends CompetizioneExecuter {

	public String salva () {
		logger.info("Salvataggio di una nuova competizione...");
		return insert ();
	}

	private String insert() {

		try {
			logger.info("Saving new Competizione...");

			delegate.save(getCompetizione());
			
			logger.info("Saved new Competizione...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.competizione.salvataggio.ko");
			return "null";
		}

		return GeCompOutcomes.LISTA_COMPETIZIONI;
	}

	public String inserisciESeleziona () {
		logger.info("Salvataggio e selezione di una nuova competizione...");
		String outcome = insert ();

		try {
			GeCompUserSessionHandler.getGeCompUserSession().setCompetizione((Competizione)delegate.retrieve(this.getCompetizione()));
			GeCompUserSessionHandler.getGeCompUserSession().setGara(null);
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger,e, "error.competizione.salvataggio.selezione.ko");
		}

		return outcome;
	}

}
