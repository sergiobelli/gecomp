package net.sb.gecomp.web.bridges.view;

import net.sb.gecomp.model.Competizione;

public class CompetizioneView extends Competizione {
	public CompetizioneView() { }
	public CompetizioneView(Competizione competizione) {
		ViewUtils.copyProperties(this, competizione);
		this.setSocietaOrganizzatrice(new SocietaView(competizione.getSocietaOrganizzatrice()));
	}
}
