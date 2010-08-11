package net.sb.gecomp.web.controllers.prestazioni;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.model.GecompModelObject;
import net.sb.gecomp.model.Prestazione;
import net.sb.gecomp.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;


public class PrestazioneController extends GenericController {
	
	public void checks(GecompModelObject element) throws GeCompException {
		
		Prestazione prestazione = (Prestazione) element;
		
		if (Eval.isNull(prestazione.getIscrizione())
				|| Eval.isNull(prestazione.getIscrizione().getIdIscrizione())) {
			throw new GeCompException("message.prestazione.iscrizione.non.valorizzato");
		}
		
		if (Eval.isNull(prestazione.getTipoPrestazione())
				|| Eval.isNull(prestazione.getTipoPrestazione().getIdTipoPrestazione())) {
			throw new GeCompException("message.prestazione.tipo.prestazione.non.valorizzato");
		}
		
		if (Eval.isNull(prestazione.getTipoMisura())
				|| Eval.isNull(prestazione.getTipoMisura().getIdTipoMisura())) {
			throw new GeCompException("message.prestazione.tipo.misura.non.valorizzato");
		}

		if (Eval.isNull(prestazione.getValoreMisura())) { //Non capitera' mai in quanto controllato da ValoreMisuraValidator
			throw new GeCompException("message.prestazione.valore.misura.non.valorizzato");
		}
		
		//TODO:aggiungere altri controlli!!!!!!!
	}
}
