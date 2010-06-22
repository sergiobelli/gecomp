package org.sbelli.gecomp.console.categorie.executers;

import javax.faces.event.ActionEvent;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class ModificaCategoriaExecuter extends CategoriaExecuter {

	private Long idCategoria;
	
	public ModificaCategoriaExecuter () { }

	public void load (ActionEvent event) {
		idCategoria = (Long) event.getComponent().getAttributes().get("idCategoria");
		init ();
	}

	private void init () {
		try {
			setCategoria(DbManagerFactory.getInstance().getCategoriaDao().get(idCategoria));			
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex,"error.atleta.caricamento.ko");
		}
	}


	public String modifica () {
		return "modificaCategoria";
	}

	public String elimina () {
		try {
			logger.info("Deleting Categoria...");
			delegate.delete(getCategoria());
			logger.info("Deleted Categoria...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.eliminazione.ko");
			return "null";
		}
		return "listaCategorie";
	}

}
