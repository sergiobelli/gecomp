package net.sb.gecomp.web.delegates.properties;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.PropertiesView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.properties.PropertiesBridge;
import net.sb.gecomp.web.delegates.GenericDelegate;
import net.sb.gecomp.web.utils.context.GecompContextFactory;


public class PropertiesDelegate extends GenericDelegate {
	
	private PropertiesBridge bridge;
	public PropertiesBridge getBridge() {return (PropertiesBridge)super.getBridge(); }
	public void setBridge(PropertiesBridge bridge) { this.bridge = bridge; }
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		PropertiesView property = (PropertiesView)element;
		return property;
	}

	public void save(GecompModelObject element) throws GeCompException {
		PropertiesView property = (PropertiesView)element;
		retrieve(property);
		logger.debug("Customized property = " + property);
		if (Eval.isNull(property.getId())) {
			getBridge().insert(property);
		} else {
			getBridge().update(property);
		}		
	}

	public void delete(GecompModelObject element) throws GeCompException {
		PropertiesView property = (PropertiesView)element;
		getBridge().delete(property);		
	}

	public PropertiesView get(Long id) throws GeCompException {
//		return getBridge().get(id);
		throw new GeCompException("Not usable!");
	}
	public PropertiesView get(String code) throws GeCompException {
		return getBridge().get(code);
	}
}