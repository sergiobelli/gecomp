package net.sb.gecomp.commons.model;

public class TipoMisuraSalto extends TipoMisura {
	public TipoMisuraSalto() {}
	public TipoMisuraSalto(TipoMisura tipoMisura) {
		setDescrizione(tipoMisura.getDescrizione());
		setIdTipoMisura(tipoMisura.getIdTipoMisura());
		setModalitaComparazione(tipoMisura.getModalitaComparazione());
		setUnitaMisura(tipoMisura.getUnitaMisura());
	}
}
