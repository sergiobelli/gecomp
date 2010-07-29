package org.sbelli.gecomp.console.atleti.bridges;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class AtletaBridge extends GenericBridge {

	public GecompModelObject insert(GecompModelObject atleta) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getAtletaDao().insert((Atleta)atleta);
	}
	
	public void update(GecompModelObject atleta) throws GeCompOrmException {
		DbManagerFactory.getInstance().getAtletaDao().update((Atleta)atleta);
	}
	
	public void delete(GecompModelObject atleta) throws GeCompOrmException {
		DbManagerFactory.getInstance().getAtletaDao().delete(((Atleta)atleta).getIdAtleta());
	}

	public Atleta get(Long id) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getAtletaDao().get(id);
	}
	
}
