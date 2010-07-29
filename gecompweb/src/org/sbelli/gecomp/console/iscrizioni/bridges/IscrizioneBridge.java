package org.sbelli.gecomp.console.iscrizioni.bridges;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Iscrizione;

public class IscrizioneBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompOrmException {
		Iscrizione gara = (Iscrizione) element;
		DbManagerFactory.getInstance().getIscrizioneDao().delete(gara.getIdIscrizione());
	}

	public GecompModelObject insert(GecompModelObject element)
			throws GeCompOrmException {
		return DbManagerFactory.getInstance().getIscrizioneDao().insert((Iscrizione) element);
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		DbManagerFactory.getInstance().getIscrizioneDao().update((Iscrizione) element);
	}

	public Iscrizione get(Long id) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getIscrizioneDao().get(id);
	}

	public List<Iscrizione> list(Gara gara) throws GeCompOrmException {
		return DbManagerFactory.getInstance().getIscrizioneDao().list(gara);
	}
}
