package org.sbelli.gecomp.console.prestazioni.bridges;

import java.util.List;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneBridge extends GenericBridge {

	public void delete(final GecompModelObject element) throws GeCompOrmException {
		// TODO Auto-generated method stub

	}

	public GecompModelObject get(final Long id) throws GeCompOrmException {
		// TODO Auto-generated method stub
		return null;
	}

	public GecompModelObject insert(final GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getPrestazioneDao().insert((Prestazione)element);	
	}

	public void update(final GecompModelObject element) throws GeCompOrmException {
		// TODO Auto-generated method stub

	}

	public List<Prestazione> list(Gara gara) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getPrestazioneDao().list(gara);
	}

}
