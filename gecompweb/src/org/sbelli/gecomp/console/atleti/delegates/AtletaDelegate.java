package org.sbelli.gecomp.console.atleti.delegates;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.atleti.bridges.AtletaBridge;
import org.sbelli.gecomp.console.atleti.controllers.AtletaController;
import org.sbelli.gecomp.console.bridges.view.AtletaView;
import org.sbelli.gecomp.console.delegates.GenericDelegate;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;
import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class AtletaDelegate extends GenericDelegate implements InitializingBean {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private AtletaController controller = new AtletaController();
	public AtletaController getController() {return controller;}
	public void setController(AtletaController controller) {this.controller = controller;}

	private AtletaBridge bridge = new AtletaBridge();
	public AtletaBridge getBridge() {return bridge;}
	public void setBridge(AtletaBridge bridge) {this.bridge = bridge;}

	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		Atleta atleta = (Atleta)element;
		getController().checks(atleta);
		atleta.setSocietaAppartenenza(DbManagerFactory.getInstance().getSocietaDao().get(atleta.getSocietaAppartenenza().getId()));
		return atleta;
	}

	public void save(GecompModelObject element) throws GeCompException {
		Atleta atleta = (Atleta)element;
		retrieve(atleta);
		logger.debug("Customized atleta = " + atleta);
		if (Eval.isNull(atleta.getIdAtleta())) {
			getBridge().insert(atleta);
		} else {
			getBridge().update(atleta);
		}		
	}

	public void delete(GecompModelObject element) throws GeCompException {
		Atleta atleta = (Atleta)element;
		getBridge().delete(atleta);		
	}

	public AtletaView get(Long id) throws GeCompException {
		return getBridge().get(id);
	}
	
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(getController(), "getController must be set");
		Assert.notNull(getBridge(), "getBridge must be set");
	}
	
}
