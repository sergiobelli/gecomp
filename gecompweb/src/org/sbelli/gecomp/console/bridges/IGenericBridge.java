package org.sbelli.gecomp.console.bridges;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.orm.model.GecompModelObject;

public interface IGenericBridge<T extends GecompModelObject> {

	T insert(T element) throws GeCompException;
	
	void update(T element) throws GeCompException;
	
	void delete(T element) throws GeCompException;
	
	public T get(Long id) throws GeCompException;
}
