package net.sb.gecomp.web.executers.iscrizioni;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.AtletaView;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.MessageSeverity;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;


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
