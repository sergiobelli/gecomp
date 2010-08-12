package net.sb.gecomp.web.executers.societa;

import net.sb.gecomp.commons.model.view.SocietaView;
import net.sb.gecomp.web.delegates.societa.SocietaDelegate;
import net.sb.gecomp.web.executers.GenericExecuter;


public abstract class SocietaExecuter extends GenericExecuter {

	protected final SocietaDelegate delegate = new SocietaDelegate();
	
	protected Long idSocieta;
	
	private SocietaView societa;
	public SocietaView getSocieta() { return societa; }
	public void setSocieta(SocietaView societa) { this.societa = societa; }

	

}
