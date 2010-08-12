package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.Atleta;

public class AtletaView extends Atleta {
	public AtletaView() { }
	public AtletaView(Atleta atleta) {
		ViewUtils.copyProperties(this, atleta);
		this.setSocietaAppartenenza(new SocietaView(atleta.getSocietaAppartenenza()));
	}
}
