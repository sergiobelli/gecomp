package net.sb.gecomp.web.delegates.tipiprestazione;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.web.delegates.GenericDelegate;

public class TipoPrestazioneDelegate extends GenericDelegate {

	public void delete(GecompModelObject element) throws GeCompException {
		getBridge().delete((TipoPrestazione)element);
	}

	public GecompModelObject get(Long id) throws GeCompException {
		return getBridge().get(id);
	}

	public GecompModelObject retrieve(GecompModelObject element)
			throws GeCompException {
		throw new GeCompException("not.implemented");
	}

	public void save(GecompModelObject element) throws GeCompException {
		throw new GeCompException("not.implemented");
	}

	public List<TipoPrestazione> list() throws GeCompException {
		return getBridge().list();
	}
}
