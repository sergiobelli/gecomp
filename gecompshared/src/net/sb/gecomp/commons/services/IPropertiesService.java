package net.sb.gecomp.commons.services;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Properties;

public interface IPropertiesService extends IService<Properties> {

	Properties get(String code) throws GeCompSrvException;
	
}
