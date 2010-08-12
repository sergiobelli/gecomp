package net.sb.gecomp.web.bridges.categorie;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.GenericBridge;


public class CategoriaBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompException {
		DbManagerFactory.getInstance().getCategoriaDao().delete(((Categoria)element).getIdCategoria());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompException {
		return DbManagerFactory.getInstance().getCategoriaDao().insert((Categoria)element);	
	}

	public void update(GecompModelObject element) throws GeCompException {
		DbManagerFactory.getInstance().getCategoriaDao().update((Categoria)element);
	}

	public CategoriaView get(Long id) throws GeCompException {
		return new CategoriaView(DbManagerFactory.getInstance().getCategoriaDao().get(id));
	}

	public List<CategoriaView> list() throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = new ArrayList<CategoriaView>();
		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaDao().list();
		logger.info("categorie = " + categorie);
		
		if (Eval.isNotEmpty(categorie)) {
			for (Categoria categoria : categorie) {
				result.add(new CategoriaView(categoria));
			}
		}
		logger.info("result = " + result);
		
		logger.info("end");
		return result;
	}
	public List<CategoriaView> list(Gara gara) throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = null;
		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);
		logger.info("categorie = " + categorie);
		
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaView>();
			for (Categoria c : categorie) {
				CategoriaView pw = new CategoriaView(c);
				result.add(pw);
			}
		}
		logger.info("result = " + result);

		logger.info("end");
		return result;
	}

}
