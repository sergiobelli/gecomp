package org.sbelli.gecomp.console.atleti.executers;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class ModificaAtletaExecuter extends AtletaExecuter {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private Long idAtleta;

	public ModificaAtletaExecuter () { }

	public void load (ActionEvent event) {
		idAtleta = (Long) event.getComponent().getAttributes().get("idAtleta");
		init ();
	}

	private void init () {
		try {
			setAtleta(DbManagerFactory.getInstance().getAtletaDao().get(idAtleta));
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.caricamento.ko");
		}
	}


	public String modifica () {
		return "modificaAtleta";
	}

	public String elimina () {
		try {
			logger.info("Deleting Atleta...");
			delegate.delete(getAtleta());
			logger.info("Deleted Atleta...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.eliminazione.ko");
			return "null";
		}
		return "listaAtleti";
	}

	public String salva() {
		logger.info("Modifica di un atleta in corso...");
		return super.salva();
	}	
}
