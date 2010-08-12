package net.sb.gecomp.web.executers.competizione;

import net.sb.gecomp.commons.exceptions.GeCompOrmException;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;
import net.sb.gecomp.srv.orm.ibatis.DbManagerFactory;


public class ListaCompetizioniExecuter extends CompetizioneExecuter {

	public ListaCompetizioniExecuter () {
		try {
			competizioni = DbManagerFactory.getInstance().getCompetizioneDao().list();
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.traceException(logger, e);
		}
	}
	
	
}
