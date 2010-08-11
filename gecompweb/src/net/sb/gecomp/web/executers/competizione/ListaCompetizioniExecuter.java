package net.sb.gecomp.web.executers.competizione;

import net.sb.gecomp.exceptions.GeCompOrmException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;

import org.sbelli.gecomp.orm.ibatis.DbManagerFactory;

public class ListaCompetizioniExecuter extends CompetizioneExecuter {

	public ListaCompetizioniExecuter () {
		try {
			competizioni = DbManagerFactory.getInstance().getCompetizioneDao().list();
		} catch (GeCompOrmException e) {
			GeCompExceptionManager.traceException(logger, e);
		}
	}
	
	
}
