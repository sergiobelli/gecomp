package net.sb.gecomp.web.delegates;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;


public interface IGenericDaoDelegate<T extends GecompModelObject> extends IGenericDelegate {

	T retrieve(T element) throws GeCompException;

	void save(T element) throws GeCompException;

	void delete(T element) throws GeCompException;
	
	public T get(Long id) throws GeCompException;
}
