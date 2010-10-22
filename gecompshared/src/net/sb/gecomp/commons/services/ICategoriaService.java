package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Categoria;

@WebService
public interface ICategoriaService extends IService<Categoria> {

	void delete(@WebParam(name="id") Long id) throws GeCompSrvException;

	Categoria get(@WebParam(name="id") Long id) throws GeCompSrvException;

	List<Categoria> list() throws GeCompSrvException;

	Categoria save(@WebParam(name="categoria") Categoria categoria) throws GeCompSrvException;
	
}
