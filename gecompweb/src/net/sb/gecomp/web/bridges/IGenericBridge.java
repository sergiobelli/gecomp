package net.sb.gecomp.web.bridges;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;


public interface IGenericBridge<T extends GecompModelObject> {

	T insert(T element) throws GeCompException;
	
	void update(T element) throws GeCompException;
	
	void delete(T element) throws GeCompException;
	
	public T get(Long id) throws GeCompException;
}
