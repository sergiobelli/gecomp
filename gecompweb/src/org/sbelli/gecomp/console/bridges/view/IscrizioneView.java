package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Iscrizione;

public class IscrizioneView extends Iscrizione {

	private GaraView gara;
	private AtletaView atleta;
	
	public IscrizioneView() { }
	public IscrizioneView(Iscrizione iscrizione) {
		ViewUtils.copyProperties(this, iscrizione);
	}
	
	public GaraView getGara() { return gara; }
	public void setGara(GaraView gara) { this.gara = gara; }

	public AtletaView getAtleta() { return atleta; }
	public void setAtleta(AtletaView atleta) { this.atleta = atleta; }

}
