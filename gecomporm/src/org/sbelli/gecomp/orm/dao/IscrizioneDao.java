package org.sbelli.gecomp.orm.dao;


import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Competizione;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Iscrizione;

public class IscrizioneDao extends DbManager implements IGeCompDao<Iscrizione> {

	private final String GET_ISCRIZIONE = "Iscrizione.selectIscrizione";
	private final String LIST_ISCRIZIONE = "Iscrizione.listIscrizione";
	private final String LIST_ISCRIZIONE_GARA = "Iscrizione.listIscrizioneGara";
	private final String LIST_ISCRIZIONE_COMPETIZIONE = "Iscrizione.listIscrizioneCompetizione";
	private final String INSERT_ISCRIZIONE = "Iscrizione.insertIscrizione";
	private final String UPDATE_ISCRIZIONE = "Iscrizione.updateIscrizione";
	private final String DELETE_ISCRIZIONE = "Iscrizione.deleteIscrizione";
	
	public void delete(Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_ISCRIZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public Iscrizione get(Long id) throws GeCompOrmException {
		try {
			return (Iscrizione) getDataBaseDao().queryForObject(GET_ISCRIZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public Iscrizione insert(Iscrizione object) throws GeCompOrmException {
		try {
			
//			Aggiunto constraint UNIQUE  KEY `GARA_PETTORALE_KEY` (`GARA`,`NUMERO_PETTORALE`)
//			List<Iscrizione> iscrizioni = list(((Iscrizione)object).getGara());
//			if (Eval.isNotEmpty(iscrizioni)) {
//				for (Iscrizione tmp : iscrizioni) {
//					if (tmp.getNumeroPettorale().equals(((Iscrizione)object).getNumeroPettorale())) {
//						throw new GeCompOrmException("xx.ss.ff.gg.numero.pettorale.gia.presente");
//					}
//				}
//			}
//			Aggiunto constraint UNIQUE  KEY `GARA_PETTORALE_KEY` (`GARA`,`NUMERO_PETTORALE`)
			
			return (Iscrizione) getDataBaseDao().insert(INSERT_ISCRIZIONE, object);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			if (e instanceof org.springframework.dao.DataIntegrityViolationException) {
				throw new GeCompOrmException("net.sb.gecomp.orm.dao.iscrizione.constraints.violation", e);	
			} else {
				throw new GeCompOrmException(e.getMessage());
			}
		}
	}

	public List<Iscrizione> list() throws GeCompOrmException {
		try {
			return (List<Iscrizione>) getDataBaseDao().queryForList(LIST_ISCRIZIONE);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Iscrizione> list (Competizione competizione) throws GeCompOrmException {//TODO:Ottimizzare
		List<Iscrizione> listaIscrizioniCompetizione = null;
		try {
			
			List<Gara> gare = DbManagerFactory.getInstance().getGaraDao().list(competizione);
			if (Eval.isNotNull(gare)) {
				listaIscrizioniCompetizione = new ArrayList<Iscrizione>();
				for (Gara g : gare) {
					listaIscrizioniCompetizione.addAll(this.list(g));
				}
			}
			
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return listaIscrizioniCompetizione;
	}
	
	public List<Iscrizione> list (Gara gara) throws GeCompOrmException {
		List<Iscrizione> listaIscrizioniGara = null;
		try {
			if (Eval.isNotNull(gara)) {
				listaIscrizioniGara = (List<Iscrizione>) getDataBaseDao().queryForList(LIST_ISCRIZIONE_GARA, gara.getIdGara());
			}
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return listaIscrizioniGara;
	}
	
	public void update(Iscrizione object) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_ISCRIZIONE, object);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			if (e instanceof org.springframework.dao.DataIntegrityViolationException) {
				throw new GeCompOrmException("net.sb.gecomp.orm.dao.iscrizione.constraints.violation", e);	
			} else {
				throw new GeCompOrmException(e.getMessage());
			}
		}
	}

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

}
