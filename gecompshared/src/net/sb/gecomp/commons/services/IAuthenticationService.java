package net.sb.gecomp.commons.services;

//import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.User;

//@WebService
public interface IAuthenticationService {

	User login(String username, String password) throws GeCompSrvException;

}