package org.sbelli.gecomp.console.atleti.delegates;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.atleti.bridges.AtletaBridge;
import org.sbelli.gecomp.console.atleti.controllers.AtletaController;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class AtletaDelegate extends GenericDelegate {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private AtletaController controller = new AtletaController();
	private AtletaBridge bridge = new AtletaBridge();
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Atleta atleta = (Atleta)element;
		controller.checks(atleta);
		atleta.setSocietaAppartenenza(DbManagerFactory.getInstance().getSocietaDao().get(atleta.getSocietaAppartenenza().getId()));
		return atleta;
	}

	public void save(GecompModelObject element) throws GeCompException {
		Atleta atleta = (Atleta)element;
		retrieve(atleta);
		logger.debug("Customized atleta = " + atleta);
		if (Eval.isNull(atleta.getIdAtleta())) {
			bridge.insert(atleta);
		} else {
			bridge.update(atleta);
		}		
	}

	public void delete(GecompModelObject element) throws GeCompException {
		Atleta atleta = (Atleta)element;
		bridge.delete(atleta);		
	}

	public GecompModelObject get(Long id) throws GeCompException {
		return bridge.get(id);
	}
	
}
