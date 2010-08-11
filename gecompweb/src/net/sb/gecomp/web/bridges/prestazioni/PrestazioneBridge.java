package net.sb.gecomp.web.bridges.prestazioni;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.PrestazioneView;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Iscrizione;
import org.sbelli.gecomp.orm.model.Prestazione;

public class PrestazioneBridge extends GenericBridge {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	public void delete(final GecompModelObject element) throws GeCompException {
		throw new GeCompException("NON IMPLEMENTATO!!!!");
	}

	public GecompModelObject get(final Long id) throws GeCompException {
		return DbManagerFactory.getInstance().getPrestazioneDao().get(id);
	}

	public GecompModelObject insert(final GecompModelObject element) throws GeCompException {
		return DbManagerFactory.getInstance().getPrestazioneDao().insert((Prestazione)element);	
	}

	public void update(final GecompModelObject element) throws GeCompException {
		DbManagerFactory.getInstance().getPrestazioneDao().update((Prestazione) element);
	}

	public List<PrestazioneView> list(Gara gara) throws GeCompException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(gara);
//		List<Categoria> categorie = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);//FIXME:male,risolvere con FS#63
		if (Eval.isNotEmpty(prestazioni)) {
			result = new ArrayList<PrestazioneView>();
			int posizione = 1;
			for (Prestazione p : prestazioni) {
				PrestazioneView pw = new PrestazioneView(p, posizione++);
//				if (Eval.isEmpty(pw.getIscrizione().getGara().getCategorie())) {//FIXME:male,risolvere con FS#63
//					pw.getIscrizione().getGara().setCategorie(categorie);//FIXME:male,risolvere con FS#63
//				}//FIXME:male,risolvere con FS#63
				result.add(pw);
			}
		}
		return result;
	}

	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = null;
		if (conAssoluti) {
			prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().list(gara, categoria);	
		} else {
			prestazioni = DbManagerFactory.getInstance().getPrestazioneDao().listSenzaAssoluti(gara, categoria);	
		}
		
		if (Eval.isNotEmpty(prestazioni)) {
			result = new ArrayList<PrestazioneView>();
			int posizione = 1;
			for (Prestazione p : prestazioni) {
				PrestazioneView pw = new PrestazioneView(p, posizione++);
				result.add(pw);
			}
		}
		return result;
	}

	public PrestazioneView get(Iscrizione iscrizione) throws GeCompException {
		logger.info("Recupero prestazione associata all'iscrizione ", iscrizione);
		PrestazioneView result = null;
		
		Prestazione prestazione = DbManagerFactory.getInstance().getPrestazioneDao().get(iscrizione.getIdIscrizione());
		logger.debug("prestazione associata all'iscrizione recuperata ", iscrizione);
		if (Eval.isNotNull(prestazione)) {
			result = new PrestazioneView(prestazione);
		}
		
		logger.info("prestazione associata all'iscrizione recuperata ", iscrizione);
		return result;
	}

}
