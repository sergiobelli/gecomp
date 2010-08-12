package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManager;

import org.apache.log4j.Logger;


public class TipoPrestazioneDao extends DbManager implements IGeCompDao<TipoPrestazione> {

	private final String GET = "TipoPrestazione.select";
	private final String LIST = "TipoPrestazione.list";
	private final String INSERT = "TipoPrestazione.insert";
	private final String UPDATE = "TipoPrestazione.update";
	private final String DELETE = "TipoPrestazione.delete";
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public TipoPrestazione get (Long id) throws GeCompOrmException {
		try {
			return (TipoPrestazione) getDataBaseDao().queryForObject(GET, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public TipoPrestazione insert (TipoPrestazione atleta) throws GeCompOrmException {
		try {
			return (TipoPrestazione) getDataBaseDao().insert(INSERT, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<TipoPrestazione> list () throws GeCompOrmException {
		try {
			return (List<TipoPrestazione>) getDataBaseDao().queryForList(LIST);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (TipoPrestazione atleta) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}	
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
}
