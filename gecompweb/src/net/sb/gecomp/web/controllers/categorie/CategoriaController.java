package net.sb.gecomp.web.controllers.categorie;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Categoria;
import net.sb.gecomp.commons.model.GecompModelObject;
import net.sb.gecomp.commons.utils.Eval;
import net.sb.gecomp.web.controllers.GenericController;


public class CategoriaController extends GenericController {
	
	public void checks(GecompModelObject element) throws GeCompException {
		Categoria categoria = (Categoria) element;
		logger.info("Checking categoria = " + categoria);
		
		checksAnnoPartenza(categoria);
		checksAnnoFine(categoria);
		checksCongruenzaDate(categoria);
		
		logger.info("Checks passed ! ");
	}
	
	protected void checksAnnoPartenza(Categoria categoria) throws GeCompException {
		if (Eval.isEmpty((categoria.getAnnoPartenza()))) {
			throw new GeCompException("net.sb.gecomp.web.categorie.controllers.error.anno_partenza.empty");
		} else {
			try {
				Integer.valueOf(categoria.getAnnoPartenza());
			} catch (NumberFormatException nfe) {
				throw new GeCompException("net.sb.gecomp.web.categorie.controllers.error.anno_partenza.bad_format");
			}
		}
	}
	
	protected void checksAnnoFine(Categoria categoria) throws GeCompException {
		if (Eval.isEmpty((categoria.getAnnoFine()))) {
			throw new GeCompException("net.sb.gecomp.web.categorie.controllers.error.anno_fine.empty");
		} else {
			try {
				Integer.valueOf(categoria.getAnnoFine());
			} catch (NumberFormatException nfe) {
				throw new GeCompException("net.sb.gecomp.web.categorie.controllers.error.anno_fine.bad_format");
			}
		}
	}
	
	protected void checksCongruenzaDate(Categoria categoria) throws GeCompException {
		try {
			String sAnnoPartenza = categoria.getAnnoPartenza();
			String sAnnoFine = categoria.getAnnoFine();
			Integer annoPartenza = Integer.valueOf(sAnnoPartenza);
			Integer annoFine = Integer.valueOf(sAnnoFine);
			
			if (annoPartenza >= annoFine) {
				throw new GeCompException("net.sb.gecomp.web.categorie.controllers.error.congruenza_date.error");
			}
		} catch (NumberFormatException nfe) {
			throw new GeCompException("net.sb.gecomp.web.categorie.controllers.error.congruenza_date.bad_format");
		} catch (GeCompException gce) {
			throw gce;
		} catch (Exception e) {
			logger.error("Errore generico", e);
			throw new GeCompException(e.getMessage());
		}	
	}
	
}
