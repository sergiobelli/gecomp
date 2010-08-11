package net.sb.gecomp.web.delegates.atleti;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.bridges.atleti.AtletaBridge;
import net.sb.gecomp.web.bridges.view.AtletaView;
import net.sb.gecomp.web.controllers.atleti.AtletaController;
import net.sb.gecomp.web.delegates.GenericDelegate;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;

import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class AtletaDelegate extends GenericDelegate implements InitializingBean {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());

	private AtletaController controller = new AtletaController();


	private AtletaBridge bridge = new AtletaBridge();

	private SocietaDelegate societaDelegate = new SocietaDelegate();
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		AtletaView atleta = (AtletaView)element;
		controller.checks(atleta);
		atleta.setSocietaAppartenenza(societaDelegate.get(atleta.getSocietaAppartenenza().getId()));
		return atleta;
	}

	public void save(GecompModelObject element) throws GeCompException {
		AtletaView atleta = (AtletaView)element;
		retrieve(atleta);
		logger.debug("Customized atleta = " + atleta);
		if (Eval.isNull(atleta.getIdAtleta())) {
			bridge.insert(atleta);
		} else {
			bridge.update(atleta);
		}		
	}

	public void delete(GecompModelObject element) throws GeCompException {
		AtletaView atleta = (AtletaView)element;
		bridge.delete(atleta);		
	}

	public AtletaView get(Long id) throws GeCompException {
		return bridge.get(id);
	}
	
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(controller, "getController must be set");
		Assert.notNull(bridge, "getBridge must be set");
	}
	
}
