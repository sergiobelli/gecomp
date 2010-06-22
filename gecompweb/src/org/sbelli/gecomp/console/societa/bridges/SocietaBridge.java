package org.sbelli.gecomp.console.societa.bridges;

import java.util.List;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Societa;

public class SocietaBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getSocietaDao().delete((Societa)element);
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getSocietaDao().insert((Societa)element);
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getSocietaDao().update((Societa)element);
	}

	public List<Societa> list() throws GeCompOrmException {
		return DbManagerFactory.getInstance().getSocietaDao().list();
	}

	public Societa get(Long idSocieta) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getSocietaDao().get(idSocieta);
	}

}
