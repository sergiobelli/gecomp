package net.sb.gecomp.web.executers.iscrizioni;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.MessageSeverity;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;
import net.sb.gecomp.web.utils.guimessages.GuiMessageHandler;

/**
 * @author 71862
 */
public class ModificaIscrizioneExecuter extends IscrizioneExecuter {
	
	public String modifica () {
		return GeCompOutcomes.MODIFICA_ISCRIZIONE;
	}
	
	public void load (ActionEvent event) {
		idIscrizione = (Long) event.getComponent().getAttributes().get("idIscrizione");
		stato = (STATO) event.getComponent().getAttributes().get("stato");
		init ();
	}
	
	private void init () {
		try {
			setIscrizione(delegate.get(idIscrizione));
			setListaGareItem(getHelper().getListaGareItem(getSelectedCompetizione()));
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
		} catch (Exception e) {
			GeCompGuiExceptionManager.manageGUIException(logger, e, "net.sb.gecomp.console.iscrizioni.executers.generic_error");
		}
	}
	
	public String salva() {
		logger.info("Modifica di una iscrizione in corso...");
		String outcome = super.salva();
		if (!Eval.equalsIgnoreCase(outcome, GeCompOutcomes.FAIL)) {
			GuiMessageHandler.addGUIMessage(MessageSeverity.info, "message.info.success", "net.sb.gecomp.console.iscrizioni.executers.modifica.success");
		}
		return outcome;
	}
	
	public String elimina () {
		return GeCompOutcomes.ELIMINA_ISCRIZIONE;
	}
	
}
