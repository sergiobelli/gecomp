package net.sb.gecomp.srv.services.categorie;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.services.ICategoriaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CategoriaDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.ICategoriaService", serviceName = "categoriaService")
public class CategoriaService implements ICategoriaService {

	private CategoriaDao dao;
	public CategoriaDao getDao() {return dao;}
	public void setDao(CategoriaDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Categoria get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	public List<Categoria> list() throws GeCompSrvException {
		return getDao().list();
	}

	public Categoria save(Categoria object) throws GeCompSrvException {
		if (Eval.isNotNull(object.getIdCategoria())) {
			getDao().update(object);
			return object;
		} else {
			return getDao().insert(object);			
		}
	}

}
