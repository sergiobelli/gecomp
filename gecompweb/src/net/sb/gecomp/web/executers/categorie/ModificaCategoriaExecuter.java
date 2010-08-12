package net.sb.gecomp.web.executers.categorie;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class ModificaCategoriaExecuter extends CategoriaExecuter {

	private Long idCategoria;
	
	public ModificaCategoriaExecuter () { }

	public void load (ActionEvent event) {
		idCategoria = (Long) event.getComponent().getAttributes().get("idCategoria");
		init ();
	}

	private void init () {
		try {
			setCategoria(delegate.get(idCategoria));			
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.caricamento.ko");
		}
	}


	public String modifica () {
		return GeCompOutcomes.MODIFICA_CATEGORIA;
	}

	public String elimina () {
		try {
			logger.info("Deleting Categoria...");
			delegate.delete(getCategoria());
			logger.info("Deleted Categoria...");
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
			return GeCompOutcomes.FAIL;
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.eliminazione.ko");
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.LISTA_CATEGORIE;
	}

}
