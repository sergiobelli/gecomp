package org.sbelli.gecomp.console.iscrizioni.executers;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;

/**
 * @author 71862
 */
public class ModificaIscrizioneExecuter extends IscrizioneExecuter {
	
	public String modificaIscrizione () {
		return "modificaIscrizione";
	}
	
	public void load (ActionEvent event) {
		idIscrizione = (Long) event.getComponent().getAttributes().get("idIscrizione");
		init ();
	}
	
	private void init () {
		try {
			setIscrizione(delegate.get(idIscrizione));
			setListaGareItem(getHelper().getListaGareItem(getSelectedCompetizione()));
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.ciupa.ko");
		}
	}
	
	public String salva() {
		logger.info("Modifica di una iscrizione in corso...");
		return super.salva();
	}
	
	public String elimina () {
		try {
			logger.info("Deleting iscrizione...");
			delegate.delete(getIscrizione());
			logger.info("Deleted iscrizione...");
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.eliminazione.ko.descrizione");
			return "null";
		}
		return "null";
	}
	
}
