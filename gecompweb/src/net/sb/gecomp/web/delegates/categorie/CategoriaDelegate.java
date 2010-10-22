package net.sb.gecomp.web.delegates.categorie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.categorie.CategoriaBridge;
import net.sb.gecomp.web.controllers.categorie.CategoriaController;
import net.sb.gecomp.web.delegates.GenericDelegate;


public class CategoriaDelegate extends GenericDelegate {

	private CategoriaBridge bridge;
	public CategoriaBridge getBridge() {return (CategoriaBridge)super.getBridge();}
	public void setBridge(CategoriaBridge bridge) {this.bridge = bridge;}

	private CategoriaController controller;
	public CategoriaController getController() {return controller;}
	public void setController(CategoriaController controller) {this.controller = controller;}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		CategoriaView categoria = (CategoriaView)element;
		getController().checks(categoria);
		
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
				getBridge().insert(categoria);	
			} else {
				getBridge().update(categoria);
			}
			
			logger.info("Saved/update Categoria...");
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error("net.sb.gecomp.console.categorie.delegates.save.generic_error", ex);
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.save.generic_error",ex);
		}
	}
	
	public void delete(GecompModelObject element) throws GeCompException {		
		try {
			CategoriaView categoria = (CategoriaView)element;
			getBridge().delete(categoria);
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error("net.sb.gecomp.console.categorie.delegates.delete.generic_error", ex);
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.delete.generic_error",ex);
		}
	}

	public CategoriaView get(Long id) throws GeCompException {
		return getBridge().get(id);
	}

	public List<CategoriaView> list() throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = new ArrayList<CategoriaView>();
		try {
			result = getBridge().list();
			logger.info("result = "+ result);
			
			logger.info("end");
			return result;
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error("net.sb.gecomp.console.categorie.delegates.list.generic_error", ex);
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.list.generic_error",ex);
		}
	}
	
	public List<CategoriaView> list(GaraView gara) throws GeCompException {
		try {
			return getBridge().list(gara);
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error("net.sb.gecomp.console.categorie.delegates.list.generic_error", ex);
			throw new GeCompException("net.sb.gecomp.console.categorie.delegates.list.generic_error",ex);
		}
	}
}
