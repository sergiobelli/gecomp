package net.sb.gecomp.web.delegates.societa;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.societa.SocietaBridge;
import net.sb.gecomp.web.controllers.societa.SocietaController;
import net.sb.gecomp.web.delegates.GenericDelegate;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class SocietaDelegate extends GenericDelegate {

	private SocietaController controller = new SocietaController();

	private SocietaBridge bridge;
	public SocietaBridge getBridge() {return (SocietaBridge)super.getBridge();}
	public void setBridge(SocietaBridge bridge) { this.bridge = bridge; }

	public List<SocietaView> list() throws GeCompException {
		List<SocietaView> lista = null;
		try {
			lista = getBridge().list();
		} catch (GeCompException e) {
			logger.error("errore in fase di reperimento della lista delle societa' ", e);
			throw e;
		}
		return lista;
	}
	
	public SocietaView retrieve(GecompModelObject element) throws GeCompException {
		SocietaView societa = (SocietaView) element;
		controller.checks(societa);
		return societa;
	}
	
	public void save(GecompModelObject element) throws GeCompException {
		SocietaView societa = null;
		try {
			societa = (SocietaView) retrieve(element);
			if (Eval.isNull(societa.getId())) {
				getBridge().insert(societa);
			} else {
				getBridge().update(societa);
			}
		} catch (GeCompException e) {
			logger.error("errore in fase di salvataggio della societa' "+societa+", ", e);
			throw e;
		}
	}

	public void delete (GecompModelObject element) throws GeCompException {
		SocietaView societa = null;
		try {
			societa = (SocietaView) element;
			logger.info("Deleting Societa " + societa);
			getBridge().delete(societa);
			logger.info("Deleted Societa " + societa);
		} catch (GeCompException ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.societa.eliminazione.ko");
			throw ex;
		}
	}

	public SocietaView get(Long idSocieta) throws GeCompException {
		return getBridge().get(idSocieta);
	}
	
}
