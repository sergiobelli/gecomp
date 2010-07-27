package org.sbelli.gecomp.console.categorie.delegates;

import java.util.Calendar;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.console.categorie.bridges.CategoriaBridge;
import org.sbelli.gecomp.console.categorie.controllers.CategoriaController;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CategoriaDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private CategoriaController controller = new CategoriaController();
	private CategoriaBridge bridge = new CategoriaBridge();
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Categoria categoria = (Categoria)element;
		controller.checks(categoria);
		
		if (Eval.isNotNull(categoria)) {
			Calendar c = Calendar.getInstance();
			if (Eval.isNotNull(categoria.getAnnoFine())) {
				c.set(Integer.valueOf(categoria.getAnnoFine()), 11, 31);
				categoria.setFine(c.getTime());
			}
			if (Eval.isNotNull(categoria.getAnnoPartenza())) {
				c.set(Integer.valueOf(categoria.getAnnoPartenza()), 0, 1);
				categoria.setInizio(c.getTime());
			}
		}
		return categoria;
	}
	
	public void save(GecompModelObject element) throws GeCompException {		
		try {
			Categoria categoria = (Categoria)element;
			retrieve(categoria);
			logger.info("Saving/updating Categoria...");
			logger.debug("Customized Categoria = " + categoria);
					
			if (Eval.isNull(categoria.getIdCategoria())) {
				bridge.insert(categoria);	
			} else {
				bridge.update(categoria);
			}
			
			logger.info("Saved/update Categoria...");
		} catch (Exception ex) {
			logger.error(ex, "XXXXXXXXXXXX");
			throw new GeCompException("XXXXXXXXXXXX",ex);
		}
	}
	
	public void delete(GecompModelObject element) throws GeCompException {		
		try {
			Categoria categoria = (Categoria)element;
			bridge.delete(categoria);
		} catch (Exception ex) {
			logger.error(ex, "XXXXXXXXXXXX");
			throw new GeCompException("XXXXXXXXXXXX",ex);
		}
	}

	public CategoriaView get(Long id) throws GeCompException {
		return new CategoriaView(bridge.get(id));
	}

	public List<CategoriaView> list(Gara gara) throws GeCompException {
		try {
			return bridge.list(gara);
		} catch (Exception ex) {
			logger.error(ex, "XXXXXXXXXXXX");
			throw new GeCompException("XXXXXXXXXXXX",ex);
		}
	}
}
