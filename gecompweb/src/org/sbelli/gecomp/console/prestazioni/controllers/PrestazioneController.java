package org.sbelli.gecomp.console.prestazioni.controllers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.controllers.GenericController;
import org.sbelli.gecomp.orm.model.GecompModelObject;
import org.sbelli.gecomp.orm.model.Prestazione;

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
