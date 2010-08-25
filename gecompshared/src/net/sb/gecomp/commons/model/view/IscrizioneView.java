package net.sb.gecomp.commons.model.view;

import net.sb.gecomp.commons.model.Iscrizione;
import net.sb.gecomp.commons.utils.Eval;


public class IscrizioneView extends Iscrizione {
	public IscrizioneView() { }
	public IscrizioneView(AtletaView atleta, GaraView gara) {
		this.setAtleta(atleta);
		this.setGara(gara);
	}
	public IscrizioneView(Iscrizione iscrizione) {
		ViewUtils.copyProperties(this, iscrizione);//FIXME:Il numero pettorale = null lo trasforma in numero pettorale = 0!!! Correggere!!!
	}
	
	public String getNumeroPettorale() {
		if (Eval.isNotNull(super.getNumeroPettorale())) {
			return super.getNumeroPettorale();
		} else {
			return "n.d.";
		}
	}
	
}
