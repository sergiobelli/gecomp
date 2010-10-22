package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Societa;

@WebService
public interface ISocietaService extends IService<Societa> {

	Societa save(@WebParam(name="societa") Societa societa) throws GeCompSrvException;

	Societa get(@WebParam(name="id") Long id) throws GeCompSrvException;
	
	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;
	
	List<Societa> list() throws GeCompSrvException; 
	
}


