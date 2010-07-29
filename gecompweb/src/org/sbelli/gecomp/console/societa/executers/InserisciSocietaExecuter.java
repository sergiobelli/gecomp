package org.sbelli.gecomp.console.societa.executers;

import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;

import org.sbelli.gecomp.orm.model.Societa;

public class InserisciSocietaExecuter extends SocietaExecuter {
	
	public InserisciSocietaExecuter () {
		setSocieta(new Societa());
	}

	public String salva() {
		
		try {
			logger.info("Saving new Societa...");
			
			delegate.save(getSocieta());
			
			logger.info("Saved new Societa...");
		} catch (Exception ex) {
			GeCompGuiExceptionManager.manageGUIException(logger, ex, "error.societa.salvataggio.ko");
			return "null";
		}
		
		return GeCompOutcomes.LISTA_SOCIETA;
  }	
}
