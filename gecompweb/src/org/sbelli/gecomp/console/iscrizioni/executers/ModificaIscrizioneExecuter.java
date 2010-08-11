package org.sbelli.gecomp.console.iscrizioni.executers;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

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
		return super.salva();
	}
	
	public String elimina () {
		return GeCompOutcomes.ELIMINA_ISCRIZIONE;
	}
	
}
