package net.sb.gecomp.web.controllers.competizione;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.Competizione;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;


public class CompetizioneController extends GenericController {

	public void checks(GecompModelObject element) throws GeCompException {
		
		Competizione competizione = (Competizione) element;
		
		logger.info("Checking Competizione = " + competizione);
		
		checksNome (competizione);
		
		checksDescrizione (competizione);
		
		checksDataInizio (competizione);
		
		checksDataFine (competizione);
		
		checksSocietaOrganizzatrice (competizione);
		
		logger.info("Checks passed ! ");
		
	}

	private void checksSocietaOrganizzatrice(Competizione competizione) throws GeCompException {

		if (Eval.isNull(competizione.getSocietaOrganizzatrice())
				|| Eval.isNull(competizione.getSocietaOrganizzatrice().getId())) {
			throw new GeCompException("message.competizione.societa.organizzatrice.non.valorizzato");
		}
		 
  }

	private void checksDataFine(Competizione competizione) throws GeCompException {
		
		if (Eval.isNull(competizione.getDataFine())) {
			throw new GeCompException("message.competizione.data.fine.non.valorizzato");
		}

  }

	private void checksDataInizio(Competizione competizione) throws GeCompException {
	
		if (Eval.isNull(competizione.getDataInizio())) {
			throw new GeCompException("message.competizione.data.inizio.non.valorizzato");
		}

	}

	private void checksDescrizione(Competizione competizione) throws GeCompException {
	  
		if (Eval.isNull(competizione.getDescrizione())
				|| Eval.isEmpty(competizione.getDescrizione())) {
			throw new GeCompException("message.competizione.descrizione.non.valorizzato");
		}
	  
  }

	private void checksNome(Competizione competizione) throws GeCompException {
	  
		if (Eval.isNull(competizione.getNome())
				|| Eval.isEmpty(competizione.getNome())) {
			throw new GeCompException("message.competizione.nome.non.valorizzato");
		}
	  
  }
}
