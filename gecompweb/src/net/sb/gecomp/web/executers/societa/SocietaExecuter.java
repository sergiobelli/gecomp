package net.sb.gecomp.web.executers.societa;

import net.sb.gecomp.utils.logger.GeCompLogger;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;

import org.sbelli.gecomp.orm.model.Societa;

public abstract class SocietaExecuter extends GenericExecuter {

	protected GeCompLogger logger = GeCompLogger.getGeCompLogger(this.getClass().getName());
	
	protected final SocietaDelegate delegate = new SocietaDelegate();
	
	protected Long idSocieta;
	
	private Societa societa;
	public Societa getSocieta() { return societa; }
	public void setSocieta(Societa societa) { this.societa = societa; }

	

}
