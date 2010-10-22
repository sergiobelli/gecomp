package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;

@WebService
public interface ICompetizioneService extends IService<Competizione> {

	Competizione save(@WebParam(name="competizione") Competizione competizione) throws GeCompSrvException;

	Competizione get(@WebParam(name="id") Long id) throws GeCompSrvException;
	
	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;
	
	List<Competizione> list() throws GeCompSrvException; 
	
}
