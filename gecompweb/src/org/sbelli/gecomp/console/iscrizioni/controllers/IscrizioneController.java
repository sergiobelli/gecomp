package org.sbelli.gecomp.console.iscrizioni.controllers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.bridges.view.IscrizioneView;
import org.sbelli.gecomp.console.controllers.GenericController;
import org.sbelli.gecomp.orm.model.GecompModelObject;

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
