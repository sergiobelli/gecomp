package org.sbelli.gecomp.console.bridges.view;

import org.sbelli.gecomp.orm.model.Societa;

public class SocietaPunteggioView {

	private Societa societa;
	private Integer punteggio;
	
	public SocietaPunteggioView() {}
	public SocietaPunteggioView(Societa societa, Integer punteggio) {
		setSocieta(societa);
		setPunteggio(punteggio);
	}
	
	public Societa getSocieta() {
		return societa;
	}
	public void setSocieta(Societa societa) {
		this.societa = societa;
	}
	public Integer getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}
	
	
}
