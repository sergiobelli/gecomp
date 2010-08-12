package net.sb.gecomp.web.bridges.tipiprestazione;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.services.ITipoPrestazioneService;
import net.sb.gecomp.srv.services.tipiprestazione.TipoPrestazioneService;
import net.sb.gecomp.web.bridges.GenericBridge;

public class TipoPrestazioneBridge extends GenericBridge {

	private final ITipoPrestazioneService service = new TipoPrestazioneService();

	public void delete(GecompModelObject tipoPrestazione) throws GeCompException {
		service.delete(((TipoPrestazione) tipoPrestazione).getIdTipoPrestazione());
	}

	public GecompModelObject get(Long id) throws GeCompException {
		return service.get(id);
	}

	public GecompModelObject insert(GecompModelObject tipoPrestazione) throws GeCompException {
		return service.save((TipoPrestazione) tipoPrestazione);
	}

	public void update(GecompModelObject tipoPrestazione) throws GeCompException {
		service.save((TipoPrestazione) tipoPrestazione);
	}
	
	public List<TipoPrestazione> list() throws GeCompException {
		return service.list();
	}
}
