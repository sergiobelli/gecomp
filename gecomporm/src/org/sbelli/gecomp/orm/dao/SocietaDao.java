package org.sbelli.gecomp.orm.dao;

import java.util.List;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.model.Societa;

public class SocietaDao extends DbManager implements IGeCompDao<Societa> {

//	private static SocietaDao instance;
//	public static SocietaDao getInstance() {
//		if (instance == null) {
//			instance = new SocietaDao();
//		}
//		return instance;
//	}
	
	protected static final String GET_SOCIETA = "Societa.selectSocieta";
	
	protected static final String LIST_SOCIETA = "Societa.listSocieta";
	protected static final String INSERT_SOCIETA = "Societa.insertSocieta";
	
	protected static final String UPDATE_SOCIETA = "Societa.updateSocieta";
	protected static final String DELETE_SOCIETA = "Societa.deleteSocieta";
	
//	private SocietaDao() {}
	public void delete (Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_SOCIETA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	public void delete (Societa societa) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_SOCIETA, societa.getId());
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	
	public Societa get (Long id) throws GeCompOrmException {
		try {
			return (Societa) getDataBaseDao().queryForObject(GET_SOCIETA, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Societa insert (Societa societa) throws GeCompOrmException {
		try {
			return (Societa) getDataBaseDao().insert(INSERT_SOCIETA, societa);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Societa> list () throws GeCompOrmException {
		try {
			return (List<Societa>) getDataBaseDao().queryForList(LIST_SOCIETA);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Societa societa) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_SOCIETA, societa);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());	

}
