package org.sbelli.gecomp.console.societa.executers;

import net.sb.gecomp.utils.logger.GeCompLogger;

import org.sbelli.gecomp.console.executers.GenericExecuter;
import org.sbelli.gecomp.console.societa.delegates.SocietaDelegate;
import org.sbelli.gecomp.orm.model.Societa;

public abstract class SocietaExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected final SocietaDelegate delegate = new SocietaDelegate();
	
	protected Long idSocieta;
	
	private Societa societa;
	public Societa getSocieta() { return societa; }
	public void setSocieta(Societa societa) { this.societa = societa; }

	

}
