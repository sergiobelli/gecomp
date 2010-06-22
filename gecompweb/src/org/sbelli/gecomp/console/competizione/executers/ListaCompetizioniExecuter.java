package org.sbelli.gecomp.console.competizione.executers;

import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;

import org.sbelli.gecomp.orm.exceptions.GeCompOrmException;
import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class ListaCompetizioniExecuter extends CompetizioneExecuter {

	public ListaCompetizioniExecuter () {
		try {
			competizioni = DbManagerFactory.getInstance().getCompetizioneDao().list();
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.manageException(logger, e);
		}
	}
	
	
}
