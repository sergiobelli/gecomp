package org.sbelli.gecomp.orm.model;

public class TipoMisuraLancio extends TipoMisura {
	public TipoMisuraLancio() {}
	public TipoMisuraLancio(TipoMisura tipoMisura) {
		setDescrizione(tipoMisura.getDescrizione());
		setIdTipoMisura(tipoMisura.getIdTipoMisura());
		setModalitaComparazione(tipoMisura.getModalitaComparazione());
		setUnitaMisura(tipoMisura.getUnitaMisura());
	}
}
