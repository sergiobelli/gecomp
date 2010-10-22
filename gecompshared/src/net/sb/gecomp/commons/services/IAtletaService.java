package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Atleta;

@WebService
public interface IAtletaService extends IService<Atleta> {

	Atleta save(@WebParam(name="atleta") Atleta atleta) throws GeCompSrvException;

	Atleta get(@WebParam(name="id") Long id) throws GeCompSrvException;

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;
	
	List<Atleta> list() throws GeCompSrvException;
	
}