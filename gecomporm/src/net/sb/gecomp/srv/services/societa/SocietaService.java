package net.sb.gecomp.srv.services.societa;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.commons.services.ISocietaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.SocietaDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ISocietaService", serviceName = "societaService")
public class SocietaService implements ISocietaService {
	
	private SocietaDao dao;
	public SocietaDao getDao() {return dao;}
	public void setDao(SocietaDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Societa save(Societa societa) throws GeCompSrvException {
		if (Eval.isNotNull(societa.getId())) {
			getDao().update(societa);
			return societa;
		} else {
			return getDao().insert(societa);			
		}
	}

	public List<Societa> list() throws GeCompSrvException {
		List<Societa> result = getDao().list();
		return result;
	}

	public SocietaView get(Long idSocieta) throws GeCompSrvException {
		return new SocietaView(getDao().get(idSocieta));
	}
}
