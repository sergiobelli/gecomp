package net.sb.gecomp.web.bridges;

import net.sb.gecomp.commons.services.IService;

import org.apache.log4j.Logger;

public abstract class GenericBridge implements IGenericBridge {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	private IService service;
	public IService getService() {return service;}
	public void setService(IService service) {this.service = service;}

	
}
