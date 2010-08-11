package net.sb.gecomp.web.delegates.prestazioni;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.prestazioni.PrestazioneBridge;
import net.sb.gecomp.web.bridges.view.PrestazioneView;
import net.sb.gecomp.web.controllers.prestazioni.PrestazioneController;
import net.sb.gecomp.web.delegates.GenericDelegate;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Iscrizione;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneDelegate extends GenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
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
			logger.error(ex, "Non ci sono prestazioni per la gara specificata ", gara);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}	
	}

	public List<PrestazioneView> list(Gara gara, Categoria categoria) throws GeCompException {
		try {
			return bridge.list(gara, categoria, true);
		} catch (GeCompException ex) {
			logger.error(ex, "Non ci sono prestazioni per la gara specificata ", gara);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}
	}
	
	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompException {
		try {
			return bridge.list(gara, categoria, conAssoluti);
		} catch (GeCompException ex) {
			logger.error(ex, "Non ci sono prestazioni per la gara specificata ", gara);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}
	}

	public PrestazioneView get(Iscrizione iscrizione) throws GeCompException {
		try {
			return bridge.get(iscrizione);
		} catch (GeCompException ex) {
			logger.error(ex, "Non ci sono prestazioni per l'iscrizione specificata ", iscrizione);
			throw new GeCompException("x.x.x.x.x.x.x.x.x");
		}
	}
}
