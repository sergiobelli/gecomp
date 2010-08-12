package net.sb.gecomp.web.executers.societa;

import net.sb.gecomp.commons.model.Societa;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;


public abstract class SocietaExecuter extends GenericExecuter {

	protected final SocietaDelegate delegate = new SocietaDelegate();
	
	protected Long idSocieta;
	
	private Societa societa;
	public Societa getSocieta() { return societa; }
	public void setSocieta(Societa societa) { this.societa = societa; }

	

}
