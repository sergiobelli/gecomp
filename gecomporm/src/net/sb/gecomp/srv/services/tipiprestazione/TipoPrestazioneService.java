package net.sb.gecomp.srv.services.tipiprestazione;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompSrvException;
import net.sb.gecomp.commons.model.TipoPrestazione;
import net.sb.gecomp.commons.services.ITipoPrestazioneService;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.srv.orm.dao.TipoPrestazioneDao;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;

public class TipoPrestazioneService implements ITipoPrestazioneService {

	private TipoPrestazioneDao dao = DbManagerFactory.getInstance().getTipoPrestazioneDao();
	
	public void delete(Long id) throws GeCompSrvException {
		dao.delete(id);
	}

	public TipoPrestazione get(Long id) throws GeCompSrvException {
		return dao.get(id);
	}

	public List<TipoPrestazione> list() throws GeCompSrvException {
		return dao.list();
	}

	public TipoPrestazione save(TipoPrestazione tipoPrestazione) throws GeCompSrvException {
		if (Eval.isNotNull(tipoPrestazione.getIdTipoPrestazione())) {
			dao.update(tipoPrestazione);
			return tipoPrestazione;
		} else {
			return dao.insert(tipoPrestazione);			
		}
	}

	
}
