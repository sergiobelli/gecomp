package net.sb.gecomp.srv.services.categorie;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.services.ICategoriaGaraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CategoriaGaraDao;
import net.sb.gecomp.srv.services.GenericService;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ICategoriaGaraService", serviceName = "categoriaGaraService")
public class CategoriaGaraService extends GenericService implements ICategoriaGaraService {

	public CategoriaGaraDao getDao() {return (CategoriaGaraDao) super.getDao();}
	
	public List<CategoriaGara> list4Gara(Gara gara) throws GeCompSrvException {
		return ((CategoriaGaraDao)getDao()).list(gara);
	}

	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public CategoriaGara get(Long id) throws GeCompSrvException {
		return (CategoriaGara) getDao().get(id);
	}

	public List<CategoriaGara> list() throws GeCompSrvException {
		return getDao().list();
	}

	public CategoriaGara save(CategoriaGara object) throws GeCompSrvException {
		if (Eval.isNotNull(object.getIdCategoriaGara())) {
			getDao().update(object);
			return object;
		} else {
			return (CategoriaGara) getDao().insert(object);			
		}
	}

}
