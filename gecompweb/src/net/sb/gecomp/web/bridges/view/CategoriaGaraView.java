package net.sb.gecomp.web.bridges.view;

import net.sb.gecomp.model.CategoriaGara;

public class CategoriaGaraView extends CategoriaGara {
	public CategoriaGaraView() { }
	public CategoriaGaraView(CategoriaGara categoriaGara) {
		ViewUtils.copyProperties(this, categoriaGara);
	}
}
