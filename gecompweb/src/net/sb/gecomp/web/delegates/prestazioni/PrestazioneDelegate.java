package net.sb.gecomp.web.delegates.prestazioni;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.model.view.PrestazioneView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.prestazioni.PrestazioneBridge;
import net.sb.gecomp.web.controllers.prestazioni.PrestazioneController;
import net.sb.gecomp.web.delegates.GenericDelegate;


public class PrestazioneDelegate extends GenericDelegate {

	private PrestazioneController controller = new PrestazioneController();
	private PrestazioneBridge bridge = new PrestazioneBridge(); 
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Prestazione prestazione = (Prestazione) element;
		controller.checks(prestazione);
		
		prestazione.setIscrizione(DbManagerFactory.getInstance().getIscrizioneDao().get(prestazione.getIscrizione().getIdIscrizione()));
		prestazione.setTipoPrestazione(DbManagerFactory.getInstance().getTipoPrestazioneDao().get(prestazione.getTipoPrestazione().getIdTipoPrestazione()));
		prestazione.setTipoMisura(DbManagerFactory.getInstance().getTipoMisuraDao().get(prestazione.getTipoMisura().getIdTipoMisura()));
		return prestazione;
	}
	
	public void save(GecompModelObject element) throws GeCompException {
		Prestazione prestazione = (Prestazione) element;
		retrieve(prestazione);
		logger.debug("Customized Prestazione = " + prestazione);
		if (Eval.isNull(prestazione.getIdPrestazione())) {
			bridge.insert(prestazione);
		} else {
			bridge.update(prestazione);
		}
	}

	public void delete(GecompModelObject element) throws GeCompException {
		throw new GeCompException("NON IMPLEMENTATO!!!!");
	}

	public Prestazione get(Long id) throws GeCompException {
		return (Prestazione) bridge.get(id);
	}

	public List<PrestazioneView> list(Gara gara) throws GeCompException {
		try {
			return bridge.list(gara);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}	
	}

	public List<PrestazioneView> list(Gara gara, Categoria categoria) throws GeCompException {
		try {
			return bridge.list(gara, categoria, true);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}
	}
	
	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompException {
		try {
			return bridge.list(gara, categoria, conAssoluti);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}
	}

	public PrestazioneView get(Iscrizione iscrizione) throws GeCompException {
		try {
			return bridge.get(iscrizione);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per l'iscrizione specificata " + iscrizione, ex);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}
	}
}
