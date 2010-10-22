package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.TipoMisura;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class TipoMisuraDao extends GenericDao implements IGeCompDao<TipoMisura> {

	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_TIPO_MISURA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public TipoMisura get (Long id) throws GeCompOrmException {
		try {
			return (TipoMisura) getDataBaseDao().queryForObject(GET_TIPO_MISURA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public TipoMisura insert (TipoMisura atleta) throws GeCompOrmException {
		try {
			return (TipoMisura) getDataBaseDao().insert(INSERT_TIPO_MISURA, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<TipoMisura> list () throws GeCompOrmException {
		try {
			return (List<TipoMisura>) getDataBaseDao().queryForList(LIST_TIPO_MISURA);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (TipoMisura atleta) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_TIPO_MISURA, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}	
		
}
