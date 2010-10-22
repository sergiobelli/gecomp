package net.sb.gecomp.srv.orm.dao;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.User;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class UserDao extends GenericDao implements IGeCompDao<User> {

	public void delete(Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(UPDATE_USER, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public User get(Long id) throws GeCompOrmException {
		try {
			return (User) getDataBaseDao().queryForObject(GET_USER, id);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public User insert(User object) throws GeCompOrmException {
		try {
			return (User) getDataBaseDao().insert(INSERT_USER, object);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<User> list() throws GeCompOrmException {
		try {
			return (List<User>) getDataBaseDao().queryForList(LIST_USER);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			
			//FS#80 - GUI Login : se ci sono eccezioni presentare un messaggio + leggibile
			if (e instanceof org.springframework.jdbc.CannotGetJdbcConnectionException) {
				throw new GeCompOrmException("net.sb.gecomp.srv.orm.dao.connection.exception");
			}
			//FS#80 - GUI Login : se ci sono eccezioni presentare un messaggio + leggibile
			
			else {
				throw new GeCompOrmException(e.getMessage());
			}
		}
	}

	public void update(User object) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_USER, object);
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public User isAutheticated(String username, String password) throws GeCompOrmException {
		logger.info("Start login operation for user " + username);
		
		long before = System.currentTimeMillis();
		User result = null;
		for (User user : list()) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				result = user;
				break;
			}
		}
		long after = System.currentTimeMillis();
		
		logger.info("Login operation for user "+username+"] took time : "+(after - before)+"ms");
		return result;
	}

}
