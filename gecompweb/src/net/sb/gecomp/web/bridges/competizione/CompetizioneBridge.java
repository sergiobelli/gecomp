package net.sb.gecomp.web.bridges.competizione;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.services.ICompetizioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class CompetizioneBridge extends GenericBridge {

	private ICompetizioneService service;
	public ICompetizioneService getService() { return service; }
	public void setService(ICompetizioneService service) { this.service = service; }
	
	public void delete(GecompModelObject element) throws GeCompException {
		Competizione competizione = (Competizione) element;
		getService().delete(competizione.getIdCompetizione());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompException {
		return getService().save((Competizione) element);
	}

	public void update(GecompModelObject element) throws GeCompException {
		getService().save((Competizione) element);
	}

	public CompetizioneView get(Long id) throws GeCompException {
		return new CompetizioneView(getService().get(id));
	}
	
	public List<CompetizioneView> list() throws GeCompException {
		List<CompetizioneView> result = new ArrayList<CompetizioneView>();
		List<Competizione> competizioni = getService().list();
		if (Eval.isNotEmpty(competizioni)) {
			for (Competizione competizione : competizioni) {
				result.add(new CompetizioneView(competizione));
			}
		}
		return result;
	}

}
