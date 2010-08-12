package net.sb.gecomp.srv.services.competizioni;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.services.ICompetizioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CompetizioneDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class CompetizioneService implements ICompetizioneService {

	private final CompetizioneDao dao = DbManagerFactory.getInstance().getCompetizioneDao();
	
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	public Competizione get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public List<Competizione> list() throws GeCompSrvException {
		return dao.list();
	}

	public Competizione save(Competizione object) throws GeCompSrvException {
		if (Eval.isNotNull(object.getIdCompetizione())) {
			dao.update(object);
			return object;
		} else {
			return dao.insert(object);			
		}
	}

}
