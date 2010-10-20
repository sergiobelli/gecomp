package net.sb.gecomp.web.bridges.properties;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.services.IPropertiesService;
import net.sb.gecomp.web.bridges.GenericBridge;


public class PropertiesBridge extends GenericBridge {

	private IPropertiesService service;
	public IPropertiesService getService() { return service; }
	public void setService(IPropertiesService service) { this.service = service; }
	
	public GecompModelObject insert(GecompModelObject property) throws GeCompException {
		return getService().save((PropertiesView)property);
	}
	
	public void update(GecompModelObject property) throws GeCompException {
		getService().save((PropertiesView)property);
	}
	
	public void delete(GecompModelObject property) throws GeCompException {
		getService().delete(((PropertiesView)property).getId());
	}

	public PropertiesView get(Long id) throws GeCompException {
//		return new PropertiesView(getService().get(id));
		throw new GeCompException("Not usable!");
	}
	
	public PropertiesView get(String code) throws GeCompException {
		return new PropertiesView(getService().get(code));
	}
}