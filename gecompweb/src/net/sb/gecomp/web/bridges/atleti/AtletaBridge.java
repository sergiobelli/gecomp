package net.sb.gecomp.web.bridges.atleti;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.Atleta;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.AtletaView;


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
