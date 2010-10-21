package net.sb.gecomp.srv.services.gara;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.services.IGaraService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.CategoriaGaraDao;
import net.sb.gecomp.srv.orm.dao.GaraDao;

/**
 * @author 71862
 * TODO : fare logging applicativo!!!!
 */
@WebService(endpointInterface = "net.sb.gecomp.commons.services.IGaraService", serviceName = "garaService")
public class GaraService implements IGaraService {

	private GaraDao dao;
	public GaraDao getDao() {return dao;}
	public void setDao(GaraDao dao) {this.dao = dao;}
	
	private CategoriaGaraDao categoriaGaraDao;
	public CategoriaGaraDao getCategoriaGaraDao() {return categoriaGaraDao;}
	public void setCategoriaGaraDao(CategoriaGaraDao categoriaGaraDao) {this.categoriaGaraDao = categoriaGaraDao;}
	
	public Gara save(Gara gara) throws GeCompSrvException {
		if (Eval.isNotNull(gara.getIdGara())) {
			getDao().update(gara);
			return gara;
		} else {
			return getDao().insert(gara);			
		}
	}

	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Gara get(Long idGara) throws GeCompSrvException {
		Gara gara = getDao().get(idGara);
		List<Categoria> categorie = getCategoriaGaraDao().listCategorie(gara);
		gara.setCategorie(categorie);
		return gara;
	}
	
	public List<Gara> list () throws GeCompSrvException {
		return getDao().list();
	}
	
	public List<Gara> list4Competizione (Competizione competizione) throws GeCompSrvException {
		return getDao().list(competizione);
	}
}
