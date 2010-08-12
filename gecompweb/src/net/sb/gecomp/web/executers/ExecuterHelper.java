package net.sb.gecomp.web.executers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.model.view.AtletaView;
import net.sb.gecomp.commons.model.view.CategoriaView;
import net.sb.gecomp.commons.model.view.CompetizioneView;
import net.sb.gecomp.commons.model.view.GaraView;
import net.sb.gecomp.commons.model.view.IscrizioneView;
import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.web.delegates.atleti.AtletaDelegate;
import net.sb.gecomp.web.delegates.categorie.CategoriaDelegate;
import net.sb.gecomp.web.delegates.gare.GaraDelegate;
import net.sb.gecomp.web.delegates.iscrizioni.IscrizioneDelegate;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;
import net.sb.gecomp.web.delegates.tipimisure.TipoMisuraDelegate;
import net.sb.gecomp.web.delegates.tipiprestazione.TipoPrestazioneDelegate;

import org.apache.log4j.Logger;


public class ExecuterHelper {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	public SelectItem[] getSessoItems() {
		SelectItem[] si = new SelectItem[2];
		si[0] = new SelectItem("M", "Maschio");
		si[1] = new SelectItem("F", "Femmina");
		return si;
	}

	public SelectItem[] getListaCategorieItem() {
		SelectItem[] listaCategorie = new SelectItem[0];
		try {
			List<CategoriaView> tmpCat;
			tmpCat = new CategoriaDelegate().list();
			int pos = 0;
			listaCategorie = new SelectItem[tmpCat.size()];
			for (Categoria soc : tmpCat) {
				listaCategorie[pos] = 
					new SelectItem(
							soc.getIdCategoria(), 
							" " + soc.getNomeCategoria() + ", " + soc.getSesso() + ", " + soc.getAnnoPartenza() + "-" + soc.getAnnoFine() + " ");
				pos++;
			}
		} catch (GeCompException ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaCategorie;
	}
	public SelectItem[] getListaCategorieItem(List<? extends Categoria> tmpCat) {
		SelectItem[] listaCategorie = new SelectItem[0];
		try {
			tmpCat = new CategoriaDelegate().list();
			int pos = 0;
			listaCategorie = new SelectItem[tmpCat.size()];
			for (Categoria soc : tmpCat) {
				listaCategorie[pos] = 
					new SelectItem(
							soc.getIdCategoria(), 
							" " + soc.getNomeCategoria() + ", " + soc.getSesso() + ", " + soc.getAnnoPartenza() + "-" + soc.getAnnoFine() + " ");
				pos++;
			}
		} catch (GeCompException ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaCategorie;
	}
	
	public SelectItem[] getListaSocietaItem() {
		SelectItem[] listaSocieta = new SelectItem[0];
		try {
			List<SocietaView> tmpSocieta = getListaSocieta();

			int pos = 0;
			listaSocieta = new SelectItem[tmpSocieta.size()];
			for (Societa soc : tmpSocieta) {
				listaSocieta[pos] = new SelectItem(soc.getId(), soc.getDenominazione());
				pos++;
			}

		} catch (Exception ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaSocieta;
	}
	public List<SocietaView> getListaSocieta() {
		try {
			return new SocietaDelegate().list();
		} catch (GeCompException e) {
			e.printStackTrace();
			return new ArrayList<SocietaView>();
		}
	}
	
	public SelectItem[] getListaGareItem() {
		SelectItem[] listaGare = new SelectItem[0];
		try {
			List<GaraView> gare = new GaraDelegate().list();

			int pos = 0;
			listaGare = new SelectItem[gare.size()];
			for (Gara g : gare) {
				listaGare[pos] = new SelectItem(g.getIdGara(), g.getNome());
				pos++;
			}

		} catch (GeCompException ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaGare;
	}
	
	public SelectItem[] getListaGareItem(CompetizioneView competizione) {
		SelectItem[] listaGare = new SelectItem[0];
		try {
			List<GaraView> gare = new GaraDelegate().list(competizione);

			int pos = 0;
			listaGare = new SelectItem[gare.size()];
			for (Gara g : gare) {
				listaGare[pos] = new SelectItem(g.getIdGara(), g.getNome());
				pos++;
			}

		} catch (GeCompException ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaGare;
	}
	
	public SelectItem[] getListaAtletiItem() {
		SelectItem[] listaAtleti = new SelectItem[0];
		try {
			List<AtletaView> atleti = getListaAtleti();

			int pos = 0;
			listaAtleti = new SelectItem[atleti.size()];
			for (Atleta a : atleti) {
				listaAtleti[pos] = new SelectItem(a.getIdAtleta(), a.getCognome() + " " + a.getNome());
				pos++;
			}

		} catch (Exception ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaAtleti;
	}
	public List<AtletaView> getListaAtleti() {
		try {
			return new AtletaDelegate().list();
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
			return new ArrayList<AtletaView>();
		}
	}
	
	public List<TipoPrestazione> getListaTipiPrestazione() {
		try {
			return new TipoPrestazioneDelegate().list();
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
			return new ArrayList<TipoPrestazione>();
		}
	}	
	public SelectItem[] getListaTipiPrestazioneItem () {
		SelectItem[] listaTipiPrestazione = new SelectItem[0];
		try {
			List<TipoPrestazione> tipiPrestazione = getListaTipiPrestazione();

			int pos = 0;
			listaTipiPrestazione = new SelectItem[tipiPrestazione.size()];
			for (TipoPrestazione a : tipiPrestazione) {
				listaTipiPrestazione[pos] = new SelectItem(a.getIdTipoPrestazione(), a.getDescrizione());
				pos++;
			}

		} catch (Exception ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaTipiPrestazione;
	}

	public List<IscrizioneView> getListaIscritti(GaraView selectedGara) {
		try {
			return new IscrizioneDelegate().list(selectedGara);
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
			return new ArrayList<IscrizioneView>();
		}
	}
	public SelectItem[] getListaIscrittiItem(GaraView selectedGara) {
		SelectItem[] listaIscritti = new SelectItem[0];
		try {
			List<IscrizioneView> iscrizioni = getListaIscritti(selectedGara);
			int pos = 0;
			listaIscritti = new SelectItem[iscrizioni.size()];
			for (Iscrizione a : iscrizioni) {
				listaIscritti[pos] = 
					new SelectItem(
							a.getIdIscrizione(), 
							a.getAtleta().getNominativo());
				pos++;
			}
		} catch (Exception ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaIscritti;
	}
	
	
	public List<TipoMisura> getListaTipiMisure() {
		try {
			return new TipoMisuraDelegate().list();
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
			return new ArrayList<TipoMisura>();
		}
	}
	public SelectItem[] getListaTipiMisureItem() {
		SelectItem[] listaIscritti = new SelectItem[0];
		try {
			List<TipoMisura> tipiPrestazione = getListaTipiMisure();
			int pos = 0;
			listaIscritti = new SelectItem[tipiPrestazione.size()];
			for (TipoMisura a : tipiPrestazione) {
				listaIscritti[pos] = new SelectItem(a.getIdTipoMisura(), a.getDescrizione() + " " + a.getUnitaMisura() + " " + a.getModalitaComparazione());
				pos++;
			}
		} catch (Exception ex) {
			GeCompExceptionManager.traceException(logger, ex);
		}
		return listaIscritti;
	}
	
}
