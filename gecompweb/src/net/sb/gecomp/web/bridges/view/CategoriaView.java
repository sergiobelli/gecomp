package net.sb.gecomp.web.bridges.view;

import org.sbelli.gecomp.orm.model.Categoria;

public class CategoriaView extends Categoria {

	public CategoriaView() { }
	public CategoriaView(Categoria categoria) {
		ViewUtils.copyProperties(this, categoria);
	}

}
