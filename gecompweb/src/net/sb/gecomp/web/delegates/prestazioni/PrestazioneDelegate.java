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
import net.sb.gecomp.web.utils.context.GecompContextFactory;


public class PrestazioneDelegate extends GenericDelegate {

	private PrestazioneController controller;
	public PrestazioneController getController() {return controller;}
	public void setController(PrestazioneController controller) {this.controller = controller;}

	private PrestazioneBridge bridge;
	public PrestazioneBridge getBridge() {return (PrestazioneBridge)super.getBridge();}
	public void setBridge(PrestazioneBridge bridge) {this.bridge = bridge;}

	private IscrizioneBridge iscrBridge;
	public IscrizioneBridge getIscrBridge() {
		if (Eval.isNull(iscrBridge)) {
			setIscrBridge((IscrizioneBridge)GecompContextFactory.getContext().getBean("iscrizioneBridge"));
		}
		return iscrBridge;
	}
	public void setIscrBridge(IscrizioneBridge iscrizioneBridge) {this.iscrBridge = iscrizioneBridge;}

	private TipoMisuraBridge tmBridge;
	public TipoMisuraBridge getTmBridge() {
		if (Eval.isNull(tmBridge)) {
			setTmBridge((TipoMisuraBridge)GecompContextFactory.getContext().getBean("tipoMisuraBridge"));
		}
		return tmBridge;
	}
	public void setTmBridge(TipoMisuraBridge tipoMisuraBridge) {this.tmBridge = tipoMisuraBridge;}

	private TipoPrestazioneBridge tpBridge;
	public TipoPrestazioneBridge getTpBridge() {
		if (Eval.isNull(tpBridge)) {
			setTpBridge((TipoPrestazioneBridge)GecompContextFactory.getContext().getBean("tipoPrestazioneBridge"));
		}
		return tpBridge;
	}
	public void setTpBridge(TipoPrestazioneBridge tipoPrestazioneBridge) {this.tpBridge = tipoPrestazioneBridge;}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Prestazione prestazione = (Prestazione) element;
		getController().checks(prestazione);
		
		prestazione.setIscrizione(getIscrBridge().get(prestazione.getIscrizione().getIdIscrizione()));
		prestazione.setTipoPrestazione(getTpBridge().get(prestazione.getTipoPrestazione().getIdTipoPrestazione()));
		prestazione.setTipoMisura(getTmBridge().get(prestazione.getTipoMisura().getIdTipoMisura()));
		return prestazione;
	}
	
	public void save(GecompModelObject element) throws GeCompException {
		Prestazione prestazione = (Prestazione) element;
		retrieve(prestazione);
		logger.debug("Customized Prestazione = " + prestazione);
		if (Eval.isNull(prestazione.getIdPrestazione())) {
			getBridge().insert(prestazione);
		} else {
			getBridge().update(prestazione);
		}
	}

	public void delete(GecompModelObject element) throws GeCompException {
		throw new GeCompException("NON IMPLEMENTATO!!!!");
	}

	public Prestazione get(Long id) throws GeCompException {
		return (Prestazione) getBridge().get(id);
	}

	public List<PrestazioneView> list(CompetizioneView competizione) throws GeCompException {
		try {
			return getBridge().list(competizione);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la competizione specificata " + competizione, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}	
	}

	public List<PrestazioneView> list(Gara gara, Categoria categoria) throws GeCompException {
		try {
			return getBridge().list(gara, categoria, true);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}
	}
	
	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompException {
		try {
			return getBridge().list(gara, categoria, conAssoluti);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}
	}

	public List<PrestazioneView> list(Gara gara) throws GeCompException {
		try {
			return getBridge().list(gara);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per la gara specificata " + gara, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}	
	}
	
	public PrestazioneView get(Iscrizione iscrizione) throws GeCompException {
		try {
			return getBridge().get(iscrizione);
		} catch (GeCompException ex) {
			logger.error("Non ci sono prestazioni per l'iscrizione specificata " + iscrizione, ex);
			throw new GeCompException("net.sb.gecomp.web.delegates.prestazioni.x.x.x.x.x.x.x.x.x");
		}
	}
}
