package net.sb.gecomp.web.bridges.societa;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.model.Societa;
import net.sb.gecomp.orm.dao.SocietaDao;
import net.sb.gecomp.orm.ibatis.DbManagerFactory;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.bridges.GenericBridge;
import net.sb.gecomp.web.bridges.view.SocietaView;


public class SocietaBridge extends GenericBridge {

	private SocietaDao dao = DbManagerFactory.getInstance().getSocietaDao();
	
	public void delete(GecompModelObject element) throws GeCompOrmException {
		dao.delete((SocietaView)element);
	}

	public GecompModelObject insert(GecompModelObject element) throws GeCompOrmException {
		return dao.insert((Societa)element);
	}

	public void update(GecompModelObject element) throws GeCompOrmException {
		dao.update((SocietaView)element);
	}

	public List<SocietaView> list() throws GeCompOrmException {
		List<SocietaView> result = new ArrayList<SocietaView>();
		List<Societa> lista = dao.list();
		if (Eval.isNotEmpty(lista)) {
			for (Societa s : lista) {
				result.add(new SocietaView(s));
			}
		}
		return result;
	}

	public SocietaView get(Long idSocieta) throws GeCompOrmException {
		return new SocietaView(dao.get(idSocieta));
	}

}
