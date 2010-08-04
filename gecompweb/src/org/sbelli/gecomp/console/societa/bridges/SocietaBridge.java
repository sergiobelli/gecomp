package org.sbelli.gecomp.console.societa.bridges;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.bridges.GenericBridge;
import org.sbelli.gecomp.console.bridges.view.SocietaView;
import org.sbelli.gecomp.orm.dao.SocietaDao;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Societa;

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
