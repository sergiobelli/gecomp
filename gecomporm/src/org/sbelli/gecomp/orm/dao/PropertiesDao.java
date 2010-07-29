/**
 * 
 */
package org.sbelli.gecomp.orm.dao;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.model.Properties;

/**
 * 
 * @author S.BELLI
 *
 */
public class PropertiesDao extends DbManager implements IGeCompDao<Properties> {

	protected static final String GET_PROPERTIES = "Properties.selectProperties";
	protected static final String LIST_PROPERTIES = "Properties.listProperties";
	protected static final String INSERT_PROPERTIES = "Properties.insertProperties";
	protected static final String UPDATE_PROPERTIES = "Properties.updateProperties";
	protected static final String DELETE_PROPERTIES = "Properties.deleteProperties";
	
//	private static PropertiesDao instance;
//	private PropertiesDao() {}
//	public static PropertiesDao getInstance() {
//		if (instance == null) {
//			instance = new PropertiesDao();
//		}
//		return instance;
//	}
	
	/**
	 * 
	 */
	public void delete(Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(UPDATE_PROPERTIES, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public Properties get(Long id) throws GeCompOrmException {
		try {
			return (Properties) getDataBaseDao().queryForObject(GET_PROPERTIES, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param chiave
	 * @return
	 * @throws GeCompOrmException
	 */
	public String get(String chiave) throws GeCompOrmException {
	  for (Properties property : list()) {
	  	if (property.getChiave().equals(chiave)) {
	  		return property.getValore();
	  	}
	  }
	  return null;
  }
	
	/**
	 * 
	 */
	public Properties insert(Properties object) throws GeCompOrmException {
		try {
			return (Properties) getDataBaseDao().insert(INSERT_PROPERTIES, object);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public List<Properties> list() throws GeCompOrmException {
		try {
			return (List<Properties>) getDataBaseDao().queryForList(LIST_PROPERTIES);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void update(Properties object) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_PROPERTIES, object);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

}
