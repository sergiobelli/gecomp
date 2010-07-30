package org.sbelli.gecomp.console.iscrizioni.bridges;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.console.bridges.view.IscrizioneView;
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

	public IscrizioneView get(Long id) throws GeCompOrmException {
		return new IscrizioneView(DbManagerFactory.getInstance().getIscrizioneDao().get(id));
	}

	public List<IscrizioneView> list(Gara gara) throws GeCompOrmException {
		List<IscrizioneView> result = new ArrayList<IscrizioneView>();
		List<Iscrizione> iscritti = DbManagerFactory.getInstance().getIscrizioneDao().list(gara);
		if (Eval.isNotEmpty(iscritti)) {
			for (Iscrizione i : iscritti) {
				result.add(new IscrizioneView(i));
			}
		}
		return result;
	}
}
