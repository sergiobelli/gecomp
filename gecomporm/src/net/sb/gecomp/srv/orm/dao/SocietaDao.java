package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManager;

import org.apache.log4j.Logger;


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
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	public void delete (Societa societa) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(DELETE_SOCIETA, societa.getId());
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());

		}
	}
	
	public Societa get (Long id) throws GeCompOrmException {
		try {
			return (Societa) getDataBaseDao().queryForObject(GET_SOCIETA, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public Societa insert (Societa societa) throws GeCompOrmException {
		try {
			return (Societa) getDataBaseDao().insert(INSERT_SOCIETA, societa);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<Societa> list () throws GeCompOrmException {
		try {
			return (List<Societa>) getDataBaseDao().queryForList(LIST_SOCIETA);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	public void update (Societa societa) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_SOCIETA, societa);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());	

}
