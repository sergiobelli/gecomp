package net.sb.gecomp.srv.services.authentication;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.User;
import net.sb.gecomp.commons.services.IAuthenticationService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.UserDao;

import org.apache.log4j.Logger;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IAuthenticationService", serviceName = "authenticationService")
public class AuthenticationService implements IAuthenticationService {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private UserDao dao;
	public UserDao getDao() {return dao;}
	public void setDao(UserDao dao) {this.dao = dao;}
	
	public User login(String username, String password) throws GeCompSrvException {
		logger.info("Start login operation for user " + username);

		User result = null;
		long before = System.currentTimeMillis();
		validate(username, password);
		result = getDao().isAutheticated(username, password);
		long after = System.currentTimeMillis();
		
		logger.info("Login operation for user "+username+"] took time : "+(after - before)+"ms");
		return result;
	}
	
	private static final String TO_BE_REMOVED_RECALLED = "XXX.parametri.richiesti.non.specificati.XXX";//TODO:ridefinire!!!
	private void validate(String username, String password) throws GeCompSrvException {
		if (Eval.isEmpty(username) || Eval.isEmpty(password)) {
			logger.error(TO_BE_REMOVED_RECALLED);
			throw new GeCompSrvException(TO_BE_REMOVED_RECALLED);
		}
	}
	
}
