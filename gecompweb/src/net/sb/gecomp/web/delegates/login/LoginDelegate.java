package net.sb.gecomp.web.delegates.login;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.login.UserBridge;
import net.sb.gecomp.web.bridges.view.PropertiesView;
import net.sb.gecomp.web.bridges.view.UserView;
import net.sb.gecomp.web.delegates.IGenericDelegate;
import net.sb.gecomp.web.delegates.properties.PropertiesDelegate;


public class LoginDelegate implements IGenericDelegate {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private UserBridge bridge = new UserBridge();
	
	public final UserView login(String username, String password) throws GeCompException {
		return new UserView(bridge.login(username, password));
	}

	public String getRefreshSessionOffset() throws GeCompException {
		return new PropertiesDelegate().get(PropertiesView.SESSION_OFFSET).getValore();
	}
	
}