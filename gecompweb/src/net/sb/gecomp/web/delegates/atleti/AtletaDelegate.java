package net.sb.gecomp.web.delegates.atleti;

import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.view.AtletaView;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.bridges.atleti.AtletaBridge;
import net.sb.gecomp.web.bridges.societa.SocietaBridge;
import net.sb.gecomp.web.controllers.atleti.AtletaController;
import net.sb.gecomp.web.delegates.GenericDelegate;

import org.springframework.util.Assert;

public class AtletaDelegate extends GenericDelegate /*implements InitializingBean */{
	
	private AtletaBridge bridge;
	public AtletaBridge getBridge() {return bridge;}
	public void setBridge(AtletaBridge bridge) {this.bridge = bridge;}

	private AtletaController controller;
	public AtletaController getController() {return controller;}
	public void setController(AtletaController controller) {this.controller = controller;}

	private SocietaBridge societaBridge;
	public SocietaBridge getSocietaBridge() {return societaBridge;}
	public void setSocietaBridge(SocietaBridge societaBridge) {this.societaBridge = societaBridge;}
	
	public GecompModelObject retrieve(GecompModelObject element) throws GeCompException {
		AtletaView atleta = (AtletaView)element;
		getController().checks(atleta);
		atleta.setSocietaAppartenenza(getSocietaBridge().get(atleta.getSocietaAppartenenza().getId()));
		return atleta;
	}

	public void save(GecompModelObject element) throws GeCompException {
		AtletaView atleta = (AtletaView)element;
		retrieve(atleta);
		logger.debug("Customized atleta = " + atleta);
		if (Eval.isNull(atleta.getIdAtleta())) {
			getBridge().insert(atleta);
		} else {
			getBridge().update(atleta);
		}		
	}

	public void delete(GecompModelObject element) throws GeCompException {
		AtletaView atleta = (AtletaView)element;
		getBridge().delete(atleta);		
	}

	public AtletaView get(Long id) throws GeCompException {
		return getBridge().get(id);
	}
	
	public List<AtletaView> list() throws GeCompException {
		return getBridge().list();
	}
	
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(controller, "getController must be set");
		Assert.notNull(bridge, "getBridge must be set");
	}
	
}
