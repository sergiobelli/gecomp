package net.sb.gecomp.web.executers.societa;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.utils.exceptions.GeCompExceptionManager;

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
