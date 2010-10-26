package net.sb.gecomp.web.bridges.atleti;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.AtletaView;
import net.sb.gecomp.commons.services.IAtletaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class AtletaBridge extends GenericBridge  {

	public IAtletaService getService() { return (IAtletaService) super.getService(); }
	public void setService(IAtletaService service) { super.setService(service); }

	public AtletaView insert(GecompModelObject atleta) throws GeCompException {
		return new AtletaView((Atleta)getService().save((Atleta)atleta));
	}
	
	public void update(GecompModelObject atleta) throws GeCompException {
		getService().save((Atleta)atleta);
	}
	
	public void delete(GecompModelObject atleta) throws GeCompException {
		getService().delete(((Atleta)atleta).getIdAtleta());
	}

	public AtletaView get(Long id) throws GeCompException {
		return new AtletaView((Atleta)getService().get(id));
	}

	public List<AtletaView> list() throws GeCompException {
		List<AtletaView> result = new ArrayList<AtletaView>();
		List<Atleta> o = getService().list();
		if (Eval.isNotEmpty(o)) {
			for (Atleta atleta : o) {
				result.add(new AtletaView(atleta));
			}
		}
		return result;
	}
}
