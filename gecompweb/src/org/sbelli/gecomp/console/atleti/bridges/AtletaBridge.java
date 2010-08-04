package org.sbelli.gecomp.console.atleti.bridges;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.console.bridges.view.AtletaView;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class AtletaBridge extends GenericBridge {

	public GecompModelObject insert(GecompModelObject atleta) throws GeCompException {
		return DbManagerFactory.getInstance().getAtletaDao().insert((Atleta)atleta);
	}
	
	public void update(GecompModelObject atleta) throws GeCompException {
		DbManagerFactory.getInstance().getAtletaDao().update((Atleta)atleta);
	}
	
	public void delete(GecompModelObject atleta) throws GeCompException {
		DbManagerFactory.getInstance().getAtletaDao().delete(((Atleta)atleta).getIdAtleta());
	}

	public AtletaView get(Long id) throws GeCompException {
		return new AtletaView(DbManagerFactory.getInstance().getAtletaDao().get(id));
	}
	
}
