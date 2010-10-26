package net.sb.gecomp.web.bridges.gare;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.services.IGaraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class GaraBridge extends GenericBridge {
	
	public IGaraService getService() { return (IGaraService) super.getService(); }
	public void setService(IGaraService service) { super.setService(service); }
	
	public void delete(GecompModelObject gara) throws GeCompException {
		getService().delete(((GaraView) gara).getIdGara());
	}

	public GaraView insert(GecompModelObject element) throws GeCompException {
		return new GaraView((Gara)getService().save((Gara) element));
	}

	public void update(GecompModelObject element) throws GeCompException {
		getService().save((Gara) element);
	}

	public GaraView get(Long idGara) throws GeCompException {
		GaraView gara = new GaraView((Gara)getService().get(idGara));
		return gara;
	}

	public List<GaraView> list() throws GeCompException {
		List<GaraView> result = new ArrayList<GaraView>();
		List<Gara> gare = getService().list();
		if (Eval.isNotEmpty(gare)) {
			for (Gara gara : gare) {
				result.add(new GaraView(gara));
			}
		}
		return result;
	}
	
	public List<GaraView> list(CompetizioneView competizione) throws GeCompException {
		List<GaraView> result = new ArrayList<GaraView>();
		List<Gara> gare = ((IGaraService)getService()).list4Competizione(competizione);
		if (Eval.isNotEmpty(gare)) {
			for (Gara gara : gare) {
				result.add(new GaraView(gara));
			}
		}
		return result;
	}
}
