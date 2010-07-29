package org.sbelli.gecomp.console.executers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Iscrizione;
import org.sbelli.gecomp.orm.model.Societa;
import org.sbelli.gecomp.orm.model.TipoMisura;
import org.sbelli.gecomp.orm.model.TipoPrestazione;

public class ExecuterHelper {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	public SelectItem[] getSessoItems() {
		SelectItem[] si = new SelectItem[2];
		si[0] = new SelectItem("M", "Maschio");
		si[1] = new SelectItem("F", "Femmina");
		return si;
	}

	public SelectItem[] getListaCategorieItem() {
		SelectItem[] listaCategorie = new SelectItem[0];
		try {
			List<Categoria> tmpCat;
			tmpCat = DbManagerFactory.getInstance().getCategoriaDao().list();
			int pos = 0;
			listaCategorie = new SelectItem[tmpCat.size()];
			for (Categoria soc : tmpCat) {
				listaCategorie[pos] = 
					new SelectItem(
							soc.getIdCategoria(), 
							" " + soc.getNomeCategoria() + ", " + soc.getSesso() + ", " + soc.getAnnoPartenza() + "-" + soc.getAnnoFine() + " ");
				pos++;
			}
		} catch (GeCompOrmException ex) {
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaCategorie;
	}
	public SelectItem[] getListaCategorieItem(List<? extends Categoria> tmpCat) {
		SelectItem[] listaCategorie = new SelectItem[0];
		try {
			tmpCat = DbManagerFactory.getInstance().getCategoriaDao().list();
			int pos = 0;
			listaCategorie = new SelectItem[tmpCat.size()];
			for (Categoria soc : tmpCat) {
				listaCategorie[pos] = 
					new SelectItem(
							soc.getIdCategoria(), 
							" " + soc.getNomeCategoria() + ", " + soc.getSesso() + ", " + soc.getAnnoPartenza() + "-" + soc.getAnnoFine() + " ");
				pos++;
			}
		} catch (GeCompOrmException ex) {
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaCategorie;
	}
	
	public SelectItem[] getListaSocietaItem() {
		SelectItem[] listaSocieta = new SelectItem[0];
		try {
			List<Societa> tmpSocieta = getListaSocieta();

			int pos = 0;
			listaSocieta = new SelectItem[tmpSocieta.size()];
			for (Societa soc : tmpSocieta) {
				listaSocieta[pos] = new SelectItem(soc.getId(), soc.getDenominazione());
				pos++;
			}

		} catch (Exception ex) {
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaSocieta;
	}
	public List<Societa> getListaSocieta() {
		try {
			return DbManagerFactory.getInstance().getSocietaDao().list();
		} catch (GeCompOrmException e) {
			e.printStackTrace();
			return new ArrayList<Societa>();
		}
	}
	
	public SelectItem[] getListaGareItem() {
		SelectItem[] listaGare = new SelectItem[0];
		try {
			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list();

			int pos = 0;
			listaGare = new SelectItem[gare.size()];
			for (Gara g : gare) {
				listaGare[pos] = new SelectItem(g.getIdGara(), g.getNome());
				pos++;
			}

		} catch (GeCompOrmException ex) {
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaGare;
	}
	
	public SelectItem[] getListaGareItem(Competizione competizione) {
		SelectItem[] listaGare = new SelectItem[0];
		try {
			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list(competizione);

			int pos = 0;
			listaGare = new SelectItem[gare.size()];
			for (Gara g : gare) {
				listaGare[pos] = new SelectItem(g.getIdGara(), g.getNome());
				pos++;
			}

		} catch (GeCompOrmException ex) {
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaGare;
	}
	
	public SelectItem[] getListaAtletiItem() {
		SelectItem[] listaAtleti = new SelectItem[0];
		try {
			List<Atleta> atleti = getListaAtleti();

			int pos = 0;
			listaAtleti = new SelectItem[atleti.size()];
			for (Atleta a : atleti) {
				listaAtleti[pos] = new SelectItem(a.getIdAtleta(), a.getCognome() + " " + a.getNome());
				pos++;
			}

		} catch (Exception ex) {
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaAtleti;
	}
	public List<Atleta> getListaAtleti() {
		try {
			return DbManagerFactory.getInstance().getAtletaDao().list();
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.manageException(logger, e);
			return new ArrayList<Atleta>();
		}
	}
	
	public List<TipoPrestazione> getListaTipiPrestazione() {
		try {
			return DbManagerFactory.getInstance().getTipoPrestazioneDao().list();
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.manageException(logger, e);
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
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaTipiPrestazione;
	}

	public List<Iscrizione> getListaIscritti(Gara selectedGara) {
		try {
			return DbManagerFactory.getInstance().getIscrizioneDao().list(selectedGara);
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.manageException(logger, e);
			return new ArrayList<Iscrizione>();
		}
	}
	public SelectItem[] getListaIscrittiItem(Gara selectedGara) {
		SelectItem[] listaIscritti = new SelectItem[0];
		try {
			List<Iscrizione> iscrizioni = getListaIscritti(selectedGara);
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
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaIscritti;
	}
	
	
	public List<TipoMisura> getListaTipiMisure() {
		try {
			return DbManagerFactory.getInstance().getTipoMisuraDao().list();
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.manageException(logger, e);
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
			GeCompExceptionManager.manageException(logger, ex);
		}
		return listaIscritti;
	}
	
}
