package net.sb.gecomp.web.executers.societa;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

public class ModificaSocietaExecuter extends SocietaExecuter {

	public String modifica () {
		return "modificaSocieta";
	}

	public void load (ActionEvent event) {
		idSocieta = (Long) event.getComponent().getAttributes().get("idSocieta");
		init ();
	}

	private void init () {
		try {
			setSocieta(delegate.get(idSocieta));
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.societa.caricamento.ko");
		}
	}

	public String salva() {
		try {
			logger.info("Updating Societa...");
			delegate.save(getSocieta());
			logger.info("Updating Societa...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.societa.modifica.ko");
			return "null";
		}
		return "listaSocieta";
	}

	public String elimina () {
		try {
			logger.info("Deleting Societa...");
			delegate.delete(getSocieta());
			logger.info("Deleted Societa...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.societa.eliminazione.ko");
			return "null";
		}
		return "listaSocieta";
	}

}
