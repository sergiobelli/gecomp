package net.sb.gecomp.srv.services.societa;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.commons.services.ISocietaService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.SocietaDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class SocietaService implements ISocietaService {
	
	private SocietaDao dao = DbManagerFactory.getInstance().getSocietaDao();
	
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	public Societa save(Societa societa) throws GeCompSrvException {
		if (Eval.isNotNull(societa.getId())) {
			dao.update(societa);
			return societa;
		} else {
			return dao.insert(societa);			
		}
	}

	public List<Societa> list() throws GeCompSrvException {
		List<Societa> result = dao.list();
		return result;
	}

	public SocietaView get(Long idSocieta) throws GeCompSrvException {
		return new SocietaView(dao.get(idSocieta));
	}
}
