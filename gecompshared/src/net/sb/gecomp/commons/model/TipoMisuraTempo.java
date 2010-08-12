package net.sb.gecomp.commons.model;

import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.commons.utils.misure.TipoMisuraTempoHelper;

public class TipoMisuraTempo extends TipoMisura {
	
	public TipoMisuraTempo() {}
	public TipoMisuraTempo(TipoMisura tipoMisura) {
		setDescrizione(tipoMisura.getDescrizione());
		setIdTipoMisura(tipoMisura.getIdTipoMisura());
		setModalitaComparazione(tipoMisura.getModalitaComparazione());
		setUnitaMisura(tipoMisura.getUnitaMisura());
	}
	
	public String getValoreMisuraFormatted(Long valoreMisura) {
		logger.info("Valore misura da formattare = " + valoreMisura);
		if (Eval.isNotNull(valoreMisura)) {
			String valoreMisuraFormattato = TipoMisuraTempoHelper.parse(valoreMisura);
			logger.info("Valore misura formattato = "+valoreMisuraFormattato);
			return valoreMisuraFormattato;
		} else {
			return super.getValoreMisuraFormatted(valoreMisura);
		}
	}
		
}
