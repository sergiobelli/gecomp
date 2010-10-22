package net.sb.gecomp.web.bridges.iscrizioni;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.services.IIscrizioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class IscrizioneBridge extends GenericBridge {

	public void delete(GecompModelObject iscrizione) throws GeCompException {
		getService().delete(((Iscrizione) iscrizione).getIdIscrizione());
	}

	public GecompModelObject insert(GecompModelObject iscrizione) throws GeCompException {
		return getService().save((Iscrizione) iscrizione);
	}

	public void update(GecompModelObject iscrizione) throws GeCompException {
		getService().save((Iscrizione) iscrizione);
	}

	public IscrizioneView get(Long id) throws GeCompException {
		return new IscrizioneView((Iscrizione)getService().get(id));
	}

	public List<IscrizioneView> list(GaraView gara) throws GeCompException {
		List<IscrizioneView> result = new ArrayList<IscrizioneView>();
		List<Iscrizione> iscritti = ((IIscrizioneService)getService()).list4Gara(gara);
		if (Eval.isNotEmpty(iscritti)) {
			for (Iscrizione i : iscritti) {
				result.add(new IscrizioneView(i));
			}
		}
		return result;
	}
	
	public List<IscrizioneView> list(CompetizioneView competizione) throws GeCompException {
		List<IscrizioneView> result = new ArrayList<IscrizioneView>();
		List<Iscrizione> iscritti = ((IIscrizioneService)getService()).list4Competizione(competizione);
		if (Eval.isNotEmpty(iscritti)) {
			for (Iscrizione i : iscritti) {
				result.add(new IscrizioneView(i));
			}
		}
		return result;
	}
	
	public List<IscrizioneView> list() throws GeCompException {
		List<IscrizioneView> result = new ArrayList<IscrizioneView>();
		List<Iscrizione> iscritti = getService().list();
		if (Eval.isNotEmpty(iscritti)) {
			for (Iscrizione i : iscritti) {
				result.add(new IscrizioneView(i));
			}
		}
		return result;
	}
}
