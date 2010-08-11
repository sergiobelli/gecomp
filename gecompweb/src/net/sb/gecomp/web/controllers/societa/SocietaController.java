package net.sb.gecomp.web.controllers.societa;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;

import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Societa;

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