package net.sb.gecomp.web.executers.atleti;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class ModificaAtletaExecuter extends AtletaExecuter {
	
	private Long idAtleta;

	public ModificaAtletaExecuter () { }

	public void load (ActionEvent event) {
		idAtleta = (Long) event.getComponent().getAttributes().get("idAtleta");
		init ();
	}

	private void init () {
		try {
			setAtleta(delegate.get(idAtleta));
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.caricamento.ko");
		}
	}


	public String modifica () {
		return GeCompOutcomes.MODIFICA_ATLETA;
	}

	public String elimina () {
		try {
			logger.info("Deleting Atleta...");
			delegate.delete(getAtleta());
			logger.info("Deleted Atleta...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.eliminazione.ko");
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.LISTA_ATLETI;
	}

	public String salva() {
		logger.info("Modifica di un atleta in corso...");
		return super.salva();
	}	
}
