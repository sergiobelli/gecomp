package net.sb.gecomp.srv.services.atleti;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.services.IAtletaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.AtletaDao;
import net.sb.gecomp.srv.services.GenericService;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IAtletaService", serviceName = "atletaService")
public class AtletaService extends GenericService implements IAtletaService {

	public AtletaDao getDao() {return (AtletaDao) super.getDao();}
	public void setDao(AtletaDao dao) {super.setDao(dao);}

	public Atleta save(Atleta atleta) throws GeCompSrvException {
		if (Eval.isNotNull(atleta.getIdAtleta())) {
			getDao().update(atleta);
			return atleta;
		} else {
			return (Atleta) getDao().insert(atleta);
		}
	}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Atleta get(Long id) throws GeCompSrvException {
		return (Atleta)getDao().get(id);
	}

	public List<Atleta> list() throws GeCompSrvException {
		return getDao().list();
	}
	
}
