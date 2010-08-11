package net.sb.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.model.Gara;
import net.sb.gecomp.model.Prestazione;
import net.sb.gecomp.orm.presentation.classifiche.ClassificaGeneraleGara;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;


/**
 * @author sbelli
 * @deprecated tutte queste attivita' devono essere fatte a front-end
 */
public class ClassificaGeneraleManager {
	
	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
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
