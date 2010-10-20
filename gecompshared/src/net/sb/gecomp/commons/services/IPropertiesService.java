package net.sb.gecomp.commons.services;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Properties;

@WebService
public interface IPropertiesService /*extends IService<Properties>*/ {

//	Properties get(
//			@WebParam(name="id") Long id) 						throws GeCompSrvException;
	
	Properties get(
			@WebParam(name="code") String code) 				throws GeCompSrvException;
	
	List<Properties> list() 									throws GeCompSrvException;
	
	Properties save(
			@WebParam(name="property") Properties property) 	throws GeCompSrvException;
	
	void delete(
			@WebParam(name="id") Long id) 						throws GeCompSrvException;
}
