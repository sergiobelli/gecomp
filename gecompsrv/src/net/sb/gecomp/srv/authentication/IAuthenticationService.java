package net.sb.gecomp.srv.authentication;

import net.sb.gecomp.exceptions.GeCompSrvException;
import net.sb.gecomp.model.User;


public interface IAuthenticationService {

	User login(String username, String password) throws GeCompSrvException;

}