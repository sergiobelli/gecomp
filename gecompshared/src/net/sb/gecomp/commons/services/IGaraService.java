package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Competizione;
import net.sb.gecomp.commons.model.Gara;

@WebService
public interface IGaraService extends IService<Gara> {
	
	List<Gara> list4Competizione (@WebParam(name="competizione") Competizione competizione) throws GeCompSrvException;
	
	Gara save(@WebParam(name="gara") Gara gara) throws GeCompSrvException;

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	Gara get(@WebParam(name="id") Long id) throws GeCompSrvException;
	
	List<Gara> list () throws GeCompSrvException;
	
}
