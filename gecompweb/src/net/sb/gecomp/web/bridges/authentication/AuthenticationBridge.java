package net.sb.gecomp.web.bridges.authentication;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.view.UserView;
import net.sb.gecomp.commons.services.IAuthenticationService;


public class AuthenticationBridge {

	private IAuthenticationService service;
	public IAuthenticationService getService() { return service; }
	public void setService(IAuthenticationService service) { this.service = service; }

	public final UserView login(String username, String password) throws GeCompException {
		//IAuthenticationService authenticationClient = (IAuthenticationService) GecompContextFactory.getContext().getBean("authenticationClient");
		return new UserView(getService().login(username, password));
	}
	
}
