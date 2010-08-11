package org.sbelli.gecomp.console.iscrizioni.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.bridges.view.AtletaView;
import org.sbelli.gecomp.console.bridges.view.IscrizioneView;

public class InserisciIscrizioneExecuter extends IscrizioneExecuter {

	public InserisciIscrizioneExecuter () {
		try {
			checks4SelectedCompetizione();
			checks4SelectedGara();
			this.setIscrizione(new IscrizioneView(new AtletaView(), getSelectedGara()));
			setListaGareItem(getHelper().getListaGareItem(getSelectedCompetizione()));
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "net.sb.gecomp.console.iscrizioni.executers.generic_error");
		}
		
	}

	public String salva() {
		logger.info("Saving new Iscrizione...");
		return super.salva();
	}
}
