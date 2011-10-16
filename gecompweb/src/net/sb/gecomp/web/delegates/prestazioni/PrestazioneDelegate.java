package net.sb.gecomp.web.delegates.prestazioni;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.PrestazioneView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.iscrizioni.IscrizioneBridge;
import net.sb.gecomp.web.bridges.prestazioni.PrestazioneBridge;
import net.sb.gecomp.web.bridges.tipimisure.TipoMisuraBridge;
import net.sb.gecomp.web.bridges.tipiprestazione.TipoPrestazioneBridge;
import net.sb.gecomp.web.controllers.prestazioni.PrestazioneController;
import net.sb.gecomp.web.delegates.GenericDelegate;


public class PrestazioneDelegate extends GenericDelegate {

	private PrestazioneController prestazioneController;
	public void setPrestazioneController(PrestazioneController controller) {this.prestazioneController = controller;}

	private PrestazioneBridge prestazioneBridge;
	public void setPrestazioneBridge(PrestazioneBridge bridge) {this.prestazioneBridge = bridge;}

	private IscrizioneBridge iscrizioneBridge;
	public void setIscrizioneBridge(IscrizioneBridge iscrizioneBridge) {this.iscrizioneBridge = iscrizioneBridge;}

	private TipoMisuraBridge tipoMisuraBridge;
	public void setTipoMisuraBridge(TipoMisuraBridge tipoMisuraBridge) {this.tipoMisuraBridge = tipoMisuraBridge;}

	private TipoPrestazioneBridge tipoPrestazioneBridge;
	public void setTipoPrestazione(TipoPrestazioneBridge tipoPrestazioneBridge) {this.tipoPrestazioneBridge = tipoPrestazioneBridge;}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Prestazione prestazione = (Prestazione) element;
		prestazioneController.checks(prestazione);
		
		prestazione.setIscrizione(iscrizioneBridge.get(prestazione.getIscrizione().getIdIscrizione()));
		prestazione.setTipoPrestazione(tipoPrestazioneBridge.get(prestazione.getTipoPrestazione().getIdTipoPrestazione()));
		prestazione.setTipoMisura(tipoMisuraBridge.get(prestazione.getTipoMisura().getIdTipoMisura()));
		return prestazione;
	}
	
	public void save(GecompModelObject element) throws GeCompException {
		Prestazione prestazione = (Prestazione) element;
		retrieve(prestazione);
		logger.debug("Customized Prestazione = " + prestazione);
		if (Eval.isNull(prestazione.getIdPrestazione())) {
			prestazioneBridge.insert(prestazione);
		} else {
			prestazioneBridge.update(prestazione);
		}
	}

	public void delete(GecompModelObject element) throws GeCompException {
		throw new GeCompException("NON IMPLEMENTATO!!!!");
	}

	public Prestazione get(Long id) throws GeCompException {
		return (Prestazione) prestazioneBridge.get(id);
	}

	public List<PrestazioneView> list(CompetizioneView competizione) throws GeCompException {
		try {
			return prestazioneBridge.list(competizione);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la competizione specificata " + competizione, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}	
	}

	public List<PrestazioneView> list(Gara gara, Categoria categoria) throws GeCompException {
		try {
			return prestazioneBridge.list(gara, categoria, true);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}
	}
	
	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompException {
		try {
			return prestazioneBridge.list(gara, categoria, conAssoluti);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}
	}

	public List<PrestazioneView> list(Gara gara) throws GeCompException {
		try {
			return prestazioneBridge.list(gara);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}	
	}
	
	public PrestazioneView get(Iscrizione iscrizione) throws GeCompException {
		try {
			return prestazioneBridge.get(iscrizione);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per l'iscrizione specificata " + iscrizione, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}
	}
}
