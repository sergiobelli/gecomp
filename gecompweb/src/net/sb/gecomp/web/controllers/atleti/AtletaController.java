package net.sb.gecomp.web.controllers.atleti;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;

import org.sbelli.gecomp.orm.model.Atleta;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class AtletaController extends GenericController {
	
	public void checks(GecompModelObject element) throws GeCompException {
		
		Atleta atleta = (Atleta) element;
		
		logger.info("Checking Atleta = " + atleta);
		
		checksCognome (atleta);
		
		checksNome (atleta);
		
		checksSesso (atleta);
		
		checksAnnoDiNascita (atleta);
		
		checksSocietaDiAppartenenza (atleta);
		
		logger.info("Checks passed ! ");
		
	}
	
	protected void checksSocietaDiAppartenenza(Atleta atleta) throws GeCompException {

		if (Eval.isNull(atleta.getSocietaAppartenenza())
				|| Eval.isNull(atleta.getSocietaAppartenenza().getId())) {
			throw new GeCompException("message.atleta.societa.appartenenza.non.valorizzato");
		}
		 
  }

	protected void checksNome(Atleta atleta) throws GeCompException {

		if (Eval.isEmpty(atleta.getNome())) {
			throw new GeCompException("message.atleta.nome.non.valorizzato");
		}
		
  }

	protected void checksCognome(Atleta atleta) throws GeCompException {

		if (Eval.isEmpty(atleta.getCognome())) {
			throw new GeCompException("message.atleta.cognome.non.valorizzato");
		}
		
  }

	protected void checksAnnoDiNascita(Atleta atleta) throws GeCompException {
		
		if (Eval.isEmpty(atleta.getAnnoNascita())) {
			throw new GeCompException("message.atleta.anno.nascita.non.valorizzato");
		}
		
		if (atleta.getAnnoNascita().length() != 4) {
			throw new GeCompException("message.atleta.anno.nascita.non.valorizzato");
		}
			
		if (Eval.isNotNumeric(atleta.getAnnoNascita())) {
			throw new GeCompException("message.atleta.anno.nascita.non.valorizzato");
		}
		
  }

	protected void checksSesso (Atleta atleta) throws GeCompException {
		
		if (Eval.isEmpty(atleta.getSesso())) {
			throw new GeCompException("message.atleta.sesso.non.valorizzato");
		}
		
		if (atleta.getSesso().length() != 1) {
			throw new GeCompException("message.atleta.sesso.non.valorizzato");
		}
		
		
		if (!("M".equals(atleta.getSesso()) || "F".equals(atleta.getSesso()))) {
			throw new GeCompException("message.atleta.sesso.non.valorizzato");
		}
				
	}
}
