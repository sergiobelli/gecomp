package org.sbelli.gecomp.console.categorie.controllers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.controllers.GenericController;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CategoriaController extends GenericController {
	
	public void checks(GecompModelObject element) throws GeCompException {
		Categoria categoria = (Categoria) element;
		logger.info("Checking Categoria = " + categoria);
		
		logger.info("Checks passed ! ");
	}
	
}
