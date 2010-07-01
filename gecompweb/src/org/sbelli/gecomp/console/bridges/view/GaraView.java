package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Gara;

public class GaraView extends Gara {
	
	public GaraView() { }
	public GaraView(Gara gara) {
		ViewUtils.copyProperties(this, gara);
	}
	
}
