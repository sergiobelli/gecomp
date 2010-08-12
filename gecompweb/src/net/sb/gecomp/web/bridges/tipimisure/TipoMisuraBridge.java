package net.sb.gecomp.web.bridges.tipimisure;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.services.ITipoMisuraService;
import net.sb.gecomp.srv.services.tipimisure.TipoMisuraService;
import net.sb.gecomp.web.bridges.GenericBridge;

public class TipoMisuraBridge extends GenericBridge {

	private final ITipoMisuraService service = new TipoMisuraService();
	
	public void delete(GecompModelObject tipoMisura) throws GeCompException {
		service.delete(((TipoMisura) tipoMisura).getIdTipoMisura());
	}

	public TipoMisura insert(GecompModelObject tipoMisura) throws GeCompException {
		return service.save((TipoMisura) tipoMisura);
	}

	public void update(GecompModelObject tipoMisura) throws GeCompException {
		service.save((TipoMisura) tipoMisura);
	}

	public TipoMisura get(Long id) throws GeCompException {
		TipoMisura gara = service.get(id);
		return gara;
	}

	public List<TipoMisura> list() throws GeCompException {
		return service.list();
	}
}