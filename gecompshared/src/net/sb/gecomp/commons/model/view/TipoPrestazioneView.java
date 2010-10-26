package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.TipoPrestazione;

public class TipoPrestazioneView extends TipoPrestazione {
	public TipoPrestazioneView() { }
	public TipoPrestazioneView(TipoPrestazione tipoPrestazione) {
		ViewUtils.copyProperties(this, tipoPrestazione);
	}
}
