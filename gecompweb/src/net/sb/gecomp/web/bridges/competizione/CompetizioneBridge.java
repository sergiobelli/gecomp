package net.sb.gecomp.web.bridges.competizione;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.Competizione;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.CompetizioneView;


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
