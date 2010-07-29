package org.sbelli.gecomp.console.societa.delegates;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.console.societa.bridges.SocietaBridge;
import org.sbelli.gecomp.console.societa.controllers.SocietaController;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Societa;

public class SocietaDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private SocietaController controller = new SocietaController();
	private SocietaBridge bridge = new SocietaBridge();
	
	public List<Societa> list() throws GeCompException {
		List<Societa> lista = null;
		try {
			lista = bridge.list();
		} catch (GeCompException e) {
			logger.error("errore in fase di reperimento della lista delle societa' ", e);
			throw e;
		}
		return lista;
	}
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Societa societa = (Societa) element;
		controller.checks(societa);
		return societa;
	}
	
	public void save(GecompModelObject element) throws GeCompException {
		Societa societa = null;
		try {
			societa = (Societa) retrieve(element);
			if (Eval.isNull(societa.getId())) {
				bridge.insert(societa);
			} else {
				bridge.update(societa);
			}
		} catch (GeCompException e) {
			logger.error("errore in fase di salvataggio della societa' "+societa+", ", e);
			throw e;
		}
	}

	public void delete (GecompModelObject element) throws GeCompException {
		Societa societa = null;
		try {
			societa = (Societa) element;
			logger.info("Deleting Societa " + societa);
			bridge.delete(societa);
			logger.info("Deleted Societa " + societa);
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.societa.eliminazione.ko");
			throw ex;
		}
	}

	public Societa get(Long idSocieta) throws GeCompException {
		return bridge.get(idSocieta);
	}		
	
}
