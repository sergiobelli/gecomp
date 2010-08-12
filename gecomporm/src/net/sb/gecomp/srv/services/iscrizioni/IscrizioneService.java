package net.sb.gecomp.srv.services.iscrizioni;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.services.IIscrizioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.IscrizioneDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class IscrizioneService implements IIscrizioneService {

	private final IscrizioneDao dao = DbManagerFactory.getInstance().getIscrizioneDao();
	
	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.iscrizioni.IIscrizioneService#delete(net.sb.gecomp.commons.model.Iscrizione)
	 */
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.iscrizioni.IIscrizioneService#save(net.sb.gecomp.commons.model.Iscrizione)
	 */
	public Iscrizione save(Iscrizione iscrizione) throws GeCompSrvException {
		if (Eval.isNotNull(iscrizione.getIdIscrizione())) {
			dao.update(iscrizione);
			return iscrizione;
		} else {
			return dao.insert(iscrizione);
		}
	}

	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.iscrizioni.IIscrizioneService#get(java.lang.Long)
	 */
	public Iscrizione get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	
	public List<Iscrizione> list() throws GeCompSrvException {
		return dao.list();
	}

	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.iscrizioni.IIscrizioneService#list(net.sb.gecomp.commons.model.Gara)
	 */
	public List<Iscrizione> list(Gara gara) throws GeCompSrvException {
		List<Iscrizione> result = dao.list(gara);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see net.sb.gecomp.srv.services.iscrizioni.IIscrizioneService#list(net.sb.gecomp.commons.model.Competizione)
	 */
	public List<Iscrizione> list(Competizione competizione) throws GeCompSrvException {
		List<Iscrizione> result = dao.list(competizione);
		return result;
	}
	
}
