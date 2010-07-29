package org.sbelli.gecomp.console.categorie.executers;

import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.categorie.delegates.CategoriaDelegate;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.orm.model.Categoria;

public class CategoriaExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected CategoriaDelegate delegate = new CategoriaDelegate();
	
	private Categoria categoria;
	public Categoria getCategoria() { return categoria; }
	public void setCategoria(Categoria categoria) { this.categoria = categoria; }
	
	public String salva() {		
		try {
			logger.info("Saving Categoria...");
			
			delegate.save(getCategoria());
			
			logger.info("Saved Categoria...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.salvataggio.ko");
			return "null";
		}
		return "listaCategorie";		
	}
	
}
