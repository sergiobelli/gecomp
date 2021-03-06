package net.sb.gecomp.web.delegates.authentication;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.model.view.UserView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.authentication.AuthenticationBridge;
import net.sb.gecomp.web.delegates.IGenericDelegate;
import net.sb.gecomp.web.delegates.properties.PropertiesDelegate;
import net.sb.gecomp.web.utils.context.GecompContextFactory;

import org.apache.log4j.Logger;


public class LoginDelegate implements IGenericDelegate {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private AuthenticationBridge bridge;
	public void setBridge(AuthenticationBridge bridge) { this.bridge = bridge; }

	public final UserView login(String username, String password) throws GeCompException {
		if (Eval.isNull(bridge)) {
			setBridge((AuthenticationBridge)GecompContextFactory.getContext().getBean("authenticationBridge"));
		}
		return new UserView(bridge.login(username, password));
	}

	public String getRefreshSessionOffset() throws GeCompException {
		return new PropertiesDelegate().get(PropertiesView.SESSION_OFFSET).getValore();
	}
	
}