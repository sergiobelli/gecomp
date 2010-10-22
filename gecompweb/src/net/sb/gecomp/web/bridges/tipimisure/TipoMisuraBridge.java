package net.sb.gecomp.web.bridges.tipimisure;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.web.bridges.GenericBridge;

public class TipoMisuraBridge extends GenericBridge {

	public void delete(GecompModelObject tipoMisura) throws GeCompException {
		getService().delete(((TipoMisura) tipoMisura).getIdTipoMisura());
	}

	public TipoMisura insert(GecompModelObject tipoMisura) throws GeCompException {
		return (TipoMisura) getService().save((TipoMisura) tipoMisura);
	}

	public void update(GecompModelObject tipoMisura) throws GeCompException {
		getService().save((TipoMisura) tipoMisura);
	}

	public TipoMisura get(Long id) throws GeCompException {
		TipoMisura gara = (TipoMisura) getService().get(id);
		return gara;
	}

	public List<TipoMisura> list() throws GeCompException {
		return getService().list();
	}
}