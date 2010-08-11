package org.sbelli.gecomp.console.iscrizioni.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.MessageSeverity;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;

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
		logger.info("Inizio salvataggio di una nuova iscrizione");
		String outcome = super.salva();
		if (!Eval.equalsIgnoreCase(outcome, GeCompOutcomes.FAIL)) {
			GuiMessageHandler.addGUIMessage(MessageSeverity.info, "message.info.success", "net.sb.gecomp.console.iscrizioni.executers.inserimento.success");
			return GeCompOutcomes.INSERISCI_ISCRIZIONI;
		} else {
			return outcome;
		}
	}
}
