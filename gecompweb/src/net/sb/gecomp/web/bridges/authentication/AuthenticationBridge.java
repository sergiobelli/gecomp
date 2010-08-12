package net.sb.gecomp.web.bridges.authentication;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.UserView;
import net.sb.gecomp.commons.services.IAuthenticationService;
import net.sb.gecomp.srv.services.authentication.AuthenticationService;


public class AuthenticationBridge {

	private final IAuthenticationService service = new AuthenticationService();
	
	public final UserView login(String username, String password) throws GeCompException {
		return new UserView(service.login(username, password));
	}
	
}
