package net.sb.gecomp.srv.services.authentication;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.User;
import net.sb.gecomp.commons.services.IAuthenticationService;
import net.sb.gecomp.srv.orm.dao.UserDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

import org.apache.log4j.Logger;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IAuthenticationService", serviceName = "aauthenticationService")
public class AuthenticationService implements IAuthenticationService {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private UserDao dao = DbManagerFactory.getInstance().getUserDao();

	public User login(String username, String password) throws GeCompSrvException {
		logger.info("Start login operation for user " + username);

		User result = null;
		long before = System.currentTimeMillis();
		result = dao.isAutheticated(username, password);
		long after = System.currentTimeMillis();
		
		logger.info("Login operation for user "+username+"] took time : "+(after - before)+"ms");
		return result;
	}
	
}
