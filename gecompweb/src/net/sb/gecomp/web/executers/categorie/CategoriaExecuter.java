package net.sb.gecomp.web.executers.categorie;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.view.CategoriaView;
import net.sb.gecomp.web.delegates.categorie.CategoriaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class CategoriaExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
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
			return GeCompOutcomes.NULL;
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.categoria.salvataggio.ko");
			return GeCompOutcomes.NULL;
		}
		return GeCompOutcomes.LISTA_CATEGORIE;		
	}
	
}
