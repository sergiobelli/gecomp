package net.sb.gecomp.web.bridges.categorie;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CategoriaGaraView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.GenericBridge;


public class CategoriaGaraBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getCategoriaGaraDao().delete(((CategoriaGara)element).getIdCategoriaGara());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getCategoriaGaraDao().insert((CategoriaGara)element);	
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getCategoriaGaraDao().update((CategoriaGara)element);
	}

	public CategoriaGaraView get(Long id) throws GeCompOrmException {
		return new CategoriaGaraView(DbManagerFactory.getInstance().getCategoriaGaraDao().get(id));
	}

	public List<CategoriaGaraView> list(Gara gara) throws GeCompOrmException {
		List<CategoriaGaraView> result = null;
		List<CategoriaGara> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().list(gara);
		if (Eval.isNotEmpty(categorie)) {
			result = new ArrayList<CategoriaGaraView>();
			for (CategoriaGara c : categorie) {
				CategoriaGaraView pw = new CategoriaGaraView(c);
				result.add(pw);
			}
		}
		return result;
	}
}
