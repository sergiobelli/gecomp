package org.sbelli.gecomp.console.login.delegates;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.bridges.view.PropertiesView;
import org.sbelli.gecomp.console.bridges.view.UserView;
import org.sbelli.gecomp.console.delegates.IGenericDelegate;
import org.sbelli.gecomp.console.login.bridges.UserBridge;
import org.sbelli.gecomp.console.properties.delegates.PropertiesDelegate;

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