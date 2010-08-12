package net.sb.gecomp.srv.services.tipimisure;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.services.ITipoMisuraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.TipoMisuraDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class TipoMisuraService implements ITipoMisuraService {

	private TipoMisuraDao dao = DbManagerFactory.getInstance().getTipoMisuraDao();
	
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	public TipoMisura get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public TipoMisura save(TipoMisura tipoMisura) throws GeCompSrvException {
		if (Eval.isNotNull(tipoMisura.getIdTipoMisura())) {
			dao.update(tipoMisura);
			return tipoMisura;
		} else {
			return dao.insert(tipoMisura);			
		}
	}

	public List<TipoMisura> list() throws GeCompSrvException {
		return dao.list();
	}

}
