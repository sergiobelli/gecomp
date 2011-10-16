package net.sb.gecomp.web.executers.login;

import java.util.Calendar;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.UserView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.delegates.authentication.LoginDelegate;
import net.sb.gecomp.web.user.GeCompUserSessionHandler;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.apache.log4j.Logger;


/**
 * @author Sergio Belli
 */
public class DoLoginExecuter {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private LoginDelegate loginDelegate;
	public void setLoginDelegate(LoginDelegate loginDelegate) {
		this.loginDelegate = loginDelegate;
	}

	private String username;
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	private String password;
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	private final String LOGIN_DONE = "loginDone";
	private final String LOGIN_FAILED = "loginFailed";
	public String doLogin() {
		logger.info("Login operation started for user = " + getUsername());
		
		String result = LOGIN_FAILED;
		try {

			UserView loggedUser = loginDelegate.login(getUsername(), getPassword());
			if (Eval.isNotNull(loggedUser)) {
				logger.info("Utente loggato = "  + loggedUser);	
				result = LOGIN_DONE;
				
				GeCompUserSessionHandler.getGeCompUserSession().setLoggedUser(loggedUser);
				
				Calendar actualTime = Calendar.getInstance();
				actualTime.add(
						Calendar.MINUTE, 
						Integer.valueOf(loginDelegate.getRefreshSessionOffset()));
				GeCompUserSessionHandler.getGeCompUserHttpSession().setLoggedUser(loggedUser);
				GeCompUserSessionHandler.getGeCompUserHttpSession().setExpireDate(actualTime.getTime());
				
			} else {
				throw new GeCompException("error.login.ko");
			}
			
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.login.ko.descrizione");
		}
		
		logger.info("Login operation result = " + result);
		return result;
	}

}
