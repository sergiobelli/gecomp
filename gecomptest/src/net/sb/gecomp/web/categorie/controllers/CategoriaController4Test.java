package net.sb.gecomp.web.categorie.controllers;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.web.controllers.categorie.CategoriaController;


public class CategoriaController4Test extends CategoriaController {

	@Override
	protected void checksAnnoFine(Categoria categoria) throws GeCompException {
		super.checksAnnoFine(categoria);
	}

	@Override
	protected void checksAnnoPartenza(Categoria categoria)
			throws GeCompException {
		super.checksAnnoPartenza(categoria);
	}

	@Override
	protected void checksCongruenzaDate(Categoria categoria)
			throws GeCompException {
		super.checksCongruenzaDate(categoria);
	}

	
}
