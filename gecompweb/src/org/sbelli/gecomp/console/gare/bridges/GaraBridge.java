package org.sbelli.gecomp.console.gare.bridges;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class GaraBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		Gara gara = (Gara) element;
		DbManagerFactory.getInstance().getGaraDao().delete(gara.getIdGara());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getGaraDao().insert((Gara) element);
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getGaraDao().update((Gara) element);
	}

	public Gara get(Long idGara) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getGaraDao().get(idGara);
	}

}
