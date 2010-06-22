package org.sbelli.gecomp.console.atleti.executers;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.atleti.delegates.AtletaDelegate;
import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.utils.exceptions.GeCompGuiExceptionManager;
import org.sbelli.gecomp.orm.model.Atleta;

public class AtletaExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
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
		return "listaAtleti";
	}
	
}
