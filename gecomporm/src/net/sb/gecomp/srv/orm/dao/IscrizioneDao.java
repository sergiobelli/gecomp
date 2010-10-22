package net.sb.gecomp.srv.orm.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class IscrizioneDao extends GenericDao implements IGeCompDao<Iscrizione> {

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
				throw new GeCompOrmException("net.sb.gecomp.srv.orm.dao.iscrizione.constraints.violation", e);	
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
		Set<Iscrizione> result = new TreeSet<Iscrizione>();
		try {
			logger.info("Richiesta lista di iscrizioni per la gara " + gara);
			
			if (Eval.isNotNull(gara)) {
				List<Iscrizione> listaIscrizioniGara = (List<Iscrizione>) getDataBaseDao().queryForList(LIST_ISCRIZIONE_GARA, gara.getIdGara());
				logger.debug("lista di iscrizioni reperita da db " + listaIscrizioniGara);
				
				if (Eval.isNotEmpty(listaIscrizioniGara)) {
					for (Iscrizione iscrizione : listaIscrizioniGara) {
						result.add(iscrizione);
					}
				}
			}
			
			logger.info("set di iscrizioni da restituire " + result);
			
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return new ArrayList<Iscrizione>(result);
	}
	
	public void update(Iscrizione object) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_ISCRIZIONE, object);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			if (e instanceof org.springframework.dao.DataIntegrityViolationException) {
				throw new GeCompOrmException("net.sb.gecomp.srv.orm.dao.iscrizione.constraints.violation", e);	
			} else {
				throw new GeCompOrmException(e.getMessage());
			}
		}
	}

}
