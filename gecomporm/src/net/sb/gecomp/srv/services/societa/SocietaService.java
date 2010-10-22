package net.sb.gecomp.srv.services.societa;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.services.ISocietaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.SocietaDao;
import net.sb.gecomp.srv.services.GenericService;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ISocietaService", serviceName = "societaService")
public class SocietaService extends GenericService implements ISocietaService {
	
	public SocietaDao getDao() {return (SocietaDao) super.getDao();}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Societa save(Societa societa) throws GeCompSrvException {
		if (Eval.isNotNull(societa.getId())) {
			((SocietaDao)getDao()).update(societa);
			return societa;
		} else {
			return (Societa) getDao().insert(societa);			
		}
	}

	public List<Societa> list() throws GeCompSrvException {
		List<Societa> result = getDao().list();
		return result;
	}

	public Societa get(Long idSocieta) throws GeCompSrvException {
		return (Societa) getDao().get(idSocieta);
	}
}
