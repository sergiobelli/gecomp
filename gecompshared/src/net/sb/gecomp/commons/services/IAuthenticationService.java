package net.sb.gecomp.commons.services;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.User;

@WebService
public interface IAuthenticationService {

	User login(
			@WebParam(name="username") String username, 
			@WebParam(name="password") String password) 
		throws GeCompSrvException;

}