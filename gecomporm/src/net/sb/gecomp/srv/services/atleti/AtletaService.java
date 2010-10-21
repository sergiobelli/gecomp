package net.sb.gecomp.srv.services.atleti;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.services.IAtletaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.AtletaDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IAtletaService", serviceName = "atletaService")
public class AtletaService implements IAtletaService {

	private AtletaDao dao;
	public AtletaDao getDao() {return dao;}
	public void setDao(AtletaDao dao) {this.dao = dao;}
	
	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.atleti.IAtletaService#save(net.sb.gecomp.commons.model.Atleta)
	 */
	public Atleta save(Atleta atleta) throws GeCompSrvException {
		if (Eval.isNotNull(atleta.getIdAtleta())) {
			getDao().update(atleta);
			return atleta;
		} else {
			return getDao().insert(atleta);
		}
	}
	
	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.atleti.IAtletaService#delete(net.sb.gecomp.commons.model.Atleta)
	 */
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.atleti.IAtletaService#get(java.lang.Long)
	 */
	public Atleta get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	public List<Atleta> list() throws GeCompSrvException {
		return getDao().list();
	}
	
}
