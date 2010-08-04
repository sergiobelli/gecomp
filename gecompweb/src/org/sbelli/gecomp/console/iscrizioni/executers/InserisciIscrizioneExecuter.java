package org.sbelli.gecomp.console.iscrizioni.executers;

import net.sb.gecomp.web.menu.GeCompOutcomes;
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
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "sssssssssswwwwwwwwwwwweeeeeeeeeeeeee");
		}
		
	}

	public String salva() {
		try {
			logger.info("Saving new Iscrizione...");
			super.salva();
			logger.info("Saved new Iscrizione...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.salvataggio.ko");
			return GeCompOutcomes.NULL;
		}
		return GeCompOutcomes.LISTA_ISCRIZIONI;
	}
}
