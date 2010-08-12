package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.CategoriaGara;

public class CategoriaGaraView extends CategoriaGara {
	public CategoriaGaraView() { }
	public CategoriaGaraView(CategoriaGara categoriaGara) {
		ViewUtils.copyProperties(this, categoriaGara);
	}
}
