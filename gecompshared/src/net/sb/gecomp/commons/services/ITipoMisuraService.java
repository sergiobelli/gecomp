package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoMisura;

@WebService
public interface ITipoMisuraService extends IService<TipoMisura> {

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	TipoMisura get(@WebParam(name="id") Long id) throws GeCompSrvException;

	TipoMisura save(@WebParam(name="tipoMisura") TipoMisura tipoMisura) throws GeCompSrvException;

	List<TipoMisura> list() throws GeCompSrvException;
	
}
