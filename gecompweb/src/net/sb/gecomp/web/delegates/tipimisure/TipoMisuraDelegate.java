package net.sb.gecomp.web.delegates.tipimisure;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.web.bridges.tipimisure.TipoMisuraBridge;
import net.sb.gecomp.web.delegates.GenericDelegate;

public class TipoMisuraDelegate extends GenericDelegate {

	private TipoMisuraBridge 			bridge 			= new TipoMisuraBridge();
	
	public void delete(GecompModelObject element) throws GeCompException {
		bridge.delete((TipoMisura)element);
	}

	public GecompModelObject get(Long id) throws GeCompException {
		return bridge.get(id);
	}

	public GecompModelObject retrieve(GecompModelObject element)
			throws GeCompException {
		throw new GeCompException("not.implemented");
	}

	public void save(GecompModelObject element) throws GeCompException {
		throw new GeCompException("not.implemented");
	}

	public List<TipoMisura> list() throws GeCompException {
		return bridge.list();
	}
}
