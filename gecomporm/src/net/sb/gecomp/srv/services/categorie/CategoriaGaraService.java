package net.sb.gecomp.srv.services.categorie;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.services.ICategoriaGaraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CategoriaGaraDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class CategoriaGaraService implements ICategoriaGaraService {

	private final CategoriaGaraDao dao = DbManagerFactory.getInstance().getCategoriaGaraDao();
	
	public List<CategoriaGara> list(Gara gara) throws GeCompSrvException {
		return dao.list(gara);
	}

	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	public CategoriaGara get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public List<CategoriaGara> list() throws GeCompSrvException {
		return dao.list();
	}

	public CategoriaGara save(CategoriaGara object) throws GeCompSrvException {
		if (Eval.isNotNull(object.getIdCategoriaGara())) {
			dao.update(object);
			return object;
		} else {
			return dao.insert(object);			
		}
	}

}
