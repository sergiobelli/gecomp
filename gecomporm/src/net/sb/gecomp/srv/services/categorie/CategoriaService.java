package net.sb.gecomp.srv.services.categorie;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.services.ICategoriaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CategoriaDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class CategoriaService implements ICategoriaService {

	private final CategoriaDao categoriaDao = DbManagerFactory.getInstance().getCategoriaDao();
	
	public void delete(Long id) throws GeCompSrvException {
		categoriaDao.delete(id);
	}

	public Categoria get(Long id) throws GeCompSrvException {
		return categoriaDao.get(id);
	}

	public List<Categoria> list() throws GeCompSrvException {
		return categoriaDao.list();
	}

	public Categoria save(Categoria object) throws GeCompSrvException {
		if (Eval.isNotNull(object.getIdCategoria())) {
			categoriaDao.update(object);
			return object;
		} else {
			return categoriaDao.insert(object);			
		}
	}

}
