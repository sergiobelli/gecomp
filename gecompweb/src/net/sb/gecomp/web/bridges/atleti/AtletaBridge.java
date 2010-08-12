package net.sb.gecomp.web.bridges.atleti;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.AtletaView;
import net.sb.gecomp.commons.services.IAtletaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.services.atleti.AtletaService;
import net.sb.gecomp.web.bridges.GenericBridge;


public class AtletaBridge extends GenericBridge  {

	private final IAtletaService service = new AtletaService();
	
	public GecompModelObject insert(GecompModelObject atleta) throws GeCompException {
		return service.save((Atleta)atleta);
	}
	
	public void update(GecompModelObject atleta) throws GeCompException {
		service.save((Atleta)atleta);
	}
	
	public void delete(GecompModelObject atleta) throws GeCompException {
		service.delete(((Atleta)atleta).getIdAtleta());
	}

	public AtletaView get(Long id) throws GeCompException {
		return new AtletaView(service.get(id));
	}

	public List<AtletaView> list() throws GeCompException {
		List<AtletaView> result = new ArrayList<AtletaView>();
		List<Atleta> o = service.list();
		if (Eval.isNotEmpty(o)) {
			for (Atleta atleta : o) {
				result.add(new AtletaView(atleta));
			}
		}
		return result;
	}
}
