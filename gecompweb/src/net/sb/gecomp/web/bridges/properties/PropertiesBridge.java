package net.sb.gecomp.web.bridges.properties;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.services.IPropertiesService;
import net.sb.gecomp.srv.services.properties.PropertiesService;
import net.sb.gecomp.web.bridges.GenericBridge;


public class PropertiesBridge extends GenericBridge {

	private final IPropertiesService service = new PropertiesService();
	
	public GecompModelObject insert(GecompModelObject property) throws GeCompException {
		return service.save((PropertiesView)property);
	}
	
	public void update(GecompModelObject property) throws GeCompException {
		service.save((PropertiesView)property);
	}
	
	public void delete(GecompModelObject property) throws GeCompException {
		service.delete(((PropertiesView)property).getId());
	}

	public PropertiesView get(Long id) throws GeCompException {
		return new PropertiesView(service.get(id));
	}
	
	public PropertiesView get(String code) throws GeCompException {
		return new PropertiesView(service.get(code));
	}
}