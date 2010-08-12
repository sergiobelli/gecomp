package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.Categoria;

public class CategoriaView extends Categoria {

	public CategoriaView() { }
	public CategoriaView(Categoria categoria) {
		ViewUtils.copyProperties(this, categoria);
	}

}
