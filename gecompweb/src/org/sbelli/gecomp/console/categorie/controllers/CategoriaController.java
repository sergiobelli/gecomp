package org.sbelli.gecomp.console.categorie.controllers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.Eval;

import org.sbelli.gecomp.console.controllers.GenericController;
import org.sbelli.gecomp.orm.model.Categoria;
import org.sbelli.gecomp.orm.model.GecompModelObject;

public class CategoriaController extends GenericController {
	
	public void checks(GecompModelObject element) throws GeCompException {
		Categoria categoria = (Categoria) element;
		logger.info("Checking categoria = " + categoria);
		
		checksAnnoPartenza(categoria);
		checksAnnoFine(categoria);
		checksCongruenzaDate(categoria);
		
		logger.info("Checks passed ! ");
	}
	
	private void checksAnnoPartenza(Categoria categoria) throws GeCompException {
		if (Eval.isEmpty((categoria.getAnnoPartenza()))) {
			throw new GeCompException("net.sb.gecomp.console.categorie.controllers.error.anno_partenza.empty");
		} else {
			try {
				Integer.valueOf(categoria.getAnnoPartenza());
			} catch (NumberFormatException nfe) {
				throw new GeCompException("net.sb.gecomp.console.categorie.controllers.error.anno_partenza.bad_format");
			}
		}
	}
	private void checksAnnoFine(Categoria categoria) throws GeCompException {
		if (Eval.isEmpty((categoria.getAnnoFine()))) {
			throw new GeCompException("net.sb.gecomp.console.categorie.controllers.error.anno_fine.empty");
		} else {
			try {
				Integer.valueOf(categoria.getAnnoFine());
			} catch (NumberFormatException nfe) {
				throw new GeCompException("net.sb.gecomp.console.categorie.controllers.error.anno_fine.bad_format");
			}
		}
	}
	private void checksCongruenzaDate(Categoria categoria) throws GeCompException {
		try {
			String sAnnoPartenza = categoria.getAnnoPartenza();
			String sAnnoFine = categoria.getAnnoFine();
			Integer annoPartenza = Integer.valueOf(sAnnoPartenza);
			Integer annoFine = Integer.valueOf(sAnnoFine);
			
			if (annoPartenza >= annoFine) {
				throw new GeCompException("net.sb.gecomp.console.categorie.controllers.error.congruenza_date.error");
			}
		} catch (NumberFormatException nfe) {
			throw new GeCompException("net.sb.gecomp.console.categorie.controllers.error.congruenza_date.bad_format");
		} catch (GeCompException gce) {
			throw gce;
		} catch (Exception e) {
			logger.error("Errore generico", e);
			throw new GeCompException(e.getMessage());
		}	
	}
	
}
