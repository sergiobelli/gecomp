package org.sbelli.gecomp.console.categorie.executers;

import org.sbelli.gecomp.orm.model.Categoria;

/**
 * @author S.BELLI
 */
public class InserisciCategoriaExecuter extends CategoriaExecuter {
	
	public InserisciCategoriaExecuter () {
		setCategoria(new Categoria());
	}

}
