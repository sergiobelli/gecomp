package net.sb.gecomp.web.bridges.tipimisure;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.model.view.TipoMisuraView;
import net.sb.gecomp.commons.model.view.TipoPrestazioneView;
import net.sb.gecomp.commons.services.ITipoMisuraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;

public class TipoMisuraBridge extends GenericBridge {

	public ITipoMisuraService getService() { return (ITipoMisuraService) super.getService(); }
	public void setService(ITipoMisuraService service) { super.setService(service); }
	
	public void delete(GecompModelObject tipoMisura) throws GeCompException {
		getService().delete(((TipoMisura) tipoMisura).getIdTipoMisura());
	}

	public TipoMisuraView insert(GecompModelObject tipoMisura) throws GeCompException {
		return (TipoMisuraView) getService().save((TipoMisura) tipoMisura);
	}

	public void update(GecompModelObject tipoMisura) throws GeCompException {
		getService().save((TipoMisura) tipoMisura);
	}

	public TipoMisuraView get(Long id) throws GeCompException {
		return new TipoMisuraView(getService().get(id));
	}

	public List<TipoMisuraView> list() throws GeCompException {
		List<TipoMisuraView> result = new ArrayList<TipoMisuraView>();
		List<TipoMisura> lista = getService().list();
		if (Eval.isNotEmpty(lista)) {
			for (TipoMisura element : lista) {
				result.add(new TipoMisuraView(element));
			}
		}
		return result;	
	}
}