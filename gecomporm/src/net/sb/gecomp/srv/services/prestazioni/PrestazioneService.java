package net.sb.gecomp.srv.services.prestazioni;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.services.IPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.PrestazioneDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

import org.apache.log4j.Logger;

public class PrestazioneService implements IPrestazioneService {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private final PrestazioneDao dao = DbManagerFactory.getInstance().getPrestazioneDao();
	
	public void delete(Long id) throws GeCompSrvException {
		throw new GeCompSrvException("NON IMPLEMENTATO!!!!");
	}

	public Prestazione get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public Prestazione save(Prestazione prestazione) throws GeCompSrvException {
		if (Eval.isNotNull(prestazione.getIdPrestazione())) {
			dao.update(prestazione);
			return prestazione;
		} else {
			return dao.insert(prestazione);			
		}
	}

	public List<Prestazione> list(Gara gara) throws GeCompSrvException {
		List<Prestazione> result = dao.list(gara);
		return result;
	}

	public List<Prestazione> list(Competizione competizione) throws GeCompSrvException {
		List<Prestazione> result = dao.list(competizione);
		return result;
	}
	
	public List<Prestazione> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompSrvException {
		List<Prestazione> result = null;
		if (conAssoluti) {
			result = dao.list(gara, categoria);	
		} else {
			result = dao.listSenzaAssoluti(gara, categoria);	
		}
		return result;
	}

	public Prestazione get(Iscrizione iscrizione) throws GeCompSrvException {
		logger.info("Recupero prestazione associata all'iscrizione " + iscrizione);
		Prestazione result = dao.get(iscrizione.getIdIscrizione());
		logger.info("prestazione associata all'iscrizione recuperata " + iscrizione);
		return result;
	}

	public List<Prestazione> list() throws GeCompSrvException {
		return dao.list();
	}
	
}
