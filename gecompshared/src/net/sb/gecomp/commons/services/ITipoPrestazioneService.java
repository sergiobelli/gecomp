package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoPrestazione;

@WebService
public interface ITipoPrestazioneService /*extends IService<TipoPrestazione>*/ {

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	TipoPrestazione get(@WebParam(name="id") Long id) throws GeCompSrvException;

	List<TipoPrestazione> list() throws GeCompSrvException;

	TipoPrestazione save(@WebParam(name="tipoPrestazione") TipoPrestazione tipoPrestazione) throws GeCompSrvException;
	
}
