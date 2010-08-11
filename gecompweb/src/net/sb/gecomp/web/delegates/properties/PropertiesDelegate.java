package net.sb.gecomp.web.delegates.properties;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.properties.PropertiesBridge;
import net.sb.gecomp.web.bridges.view.PropertiesView;
import net.sb.gecomp.web.delegates.GenericDelegate;


public class PropertiesDelegate extends GenericDelegate {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private PropertiesBridge bridge = new PropertiesBridge();

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		PropertiesView property = (PropertiesView)element;
		return property;
	}

	public void save(GecompModelObject element) throws GeCompException {
		PropertiesView property = (PropertiesView)element;
		retrieve(property);
		logger.debug("Customized property = " + property);
		if (Eval.isNull(property.getId())) {
			bridge.insert(property);
		} else {
			bridge.update(property);
		}		
	}

	public void delete(GecompModelObject element) throws GeCompException {
		PropertiesView property = (PropertiesView)element;
		bridge.delete(property);		
	}

	public PropertiesView get(Long id) throws GeCompException {
		return bridge.get(id);
	}
	public PropertiesView get(String code) throws GeCompException {
		return bridge.get(code);
	}
}