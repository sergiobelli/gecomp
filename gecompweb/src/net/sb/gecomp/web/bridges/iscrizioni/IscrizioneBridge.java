package net.sb.gecomp.web.bridges.iscrizioni;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.model.Iscrizione;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.CompetizioneView;
import net.sb.gecomp.web.bridges.view.GaraView;
import net.sb.gecomp.web.bridges.view.IscrizioneView;


public class IscrizioneBridge extends GenericBridge {

	public void delete(GecompModelObject element) throws GeCompException {
		Iscrizione gara = (Iscrizione) element;
		DbManagerFactory.getInstance().getIscrizioneDao().delete(gara.getIdIscrizione());
	}

	public GecompModelObject insert(GecompModelObject element)
			throws GeCompException {
		return DbManagerFactory.getInstance().getIscrizioneDao().insert((Iscrizione) element);
	}

	public void update(GecompModelObject element) throws GeCompException {
		DbManagerFactory.getInstance().getIscrizioneDao().update((Iscrizione) element);
	}

	public IscrizioneView get(Long id) throws GeCompException {
		return new IscrizioneView(DbManagerFactory.getInstance().getIscrizioneDao().get(id));
	}

	public List<IscrizioneView> list(GaraView gara) throws GeCompException {
		List<IscrizioneView> result = new ArrayList<IscrizioneView>();
		List<Iscrizione> iscritti = DbManagerFactory.getInstance().getIscrizioneDao().list(gara);
		if (Eval.isNotEmpty(iscritti)) {
			for (Iscrizione i : iscritti) {
				result.add(new IscrizioneView(i));
			}
		}
		return result;
	}
	
	public List<IscrizioneView> list(CompetizioneView competizione) throws GeCompException {
		List<IscrizioneView> result = new ArrayList<IscrizioneView>();
		List<Iscrizione> iscritti = DbManagerFactory.getInstance().getIscrizioneDao().list(competizione);
		if (Eval.isNotEmpty(iscritti)) {
			for (Iscrizione i : iscritti) {
				result.add(new IscrizioneView(i));
			}
		}
		return result;
	}
}
