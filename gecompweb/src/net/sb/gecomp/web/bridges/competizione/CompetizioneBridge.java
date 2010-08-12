package net.sb.gecomp.web.bridges.competizione;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.GenericBridge;


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

	public CompetizioneView get(Long id) throws GeCompOrmException {
		return new CompetizioneView(DbManagerFactory.getInstance().getCompetizioneDao().get(id));
	}

}
