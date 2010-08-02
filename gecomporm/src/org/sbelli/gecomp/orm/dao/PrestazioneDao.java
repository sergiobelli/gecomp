package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.joda.time.DateTime;
import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.model.TipoMisura;
import org.sbelli.gecomp.orm.model.TipoMisuraLancio;
import org.sbelli.gecomp.orm.model.TipoMisuraPosizione;
import org.sbelli.gecomp.orm.model.TipoMisuraSalto;
import org.sbelli.gecomp.orm.model.TipoMisuraTempo;

public class PrestazioneDao extends DbManager implements IGeCompDao<Prestazione> {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	private final String GET_PRESTAZIONE = "Prestazione.selectPrestazione";
	private final String LIST_PRESTAZIONE = "Prestazione.listPrestazione";
	private final String LIST_PRESTAZIONE_GARA = "Prestazione.listPrestazioneGara";
	private final String INSERT_PRESTAZIONE = "Prestazione.insertPrestazione";
	private final String UPDATE_PRESTAZIONE = "Prestazione.updatePrestazione";
	private final String DELETE_PRESTAZIONE = "Prestazione.deletePrestazione";
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_PRESTAZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public Prestazione get (Long id) throws GeCompOrmException {
		try {
			return (Prestazione) getDataBaseDao().queryForObject(GET_PRESTAZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Prestazione insert (Prestazione prestazione) throws GeCompOrmException {
		try {
			return (Prestazione) getDataBaseDao().insert(INSERT_PRESTAZIONE, prestazione);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Prestazione> list () throws GeCompOrmException {
		try {
			return gestioneLista((List<Prestazione>) getDataBaseDao().queryForList(LIST_PRESTAZIONE), null);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Prestazione prestazione) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_PRESTAZIONE, prestazione);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public List<Prestazione> list (Gara gara) throws GeCompOrmException {
		Set<Prestazione> prestazioniGara = null;
		try {
			List<Prestazione> listaPrestazioni = (List<Prestazione>) getDataBaseDao().queryForList(LIST_PRESTAZIONE_GARA, gara);
			prestazioniGara = new TreeSet<Prestazione>();
			prestazioniGara.addAll(listaPrestazioni);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}		
		return gestioneLista(new ArrayList<Prestazione>(prestazioniGara), gara);
	}

	public List<Prestazione> listSenzaAssoluti (Gara gara, Categoria categoria) throws GeCompOrmException {
		List<Prestazione> listaPrestazioniSenzaAssoluti = new ArrayList<Prestazione>();
		List<Prestazione> listaPrestazioniConAssoluti = list(gara);
		if (Eval.isNotEmpty(listaPrestazioniConAssoluti)) {
			int posizione = 1;
			for (Prestazione prestazione : listaPrestazioniConAssoluti) {
				if (prestazione.getIscrizione().getAtleta().getSesso().equals(categoria.getSesso())
						&& categoria.getAnniAppartenenza().contains(Integer.valueOf(prestazione.getIscrizione().getAtleta().getAnnoNascita()))
						&& posizione > gara.getNumeroAssoluti(categoria)) {
					listaPrestazioniSenzaAssoluti.add(prestazione);
				}
				posizione++;
			}
		}
		return gestioneLista(new ArrayList<Prestazione>(listaPrestazioniSenzaAssoluti), gara);
	}
	
	public List<Prestazione> list (Gara gara, Categoria categoria) throws GeCompOrmException {
		Set<Prestazione> prestazioniGaraCategoria = null;
		try {
			List<Prestazione> listaPrestazioni = (List<Prestazione>) getDataBaseDao().queryForList(LIST_PRESTAZIONE_GARA, gara);
			prestazioniGaraCategoria = new TreeSet<Prestazione>();
			
			for (Prestazione prestazione : listaPrestazioni) {
				if (categoria.getSesso().equals(prestazione.getIscrizione().getAtleta().getSesso())
						&& categoria.getAnniAppartenenza().contains(Integer.valueOf(prestazione.getIscrizione().getAtleta().getAnnoNascita()))) {
					prestazioniGaraCategoria.add(prestazione);
				}
			}
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		return gestioneLista(new ArrayList<Prestazione>(prestazioniGaraCategoria), gara);
	}
	public List<Prestazione> list (Competizione competizione) throws GeCompOrmException {
		List<Prestazione> prestazioniCompetizione = null;
		try {
			List<Prestazione> listaPrestazioni = (List<Prestazione>) getDataBaseDao().queryForList(LIST_PRESTAZIONE);
			prestazioniCompetizione = new ArrayList<Prestazione>();			
			for (Prestazione prestazione : listaPrestazioni) {
				if (prestazione.getIscrizione().getGara().getCompetizione().equals(competizione)) {
					prestazioniCompetizione.add(prestazione);
				}
			}
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}		
		return gestioneLista(prestazioniCompetizione, null);
	}
	public List<Prestazione> list (Competizione competizione, Categoria categoria) throws GeCompOrmException {
		Set<Prestazione> prestazioniCompetizione = null;
		try {
			List<Prestazione> listaPrestazioni = (List<Prestazione>) getDataBaseDao().queryForList(LIST_PRESTAZIONE);
			prestazioniCompetizione = new TreeSet<Prestazione>();
			for (Prestazione prestazione : listaPrestazioni) {
				if (prestazione.getIscrizione().getGara().getCompetizione().equals(competizione.getIdCompetizione())
						&& categoria.getSesso().equals(prestazione.getIscrizione().getAtleta().getSesso())
						&& categoria.getAnniAppartenenza().contains(
								Integer.valueOf(prestazione.getIscrizione().getAtleta().getAnnoNascita()))) {
					prestazioniCompetizione.add(prestazione);
				}
			}
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		return gestioneLista(new ArrayList<Prestazione>(prestazioniCompetizione), null);
	}
	
	public final String getTempo(long tempo) {
		StringBuffer s = new StringBuffer("");

		DateTime dt = new DateTime(tempo);
		s.append(dt.getHourOfDay() - 1).append("h ");
		s.append(dt.getMinuteOfHour()).append("' ");
		s.append(dt.getSecondOfMinute()).append("''");
		
		return s.toString();
	}
	
	private static final List<Prestazione> gestioneLista (List<Prestazione> lista, Gara gara) throws GeCompOrmException {
		if (Eval.isNotEmpty(lista)) {
			
			List<Categoria> categorieGara = null;
			if (Eval.isNotNull(gara)) {
				categorieGara = DbManagerFactory.getInstance().getCategoriaGaraDao().listCategorie(gara);	
			}
			
			for (Prestazione p : lista) {
				gestioneTipoMisura(p);
				if (Eval.isNotEmpty(categorieGara)) {
					gestioneCategorieGara(p, categorieGara);
				}
			}			
		}
		return lista;
	}

	private static final void gestioneCategorieGara(Prestazione prestazione, List<Categoria> categorieGara) {
		prestazione.getIscrizione().getGara().setCategorie(categorieGara);
	}

	private static void gestioneTipoMisura(Prestazione p) {
		if (TipoMisura.TIPO_MISURA_TEMPO.equals(p.getTipoMisura().getIdTipoMisura())) {
			p.setTipoMisura(new TipoMisuraTempo(p.getTipoMisura()));
		} else if (TipoMisura.TIPO_MISURA_POSIZIONE.equals(p.getTipoMisura().getIdTipoMisura())) {
			p.setTipoMisura(new TipoMisuraPosizione(p.getTipoMisura()));
		} else if (TipoMisura.TIPO_MISURA_LANCIO.equals(p.getTipoMisura().getIdTipoMisura())) {
			p.setTipoMisura(new TipoMisuraLancio(p.getTipoMisura()));
		} else if (TipoMisura.TIPO_MISURA_SALTO.equals(p.getTipoMisura().getIdTipoMisura())) {
			p.setTipoMisura(new TipoMisuraSalto(p.getTipoMisura()));
		}
	}	
}
