package net.sb.gecomp.web.delegates.iscrizioni;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.model.view.PrestazioneView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.iscrizioni.IscrizioneBridge;
import net.sb.gecomp.web.controllers.iscrizioni.IscrizioneController;
import net.sb.gecomp.web.delegates.GenericDelegate;
import net.sb.gecomp.web.delegates.atleti.AtletaDelegate;
import net.sb.gecomp.web.delegates.gare.GaraDelegate;
import net.sb.gecomp.web.delegates.prestazioni.PrestazioneDelegate;


public class IscrizioneDelegate extends GenericDelegate {

	private IscrizioneController 	controller 	= new IscrizioneController();
	private IscrizioneBridge 		bridge 		= new IscrizioneBridge();

	public void delete(GecompModelObject element) throws GeCompException {
		try {
			Iscrizione iscrizione = (Iscrizione)element;
			logger.info("Inizio operazione di cancellazione dell'iscrizione "+ iscrizione);
			
			PrestazioneView prestazioneAssociata = new PrestazioneDelegate().get(iscrizione);
			if (Eval.isNotNull(prestazioneAssociata)) {
				logger.warn("Trovata una prestazione associata all'iscrizione " + prestazioneAssociata);
				throw new GeCompException("net.sb.gecomp.console.iscrizioni.delegates.delete.prestazione_associata");
			} else {
				logger.info("Si procede nell'eliminazione dell'iscrizione...");
				bridge.delete(iscrizione);			
			}
			logger.info("Eliminazione iscrizione eseguita con successo.");
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error("net.sb.gecomp.console.iscrizioni.delegates.delete.generic_error", ex);
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.delegates.delete.generic_error",ex);
		}
	}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Iscrizione iscrizione = (Iscrizione)element;
		controller.checks(element);
		
		iscrizione.setAtleta(new AtletaDelegate().get(iscrizione.getAtleta().getIdAtleta()));//recupero l'oggettone AtletaView
		iscrizione.setGara(new GaraDelegate().get(iscrizione.getGara().getIdGara()));//recupero l'oggettone GaraView
		
		return iscrizione;
	}

	public void save(GecompModelObject element) throws GeCompException {
		try {
			Iscrizione iscrizione = (Iscrizione) retrieve(element);
			logger.debug("Customized Iscrizione = " + iscrizione);
			if (Eval.isNull(iscrizione.getIdIscrizione())) {
				iscrizione = (Iscrizione)bridge.insert(iscrizione);
			} else {
				bridge.update(iscrizione);
			}
		} catch (GeCompException gce) {
			logger.error("Errore gestito", gce);
			throw gce;
		} catch (Exception ex) {
			logger.error("net.sb.gecomp.console.iscrizioni.delegates.save.generic_error", ex);
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.delegates.save.generic_error",ex);
		}
	}

	public IscrizioneView get(Long id) throws GeCompException {
		return bridge.get(id);
	}

	public List<IscrizioneView> list(GaraView gara) throws GeCompException {
		try {
			return bridge.list(gara);
		} catch (GeCompException ex) {
			logger.error("net.sb.gecomp.console.iscrizioni.delegates.generic_error " + gara, ex);
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.delegates.generic_error");
		}
	}
	
	public List<IscrizioneView> list(CompetizioneView competizione) throws GeCompException {
		try {
			return bridge.list(competizione);
		} catch (GeCompException ex) {
			logger.error("net.sb.gecomp.console.iscrizioni.delegates.generic_error " + competizione, ex);
			throw new GeCompException("net.sb.gecomp.console.iscrizioni.delegates.generic_error");
		}
	}
}
