package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.CategoriaGara;

public class CategoriaGaraView extends CategoriaGara {
	public CategoriaGaraView() { }
	public CategoriaGaraView(CategoriaGara categoriaGara) {
		ViewUtils.copyProperties(this, categoriaGara);
	}
}
