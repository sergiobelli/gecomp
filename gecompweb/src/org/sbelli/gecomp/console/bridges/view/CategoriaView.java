package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Categoria;

public class CategoriaView extends Categoria {

	public CategoriaView() { }
	public CategoriaView(Categoria categoria) {
		ViewUtils.copyProperties(this, categoria);
	}

}
