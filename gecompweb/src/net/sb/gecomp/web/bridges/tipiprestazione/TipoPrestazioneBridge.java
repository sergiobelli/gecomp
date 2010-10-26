package net.sb.gecomp.web.bridges.tipiprestazione;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.model.view.TipoPrestazioneView;
import net.sb.gecomp.commons.services.ITipoPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;

public class TipoPrestazioneBridge extends GenericBridge {

	public ITipoPrestazioneService getService() { return (ITipoPrestazioneService) super.getService(); }
	public void setService(ITipoPrestazioneService service) { super.setService(service); }
	
	public void delete(GecompModelObject tipoPrestazione) throws GeCompException {
		getService().delete(((TipoPrestazione) tipoPrestazione).getIdTipoPrestazione());
	}

	public TipoPrestazioneView get(Long id) throws GeCompException {
		return new TipoPrestazioneView(getService().get(id));
	}

	public TipoPrestazione insert(GecompModelObject tipoPrestazione) throws GeCompException {
		return getService().save((TipoPrestazione) tipoPrestazione);
	}

	public void update(GecompModelObject tipoPrestazione) throws GeCompException {
		getService().save((TipoPrestazione) tipoPrestazione);
	}
	
	public List<TipoPrestazioneView> list() throws GeCompException {
		List<TipoPrestazioneView> result = new ArrayList<TipoPrestazioneView>();
		List<TipoPrestazione> lista = getService().list();
		if (Eval.isNotEmpty(lista)) {
			for (TipoPrestazione element : lista) {
				result.add(new TipoPrestazioneView(element));
			}
		}
		return result;	
	}
}
