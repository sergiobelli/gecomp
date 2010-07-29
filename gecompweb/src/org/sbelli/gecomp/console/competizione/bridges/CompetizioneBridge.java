package org.sbelli.gecomp.console.competizione.bridges;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CompetizioneBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		Competizione competizione = (Competizione) element;
		DbManagerFactory.getInstance().getCompetizioneDao().delete(competizione.getIdCompetizione());
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getCompetizioneDao().insert((Competizione) element);
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getCompetizioneDao().update((Competizione) element);
	}

	public Competizione get(Long id) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getCompetizioneDao().get(id);
	}

}
