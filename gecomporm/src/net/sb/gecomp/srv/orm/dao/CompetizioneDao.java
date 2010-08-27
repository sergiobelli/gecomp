package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManager;

import org.apache.log4j.Logger;


public class CompetizioneDao extends DbManager implements IGeCompDao<Competizione> {
	
	private final String GET_COMPETIZIONE = "Competizione.selectCompetizione";
	private final String LIST_COMPETIZIONE = "Competizione.listCompetizione";
	private final String INSERT_COMPETIZIONE = "Competizione.insertCompetizione";
	private final String UPDATE_COMPETIZIONE = "Competizione.updateCompetizione";
	private final String DELETE_COMPETIZIONE = "Competizione.deleteCompetizione";
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_COMPETIZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	
	public Competizione get (Long id) throws GeCompOrmException {
		try {
			return (Competizione) getDataBaseDao().queryForObject(GET_COMPETIZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Competizione insert (Competizione competizione) throws GeCompOrmException {
		try {
			return (Competizione) getDataBaseDao().insert(INSERT_COMPETIZIONE, competizione);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Competizione> list () throws GeCompOrmException {
		try {
			return (List<Competizione>) getDataBaseDao().queryForList(LIST_COMPETIZIONE);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Competizione competizione) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_COMPETIZIONE, competizione);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());

}