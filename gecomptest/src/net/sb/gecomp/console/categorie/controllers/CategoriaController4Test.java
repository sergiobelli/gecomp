package net.sb.gecomp.console.categorie.controllers;

import net.sb.gecomp.exceptions.GeCompException;

import org.sbelli.gecomp.console.categorie.controllers.CategoriaController;
import org.sbelli.gecomp.orm.model.Categoria;

public class CategoriaController4Test extends CategoriaController {

	@Override
	protected void checksAnnoFine(Categoria categoria) throws GeCompException {
		// TODO Auto-generated method stub
		super.checksAnnoFine(categoria);
	}

	@Override
	protected void checksAnnoPartenza(Categoria categoria)
			throws GeCompException {
		// TODO Auto-generated method stub
		super.checksAnnoPartenza(categoria);
	}

	@Override
	protected void checksCongruenzaDate(Categoria categoria)
			throws GeCompException {
		// TODO Auto-generated method stub
		super.checksCongruenzaDate(categoria);
	}

	
}
