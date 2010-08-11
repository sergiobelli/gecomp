package net.sb.gecomp.web.bridges.categorie;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.CategoriaGaraView;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.CategoriaGara;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

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
