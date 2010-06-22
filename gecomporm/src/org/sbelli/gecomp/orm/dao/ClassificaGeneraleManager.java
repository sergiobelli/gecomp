package org.sbelli.gecomp.orm.dao;

import java.util.ArrayList;
import java.util.List;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.model.Gara;
import org.sbelli.gecomp.orm.model.Prestazione;
import org.sbelli.gecomp.orm.presentation.classifiche.ClassificaGeneraleGara;

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
			GeCompExceptionManager.manageException(logger, e);
			throw new GeCompOrmException(e.getMessage());
		}
		
		return classificaGeneraleGara;
	}
	
}
