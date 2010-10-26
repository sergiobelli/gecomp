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
import net.sb.gecomp.srv.services.GenericService;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IPrestazioneService", serviceName = "prestazioneService")
public class PrestazioneService extends GenericService implements IPrestazioneService {

	public PrestazioneDao getDao() {return (PrestazioneDao) super.getDao();}
	public void setDao(PrestazioneDao dao) {super.setDao(dao);}
	
	public void delete(Long id) throws GeCompSrvException {
		throw new GeCompSrvException("NON IMPLEMENTATO!!!!");
	}

	public Prestazione get(Long id) throws GeCompSrvException {
		return (Prestazione) getDao().get(id);
	}

	public Prestazione save(Prestazione prestazione) throws GeCompSrvException {
		if (Eval.isNotNull(prestazione.getIdPrestazione())) {
			getDao().update(prestazione);
			return prestazione;
		} else {
			return (Prestazione) getDao().insert(prestazione);			
		}
	}

	public List<Prestazione> list4Gara(Gara gara) throws GeCompSrvException {
		List<Prestazione> result = ((PrestazioneDao) getDao()).list(gara);
		return result;
	}

	public List<Prestazione> list4Competizione(Competizione competizione) throws GeCompSrvException {
		List<Prestazione> result = ((PrestazioneDao) getDao()).list(competizione);
		return result;
	}
	
	public List<Prestazione> list4GaraCategoria(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompSrvException {
		List<Prestazione> result = null;
		if (conAssoluti) {
			result = ((PrestazioneDao) getDao()).list(gara, categoria);	
		} else {
			result = ((PrestazioneDao) getDao()).listSenzaAssoluti(gara, categoria);	
		}
		return result;
	}

	public Prestazione get4Iscrizione(Iscrizione iscrizione) throws GeCompSrvException {
		logger.info("Recupero prestazione associata all'iscrizione " + iscrizione);
		Prestazione result = ((PrestazioneDao) getDao()).get(iscrizione.getIdIscrizione());
		logger.info("prestazione associata all'iscrizione recuperata " + iscrizione);
		return result;
	}

	public List<Prestazione> list() throws GeCompSrvException {
		return getDao().list();
	}
	
}
