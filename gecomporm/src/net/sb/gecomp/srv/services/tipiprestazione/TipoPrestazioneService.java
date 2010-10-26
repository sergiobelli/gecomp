package net.sb.gecomp.srv.services.tipiprestazione;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.services.ITipoPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.TipoPrestazioneDao;
import net.sb.gecomp.srv.services.GenericService;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ITipoPrestazioneService", serviceName = "tipoPrestazioneService")
public class TipoPrestazioneService extends GenericService implements ITipoPrestazioneService {

	public TipoPrestazioneDao getDao() {return (TipoPrestazioneDao) super.getDao();}
	public void setDao(TipoPrestazioneDao dao) {super.setDao(dao);}
	
	public void delete(Long id) throws GeCompSrvException {
		logger.info("Richiesta cancellazione TipoPrestazione, id = " + id);
		getDao().delete(id);
		logger.info("Cancellazione TipoPrestazione, id = " + id + " effettuata.");
	}

	public TipoPrestazione get(Long id) throws GeCompSrvException {
		return (TipoPrestazione) getDao().get(id);
	}

	public List<TipoPrestazione> list() throws GeCompSrvException {
//		List<TipoPrestazione> result = null;
//		List<GecompModelObject> lista = getDao().list();
//		if (Eval.isNotEmpty(lista)) {
//			result = new ArrayList<TipoPrestazione>(); 
//			for (GecompModelObject gmo : lista) {
//				result.add((TipoPrestazione)gmo);
//			}
//		}
//		return result;
		return getDao().list();
	}

	public TipoPrestazione save(TipoPrestazione tipoPrestazione) throws GeCompSrvException {
		if (Eval.isNotNull(tipoPrestazione.getIdTipoPrestazione())) {
			getDao().update(tipoPrestazione);
			return tipoPrestazione;
		} else {
			return (TipoPrestazione) getDao().insert(tipoPrestazione);			
		}
	}

	
}
