package org.sbelli.gecomp.console.societa.executers;

import net.sb.gecomp.exceptions.GeCompException;
import net.sb.gecomp.utils.exceptions.GeCompExceptionManager;

public class ListaSocietaExecuter extends SocietaExecuter {
		
	public String salva() {
		try {
			delegate.save(getSocieta());
		} catch (GeCompException e) {
			GeCompExceptionManager.traceException(logger, e);
		}	
		return "";
	}
	
}
