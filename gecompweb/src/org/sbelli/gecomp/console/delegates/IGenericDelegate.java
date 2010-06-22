package org.sbelli.gecomp.console.delegates;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.orm.model.GecompModelObject;

public interface IGenericDelegate<T extends GecompModelObject> {

	T retrieve(T element) throws GeCompException;

	void save(T element) throws GeCompException;

	void delete(T element) throws GeCompException;
	
	public T get(Long id) throws GeCompException;
}
