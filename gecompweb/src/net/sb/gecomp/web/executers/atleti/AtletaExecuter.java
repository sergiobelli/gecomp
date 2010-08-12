package net.sb.gecomp.web.executers.atleti;

import net.sb.gecomp.commons.model.Atleta;
import net.sb.gecomp.web.delegates.atleti.AtletaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class AtletaExecuter extends GenericExecuter implements InitializingBean {

	protected AtletaDelegate delegate = new AtletaDelegate();

	private Atleta atleta;
	public Atleta getAtleta() { return atleta; }
	public void setAtleta(Atleta atleta) { this.atleta = atleta; }

	public String salva() {
		try {
			logger.info("Saving Atleta...");

			delegate.save(getAtleta());
			
			logger.info("Saved Atleta...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.atleta.salvataggio.ko");
			return "null";
		}			
		return GeCompOutcomes.LISTA_ATLETI;
	}
	
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(delegate, "getDelegate must be set");
	}
	
}
