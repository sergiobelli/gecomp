package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class TipoPrestazioneDao extends GenericDao implements IGeCompDao<TipoPrestazione> {

	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_TIPO_PRESTAZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public TipoPrestazione get (Long id) throws GeCompOrmException {
		try {
			return (TipoPrestazione) getDataBaseDao().queryForObject(GET_TIPO_PRESTAZIONE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public TipoPrestazione insert (TipoPrestazione atleta) throws GeCompOrmException {
		try {
			return (TipoPrestazione) getDataBaseDao().insert(INSERT_TIPO_PRESTAZIONE, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<TipoPrestazione> list () throws GeCompOrmException {
		try {
			return (List<TipoPrestazione>) getDataBaseDao().queryForList(LIST_TIPO_PRESTAZIONE);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (TipoPrestazione atleta) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_TIPO_PRESTAZIONE, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}	
		
}
