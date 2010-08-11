package net.sb.gecomp.web.delegates.categorie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.categorie.CategoriaBridge;
import net.sb.gecomp.web.bridges.view.CategoriaView;
import net.sb.gecomp.web.bridges.view.GaraView;
import net.sb.gecomp.web.controllers.categorie.CategoriaController;
import net.sb.gecomp.web.delegates.GenericDelegate;


public class CategoriaDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private CategoriaController controller = new CategoriaController();
	private CategoriaBridge bridge = new CategoriaBridge();
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		CategoriaView categoria = (CategoriaView)element;
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
			CategoriaView categoria = (CategoriaView)element;
			retrieve(categoria);
			logger.info("Saving/updating Categoria...");
			logger.debug("Customized Categoria = " + categoria);
					
			if (Eval.isNull(categoria.getIdCategoria())) {
				bridge.insert(categoria);	
			} else {
				bridge.update(categoria);
			}
			
			logger.info("Saved/update Categoria...");
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error(ex, "net.sb.gecomp.console.categorie.delegates.save.generic_error");
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.save.generic_error",ex);
		}
	}
	
	public void delete(GecompModelObject element) throws GeCompException {		
		try {
			CategoriaView categoria = (CategoriaView)element;
			bridge.delete(categoria);
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error(ex, "net.sb.gecomp.console.categorie.delegates.delete.generic_error");
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.delete.generic_error",ex);
		}
	}

	public CategoriaView get(Long id) throws GeCompException {
		return bridge.get(id);
	}

	public List<CategoriaView> list() throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = new ArrayList<CategoriaView>();
		try {
			result = bridge.list();
			logger.info("result = ", result);
			
			logger.info("end");
			return result;
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error(ex, "net.sb.gecomp.console.categorie.delegates.list.generic_error");
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.list.generic_error",ex);
		}
	}
	
	public List<CategoriaView> list(GaraView gara) throws GeCompException {
		try {
			return bridge.list(gara);
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error(ex, "net.sb.gecomp.console.categorie.delegates.list.generic_error");
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.list.generic_error",ex);
		}
	}
}
