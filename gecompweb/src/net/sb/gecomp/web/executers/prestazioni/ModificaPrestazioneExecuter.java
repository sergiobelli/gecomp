package net.sb.gecomp.web.executers.prestazioni;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

/**
 * @author 71862
 */
public class ModificaPrestazioneExecuter extends PrestazioneExecuter {
	
	public String modifica() {
		return "modificaPrestazione";
	}
	
	public void load (ActionEvent event) {
		idPrestazione = (Long) event.getComponent().getAttributes().get("idPrestazione");
		init ();
	}
	
	private void init () {
		try {
			setPrestazione(delegate.get(idPrestazione));
			setListaIscrittiItem(getHelper().getListaIscrittiItem(getSelectedGara()));
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.ciupa.ko");
		}
	}
	
	public String salva() {
		logger.info("Modifica di una prestazione in corso...");
		return super.salva();
	}
	
	public String elimina () {
		try {
			logger.info("Deleting prestazione...");
			delegate.delete(getPrestazione());
			logger.info("Deleted prestazione...");
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.iscrizione.eliminazione.ko.descrizione");
			return "null";
		}
		return "listaPrestazioni";
	}
	
}
