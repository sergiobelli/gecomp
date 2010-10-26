package net.sb.gecomp.web.bridges.prestazioni;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.PrestazioneView;
import net.sb.gecomp.commons.services.IPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class PrestazioneBridge extends GenericBridge {

	public IPrestazioneService getService() { return (IPrestazioneService) super.getService(); }
	public void setService(IPrestazioneService service) { super.setService(service); }

	
	public void delete(final GecompModelObject element) throws GeCompException {
		getService().delete(((Prestazione)element).getIdPrestazione());
	}

	public PrestazioneView get(final Long id) throws GeCompException {
		return new PrestazioneView((Prestazione)getService().get(id));
	}

	public GecompModelObject insert(final GecompModelObject element) throws GeCompException {
		return new PrestazioneView((Prestazione)getService().save((Prestazione)element));	
	}

	public void update(final GecompModelObject element) throws GeCompException {
		getService().save((Prestazione) element);
	}

	public List<PrestazioneView> list(Gara gara) throws GeCompException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = ((IPrestazioneService)getService()).list4Gara(gara);
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

	public List<PrestazioneView> list(CompetizioneView competizione) throws GeCompException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = ((IPrestazioneService)getService()).list4Competizione(competizione);	
		
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
	
	public List<PrestazioneView> list(Gara gara, Categoria categoria, Boolean conAssoluti) throws GeCompException {
		List<PrestazioneView> result = null;
		List<Prestazione> prestazioni = ((IPrestazioneService)getService()).list4GaraCategoria(gara, categoria, conAssoluti);	
		
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
		logger.info("Recupero prestazione associata all'iscrizione " + iscrizione);
		PrestazioneView result = null;
		
		Prestazione prestazione = ((IPrestazioneService)getService()).get(iscrizione.getIdIscrizione());
		logger.debug("prestazione associata all'iscrizione recuperata " + iscrizione);
		if (Eval.isNotNull(prestazione)) {
			result = new PrestazioneView(prestazione);
		}
		
		logger.info("prestazione associata all'iscrizione recuperata " + iscrizione);
		return result;
	}
	
	public List<PrestazioneView> list() throws GeCompException {
		List<PrestazioneView> result = new ArrayList<PrestazioneView>();
		List<Prestazione> prestazioni = getService().list();
		if (Eval.isNotEmpty(prestazioni)) {
			for (Prestazione prestazione : prestazioni) {
				result.add(new PrestazioneView(prestazione));
			}
		}
		return result;
	}

}
