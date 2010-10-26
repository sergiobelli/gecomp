package net.sb.gecomp.web.delegates.tipimisure;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.model.view.TipoMisuraView;
import net.sb.gecomp.web.bridges.tipimisure.TipoMisuraBridge;
import net.sb.gecomp.web.delegates.GenericDelegate;

public class TipoMisuraDelegate extends GenericDelegate {

	public TipoMisuraBridge getBridge() { return (TipoMisuraBridge) super.getBridge(); }
	public void setBridge(TipoMisuraBridge bridge) { super.setBridge(bridge); }
	
	public void delete(GecompModelObject element) throws GeCompException {
		getBridge().delete((TipoMisura)element);
	}

	public TipoMisuraView get(Long id) throws GeCompException {
		return getBridge().get(id);
	}

	public GecompModelObject retrieve(GecompModelObject element)
			throws GeCompException {
		throw new GeCompException("not.implemented");
	}

	public void save(GecompModelObject element) throws GeCompException {
		throw new GeCompException("not.implemented");
	}

	public List<TipoMisuraView> list() throws GeCompException {
		return getBridge().list();
	}
}
