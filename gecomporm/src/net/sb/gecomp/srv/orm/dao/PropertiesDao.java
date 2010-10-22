/**
 * 
 */
package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Properties;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


/**
 * 
 * @author S.BELLI
 *
 */
public class PropertiesDao extends GenericDao implements IGeCompDao<Properties> {

	/**
	 * 
	 */
	public void delete(Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(UPDATE_PROPERTIES, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
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
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param chiave
	 * @return
	 * @throws GeCompOrmException
	 */
	public Properties get(String chiave) throws GeCompOrmException {
	  for (Properties property : list()) {
	  	if (property.getChiave().equals(chiave)) {
	  		return property;
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
			GeCompExceptionManager.traceException(logger, e);
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
			GeCompExceptionManager.traceException(logger, e);
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
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

}
