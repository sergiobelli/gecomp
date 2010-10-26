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
	
	public ISocietaService getService() { return (ISocietaService) super.getService(); }
	public void setService(ISocietaService service) { super.setService(service); }
	
	public void delete(GecompModelObject element) throws GeCompException {
		getService().delete(((SocietaView)element).getId());
	}

	public SocietaView insert(GecompModelObject element) throws GeCompException {
		return new SocietaView((Societa)getService().save((Societa)element));
	}

	public void update(GecompModelObject element) throws GeCompException {
		getService().save((SocietaView)element);
	}

	public List<SocietaView> list() throws GeCompException {
		List<SocietaView> result = new ArrayList<SocietaView>();
		List<Societa> lista = getService().list();
		if (Eval.isNotEmpty(lista)) {
			for (Societa s : lista) {
				result.add(new SocietaView(s));
			}
		}
		return result;
	}

	public SocietaView get(Long idSocieta) throws GeCompException {
		return new SocietaView((Societa)getService().get(idSocieta));
	}

}
