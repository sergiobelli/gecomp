package net.sb.gecomp.srv.services.gara;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.services.IGaraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CategoriaGaraDao;
import net.sb.gecomp.srv.orm.dao.GaraDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

/**
 * @author 71862
 * TODO : fare logging applicativo!!!!
 */
public class GaraService implements IGaraService {

	private final GaraDao 			garaDao 			= DbManagerFactory.getInstance().getGaraDao();
	private final CategoriaGaraDao 	categoriaGaraDao 	= DbManagerFactory.getInstance().getCategoriaGaraDao();
	
	public Gara save(Gara gara) throws GeCompSrvException {
		if (Eval.isNotNull(gara.getIdGara())) {
			garaDao.update(gara);
			return gara;
		} else {
			return garaDao.insert(gara);			
		}
	}

	public void delete(Long id) throws GeCompSrvException {
		garaDao.delete(id);
	}

	public Gara get(Long idGara) throws GeCompSrvException {
		Gara gara = garaDao.get(idGara);
		List<Categoria> categorie = categoriaGaraDao.listCategorie(gara);
		gara.setCategorie(categorie);
		return gara;
	}
	
	public List<Gara> list () throws GeCompSrvException {
		return garaDao.list();
	}
	
	public List<Gara> list (Competizione competizione) throws GeCompOrmException {
		return garaDao.list(competizione);
	}
}
