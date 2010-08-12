package net.sb.gecomp.web.executers.categorie;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.web.delegates.categorie.CategoriaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class CategoriaExecuter extends GenericExecuter {

	protected CategoriaDelegate delegate = new CategoriaDelegate();
	
	private CategoriaView categoria;
	public CategoriaView getCategoria() { return categoria; }
	public void setCategoria(CategoriaView categoria) { this.categoria = categoria; }
	
	public String salva() {		
		try {
			logger.info("Saving Categoria...");
			delegate.save(getCategoria());
			logger.info("Saved Categoria...");
		} catch (GeCompException gce) {
			GeCompGuiExceptionManager.manageGUIException(logger, gce, gce.getMessage());
			return GeCompOutcomes.FAIL;
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.categoria.salvataggio.ko");
			return GeCompOutcomes.FAIL;
		}
		return GeCompOutcomes.LISTA_CATEGORIE;		
	}
	
}
