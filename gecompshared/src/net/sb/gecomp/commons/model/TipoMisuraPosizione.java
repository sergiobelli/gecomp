package net.sb.gecomp.commons.model;

public class TipoMisuraPosizione extends TipoMisura {
	public TipoMisuraPosizione() {}
	public TipoMisuraPosizione(TipoMisura tipoMisura) {
		setDescrizione(tipoMisura.getDescrizione());
		setIdTipoMisura(tipoMisura.getIdTipoMisura());
		setModalitaComparazione(tipoMisura.getModalitaComparazione());
		setUnitaMisura(tipoMisura.getUnitaMisura());
	}
}
