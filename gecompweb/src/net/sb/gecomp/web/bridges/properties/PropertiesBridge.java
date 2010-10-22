package net.sb.gecomp.web.bridges.properties;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Properties;
import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.services.IPropertiesService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;


public class PropertiesBridge extends GenericBridge {
	
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
		throw new GeCompException("Not usable!");
	}
	
	public PropertiesView get(String code) throws GeCompException {
		return new PropertiesView((Properties)((IPropertiesService)getService()).getByCode(code));
	}
	
	public List<PropertiesView> list() throws GeCompException {
		List<PropertiesView> result = new ArrayList<PropertiesView>();
		List<Properties> properties = getService().list();
		if (Eval.isNotEmpty(properties)) {
			for (Properties property : properties) {
				result.add(new PropertiesView(property));
			}
		}
		return result;

	}
}