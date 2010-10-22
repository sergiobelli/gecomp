package net.sb.gecomp.web.bridges;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;


public interface IGenericBridge<T extends GecompModelObject> {

	T insert(T element) throws GeCompException;
	
	void update(T element) throws GeCompException;
	
	void delete(T element) throws GeCompException;
	
	T get(Long id) throws GeCompException;
	
	List<T> list() throws GeCompException;
}
