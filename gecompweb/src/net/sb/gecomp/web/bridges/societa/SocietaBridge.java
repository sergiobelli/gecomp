package net.sb.gecomp.web.bridges.societa;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.commons.services.ISocietaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class SocietaBridge extends GenericBridge {

	private ISocietaService service;
	public ISocietaService getService() { return service; }
	public void setService(ISocietaService service) { this.service = service; }
	
	public void delete(GecompModelObject element) throws GeCompException {
		service.delete(((SocietaView)element).getId());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompException {
		return service.save((Societa)element);
	}

	public void update(GecompModelObject element) throws GeCompException {
		service.save((SocietaView)element);
	}

	public List<SocietaView> list() throws GeCompException {
		List<SocietaView> result = new ArrayList<SocietaView>();
		List<Societa> lista = service.list();
		if (Eval.isNotEmpty(lista)) {
			for (Societa s : lista) {
				result.add(new SocietaView(s));
			}
		}
		return result;
	}

	public SocietaView get(Long idSocieta) throws GeCompException {
		return new SocietaView(service.get(idSocieta));
	}

}
