package net.sb.gecomp.srv.authentication;

import net.sb.gecomp.exceptions.GeCompSrvException;
import net.sb.gecomp.model.User;
import net.sb.gecomp.orm.dao.UserDao;
import net.sb.gecomp.utils.logger.GeCompLogger;


public class AuthenticationService implements IAuthenticationService {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	public User login(String username, String password) throws GeCompSrvException {
		logger.info("Start login operation for user ",username);

		User result = null;
		long before = System.currentTimeMillis();
		result = new UserDao().isAutheticated(username, password);
		long after = System.currentTimeMillis();
		
		logger.info("Login operation for user ",username,"] took time : ",(after - before),"ms");
		return result;
	}
	
}
