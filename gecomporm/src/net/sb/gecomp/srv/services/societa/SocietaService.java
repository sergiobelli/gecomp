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
	public void setDao(SocietaDao dao) {super.setDao(dao);}
	
	public void delete(Long id) throws GeCompSrvException {
		logger.info("Richiesta cancellazione della societa avente id " + id);
		getDao().delete(id);
		logger.info("Cancellazione della societa avente id " + id + " avvenuta con successo.");
	}

	public Societa save(Societa societa) throws GeCompSrvException {
		logger.info("Richiesto salvataggio della societa " + societa);
		Societa result = null;
		if (Eval.isNotNull(societa.getId())) {
			logger.debug("Si tratta di una modifica...");
			getDao().update(societa);
			result = societa;
		} else {
			logger.debug("Si tratta di un nuovo inserimento...");
			result = getDao().insert(societa);			
		}
		logger.info("Richiesto salvataggio della societa " + result + " effettuato con successo.");
		return result;
	}

	public List<Societa> list() throws GeCompSrvException {
		logger.info("Richiesto elenco delle societa.");
		List<Societa> result = getDao().list();
		logger.info("Elenco delle societa reperito avente cardinalita' " + (Eval.isNotEmpty(result) ? result.size() : "0"));
		return result;
	}

	public Societa get(Long id) throws GeCompSrvException {		
		logger.info("Richiesta societa avente id " + id);
		Societa result = null;
		result = getDao().get(id);
		logger.info("Societa reperita " + result);
		return result;
	}
}
