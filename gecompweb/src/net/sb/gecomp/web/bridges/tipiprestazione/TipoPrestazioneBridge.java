package net.sb.gecomp.web.bridges.tipiprestazione;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.web.bridges.GenericBridge;

public class TipoPrestazioneBridge extends GenericBridge {

	public void delete(GecompModelObject tipoPrestazione) throws GeCompException {
		getService().delete(((TipoPrestazione) tipoPrestazione).getIdTipoPrestazione());
	}

	public TipoPrestazione get(Long id) throws GeCompException {
		return (TipoPrestazione)getService().get(id);
	}

	public TipoPrestazione insert(GecompModelObject tipoPrestazione) throws GeCompException {
		return (TipoPrestazione) getService().save((TipoPrestazione) tipoPrestazione);
	}

	public void update(GecompModelObject tipoPrestazione) throws GeCompException {
		getService().save((TipoPrestazione) tipoPrestazione);
	}
	
	public List<TipoPrestazione> list() throws GeCompException {
		return getService().list();
	}
}
