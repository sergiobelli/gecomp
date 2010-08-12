package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.Competizione;

public class CompetizioneView extends Competizione {
	public CompetizioneView() { }
	public CompetizioneView(Competizione competizione) {
		ViewUtils.copyProperties(this, competizione);
		this.setSocietaOrganizzatrice(new SocietaView(competizione.getSocietaOrganizzatrice()));
	}
}
