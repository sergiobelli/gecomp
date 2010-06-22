package org.sbelli.gecomp.orm.dao;

import java.util.List;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;

public interface IGeCompDao<T extends java.io.Serializable> {

	public void delete (Long id) throws GeCompOrmException;
	
	public T get (Long id) throws GeCompOrmException;
	
	public T insert (T object) throws GeCompOrmException;
	
	public List<T> list () throws GeCompOrmException;
	
	public void update (T object) throws GeCompOrmException;

}
