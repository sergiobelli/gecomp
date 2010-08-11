package net.sb.gecomp.web.bridges.view;

import net.sb.gecomp.model.Atleta;

public class AtletaView extends Atleta {
	public AtletaView() { }
	public AtletaView(Atleta atleta) {
		ViewUtils.copyProperties(this, atleta);
		this.setSocietaAppartenenza(new SocietaView(atleta.getSocietaAppartenenza()));
	}
}
