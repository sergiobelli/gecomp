package net.sb.gecomp.web.bridges.properties;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.PropertiesView;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class PropertiesBridge extends GenericBridge {

	public GecompModelObject insert(GecompModelObject property) throws GeCompException {
		return DbManagerFactory.getInstance().getPropertiesDao().insert((PropertiesView)property);
	}
	
	public void update(GecompModelObject property) throws GeCompException {
		DbManagerFactory.getInstance().getPropertiesDao().update((PropertiesView)property);
	}
	
	public void delete(GecompModelObject property) throws GeCompException {
		DbManagerFactory.getInstance().getPropertiesDao().delete(((PropertiesView)property).getId());
	}

	public PropertiesView get(Long id) throws GeCompException {
		return new PropertiesView(DbManagerFactory.getInstance().getPropertiesDao().get(id));
	}
	
	public PropertiesView get(String code) throws GeCompException {
		return new PropertiesView(DbManagerFactory.getInstance().getPropertiesDao().get(code));
	}
}