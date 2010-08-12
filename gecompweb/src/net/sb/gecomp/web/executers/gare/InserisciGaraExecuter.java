package net.sb.gecomp.web.executers.gare;

import java.util.Date;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class InserisciGaraExecuter extends GaraExecuter {
	
	public InserisciGaraExecuter () {
		try {
			checks4SelectedCompetizione ();
			setGara(
					new GaraView(
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
