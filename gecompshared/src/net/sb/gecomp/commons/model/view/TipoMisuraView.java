package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.TipoMisura;

public class TipoMisuraView extends TipoMisura {
	public TipoMisuraView() { }
	public TipoMisuraView(TipoMisura tipoMisura) {
		ViewUtils.copyProperties(this, tipoMisura);
	}
}
