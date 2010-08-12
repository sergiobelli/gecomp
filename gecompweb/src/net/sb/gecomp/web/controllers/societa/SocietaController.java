package net.sb.gecomp.web.controllers.societa;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;


public class SocietaController extends GenericController {

	public void checks(GecompModelObject element) throws GeCompException {
		
		Societa societa = (Societa) element;
		
		logger.info("Checking Societa = " + societa);
		
		checksNome (societa);
		
		//TODO:inventare altri controlli
		logger.info("Checks passed ! ");
	}

	private void checksNome(Societa societa) throws GeCompException {
		if (Eval.isEmpty(societa.getDenominazione())) {
			throw new GeCompException("message.societa.nome.non.valorizzato");
		}
	}
}
