package org.sbelli.gecomp.console.categorie.bridges;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
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

	public Categoria get(Long id) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getCategoriaDao().get(id);
	}

}
