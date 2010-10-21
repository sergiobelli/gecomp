package net.sb.gecomp.srv.services.tipiprestazione;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.services.ITipoPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.TipoPrestazioneDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ITipoPrestazioneService", serviceName = "tipoPrestazioneService")
public class TipoPrestazioneService implements ITipoPrestazioneService {

	private TipoPrestazioneDao dao;
	public TipoPrestazioneDao getDao() {return dao;}
	public void setDao(TipoPrestazioneDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public TipoPrestazione get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	public List<TipoPrestazione> list() throws GeCompSrvException {
		return getDao().list();
	}

	public TipoPrestazione save(TipoPrestazione tipoPrestazione) throws GeCompSrvException {
		if (Eval.isNotNull(tipoPrestazione.getIdTipoPrestazione())) {
			getDao().update(tipoPrestazione);
			return tipoPrestazione;
		} else {
			return getDao().insert(tipoPrestazione);			
		}
	}

	
}
