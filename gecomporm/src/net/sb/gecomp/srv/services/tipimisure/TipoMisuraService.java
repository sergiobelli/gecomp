package net.sb.gecomp.srv.services.tipimisure;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.services.ITipoMisuraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.TipoMisuraDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ITipoMisuraService", serviceName = "tipoMisuraService")
public class TipoMisuraService implements ITipoMisuraService {

	private TipoMisuraDao dao;
	public TipoMisuraDao getDao() {return dao;}
	public void setDao(TipoMisuraDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public TipoMisura get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	public TipoMisura save(TipoMisura tipoMisura) throws GeCompSrvException {
		if (Eval.isNotNull(tipoMisura.getIdTipoMisura())) {
			getDao().update(tipoMisura);
			return tipoMisura;
		} else {
			return getDao().insert(tipoMisura);			
		}
	}

	public List<TipoMisura> list() throws GeCompSrvException {
		return getDao().list();
	}

}
