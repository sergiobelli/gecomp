package net.sb.gecomp.srv.services.atleti;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.services.IAtletaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.AtletaDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class AtletaService implements IAtletaService {

	private final AtletaDao dao = DbManagerFactory.getInstance().getAtletaDao();
	
	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.atleti.IAtletaService#save(net.sb.gecomp.commons.model.Atleta)
	 */
	public Atleta save(Atleta atleta) throws GeCompSrvException {
		if (Eval.isNotNull(atleta.getIdAtleta())) {
			dao.update(atleta);
			return atleta;
		} else {
			return dao.insert(atleta);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.atleti.IAtletaService#delete(net.sb.gecomp.commons.model.Atleta)
	 */
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.atleti.IAtletaService#get(java.lang.Long)
	 */
	public Atleta get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public List<Atleta> list() throws GeCompSrvException {
		return dao.list();
	}
	
}
