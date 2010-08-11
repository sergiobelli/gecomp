package net.sb.gecomp.web.controllers.gare;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;

import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class GaraController extends GenericController {
	
	public void checks(GecompModelObject element) throws GeCompException {
		
		Gara gara = (Gara) element;
		
		logger.info("Checking Gara = " + gara);
		
		checksNome (gara);
		
		checksDescrizione (gara);
		
		checksData (gara);
		
		checksDistanza (gara);			
		
		logger.info("Checks passed ! ");
		
	}
	
	private void checksDistanza(Gara gara) throws GeCompException {
	  
		if (Eval.isNull(gara.getDistanza())) {
			throw new GeCompException("message.gara.distanza.non.valorizzato");
		}
	  
  }

	private void checksData(Gara gara) throws GeCompException {
		
		if (Eval.isNull(gara.getData())) {
			throw new GeCompException("message.gara.data.non.valorizzato");
		}

  }

	private void checksDescrizione(Gara gara) throws GeCompException {
	  
		if (Eval.isNull(gara.getDescrizione())
				|| Eval.isEmpty(gara.getDescrizione())) {
			throw new GeCompException("message.gara.descrizione.non.valorizzato");
		}
	  
  }

	private void checksNome(Gara gara) throws GeCompException {
	  
		if (Eval.isNull(gara.getNome())
				|| Eval.isEmpty(gara.getNome())) {
			throw new GeCompException("message.gara.nome.non.valorizzato");
		}
	  
  }
}
