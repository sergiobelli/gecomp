package org.sbelli.gecomp.orm.dao;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.model.TipoMisura;

public class TipoMisuraDao extends DbManager implements IGeCompDao<TipoMisura> {

	private final String GET = "TipoMisura.select";
	private final String LIST = "TipoMisura.list";
	private final String INSERT = "TipoMisura.insert";
	private final String UPDATE = "TipoMisura.update";
	private final String DELETE = "TipoMisura.delete";
	
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	public TipoMisura get (Long id) throws GeCompOrmException {
		try {
			return (TipoMisura) getDataBaseDao().queryForObject(GET, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public TipoMisura insert (TipoMisura atleta) throws GeCompOrmException {
		try {
			return (TipoMisura) getDataBaseDao().insert(INSERT, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<TipoMisura> list () throws GeCompOrmException {
		try {
			return (List<TipoMisura>) getDataBaseDao().queryForList(LIST);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (TipoMisura atleta) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE, atleta);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}	
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
}
