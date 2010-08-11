package net.sb.gecomp.web.iscrizioni.controllers;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.bridges.view.IscrizioneView;
import org.sbelli.gecomp.console.iscrizioni.controllers.IscrizioneController;

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
