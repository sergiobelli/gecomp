package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Competizione;

public class CompetizioneView extends Competizione {

	public CompetizioneView() { }
	public CompetizioneView(Competizione competizione) {
		ViewUtils.copyProperties(this, competizione);
	}
	
}
