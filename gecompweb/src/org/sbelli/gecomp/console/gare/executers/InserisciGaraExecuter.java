package org.sbelli.gecomp.console.gare.executers;

import java.util.Date;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.TipoMisura;

public class InserisciGaraExecuter extends GaraExecuter {
	
	public InserisciGaraExecuter () {
		try {
			checks4SelectedCompetizione ();
			setGara(
					new Gara(
							GeCompUserSessionHandler.getGeCompUserSession().getCompetizione(),
							"", 
							"", 
							new Date(), 
							0.0f, 
							new TipoMisura()));
		} catch (GeCompException e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "error.competizione.selezione.ko");
		}
	}

	public String salva() {
		logger.info("Inserimento di una gara in corso...");
		return super.salva();
  }
}
