package net.sb.gecomp.srv.services.prestazioni;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.services.IPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.PrestazioneDao;

import org.apache.log4j.Logger;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IPrestazioneService", serviceName = "prestazioneService")
public class PrestazioneService implements IPrestazioneService {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private PrestazioneDao dao;
	public PrestazioneDao getDao() {return dao;}
	public void setDao(PrestazioneDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		throw new GeCompSrvException("NON IMPLEMENTATO!!!!");
	}

	public Prestazione get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	public Prestazione save(Prestazione prestazione) throws GeCompSrvException {
		if (Eval.isNotNull(prestazione.getIdPrestazione())) {
			getDao().update(prestazione);
			return prestazione;
		} else {
			return getDao().insert(prestazione);			
		}
	}

	public List<Prestazione> list4Gara(Gara gara) throws GeCompSrvException {
		List<Prestazione> result = getDao().list(gara);
		return result;
	}

	public List<Prestazione> list4Competizione(Competizione competizione) throws GeCompSrvException {
		List<Prestazione> result = getDao().list(competizione);
		return result;
	}
	
	public List<Prestazione> list4GaraCategoria(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompSrvException {
		List<Prestazione> result = null;
		if (conAssoluti) {
			result = getDao().list(gara, categoria);	
		} else {
			result = getDao().listSenzaAssoluti(gara, categoria);	
		}
		return result;
	}

	public Prestazione get4Iscrizione(Iscrizione iscrizione) throws GeCompSrvException {
		logger.info("Recupero prestazione associata all'iscrizione " + iscrizione);
		Prestazione result = getDao().get(iscrizione.getIdIscrizione());
		logger.info("prestazione associata all'iscrizione recuperata " + iscrizione);
		return result;
	}

	public List<Prestazione> list() throws GeCompSrvException {
		return getDao().list();
	}
	
}
