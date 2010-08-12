package net.sb.gecomp.web.executers.competizione;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;


public class ListaCompetizioniExecuter extends CompetizioneExecuter {

	public ListaCompetizioniExecuter () {
		try {
			competizioni = delegate.list();
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
		}
	}
	
	
}
