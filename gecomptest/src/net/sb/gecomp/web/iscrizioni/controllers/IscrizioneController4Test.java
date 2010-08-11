package net.sb.gecomp.web.iscrizioni.controllers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.bridges.view.IscrizioneView;
import net.sb.gecomp.web.controllers.iscrizioni.IscrizioneController;


public class IscrizioneController4Test extends IscrizioneController {

	@Override
	protected void checkAtleta(IscrizioneView iscrizione)
			throws GeCompException {
		super.checkAtleta(iscrizione);
	}

	@Override
	protected void checkCompetitivo(IscrizioneView iscrizione)
			throws GeCompException {
		super.checkCompetitivo(iscrizione);
	}

	@Override
	protected void checkGara(IscrizioneView iscrizione) throws GeCompException {
		super.checkGara(iscrizione);
	}

}
