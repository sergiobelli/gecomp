package net.sb.gecomp.commons.services;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.GecompModelObject;

public interface IService<T extends GecompModelObject> {
	
	T save(T object) throws GeCompSrvException;

	//T get(Long id) throws GeCompSrvException;
	
	void delete(Long id) throws GeCompSrvException;
	
	List<T> list() throws GeCompSrvException; 
}
