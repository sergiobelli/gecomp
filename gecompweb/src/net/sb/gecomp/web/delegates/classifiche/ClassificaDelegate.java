package net.sb.gecomp.web.delegates.classifiche;

import net.sb.gecomp.commons.exceptions.GeCompException;
import net.sb.gecomp.commons.model.Gara;
import net.sb.gecomp.commons.model.view.ClassificaView;

import org.apache.log4j.Logger;


public abstract class ClassificaDelegate implements IClassificaDelegate {

	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	public abstract ClassificaView getClassifica(Gara gara) throws GeCompException;

}
