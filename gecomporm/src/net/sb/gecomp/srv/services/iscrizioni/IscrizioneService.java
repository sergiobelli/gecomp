package net.sb.gecomp.srv.services.iscrizioni;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.services.IIscrizioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.IscrizioneDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IIscrizioneService", serviceName = "iscrizioneService")
public class IscrizioneService implements IIscrizioneService {

	private IscrizioneDao dao;
	public IscrizioneDao getDao() {return dao;}
	public void setDao(IscrizioneDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Iscrizione save(Iscrizione iscrizione) throws GeCompSrvException {
		if (Eval.isNotNull(iscrizione.getIdIscrizione())) {
			getDao().update(iscrizione);
			return iscrizione;
		} else {
			return getDao().insert(iscrizione);
		}
	}

	public Iscrizione get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	
	public List<Iscrizione> list() throws GeCompSrvException {
		return getDao().list();
	}

	public List<Iscrizione> list4Gara(Gara gara) throws GeCompSrvException {
		List<Iscrizione> result = getDao().list(gara);
		return result;
	}
	
	public List<Iscrizione> list4Competizione(Competizione competizione) throws GeCompSrvException {
		List<Iscrizione> result = getDao().list(competizione);
		return result;
	}
	
}
