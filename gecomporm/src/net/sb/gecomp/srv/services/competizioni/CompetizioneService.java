package net.sb.gecomp.srv.services.competizioni;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.services.ICompetizioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CompetizioneDao;
import net.sb.gecomp.srv.services.GenericService;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ICompetizioneService", serviceName = "competizioneService")
public class CompetizioneService extends GenericService implements ICompetizioneService {

	public CompetizioneDao getDao() {return (CompetizioneDao) super.getDao();}
	public void setDao(CompetizioneDao dao) {super.setDao(dao);}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Competizione get(Long id) throws GeCompSrvException {
		return (Competizione) getDao().get(id);
	}

	public List<Competizione> list() throws GeCompSrvException {
		return getDao().list();
	}

	public Competizione save(Competizione object) throws GeCompSrvException {
		if (Eval.isNotNull(object.getIdCompetizione())) {
			getDao().update(object);
			return object;
		} else {
			return (Competizione) getDao().insert(object);			
		}
	}

}
