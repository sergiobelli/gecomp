package net.sb.gecomp.web.controllers.iscrizioni;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;


public class IscrizioneController extends GenericController {

	public void checks(GecompModelObject element) throws GeCompException {
		IscrizioneView iscrizione = (IscrizioneView)element;
		
		checkAtleta(iscrizione);
		checkGara(iscrizione);
		checkCompetitivo(iscrizione);
				
	}

	protected void checkAtleta(IscrizioneView iscrizione) throws GeCompException {
		if (Eval.isNull(iscrizione.getAtleta())
				|| Eval.isNull(iscrizione.getAtleta().getIdAtleta())) {
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.controllers.error.atleta.empty");
		}
	}
	
	protected void checkGara(IscrizioneView iscrizione) throws GeCompException {
		if (Eval.isNull(iscrizione.getGara())
				|| Eval.isNull(iscrizione.getGara().getIdGara())) {
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.controllers.error.gara.empty");
		}
	}
	
	protected void checkCompetitivo(IscrizioneView iscrizione) throws GeCompException {
		if (Eval.isNull(iscrizione.getCompetitivo())) {
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.controllers.error.competitivo.empty");
		}
	}
}
