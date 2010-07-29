package org.sbelli.gecomp.console.categorie.bridges;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.console.bridges.view.CategoriaView;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CategoriaBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getCategoriaDao().delete(((Categoria)element).getIdCategoria());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getCategoriaDao().insert((Categoria)element);	
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getCategoriaDao().update((Categoria)element);
	}

	public CategoriaView get(Long id) throws GeCompOrmException {
		return new CategoriaView(DbManagerFactory.getInstance().getCategoriaDao().get(id));
	}

	public List<CategoriaView> list(Gara gara) throws GeCompOrmException {
		List<CategoriaView> result = null;
		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaView>();
			for (Categoria c : categorie) {
				CategoriaView pw = new CategoriaView(c);
				result.add(pw);
			}
		}
		return result;
	}

}
