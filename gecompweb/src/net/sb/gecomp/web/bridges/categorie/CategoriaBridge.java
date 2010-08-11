package net.sb.gecomp.web.bridges.categorie;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.CategoriaView;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CategoriaBridge extends GenericBridge {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
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
		logger.info("categorie = ", categorie);
		
		if (Eval.isNotEmpty(categorie)) {
			for (Categoria categoria : categorie) {
				result.add(new CategoriaView(categoria));
			}
		}
		logger.info("result = ", result);
		
		logger.info("end");
		return result;
	}
	public List<CategoriaView> list(Gara gara) throws GeCompException {
		logger.info("start...");
		
		List<CategoriaView> result = null;
		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);
		logger.info("categorie = ", categorie);
		
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaView>();
			for (Categoria c : categorie) {
				CategoriaView pw = new CategoriaView(c);
				result.add(pw);
			}
		}
		logger.info("result = ", result);

		logger.info("end");
		return result;
	}

}
