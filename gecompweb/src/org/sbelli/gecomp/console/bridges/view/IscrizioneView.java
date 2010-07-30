package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Iscrizione;

public class IscrizioneView extends Iscrizione {
	public IscrizioneView() { }
	public IscrizioneView(Iscrizione iscrizione) {
		ViewUtils.copyProperties(this, iscrizione);
	}
}
