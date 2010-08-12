package net.sb.gecomp.srv.services.properties;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Properties;
import net.sb.gecomp.commons.services.IPropertiesService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.PropertiesDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class PropertiesService implements IPropertiesService {

	private final PropertiesDao dao = DbManagerFactory.getInstance().getPropertiesDao();
	
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	public Properties get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public Properties get(String code) throws GeCompSrvException {
		return dao.get(code);
	}
	
	public Properties save(Properties property) throws GeCompSrvException {
		if (Eval.isNotNull(property.getId())) {
			dao.update(property);
			return property;
		} else {
			return dao.insert(property);			
		}
	}

	public List<Properties> list() throws GeCompSrvException {
		return dao.list();
	}

}
