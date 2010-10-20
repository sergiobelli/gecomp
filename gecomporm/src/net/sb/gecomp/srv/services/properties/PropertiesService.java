package net.sb.gecomp.srv.services.properties;

import java.util.List;

import javax.jws.WebService;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Properties;
import net.sb.gecomp.commons.services.IPropertiesService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.PropertiesDao;

@WebService(endpointInterface = "net.sb.gecomp.commons.services.IPropertiesService", serviceName = "propertiesService")
public class PropertiesService implements IPropertiesService {

	private PropertiesDao dao;
	public PropertiesDao getDao() {return dao;}
	public void setDao(PropertiesDao dao) {this.dao = dao;}
	
	public void delete(Long id) throws GeCompSrvException {
		getDao().delete(id);
	}

	public Properties get(Long id) throws GeCompSrvException {
		return getDao().get(id);
	}

	public Properties get(String code) throws GeCompSrvException {
		return getDao().get(code);
	}
	
	public Properties save(Properties property) throws GeCompSrvException {
		if (Eval.isNotNull(property.getId())) {
			getDao().update(property);
			return property;
		} else {
			return getDao().insert(property);			
		}
	}

	public List<Properties> list() throws GeCompSrvException {
		return getDao().list();
	}

}
