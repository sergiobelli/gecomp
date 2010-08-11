package net.sb.gecomp.web.bridges.view;

import org.sbelli.gecomp.orm.model.Societa;

public class SocietaView extends Societa {
	public SocietaView() { }
	public SocietaView(Societa societa) {
		ViewUtils.copyProperties(this, societa);
	}
	
	public String getDenominazioneEstesa() {
		return this.getCodiceFidal() + " - " + this.getDenominazione();
	}
}
