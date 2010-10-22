package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class GaraDao extends GenericDao implements IGeCompDao<Gara> {
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	
	public Gara get (Long id) throws GeCompOrmException {
		try {
			return (Gara) getDataBaseDao().queryForObject(GET_GARA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Gara insert (Gara gara) throws GeCompOrmException {
		try {
			Long id = (Long) getDataBaseDao().insert(INSERT_GARA, gara);
			return gara;
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Gara> list () throws GeCompOrmException {
		try {
			return (List<Gara>) getDataBaseDao().queryForList(LIST_GARA);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public List<Gara> list (Competizione competizione) throws GeCompOrmException {
		List<Gara> listaGareCompetizione = null;
		try {
//			List<Gara> listaGare = (List<Gara>) getDataBaseDao().queryForList(LIST_GARA);
//			listaGareCompetizione = new ArrayList<Gara>();
//			
//			for (Gara gara : listaGare) {
//				if (gara.getCompetizione().getIdCompetizione() == competizione.getIdCompetizione()) {
//					listaGareCompetizione.add(gara);
//				}
//			}

			listaGareCompetizione = (List<Gara>) getDataBaseDao().queryForList(LIST_GARA_COMPETIZIONE, competizione);
			
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return listaGareCompetizione;
	}
	public void update (Gara gara) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_GARA, gara);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
		
}
