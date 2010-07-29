package org.sbelli.gecomp.orm.dao;

import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.ibatis.DbManager;
import org.sbelli.gecomp.orm.model.User;

public class UserDao extends DbManager implements IGeCompDao<User> {

	protected static final String GET_USER = "User.selectUser";
	protected static final String LIST_USER = "User.listUser";
	protected static final String INSERT_USER = "User.insertUser";
	protected static final String UPDATE_USER = "User.updateUser";
	protected static final String DELETE_USER = "User.deleteUser";

	public void delete(Long id) throws GeCompOrmException {
		try {
			getDataBaseDao().delete(UPDATE_USER, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public User get(Long id) throws GeCompOrmException {
		try {
			return (User) getDataBaseDao().queryForObject(GET_USER, id);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public User insert(User object) throws GeCompOrmException {
		try {
			return (User) getDataBaseDao().insert(INSERT_USER, object);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public List<User> list() throws GeCompOrmException {
		try {
			return (List<User>) getDataBaseDao().queryForList(LIST_USER);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public void update(User object) throws GeCompOrmException {
		try {
			getDataBaseDao().update(UPDATE_USER, object);
		} catch (Exception e) {
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
	}

	public User isAutheticated(String username, String password) throws GeCompOrmException {
		logger.info("Start login operation for user ",username);
		
		long before = System.currentTimeMillis();
		User result = null;
		for (User user : list()) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				result = user;
			}
		}
		long after = System.currentTimeMillis();
		
		logger.info("Login operation for user ",username,"] took time : ",(after - before),"ms");
		return result;
	}

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

}
