package net.sb.gecomp.srv.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.Prestazione;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.presentation.classifiche.ClassificaGeneraleGara;

import org.apache.log4j.Logger;


/**
 * @deprecated tutte queste attivita' devono essere fatte a front-end
 */
public class ClassificaGeneraleManager {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	public ClassificaGeneraleGara getClassificaGeneraleGara(
			Gara gara, 
			List<Prestazione> prestazioniDellaCompetizione) throws GeCompOrmException {
		
		ClassificaGeneraleGara classificaGeneraleGara = null;
		try {
			
			List<Prestazione> prestazioniGeneraleGara = new ArrayList<Prestazione>();
			for (Prestazione prestazione : prestazioniDellaCompetizione) {
				if (prestazione.getIscrizione().getGara().equals(gara)) {
					prestazioniGeneraleGara.add(prestazione);
				}
			}
			
			classificaGeneraleGara = new ClassificaGeneraleGara( gara, prestazioniGeneraleGara );
			
		} catch (Exception e) {
			GeCompExceptionManager.traceException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return classificaGeneraleGara;
	}
	
}
