package org.sbelli.gecomp.console.bridges;

import net.sb.gecomp.exceptions.GeCompOrmException;

import org.sbelli.gecomp.orm.model.GecompModelObject;

public interface IGenericBridge<T extends GecompModelObject> {

	T insert(T element) throws GeCompOrmException;
	
	void update(T element) throws GeCompOrmException;
	
	void delete(T element) throws GeCompOrmException;
	
	public T get(Long id) throws GeCompOrmException;
}
