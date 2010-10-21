package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.CategoriaGara;
import net.sb.gecomp.commons.model.Gara;

@WebService
public interface ICategoriaGaraService /*extends IService<CategoriaGara>*/ {

	List<CategoriaGara> list4Gara(@WebParam(name="gara") Gara gara) throws GeCompSrvException;;

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	CategoriaGara get(@WebParam(name="id") Long id) throws GeCompSrvException;

	List<CategoriaGara> list() throws GeCompSrvException;

	CategoriaGara save(@WebParam(name="categoriaGara") CategoriaGara categoriaGara) throws GeCompSrvException;
	
}
