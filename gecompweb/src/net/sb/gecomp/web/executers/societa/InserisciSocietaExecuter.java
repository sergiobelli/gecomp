package net.sb.gecomp.web.executers.societa;

import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.web.menu.GeCompOutcomes;
import net.sb.gecomp.web.utils.exceptions.GeCompGuiExceptionManager;


public class InserisciSocietaExecuter extends SocietaExecuter {
	
	public InserisciSocietaExecuter () {
		setSocieta(new SocietaView());
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
