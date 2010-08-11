package net.sb.gecomp.web.bridges.view;

import net.sb.gecomp.model.Categoria;

public class CategoriaView extends Categoria {

	public CategoriaView() { }
	public CategoriaView(Categoria categoria) {
		ViewUtils.copyProperties(this, categoria);
	}

}
